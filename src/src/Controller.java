package src;

import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;

/**
 * Created by Gergo on 14/05/16.
 */
public class Controller implements KeyListener {
    boolean endGame = false;
    GameEngine engine = null;
    View ourView;
    float lastUpdated = 0;
    public void run(){
        engine.loadMap("src/map.csv");
        while (!endGame) {
            endGame = engine.endGame();
            if (endGame) {
                engine.exit();
            }
            long currentTime = System.currentTimeMillis() / 1000;
            if (currentTime - lastUpdated > 2) {
                engine.updateBullets();
                engine.moveRandomReplicator();
            }
        }
    }

    public Controller(GameEngine game) {
        engine = game;
        View.initGui(this);
        //ourView = View.getInstance();
       // ourView.addKeyListener(this);
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
        engine.Animate();

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
            case "R":

                engine.jaffaShootBullet("G");

                break;

            case "N":
                engine.oNeilGetBox();

                break;


            case "Y":
                engine.jaffaDropBox();

                break;

            case "M":
                engine.oNeilGetBox();

                break;

            case "X":
                engine.jaffaGetBox();

                break;

        }
    }
}
