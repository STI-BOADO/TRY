
import java.awt.event.*;
import java.io.File;

import javax.sound.sampled.AudioInputStream;
import javax.sound.sampled.AudioSystem;
import javax.sound.sampled.Clip;
import javax.swing.*;

public class first extends JFrame {
    private ImageIcon backgroundImage, darkenter, buttonImage;
    private JButton imageButton;
    Clip clip;

    public first() {

        setTitle("My Space Friend");
        setSize(1350, 750);
        setLocationRelativeTo(null);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setResizable(false);

        /*
         * try {
         * File file = new File("images\\bgm.wav");
         * AudioInputStream audioStream = AudioSystem.getAudioInputStream(file);
         * 
         * clip = AudioSystem.getClip();
         * clip.open(audioStream);
         * clip.loop(Clip.LOOP_CONTINUOUSLY);
         * } catch (Exception e) {
         * e.printStackTrace();
         * }
         */

        backgroundImage = new ImageIcon("images\\plainbg.png");
        JLabel backgroundLabel = new JLabel(backgroundImage);
        ImageIcon bg = new ImageIcon("images\\plainbg.png");
        JLabel bgLabel = new JLabel(bg);

        JFrame loadingScreen = new JFrame();
        loadingScreen.setSize(1350, 750);
        loadingScreen.setLocationRelativeTo(null);
        loadingScreen.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        loadingScreen.setContentPane(bgLabel);
        ImageIcon loadingImage = new ImageIcon("images\\loading.gif");
        JLabel loadingLabel = new JLabel(loadingImage);
        loadingLabel.setBounds(547, 247, loadingImage.getIconWidth(), loadingImage.getIconHeight());
        loadingScreen.add(loadingLabel);
        loadingScreen.setVisible(true);

        try {
            Thread.sleep(1000);
        } catch (InterruptedException ex) {
            ex.printStackTrace();
        }

        loadingLabel.setIcon(null);

        loadingScreen.setVisible(false);

        setContentPane(backgroundLabel);

        buttonImage = new ImageIcon("images\\btbtn.png");
        darkenter = new ImageIcon("images\\darkdark.png");
        imageButton = new JButton(buttonImage);
        imageButton.setBorder(null);
        imageButton.setBounds(546, 400, buttonImage.getIconWidth(), buttonImage.getIconHeight());
        add(imageButton);

        imageButton.addMouseListener(new MouseListener() {

            @Override
            public void mouseClicked(MouseEvent e) {
            }

            @Override
            public void mousePressed(MouseEvent e) {
            }

            @Override
            public void mouseReleased(MouseEvent e) {
            }

            @Override
            public void mouseEntered(MouseEvent e) {
                imageButton.setIcon(darkenter);
            }

            @Override
            public void mouseExited(MouseEvent e) {
                imageButton.setIcon(buttonImage);
            }

        });

        imageButton.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                Second eto = new Second();
                setVisible(false);
                // clip.stop();
                eto.setVisible(true);
                loadingScreen.setVisible(false);
            }
        });
    }

    public static void main(String[] args) {
        first window = new first();
        window.setVisible(true);
    }
}
