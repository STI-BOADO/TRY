package LoadingScreens;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.File;
import javax.swing.Timer;

import Game.mainmenu;

import javax.sound.sampled.AudioInputStream;
import javax.sound.sampled.AudioSystem;
import javax.sound.sampled.Clip;
import javax.swing.ImageIcon;
import javax.swing.JFrame;
import javax.swing.JLabel;

public class returntomm extends JFrame implements ActionListener{

    Clip clip;

    public returntomm() {
        setTitle("PAWSTRONAUT");
        setSize(1350, 750);
        setLocationRelativeTo(null);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setResizable(false);

        ImageIcon backgroundImage = new ImageIcon("images\\plainbg.png");
        JLabel backgroundLabel = new JLabel(backgroundImage);
        setContentPane(backgroundLabel);

        try {
            File file = new File("images\\bgm.wav");
            AudioInputStream audioStream = AudioSystem.getAudioInputStream(file);

            clip = AudioSystem.getClip();
            clip.open(audioStream);
            clip.loop(Clip.LOOP_CONTINUOUSLY);
        } catch (Exception e) {
            e.printStackTrace();
        }

        ImageIcon loadingIcon = new ImageIcon("images\\rtm.gif");
        JLabel load = new JLabel(loadingIcon);
        load.setBounds(getWidth()/2 - loadingIcon.getIconWidth()/2, getHeight()/2 - loadingIcon.getIconHeight()/2, loadingIcon.getIconWidth(), loadingIcon.getIconHeight());
        add(load);

        Timer timer = new Timer(4000, this);
        timer.setRepeats(false);
        timer.start();

        setVisible(true);

    }

    public static void main(String[] args) {
        new returntomm();
    }

    public void actionPerformed(ActionEvent e) {
        mainmenu mainmenu = new mainmenu();
        dispose();
        setVisible(false);
        clip.stop();
        mainmenu.setVisible(true);
    }
}
