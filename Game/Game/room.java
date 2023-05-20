package Game;
import java.awt.Color;
import java.awt.Font;
//import java.awt.Image;
//import java.awt.TextArea;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
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
import javax.swing.Timer;

import LoadingScreens.returntomm;
import ProgressBarColors.*;

import static java.nio.file.StandardOpenOption.*;

import javax.sound.sampled.AudioInputStream;
import javax.sound.sampled.AudioSystem;
import javax.sound.sampled.Clip;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JProgressBar;
import javax.swing.JTextArea;

public class room extends JFrame implements ActionListener, MouseListener {

    ImageIcon bg, dbg, mute, muted, dddbg;
    JLabel bglabel;
    JButton muteButton, switchee, duck, back;
    ImageIcon backk, backwhite;

    Clip clip, clip2;
    boolean isMuted = false, isDark = false;
    int coins;
    Path file;
    BufferedWriter writer;
    JProgressBar healthBar, hungerBar, energyBar;
    Timer hTimer, eTimer;
    JTextArea hunger, energy, health;

    public room() {
        setTitle("PAWSTRONAUT");
        setSize(1350, 750);
        setLocationRelativeTo(null);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setResizable(false);

        Color brown = new Color(205, 133, 63);

        Font font = new Font("Arial", Font.BOLD, 15);

        healthBar = new JProgressBar(0, 100);
        healthBar.setValue(50);
        healthBar.setUI(new RedProgressBarUI());
        healthBar.setBounds(1200, 10, 100, 20);

        health = new JTextArea("Health: " + healthBar.getValue());
        health.setBounds(1220, 35, 100, 20);
        health.setBorder(null);
        health.setFont(font);
        health.setForeground(Color.RED);
        health.setEditable(false);
        health.setOpaque(false);

        add(health);
        add(healthBar);

        hTimer = new Timer(5000, this);
        hTimer.start();

        hungerBar = new JProgressBar(0, 100);
        hungerBar.setValue(50);
        hungerBar.setUI(new BrownProgressBarUI());
        hungerBar.setBounds(1200, 60, 100, 20);
        add(hungerBar);

        hunger = new JTextArea("Hunger: " + hungerBar.getValue());
        hunger.setBounds(1220, 85, 100, 20);
        hunger.setBorder(null);
        hunger.setFont(font);
        hunger.setForeground(brown);
        hunger.setEditable(false);
        hunger.setOpaque(false);
        add(hunger);

        energyBar = new JProgressBar(0, 100);
        energyBar.setValue(50);
        energyBar.setUI(new YellowProgressBarUI());
        energyBar.setBounds(1200, 110, 100, 20);
        add(energyBar);

        energy = new JTextArea("Energy: " + energyBar.getValue());
        energy.setBounds(1220, 135, 100, 20);
        energy.setBorder(null);
        energy.setEditable(false);
        energy.setFont(font);
        energy.setForeground(Color.YELLOW);
        energy.setOpaque(false);
        add(energy);

        eTimer = new Timer(5000, this);
        eTimer.start();

        file = Paths.get("db\\coins.txt");
        try {
            Scanner scan = new Scanner(file);

            coins = scan.nextInt();

            scan.close();
        } catch (Exception e) {
            e.printStackTrace();
        }

        bg = new ImageIcon("images\\19.png");
        dbg = new ImageIcon("images\\20.jpg");

        bglabel = new JLabel(bg);

        duck = new JButton();
        duck.setBounds(1050, 600, 75, 60);
        duck.setContentAreaFilled(false);
        duck.setBorderPainted(false);
        add(duck);
        duck.addActionListener(this);

        switchee = new JButton();
        switchee.setContentAreaFilled(false);
        switchee.setBorderPainted(false);
        switchee.setBounds(637, 55, 130, 150);

        switchee.addActionListener(this);

        add(switchee);

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

        mute = new ImageIcon("images\\unmute.png");
        muted = new ImageIcon("images\\mute.png");
        muteButton = new JButton(mute);
        muteButton.setBorder(null);
        muteButton.addActionListener(this);
        muteButton.setBounds(1300, 680, 30, 30);
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

        try {
            File file = new File("images\\rubber.wav");
            AudioInputStream audioStream = AudioSystem.getAudioInputStream(file);

            clip2 = AudioSystem.getClip();
            clip2.open(audioStream);
        } catch (Exception e) {
            e.printStackTrace();
        }

        add(bglabel);

    }

    public void actionPerformed(ActionEvent e) {

        if (e.getSource() == hTimer) {
            int hvalue = hungerBar.getValue();
            hvalue -= 1;
            hungerBar.setValue(hvalue);
            hunger.setText("Hunger: " + hungerBar.getValue());
        }

        if (e.getSource() == eTimer) {
            if (isDark) {
                int evalue = energyBar.getValue();
                evalue += 5;
                energyBar.setValue(evalue);
                energy.setText("Energy: " + energyBar.getValue());
            }
        }

        OutputStream output;
        try {
            output = new BufferedOutputStream(Files.newOutputStream(file, CREATE));
            writer = new BufferedWriter(new OutputStreamWriter(output));
        } catch (IOException e1) {
            e1.printStackTrace();
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

        if (e.getSource() == switchee) {
            if (bglabel.getIcon().toString().equals("images\\19.png")) {
                bglabel.setIcon(dbg);
                isDark = true;

                coins -= 5;

                try {
                    writer.write(String.valueOf(coins));
                    writer.flush();
                } catch (IOException e1) {
                    e1.printStackTrace();
                }
            } else if (bglabel.getIcon().toString().equals("images\\20.jpg")) {
                bglabel.setIcon(bg);
                isDark = false;
            }
        }

        if (e.getSource() == duck) {
            clip2.setFramePosition(0);
            clip2.start();
        }

        if (e.getSource() == back) {
            returntomm bb = new returntomm();
            clip.stop();
            bb.setVisible(true);
            setVisible(false);

        }

    }

    public static void main(String[] args) {
        room grr = new room();
        grr.setVisible(true);
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

}
