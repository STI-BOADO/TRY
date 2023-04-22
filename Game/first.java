
import java.awt.event.*;
import javax.swing.*;

public class first extends JFrame {
    private ImageIcon backgroundImage;
    private JButton imageButton;

    public first() {
        // Set the window properties
        setTitle("My Space Friend");
        setSize(900, 500);
        setLocationRelativeTo(null);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        // Create and show the loading screen
        JFrame loadingScreen = new JFrame();
        loadingScreen.setSize(200, 200);
        loadingScreen.setLocationRelativeTo(null);
        loadingScreen.setDefaultCloseOperation(JFrame.DO_NOTHING_ON_CLOSE);
        ImageIcon loadingImage = new ImageIcon("loading.gif");
        JLabel loadingLabel = new JLabel(loadingImage);
        loadingScreen.add(loadingLabel);
        loadingScreen.setVisible(true);

        try {
            Thread.sleep(2000);
        } catch (InterruptedException ex) {
            ex.printStackTrace();
        }

        // Set the background image
        backgroundImage = new ImageIcon("bgbgbg.png");
        JLabel backgroundLabel = new JLabel(backgroundImage);
        setContentPane(backgroundLabel);

        // Set the image button
        ImageIcon buttonImage = new ImageIcon("btbtn.png");
        imageButton = new JButton(buttonImage);
        imageButton.setBounds(320, 330, buttonImage.getIconWidth(), buttonImage.getIconHeight());
        add(imageButton);

        // Add action listener for the button
        imageButton.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                Second eto = new Second();
                setVisible(false);
                eto.setVisible(true);
                loadingScreen.setVisible(false); // Hide or dispose the loading screen
            }
        });
    }

    public static void main(String[] args) {
        first window = new first();
        window.setVisible(true);
    }
}
