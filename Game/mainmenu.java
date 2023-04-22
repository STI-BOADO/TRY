import java.awt.Graphics;
import java.awt.Image;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.File;
import java.io.IOException;

import javax.imageio.ImageIO;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;

public class mainmenu extends JFrame implements ActionListener {

    private ImageIcon backgroundImage;
    private ImageIcon left, right;
    private JButton leftbtn, rightbtn;
    
    int[][] circles = {
        {145, 225, 50, 50},
        {215, 217, 65, 65},
        {300, 210, 80, 80},
        {400, 200, 100, 100},
        {520, 210, 80, 80},
        {620, 217, 65, 65},
        {700, 225, 50, 50}
    };

    public mainmenu() {
        setTitle("My Space Friend");
        setSize(900, 500);
        setLocationRelativeTo(null);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        left = new ImageIcon("arrleft.jpg");
        leftbtn = new JButton(left); 
        leftbtn.setBorderPainted(false);
        leftbtn.setBounds(50, 225, 50, 50);

        right = new ImageIcon("arrright.jpg");
        rightbtn = new JButton(right); 
        rightbtn.setBorderPainted(false);
        rightbtn.setBounds(800, 225,50,50);

        add(leftbtn);
        add(rightbtn);

        leftbtn.addActionListener(this);
        rightbtn.addActionListener(this);

        backgroundImage = new ImageIcon("plainbg.png");

        JPanel panel = new JPanel() {
            public void paintComponent(Graphics g) {
                super.paintComponent(g);

                g.drawImage(backgroundImage.getImage(), 0, 0, getWidth(), getHeight(), null);

                for (int i = 0; i < circles.length; i++) {
                    int[] c = circles[i];
                    Image img = null;
                    try {
                        img = ImageIO.read(new File("image" + (i + 1) + ".png"));
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

    public void actionPerformed(ActionEvent e){
        if (e.getSource() == leftbtn){
            int[] temp = circles[circles.length-1];
            for(int i = circles.length-1; i > 0; i--) {
                circles[i] = circles[i-1];
            }
            circles[0] = temp;
        }
        if (e.getSource() == rightbtn){
            int[] temp = circles[0];
            for(int i = 0; i < circles.length-1; i++) {
                circles[i] = circles[i+1];
            }
            circles[circles.length-1] = temp;
        }
        repaint();
    }

    public static void main(String args[]){
        mainmenu window = new mainmenu();
        window.setVisible(true);
    }
}
