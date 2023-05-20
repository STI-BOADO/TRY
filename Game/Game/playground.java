package Game;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.io.File;

import javax.sound.sampled.AudioInputStream;
import javax.sound.sampled.AudioSystem;
import javax.sound.sampled.Clip;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;

import LoadingScreens.returntomm;
import MiniGames.*;

public class playground extends JFrame implements ActionListener, MouseListener {

    ImageIcon backk, backwhite, mute, muted, hmlogo, hmgif;
    JButton back, muteButton, hm;
    Clip clip;
    Boolean isMuted = false;

    public playground() {

        setTitle("PAWSTRONAUT");
        setSize(1350, 750);
        setLocationRelativeTo(null);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setResizable(false);

        try {
            File file = new File("images\\bgm.wav");
            AudioInputStream audioStream = AudioSystem.getAudioInputStream(file);

            clip = AudioSystem.getClip();
            clip.open(audioStream);
            clip.loop(Clip.LOOP_CONTINUOUSLY);
        } catch (Exception e) {
            e.printStackTrace();
        }

        mute = new ImageIcon("images\\unmute.png");
        muted = new ImageIcon("images\\mute.png");
        muteButton = new JButton(mute);
        muteButton.setBorder(null);
        muteButton.addActionListener(this);
        muteButton.setBounds(1300, 680, 30, 30);

        ImageIcon backgroundImage = new ImageIcon("images\\playground.png");
        JLabel backgroundLabel = new JLabel(backgroundImage);
        setContentPane(backgroundLabel);
        add(muteButton);

        backk = new ImageIcon("images\\back.png");
        backwhite = new ImageIcon("images\\backwhite.png");
        back = new JButton(backk);
        back.setBackground(null);
        back.setContentAreaFilled(false);
        back.setBorderPainted(false);
        back.setBounds(10, 30, backk.getIconWidth(), backk.getIconHeight());
        add(back);
        back.addActionListener(this);
        back.addMouseListener(this);

        hmlogo = new ImageIcon("images\\hmlogo.png");
        hmgif = new ImageIcon("images\\hmgif.gif");
        hm = new JButton(hmlogo);
        hm.setBounds(198, 225, hmlogo.getIconWidth(), hmlogo.getIconHeight());
        add(hm);
        hm.addActionListener(this);
        hm.addMouseListener(this);

        setVisible(true);
    }

    public static void main(String[] args) {
        new playground();
    }

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
        if (e.getSource() == back) {
            back.setIcon(backwhite);
        }
        if (e.getSource() == hm) {
            hm.setIcon(hmgif);
        }

    }

    @Override
    public void mouseExited(MouseEvent e) {
        if (e.getSource() == back) {
            back.setIcon(backk);
        }
        if (e.getSource() == hm) {
            hm.setIcon(hmlogo);
        }
    }

    @Override
    public void actionPerformed(ActionEvent e) {

        if (e.getSource() == back) {
            returntomm bb = new returntomm();
            clip.stop();
            bb.setVisible(true);
            setVisible(false);

        }

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

        if (e.getSource() == hm){
            Hangman hangman = new Hangman();
            clip.stop();
            hangman.setVisible(true);
            setVisible(false);
        }

    }
}
