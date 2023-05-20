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

public class kitchen extends JFrame implements ActionListener, MouseListener{
    
    ImageIcon backk, backwhite, mute, muted;
    JButton back, muteButton;
    Clip clip;
    Boolean isMuted = false;

    public kitchen() {

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
        

        ImageIcon backgroundImage = new ImageIcon("images\\kitchen.png");
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

        setVisible(true);
    }

    public static void main(String[] args) {
        new kitchen();
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
        back.setIcon(backwhite);
    }

    @Override
    public void mouseExited(MouseEvent e) {
        back.setIcon(backk);
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

    }
}
