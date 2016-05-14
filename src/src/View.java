package src;

/**
 * Created by Gergo on 14/05/16.
 */

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import java.awt.GridLayout;
import javax.swing.JLabel;

public class View extends JFrame {

    private JPanel contentPane;
    public static View frame;
    /**
     * Launch the application.
     */
    public static void initGui() {
        EventQueue.invokeLater(new Runnable() {
            public void run() {
                try {
                     frame = new View();
                    Controller c = new Controller();

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
        setBounds(100, 100, 670, 397);
        contentPane = new JPanel();
        contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
        setContentPane(contentPane);
        contentPane.setLayout(new BorderLayout(0, 0));

        JPanel gamePanel = new JPanel();
        contentPane.add(gamePanel, BorderLayout.CENTER);
        gamePanel.setLayout(new GridLayout(6, 6, 0, 0));

        JLabel lblImage = new JLabel("Image11");
        gamePanel.add(lblImage);

        JLabel lblImage_1 = new JLabel("Image12");
        gamePanel.add(lblImage_1);

        JLabel lblImage_5 = new JLabel("Image13");
        gamePanel.add(lblImage_5);

        JLabel lblImage_2 = new JLabel("Image14");
        gamePanel.add(lblImage_2);

        JLabel lblImage_3 = new JLabel("Image15");
        gamePanel.add(lblImage_3);

        JLabel lblImage_4 = new JLabel("Image16");
        gamePanel.add(lblImage_4);

        JLabel lblImage_6 = new JLabel("Image11");
        gamePanel.add(lblImage_6);

        JLabel lblImage_7 = new JLabel("Image12");
        gamePanel.add(lblImage_7);

        JLabel lblImage_8 = new JLabel("Image13");
        gamePanel.add(lblImage_8);

        JLabel lblImage_9 = new JLabel("Image14");
        gamePanel.add(lblImage_9);

        JLabel lblImage_10 = new JLabel("Image15");
        gamePanel.add(lblImage_10);

        JLabel lblImage_11 = new JLabel("Image16");
        gamePanel.add(lblImage_11);

        JLabel lblImage_12 = new JLabel("Image11");
        gamePanel.add(lblImage_12);

        JLabel lblImage_13 = new JLabel("Image12");
        gamePanel.add(lblImage_13);

        JLabel lblImage_14 = new JLabel("Image13");
        gamePanel.add(lblImage_14);

        JLabel lblImage_15 = new JLabel("Image14");
        gamePanel.add(lblImage_15);

        JLabel lblImage_16 = new JLabel("Image15");
        gamePanel.add(lblImage_16);

        JLabel lblImage_17 = new JLabel("Image16");
        gamePanel.add(lblImage_17);

        JLabel lblImage_18 = new JLabel("Image11");
        gamePanel.add(lblImage_18);

        JLabel lblImage_19 = new JLabel("Image12");
        gamePanel.add(lblImage_19);

        JLabel lblImage_20 = new JLabel("Image13");
        gamePanel.add(lblImage_20);

        JLabel lblImage_21 = new JLabel("Image14");
        gamePanel.add(lblImage_21);

        JLabel lblImage_22 = new JLabel("Image15");
        gamePanel.add(lblImage_22);

        JLabel lblImage_23 = new JLabel("Image16");
        gamePanel.add(lblImage_23);
        JLabel lblImage_24 = new JLabel("Image11");
        gamePanel.add(lblImage_24);

        JLabel lblImage_25 = new JLabel("Image12");
        gamePanel.add(lblImage_25);

        JLabel lblImage_26 = new JLabel("Image13");
        gamePanel.add(lblImage_26);

        JLabel lblImage_27 = new JLabel("Image14");
        gamePanel.add(lblImage_27);

        JLabel lblImage_28 = new JLabel("Image15");
        gamePanel.add(lblImage_28);

        JLabel lblImage_29 = new JLabel("Image16");
        gamePanel.add(lblImage_29);
        JLabel lblImage_30 = new JLabel("Image11");
        gamePanel.add(lblImage_30);

        JLabel lblImage_31 = new JLabel("Image12");
        gamePanel.add(lblImage_31);

        JLabel lblImage_32 = new JLabel("Image13");
        gamePanel.add(lblImage_32);

        JLabel lblImage_33 = new JLabel("Image14");
        gamePanel.add(lblImage_33);

        JLabel lblImage_34 = new JLabel("Image15");
        gamePanel.add(lblImage_34);

        JLabel lblImage_35 = new JLabel("Image16");
        gamePanel.add(lblImage_35);


        JPanel infoPanel = new JPanel();
        contentPane.add(infoPanel, BorderLayout.NORTH);

        JLabel lblInformation = new JLabel("Information:");
        infoPanel.add(lblInformation);
    }

}

