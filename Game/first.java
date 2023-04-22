
import java.awt.event.*;
import javax.swing.*;

public class first extends JFrame{
    private ImageIcon backgroundImage, darkenter, buttonImage;
    private JButton imageButton;

    public first() {
        
        setTitle("My Space Friend");
        setSize(900, 500);
        setLocationRelativeTo(null);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setResizable(false);

        backgroundImage = new ImageIcon("images\\bgbgbg.png");
        JLabel backgroundLabel = new JLabel(backgroundImage);
        ImageIcon bg = new ImageIcon("images\\plainbg.png");
        JLabel bgLabel = new JLabel(bg);

        
        JFrame loadingScreen = new JFrame();
        loadingScreen.setSize(900, 500);
        loadingScreen.setLocationRelativeTo(null);
        loadingScreen.setDefaultCloseOperation(JFrame.DO_NOTHING_ON_CLOSE);
        loadingScreen.setContentPane(bgLabel);
        ImageIcon loadingImage = new ImageIcon("images\\loading.gif");
        JLabel loadingLabel = new JLabel(loadingImage);
        loadingLabel.setBounds(340, 140, loadingImage.getIconWidth(), loadingImage.getIconHeight());
        loadingScreen.add(loadingLabel);
        loadingScreen.setVisible(true);

        try {
            Thread.sleep(2000);
        } catch (InterruptedException ex) {
            ex.printStackTrace();
        }

        loadingLabel.setIcon(null);

        loadingScreen.setVisible(false);
        
        setContentPane(backgroundLabel);

        ImageIcon rocket = new ImageIcon("images\\rocket.gif");
        JLabel rocketlabel = new JLabel(rocket);
        rocketlabel.setBounds(0, 240, rocket.getIconWidth(), rocket.getIconHeight());
        add(rocketlabel);

        buttonImage = new ImageIcon("images\\btbtn.png");
        darkenter = new ImageIcon("images\\darkdark.png");
        imageButton = new JButton(buttonImage);
        imageButton.setBorder(null);
        imageButton.setBounds(320, 330, buttonImage.getIconWidth(), buttonImage.getIconHeight());
        add(imageButton);

        imageButton.addMouseListener(new MouseListener() {

            @Override
            public void mouseClicked(MouseEvent e) {
                // TODO Auto-generated method stub
                throw new UnsupportedOperationException("Unimplemented method 'mouseClicked'");
            }

            @Override
            public void mousePressed(MouseEvent e) {
                // TODO Auto-generated method stub
                throw new UnsupportedOperationException("Unimplemented method 'mousePressed'");
            }

            @Override
            public void mouseReleased(MouseEvent e) {
                // TODO Auto-generated method stub
                throw new UnsupportedOperationException("Unimplemented method 'mouseReleased'");
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
