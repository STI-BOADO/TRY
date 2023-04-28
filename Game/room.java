import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.File;

import javax.sound.sampled.AudioInputStream;
import javax.sound.sampled.AudioSystem;
import javax.sound.sampled.Clip;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;

public class room extends JFrame implements ActionListener {

    ImageIcon bg, dbg, mute, muted;
    JLabel bglabel;
    JButton muteButton, switchee, duck, back;

    Clip clip, clip2;
    boolean isMuted = false;

    public room() {
        setTitle("My Space Friend");
        setSize(900, 500);
        setLocationRelativeTo(null);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setResizable(false);

        bg = new ImageIcon("images\\19.jpg");
        dbg = new ImageIcon("images\\20.jpg");

        bglabel = new JLabel(bg);

        duck = new JButton();
        duck.setBounds(690, 390, 60, 35);
        duck.setContentAreaFilled(false);
        duck.setBorderPainted(false);
        add(duck);
        duck.addActionListener(this);

        switchee = new JButton();
        switchee.setContentAreaFilled(false);
        switchee.setBorderPainted(false);
        switchee.setBounds(425, 25, 75, 110);

        switchee.addActionListener(this);

        add(switchee);

        back = new JButton("<---");
        back.setBounds(10, 30, 60, 20);
        add(back);
        back.addActionListener(this);

        mute = new ImageIcon("images\\audio-speaker.png");
        muted = new ImageIcon("images\\mute.png");
        muteButton = new JButton(mute);
        muteButton.setBorder(null);
        muteButton.addActionListener(this);
        muteButton.setBounds(860, 440, 20, 20);
        add(muteButton);

        try {
            File file = new File("images\\bgm.wav");
            AudioInputStream audioStream = AudioSystem.getAudioInputStream(file);

            clip = AudioSystem.getClip();
            clip.open(audioStream);
            clip.loop(Clip.LOOP_CONTINUOUSLY);
        } catch (Exception e) {
            e.printStackTrace();
        }

        add(bglabel);

        try {
            File file = new File("images\\rubber.wav");
            AudioInputStream audioStream = AudioSystem.getAudioInputStream(file);

            clip2 = AudioSystem.getClip();
            clip2.open(audioStream);
        } catch (Exception e) {
            e.printStackTrace();
        }

    }

    public void actionPerformed(ActionEvent e) {
        if (e.getSource() == muteButton) {
            if (isMuted) {
                clip.loop(Clip.LOOP_CONTINUOUSLY);
                muteButton.setIcon(mute);
                isMuted = false;
            } else {
                clip.stop();
                muteButton.setIcon(muted);
                isMuted = true;
            }
        }

        if (e.getSource() == switchee) {
            if (bglabel.getIcon().toString().equals("images\\19.jpg")) {
                bglabel.setIcon(dbg);
            } else if (bglabel.getIcon().toString().equals("images\\20.jpg")) {
                bglabel.setIcon(bg);
            }
        }

        if (e.getSource() == duck) {
            clip2.setFramePosition(0);
            clip2.start();
        }

        if (e.getSource() == back) {
            mainmenu bb = new mainmenu();
            clip.stop();
            bb.setVisible(true);
            setVisible(false);

        }

    }

    public static void main(String[] args) {
        room grr = new room();
        grr.setVisible(true);
    }
}