package src;

import java.awt.*;

import javax.swing.*;
import javax.swing.border.EmptyBorder;
import java.awt.Color;
import java.awt.image.BufferedImage;
import java.io.IOException;

public class View extends JFrame {

    private JPanel contentPane;
    public static View frame;
    private int Fwidth = 50, Fheight = 50;

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

    /**
     *
     * @param g
     */
    public void paint(Graphics g){}

    /**
     *
     */
    public void Invalidate(){

        Graphics g = getGraphics();
        g.setColor(Color.lightGray);

        g.fillRect(0,0,850,850);

    }

    /**
     *
     * @return
     */
    public static View getInstance(){
        return frame;
    }

    /**
     * Create the frame.
     */
    public View() {

        setSize(850, 850);

        setVisible(true);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        //setBounds(100, 100, 310, 350);
       contentPane = new JPanel();

        contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
        contentPane.setSize(850, 850);
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

    /**
     *
     * @param originalImage
     * @param width
     * @param height
     * @param type
     * @return
     * @throws IOException
     */
    private BufferedImage resizeImage(BufferedImage originalImage, int width, int height, int type) throws IOException {
        BufferedImage resizedImage = new BufferedImage(width, height, type);
        Graphics2D g = resizedImage.createGraphics();
        g.drawImage(originalImage, 0, 0, width, height, null);
        g.dispose();
        return resizedImage;
    }

    /**
     *
     * @param bi
     * @param x
     * @param y
     */
    public void paintOn(BufferedImage bi, int x, int y){
        Graphics g = getGraphics();

        BufferedImage scaled = null;
        try {
            scaled = resizeImage(bi, Fwidth, Fheight,  BufferedImage.TYPE_INT_ARGB);
        } catch (IOException e) {
            e.printStackTrace();
        }

        g.drawImage(scaled, (y-1)*Fheight, (x-1)*Fwidth, null);


    }

    /**
     *
     * @param player
     */
    public void setPlayerImage(Player player) {
        int y = player.getY();
        int x = player.getX();
        paintOn(player.getImage(), x, y);
    }

    /**
     *
     * @param field
     */
    public void setFieldImage(Field field){
        int y = field.getyPos();
        int x = field.getxPos();
        paintOn(field.getImage(), x, y);

    }

    /**
     *
     * @param box
     */
    public void setBoxImage(Box box){
        int y = box.getField().getyPos();
        int x = box.getField().getxPos();
        paintOn(box.getImage(), x, y);
        getGraphics().drawString(String.valueOf(box.getWeight()),(y-1)*Fheight+11, (x-1)*Fwidth+20);

    }

    /**
     *
     * @param zpm
     */
    public void setZPMImage(ZPM zpm){
        int y = zpm.getField().getyPos();
        int x = zpm.getField().getxPos();
        paintOn(zpm.getImage(), x, y);
    }

    /**
     *
     * @param replicator
     */
    public void setReplicatorImage(Replicator replicator){
        int y = replicator.getField().getyPos();
        int x = replicator.getField().getxPos();
        paintOn(replicator.getImage(), x, y);
    }

    /**
     *
     * @param scale
     */
    public void writeScaleWeight(Scale scale){
        int y = scale.getyPos();
        int x = scale.getxPos();

        Graphics g = getGraphics();
        g.setColor(Color.BLACK);
        g.fillRect((y - 1) * Fheight + 14, (x - 1) * Fwidth + 16, 23, 18);
        g.setColor(Color.WHITE);
        g.drawString(String.valueOf(scale.getCurrentWeight()), (y - 1) * Fheight + 18, (x - 1) * Fwidth + 29);


    }

    /**
     *
     * @param field
     */
    public void invalidateField(Field field){
        Graphics g = getGraphics();
        g.setColor(Color.lightGray);
        g.fillRect((field.getyPos()-1)*Fheight, (field.getxPos()-1)*Fwidth, Fwidth, Fheight);

    }

    /**
     *
     * @param image
     * @param angle
     * @return
     */
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

    /**
     *
     * @return
     */
    private static GraphicsConfiguration getDefaultConfiguration() {
        GraphicsEnvironment ge = GraphicsEnvironment.getLocalGraphicsEnvironment();
        GraphicsDevice gd = ge.getDefaultScreenDevice();
        return gd.getDefaultConfiguration();
    }

    /**
     *
     * @param dir
     * @return
     */
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

    /**
     *
     * @param bulletImage
     */
    public void setBulletImage(Bullet bulletImage) {
        int y = bulletImage.getField().getyPos();
        int x = bulletImage.getField().getxPos();
        paintOn(bulletImage.getImage(), x, y);
    }
}

