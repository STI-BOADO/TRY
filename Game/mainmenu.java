import java.awt.Graphics;
import java.awt.Image;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.io.File;
import java.io.IOException;

import javax.imageio.ImageIO;
import javax.sound.sampled.AudioInputStream;
import javax.sound.sampled.AudioSystem;
import javax.sound.sampled.Clip;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;

public class mainmenu extends JFrame implements ActionListener, MouseListener {

    private ImageIcon backgroundImage, mute, muted;
    private ImageIcon left, right;
    private ImageIcon options, options1, options2, options3, options4, options5, options6;
    private JButton leftbtn, rightbtn, muteButton;
    private JButton enter;
    private ImageIcon entering, hoverenter;
    private JLabel label;
    Clip clip, clip2;
    boolean isMuted = false;

    int[][] circles = {
            { 100, 338, 65, 65 },
            { 240, 335, 80, 80 },
            { 410, 325, 100, 100 },
            { 575, 275, 200, 200 },
            { 835, 325, 100, 100 },
            { 1005, 335, 80, 80 },
            { 1150, 338, 65, 65 }
    };

    public mainmenu() {
        setTitle("My Space Friend");
        setSize(1350, 750);
        setLocationRelativeTo(null);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setResizable(false);

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

        ImageIcon comet = new ImageIcon("images\\comet.gif");
        JLabel cometlabel = new JLabel(comet);
        cometlabel.setBounds(900, 0, comet.getIconWidth(), comet.getIconHeight());
        add(cometlabel);

        left = new ImageIcon("images\\arrleft.jpg");
        leftbtn = new JButton(left);
        leftbtn.setBorderPainted(false);
        leftbtn.setBounds(25, 345, 50, 50);

        right = new ImageIcon("images\\arrright.jpg");
        rightbtn = new JButton(right);
        rightbtn.setBorderPainted(false);
        rightbtn.setBounds(1240, 345, 50, 50);

        entering = new ImageIcon("images\\btbtn1.png");
        hoverenter = new ImageIcon("images\\image.png");
        enter = new JButton(entering);
        enter.setBorder(null);
        enter.setBounds(605, 555, entering.getIconWidth(), entering.getIconHeight());

        add(enter);
        add(leftbtn);
        add(rightbtn);

        options = new ImageIcon("images\\o1.png");
        options1 = new ImageIcon("images\\o2.png");
        options2 = new ImageIcon("images\\o3.png");
        options3 = new ImageIcon("images\\o4.png");
        options4 = new ImageIcon("images\\o5.png");
        options5 = new ImageIcon("images\\o6.png");
        options6 = new ImageIcon("images\\o7.png");
        label = new JLabel(options);
        label.setBounds(599, 180, options.getIconWidth(), options.getIconHeight());
        add(label);

        enter.addMouseListener(this);
        enter.addActionListener(this);
        leftbtn.addActionListener(this);
        rightbtn.addActionListener(this);

        backgroundImage = new ImageIcon("images\\plainbg.png");

        JPanel panel = new JPanel() {
            public void paintComponent(Graphics g) {
                super.paintComponent(g);

                g.drawImage(backgroundImage.getImage(), 0, 0, getWidth(), getHeight(), null);

                for (int i = 0; i < circles.length; i++) {
                    int[] c = circles[i];
                    Image img = null;
                    try {
                        img = ImageIO.read(new File("images\\image" + (i + 1) + ".png"));
                    } catch (IOException e) {
                        e.printStackTrace();
                    }
                    g.drawImage(img, c[0], c[1], c[2], c[3], null);
                }
            }
        };

        add(panel);
        setVisible(true);
    }

    public void actionPerformed(ActionEvent e) {
        if (e.getSource() == leftbtn) {
            int[] temp = circles[circles.length - 1];
            for (int i = circles.length - 1; i > 0; i--) {
                circles[i] = circles[i - 1];
            }
            circles[0] = temp;
            if (circles[0][0] == 100){
                label.setIcon(options);
            } else if (circles[0][0] == 240){
                label.setIcon(options1);
            } else if (circles[0][0] == 410){
                label.setIcon(options2);
            } else if (circles[0][0] == 575){
                label.setIcon(options3);
            } else if (circles[0][0] == 835){
                label.setIcon(options4);
            } else if (circles[0][0] == 1005){
                label.setIcon(options5);
            } else {
                label.setIcon(options6);
            }
        }

        if (e.getSource() == rightbtn) {
            int[] temp = circles[0];
            for (int i = 0; i < circles.length - 1; i++) {
                circles[i] = circles[i + 1];
            }
            circles[circles.length - 1] = temp;
            if (circles[0][0] == 100){
                label.setIcon(options);
            } else if (circles[0][0] == 240){
                label.setIcon(options1);
            } else if (circles[0][0] == 410){
                label.setIcon(options2);
            } else if (circles[0][0] == 575){
                label.setIcon(options3);
            } else if (circles[0][0] == 835){
                label.setIcon(options4);
            } else if (circles[0][0] == 1005){
                label.setIcon(options5);
            } else {
                label.setIcon(options6);
            }
        }

        if (e.getSource() == enter) {
            if (circles[0][0] == 100){
                room room = new room();
                //clip.stop();
                room.setVisible(true);
                setVisible(false);
                dispose();
            } else if (circles[0][0] == 240){
                System.out.print("YES TAMA 2");
            } else if (circles[0][0] == 410){
                System.out.print("YES TAMA 3");
            } else if (circles[0][0] == 575){
                System.out.print("YES TAMA 4");
            } else if (circles[0][0] == 835){
                System.out.print("YES TAMA 5");
            } else if (circles[0][0] == 1005){
                System.out.print("YES TAMA 6");
            } else {
                System.out.print("YES TAMA 7");
            }
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
        repaint();
    }

    public static void main(String args[]) {
        mainmenu window = new mainmenu();
        window.setVisible(true);
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
        enter.setIcon(hoverenter);
    }

    @Override
    public void mouseExited(MouseEvent e) {
        enter.setIcon(entering);
    }
}