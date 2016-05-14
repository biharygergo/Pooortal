package src;

import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;

/**
 * Created by Gergo on 14/05/16.
 */
public class Controller implements KeyListener {
    View ourView = View.getInstance();

    public Controller() {
        ourView.addKeyListener(this);
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

    }
}
