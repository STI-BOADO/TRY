package LoadingScreens;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.File;
import java.util.Scanner;

import javax.sound.sampled.AudioInputStream;
import javax.sound.sampled.AudioSystem;
import javax.sound.sampled.Clip;
import javax.swing.ImageIcon;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.Timer;

import Game.clinic;
import Game.kitchen;
import Game.playground;
import Game.room;

public class lds extends JFrame implements ActionListener {

    int planet;
    Clip clip;

    public lds(){

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

        ImageIcon loadingIcon = new ImageIcon("images\\lds.gif");
        JLabel load = new JLabel(loadingIcon);
        load.setBounds(getWidth()/2 - loadingIcon.getIconWidth()/2, getHeight()/2 - loadingIcon.getIconHeight()/2, loadingIcon.getIconWidth(), loadingIcon.getIconHeight());
        add(load);

        Timer timer = new Timer(4000, this);
        timer.setRepeats(false);
        timer.start();
    }

    public void actionPerformed(ActionEvent e) {
        File file = new File("db\\lds.txt");

        try {
            Scanner scanner = new Scanner(file);

            planet = scanner.nextInt();

            scanner.close();

        } catch (Exception ex) {
            ex.printStackTrace();
        }

        if (planet == 0){

            setVisible(false);
            dispose();
            clip.stop();
            room room = new room();
            room.setVisible(true);

        } else if (planet == 1){

            setVisible(false);
            dispose();
            clip.stop();
            kitchen kitchen = new kitchen();
            kitchen.setVisible(true);

        } else if (planet == 2){

            System.out.print("2");

        } else if (planet == 3){

            setVisible(false);
            dispose();
            clip.stop();
            playground playground = new playground();
            playground.setVisible(true);
            
        } else if (planet == 4){

            System.out.print("4");

        } else if (planet == 5){

            setVisible(false);
            dispose();
            clip.stop();
            clinic clinic = new clinic();
            clinic.setVisible(true);

        } else {

            System.out.print("6");

        }
    }

    public static void main(String[] args) {
        new lds().setVisible(true);
    }
}
