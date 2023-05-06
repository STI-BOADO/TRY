import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.BufferedOutputStream;
import java.io.BufferedWriter;
import java.io.File;
import java.io.IOException;
import java.io.OutputStream;
import java.io.OutputStreamWriter;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.Scanner;
import static java.nio.file.StandardOpenOption.*;

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
    int coins;
    Path file;
    BufferedWriter writer;

    public room() {
        setTitle("My Space Friend");
        setSize(1350, 750);
        setLocationRelativeTo(null);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setResizable(false);

        file = Paths.get("coins.txt");
        try{
            Scanner scan = new Scanner(file);

            coins = scan.nextInt();

            scan.close();
        } catch (Exception e){
            e.printStackTrace();
        }

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

        /*mute = new ImageIcon("images\\audio-speaker.png");
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
        }*/

        add(bglabel);

        /*try {
            File file = new File("images\\rubber.wav");
            AudioInputStream audioStream = AudioSystem.getAudioInputStream(file);

            clip2 = AudioSystem.getClip();
            clip2.open(audioStream);
        } catch (Exception e) {
            e.printStackTrace();
        }*/

    }

    public void actionPerformed(ActionEvent e) {

        OutputStream output;
        try {
            output = new BufferedOutputStream(Files.newOutputStream(file, CREATE));
            writer = new BufferedWriter(new OutputStreamWriter(output));
        } catch (IOException e1) {
            // TODO Auto-generated catch block
            e1.printStackTrace();
        }

        /*if (e.getSource() == muteButton) {
            if (isMuted) {
                clip.loop(Clip.LOOP_CONTINUOUSLY);
                muteButton.setIcon(mute);
                isMuted = false;
            } else {
                clip.stop();
                muteButton.setIcon(muted);
                isMuted = true;
            }
        }*/

        if (e.getSource() == switchee) {
            if (bglabel.getIcon().toString().equals("images\\19.jpg")) {
                bglabel.setIcon(dbg);
                int ucoins = coins - 5;

                String coco = ucoins + "";  

                try {
                    writer.write(coco);
                    writer.newLine();
                    writer.flush();
                } catch (IOException e1) {
                    // TODO Auto-generated catch block
                    e1.printStackTrace();
                }
            } else if (bglabel.getIcon().toString().equals("images\\20.jpg")) {
                bglabel.setIcon(bg);
            }
        }

        /*if (e.getSource() == duck) {
            clip2.setFramePosition(0);
            clip2.start();
        }*/

        if (e.getSource() == back) {
            mainmenu bb = new mainmenu();
            //clip.stop();
            bb.setVisible(true);
            setVisible(false);

        }

    }

    public static void main(String[] args) {
        room grr = new room();
        grr.setVisible(true);
    }
}
