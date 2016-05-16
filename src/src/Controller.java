package src;

import javax.swing.*;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;

public class Controller implements KeyListener, Runnable {

    boolean endGame = false;
    static GameEngine engine = null;
    long lastUpdated = System.currentTimeMillis()/1000;
    long lastUpdatedReplicator = System.currentTimeMillis()/1000;
    View ourView;

    String type = "listener";

    public void run() {
        if (type.equals("listener")) {
            setListener();
        } else {
            engine.loadMap("res/csv/map_2.csv");
            while (!endGame) {
                endGame = engine.endGame();
                if (endGame) {
                    exitGameWithStyle();
                }
                long currentTime = System.currentTimeMillis() / 1000;
                if (currentTime - lastUpdatedReplicator > 2) {


                    engine.moveRandomReplicator();
                    lastUpdatedReplicator = currentTime;
                }
                if(currentTime-lastUpdated > 0.2){
                    engine.updateBullets();
                    lastUpdated = currentTime;

                }
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

    public void setListener(){
        View.initGui(this);
    }

    public Controller(GameEngine game, String type) {
        engine = game;
        this.type = type;
    }

    public static void loadImages(){
            engine.Animate();
    }

    @Override
    public void keyPressed(KeyEvent e) {

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

            case "E":
                engine.jaffaShootBullet("G");
                break;

            case "M":
                engine.oNeilGetBox();
                break;

            case "Y":
                engine.jaffaDropBox();
                break;

            case "N":
                engine.oNeilDropBox();
                break;

            case "X":
                engine.jaffaGetBox();
                break;
        }
    }

    @Override
    public void keyTyped(KeyEvent e) {}

    @Override
    public void keyReleased(KeyEvent e) {}
}
