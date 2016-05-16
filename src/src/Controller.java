package src;

import java.awt.*;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.io.IOException;

/**
 * Created by Gergo on 14/05/16.
 */
public class Controller implements KeyListener {
    boolean endGame = false;
    static GameEngine engine = null;
    View ourView;
    long lastUpdated = System.currentTimeMillis()/1000;
    public void run(){
        engine.loadMap("src/map.csv");
        Thread t = new Thread();
        while (!endGame) {
            endGame = engine.endGame();
            if (endGame) {
                engine.exit();
            }
            long currentTime = System.currentTimeMillis()/1000;
            long elapsed = currentTime -lastUpdated;
            if (currentTime - lastUpdated > 2) {
                engine.updateBullets();

               // engine.moveRandomReplicator();
                lastUpdated = currentTime;

            }
        }
    }

    public Controller(GameEngine game) {
        engine = game;
        View.initGui(this);
        //ourView = View.getInstance();
       // ourView.addKeyListener(this);
    }

    public static void loadImages(){

            engine.Animate();

    }
    @Override
    public void keyTyped(KeyEvent e) {
    }

    @Override
    public void keyPressed(KeyEvent e) {

    }

    @Override
    public void keyReleased(KeyEvent e) {
        System.out.println(e.getKeyChar());


        char typed = e.getKeyChar();
        String command = typed+"";
        command = command.toUpperCase();

        switch (command) {


            case "I":

                engine.oNeillMove("I");
                break;
            case "J":

                engine.oNeillMove("J");
                break;
            case "K":

                engine.oNeillMove("K");

                break;
            case "L":

                engine.oNeillMove("L");
                break;

            case "A":

                engine.jaffaMove("A");

                break;
            case "S":

                engine.jaffaMove("S");

                break;
            case "D":

                engine.jaffaMove(command);

                break;
            case "W":

                engine.jaffaMove(command);

                break;

            case "U":

                engine.oNeillShootBullet("B");


                break;

            case "O":

                engine.oNeillShootBullet("Y");

                break;
            case "Q":

                engine.jaffaShootBullet("R");

                break;
            case "E":

                engine.jaffaShootBullet("G");

                break;

            case "N":
                engine.oNeilGetBox();

                break;


            case "Y":
                engine.jaffaDropBox();

                break;

            case "M":
                engine.oNeilDropBox();

                break;

            case "X":
                engine.jaffaGetBox();

                break;

        }


            //engine.Animate();

    }
}
