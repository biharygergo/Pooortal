package src;

import javax.swing.*;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;

/**
 * Created by Gergo on 14/05/16.
 */
public class Controller implements KeyListener {

    boolean endGame = false;
    static GameEngine engine = null;
    View ourView; // Ez minek ide ?
    float lastUpdated = 0;

    public Controller(GameEngine game) {
        engine = game;
        View.initGui(this);
        //ourView = View.getInstance();
        // ourView.addKeyListener(this);
    }

    public void run(){
        engine.loadMap("src/map.csv");
        while (!endGame) {
            endGame = engine.endGame();
            if (endGame) {
                exitGameWithStyle();
            }
            long currentTime = System.currentTimeMillis() / 1000;
            if (currentTime - lastUpdated > 2) {
                engine.updateBullets();
                engine.moveRandomReplicator();
            }
        }
    }

    private void exitGameWithStyle() {
        String reason;
        if (engine.getActiveModules().noMoreZPM()) {
            reason = "Gratulálunk, nyertél!\n\n";
        } else {
            reason = "Sajnos vesztettél!\n\n";
        }

        int result = JOptionPane.showConfirmDialog(ourView, reason + engine.getExitString(), "Játék vége", JOptionPane.CLOSED_OPTION, 1);
        if (result == 0) {
            System.exit(0);
        }
    }

    public static void loadImages(){
        engine.Animate();
    }

    @Override
    public void keyPressed(KeyEvent e) {
        System.out.println(e.getKeyChar());

        char typed = e.getKeyChar();
        String command = typed + "";
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
                engine.oNeilDropBox();
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
        engine.Animate();
    }

    @Override
    public void keyReleased(KeyEvent e) {}

    @Override
    public void keyTyped(KeyEvent e) {}
}
