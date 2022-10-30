package main;

import javax.swing.*;
import java.awt.*;
import entity.Player;
import javax.swing.JPanel;
import java.sql.SQLOutput;

public class Panel extends JPanel implements Runnable {

     final int originalTileSize=16; // 16x16 tile
    final int scale = 3;

    public final int tileSize = originalTileSize * scale; //48
    final int maxScreenCol = 16;
    final int maxScreenRow = 12;
    final int screenWidth = tileSize * maxScreenCol; //768 Pixels
    final int screenHeight = tileSize * maxScreenRow; //576 Pixels

    int FPS = 60;
    KeyHandler keyH = new KeyHandler();
    Thread gameThread;
    Player player = new Player(this, keyH);

    int playerX = 100;
    int playerY = 100;
    int playerSpeed = 4;


    public Panel (){
        this.setPreferredSize(new Dimension(screenWidth, screenHeight));
        this.setBackground(Color.black);
        this.setDoubleBuffered(true);
        this.addKeyListener(keyH);
        this.setFocusable(true);

    }
public void startGameThread(){
        gameThread = new Thread(this);
        gameThread.start();

}

    @Override
    public void run() {

        double drawInterval = 1000000000/FPS;
        double nextDrawTime = System.nanoTime() + drawInterval;
        long lastTime = System.nanoTime();
        long currentTime;



        while(gameThread != null){

            update();

            repaint();
            try{
                double remainingTime = nextDrawTime - System.nanoTime();
                remainingTime= remainingTime/1000000; //nano to milli

                if(remainingTime < 0){
                    remainingTime = 0;
                }
                Thread.sleep((long) remainingTime);

                nextDrawTime += drawInterval;

            } catch (InterruptedException e){
                e.printStackTrace();
            }

        }

    }
    public void update(){

        player.update();

    }

    public void paintComponent(Graphics g){

        super.paintComponent(g);

        Graphics2D g2 = (Graphics2D) g;

        player.draw(g2);

        g2.dispose();
    }
}
