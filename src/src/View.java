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



        JLabel lblImage = new JLabel("Image11");
        gamePanel.add(lblImage);
        labels[0][0] = lblImage;

        //FIGYELEM!!! SZAMOZAS 0-tol indul es nem 1-tol mint a GameEngineben!!!
        JLabel lblImage_1 = new JLabel("Image12");
        gamePanel.add(lblImage_1);
        labels[1][0] = lblImage_1;

        JLabel lblImage_5 = new JLabel("Image13");
        gamePanel.add(lblImage_5);
        labels[2][0] = lblImage_5;

        JLabel lblImage_2 = new JLabel("Image14");
        gamePanel.add(lblImage_2);
        labels[3][0] = lblImage_2;

        JLabel lblImage_3 = new JLabel("Image15");
        gamePanel.add(lblImage_3);
        labels[4][0] = lblImage_3;

        JLabel lblImage_4 = new JLabel("Image16");
        gamePanel.add(lblImage_4);
        labels[5][0] = lblImage_4;

        JLabel lblImage_6 = new JLabel("Image11");
        gamePanel.add(lblImage_6);
        labels[0][1] = lblImage_6;

        JLabel lblImage_7 = new JLabel("Image12");
        gamePanel.add(lblImage_7);
        labels[1][1] = lblImage_7;

        JLabel lblImage_8 = new JLabel("Image13");
        gamePanel.add(lblImage_8);
        labels[2][1] = lblImage_8;

        JLabel lblImage_9 = new JLabel("Image14");
        gamePanel.add(lblImage_9);
        labels[3][1] = lblImage_9;


//        JLayeredPane testPanel = new JLayeredPane();
//        gamePanel.add(testPanel);
//        labels[3][1] = testPanel;

        JLabel lblImage_10 = new JLabel("Image15");
        gamePanel.add(lblImage_10);
        labels[4][1] = lblImage_10;

        JLabel lblImage_11 = new JLabel("Image16");
        gamePanel.add(lblImage_11);
        labels[5][1] = lblImage_11;

        JLabel lblImage_12 = new JLabel("Image11");
        gamePanel.add(lblImage_12);
        labels[0][2] = lblImage_12;

        JLabel lblImage_13 = new JLabel("Image12");
        gamePanel.add(lblImage_13);
        labels[1][2] = lblImage_13;

        JLabel lblImage_14 = new JLabel("Image13");
        gamePanel.add(lblImage_14);
        labels[2][2] = lblImage_14;

        JLabel lblImage_15 = new JLabel("Image14");
        gamePanel.add(lblImage_15);
        labels[3][2] = lblImage_15;

        JLabel lblImage_16 = new JLabel("Image15");
        gamePanel.add(lblImage_16);
        labels[4][2] = lblImage_16;

        JLabel lblImage_17 = new JLabel("Image16");
        gamePanel.add(lblImage_17);
        labels[5][2] = lblImage_17;

        JLabel lblImage_18 = new JLabel("Image11");
        gamePanel.add(lblImage_18);
        labels[0][3] = lblImage_18;

        JLabel lblImage_19 = new JLabel("Image12");
        gamePanel.add(lblImage_19);
        labels[1][3] = lblImage_19;

        JLabel lblImage_20 = new JLabel("Image13");
        gamePanel.add(lblImage_20);
        labels[2][3] = lblImage_20;

        JLabel lblImage_21 = new JLabel("Image14");
        gamePanel.add(lblImage_21);
        labels[3][3] = lblImage_21;

        JLabel lblImage_22 = new JLabel("Image15");
        gamePanel.add(lblImage_22);
        labels[4][3] = lblImage_22;

        JLabel lblImage_23 = new JLabel("Image16");
        gamePanel.add(lblImage_23);
        labels[5][3] = lblImage_23;

        JLabel lblImage_24 = new JLabel("Image11");
        gamePanel.add(lblImage_24);
        labels[0][4] = lblImage_24;

        JLabel lblImage_25 = new JLabel("Image12");
        gamePanel.add(lblImage_25);
        labels[1][4] = lblImage_25;

        JLabel lblImage_26 = new JLabel("Image13");
        gamePanel.add(lblImage_26);
        labels[2][4] = lblImage_26;

        JLabel lblImage_27 = new JLabel("Image14");
        gamePanel.add(lblImage_27);
        labels[3][4] = lblImage_27;

        JLabel lblImage_28 = new JLabel("Image15");
        gamePanel.add(lblImage_28);
        labels[4][4] = lblImage_28;

        JLabel lblImage_29 = new JLabel("Image16");
        gamePanel.add(lblImage_29);
        labels[5][4] = lblImage_29;

        JLabel lblImage_30 = new JLabel("Image11");
        gamePanel.add(lblImage_30);
        labels[0][5] = lblImage_30;

        JLabel lblImage_31 = new JLabel("Image12");
        gamePanel.add(lblImage_31);
        labels[1][5] = lblImage_31;

        JLabel lblImage_32 = new JLabel("Image13");
        gamePanel.add(lblImage_32);
        labels[2][5] = lblImage_32;

        JLabel lblImage_33 = new JLabel("Image14");
        gamePanel.add(lblImage_33);
        labels[3][5] = lblImage_33;

        JLabel lblImage_34 = new JLabel("Image15");
        gamePanel.add(lblImage_34);
        labels[4][5] = lblImage_34;

        JLabel lblImage_35 = new JLabel("Image16");
        gamePanel.add(lblImage_35);
        labels[5][5] = lblImage_35;


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

