package main;

import javax.swing.*;
import java.awt.*;
import java.sql.SQLOutput;

public class Panel extends JPanel implements Runnable {

    final int originalTileSize=16; // 16x16 tile
    final int scale = 3;

    final int tileSize = originalTileSize * scale; //48
    final int maxScreenCol = 16;
    final int maxScreenRow = 12;
    final int screenWidth = tileSize * maxScreenCol; //768 Pixels
    final int screenHeight = tileSize * maxScreenRow; //576 Pixels

    Thread gameThread;

    public Panel (){
        this.setPreferredSize(new Dimension(screenWidth, screenHeight));
        this.setBackground(Color.black);
        this.setDoubleBuffered(true);

    }
public void startGameThread(){
        gameThread = new Thread(this);
        gameThread.start();

}

    @Override
    public void run() {

        while(gameThread != null){
            //System.out.println("the loop running mfa");

            //Update: update information such as character positions



        }

    }
}
