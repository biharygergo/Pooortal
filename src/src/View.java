package src;

/**
 * Created by Gergo on 14/05/16.
 */

import java.awt.*;

import javax.swing.*;
import javax.swing.border.EmptyBorder;
import java.awt.image.BufferedImage;
import java.util.List;

public class View extends JFrame {

    private JPanel contentPane;
    private JLabel[][] labels = new JLabel[6][6];
    public static View frame;

    /**
     * Launch the application.
     * @param controller
     */

    public static void initGui(Controller controller) {
        EventQueue.invokeLater(new Runnable() {
            public void run() {
                try {
                     frame = new View();

                    frame.addKeyListener(controller);
                    Controller.loadImages();
                    frame.setVisible(true);
                } catch (Exception e) {
                    e.printStackTrace();
                }
            }
        });
    }

    public static View getInstance(){
        return frame;
    }

    /**
     * Create the frame.
     */
    public View() {
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setBounds(100, 100, 310, 350);
        contentPane = new JPanel();

        contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
        setContentPane(contentPane);
        contentPane.setLayout(new BorderLayout(0, 0));

        JPanel gamePanel = new JPanel();
        contentPane.add(gamePanel, BorderLayout.CENTER);
        gamePanel.setLayout(new GridLayout(6, 6, 0, 0));

        // JLabels
        for (int i = 0; i <= 5; i++) {
            for (int j = 0; j <= 5; j++) {
                JLabel label = new JLabel();
                gamePanel.add(label);
                labels[j][i] = label;
            }
        }

        JPanel infoPanel = new JPanel();
        contentPane.add(infoPanel, BorderLayout.NORTH);

        JLabel lblInformation = new JLabel("Information:");
        infoPanel.add(lblInformation);
    }

    /**
     * @param player
     */
    public void notifyPlayerMoved(Player player) {
        // TODO implement here
    }

    /**
     * @param replicator
     */
    public void notifyReplicatorMoved(Replicator replicator) {
        // TODO implement here
    }

    public void setPlayerImage(Player player){
        int y = player.getY();
        int x = player.getX();
        labels[player.getY()-1][player.getX()-1].setIcon(player.getImage());
        labels[player.getY()-1][player.getX()-1].setText("");
        contentPane.invalidate();
    }

    public void setFieldImage(Field field){
        int y = field.getyPos();
        int x = field.getxPos();
        labels[y-1][x-1].setIcon(field.getImage());
       labels[y-1][x-1].setText("");
        contentPane.invalidate();
    }

    public void setBoxImage(Box box){
        int y = box.getField().getyPos();
        int x = box.getField().getxPos();
        labels[y-1][x-1].setIcon(box.getImage());
        labels[y-1][x-1].setText("");
        contentPane.invalidate();

    }

    public void setZPMImage(ZPM zpm){
        int y = zpm.getField().getyPos();
        int x = zpm.getField().getxPos();
        labels[y-1][x-1].setIcon(zpm.getImage());
        labels[y-1][x-1].setText("");
        contentPane.invalidate();
    }

    public void setReplicatorImage(Replicator replicator){
        int y = replicator.getField().getyPos();
        int x = replicator.getField().getxPos();
        labels[y-1][x-1].setIcon(replicator.getImage());
        labels[y-1][x-1].setText("");
        contentPane.invalidate();
    }
    /**
     * @param boxes
     * @return
     */
    public void notifyBoxMoved(List<Box> boxes) {
        // TODO implement here
    }

    /**
     * @param ZPMs
     * @return
     */
    public void notifyZpmMoved(List<ZPM> ZPMs) {
        // TODO implement here
    }

    /**
     * @param bullets
     * @return
     */
    public void notifyBulletsMoved(List<Bullet> bullets) {
        // TODO implement here
    }

    /**
     * @param replicator
     * @return
     */
    public void notifyReplicatorClosedGap(Replicator replicator) {
        // TODO implement here
    }

    /**
     * @param jaffaHole
     * @param colonelHole
     * @return
     */
    public void notifyWormholeStateChanged(Wormhole jaffaHole, Wormhole colonelHole) {
        // TODO implement here
    }

    public static BufferedImage rotate(BufferedImage image, double angle) {
        double sin = Math.abs(Math.sin(angle)), cos = Math.abs(Math.cos(angle));
        int w = image.getWidth(), h = image.getHeight();
        int neww = (int)Math.floor(w*cos+h*sin), newh = (int) Math.floor(h * cos + w * sin);
        GraphicsConfiguration gc = getDefaultConfiguration();
        BufferedImage result = gc.createCompatibleImage(neww, newh, Transparency.TRANSLUCENT);
        Graphics2D g = result.createGraphics();
        g.translate((neww - w) / 2, (newh - h) / 2);
        g.rotate(angle, w / 2, h / 2);
        g.drawRenderedImage(image, null);
        g.dispose();
        return result;
    }

    private static GraphicsConfiguration getDefaultConfiguration() {
        GraphicsEnvironment ge = GraphicsEnvironment.getLocalGraphicsEnvironment();
        GraphicsDevice gd = ge.getDefaultScreenDevice();
        return gd.getDefaultConfiguration();
    }

    public static double getAngleFromDir(Dir dir){
        double degree;
        switch (dir){
            case Up:
                degree = 0;
                break;

            case Right:
                degree = 90;
                break;

            case Down:
                degree = 180;
                break;

            case Left:
                degree = 270;
                break;

            default:
                degree = 0;
        }

        return Math.toRadians(degree);
    }

}

