package entity;

import main.KeyHandler;
import main.Panel;

public class Player extends Entity {

    Panel gp;
    KeyHandler keyH;

    public Player(Panel gp, KeyHandler keyH){

        this.gp = gp;
        this.keyH = keyH;
        setDefaultValues();
    }
    public void setDefaultValues() {
       int x = 100;
       int y = 100;
       int speed = 4;
    }
    public void update(){

        if(keyH.upPressed==true){
            y -= speed;
        }
        else if(keyH.downPressed==true){
            y += speed;
        }
        else if (keyH.leftPressed==true){
            x -= speed;
        }
        else if (keyH.rightPressed==true){
            x += speed;
        }

    }
    public void draw(Graphics2D g2){

        g2.setColor(Color.white);

        g2.fillRect(x, y, gp.tileSize, gp.tileSize);

    }
}
