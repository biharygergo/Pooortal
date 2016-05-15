package src;

import java.awt.*;

import javax.swing.*;
import javax.swing.border.EmptyBorder;
import java.awt.Color;
import java.awt.image.BufferedImage;
import java.io.IOException;
import java.util.List;

public class View extends JFrame {

    private JPanel contentPane;
    //private JLabel[][] labels = new JLabel[6][6];
    public static View frame;
    private int Fwidth = 100, Fheight = 100;
    //private  Graphics g;
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

    public void paint(Graphics g){

    }

    public void Invalidate(){


        Graphics g = getGraphics();
        g.setColor(Color.lightGray);
        g.drawRect(0,0,800,800);
        g.fillRect(0,0,800,800);

    }

    public static View getInstance(){
        return frame;
    }
    /**
     * Create the frame.
     */
    public View() {

        setSize(800, 800);

        setVisible(true);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        //setBounds(100, 100, 310, 350);
       contentPane = new JPanel();

        contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
        contentPane.setSize(800, 800);
        contentPane.setBackground(Color.RED);
        setContentPane(contentPane);
        contentPane.setVisible(true);
        //contentPane.setLayout(new BorderLayout(0, 0));
       // g = contentPane.getGraphics();
/*
        JPanel gamePanel = new JPanel();
        contentPane.add(gamePanel, BorderLayout.CENTER);
        gamePanel.setLayout(new GridLayout(6, 6, 0, 0));*/


    }

    private BufferedImage resizeImage(BufferedImage originalImage, int width, int height, int type) throws IOException {
        BufferedImage resizedImage = new BufferedImage(width, height, type);
        Graphics2D g = resizedImage.createGraphics();
        g.drawImage(originalImage, 0, 0, width, height, null);
        g.dispose();
        return resizedImage;
    }

    public void paintOn(BufferedImage bi, int x, int y){
        Graphics g = getGraphics();

        BufferedImage scaled = null;
        try {
            scaled = resizeImage(bi, 100, 100,  BufferedImage.TYPE_INT_ARGB);
        } catch (IOException e) {
            e.printStackTrace();
        }

        g.drawImage(scaled, y*Fheight, x*Fwidth, null);


    }

    public void setPlayerImage(Player player) {
        int y = player.getY();
        int x = player.getX();
        paintOn(player.getImage(), x, y);
    }

    public void setFieldImage(Field field){
        int y = field.getyPos();
        int x = field.getxPos();
        paintOn(field.getImage(), x, y);

    }

    public void setBoxImage(Box box){
        int y = box.getField().getyPos();
        int x = box.getField().getxPos();
        paintOn(box.getImage(), x, y);

    }

    public void setZPMImage(ZPM zpm){
        int y = zpm.getField().getyPos();
        int x = zpm.getField().getxPos();
        paintOn(zpm.getImage(), x, y);
    }

    public void setReplicatorImage(Replicator replicator){
        int y = replicator.getField().getyPos();
        int x = replicator.getField().getxPos();
        paintOn(replicator.getImage(), x, y);
    }

    public void invalidateField(Field field){
        Graphics g = getGraphics();
        g.setColor(Color.lightGray);
        g.fillRect(field.getyPos()*Fheight, field.getxPos()*Fwidth, 100, 100);

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

    public void setBulletImage(Bullet bulletImage) {
        int y = bulletImage.getField().getyPos();
        int x = bulletImage.getField().getxPos();
        paintOn(bulletImage.getImage(), x, y);
    }
}

