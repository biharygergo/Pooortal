package src;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

/**
 * The Main class
 */
public class Main {

    private static GameEngine gameEngine = new GameEngine();
    private static Controller controller = new Controller(gameEngine);

    public static void main (String[] args){
        controller.run();
    }
}
