import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;

import javax.swing.*;

public class Second extends JFrame implements ActionListener {

    private ImageIcon imageIcon;
    private ImageIcon backgroundImage;
    private JTextField textField;
    private JLabel label;
    private ImageIcon left, right, buttonImage;
    private JButton leftbtn, rightbtn, imageButton;
    private int i = 0;
    private File file, name1;

    public Second() {
        setTitle("My Space Friend");
        setSize(900, 500);
        setLocationRelativeTo(null);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        file = new File("Icon.txt");
        name1 = new File("name.txt");

        try {
            FileWriter writer = new FileWriter(file);
            writer.write("0");
            writer.close();
        } catch (IOException ee) {
            ee.printStackTrace();
        }

        backgroundImage = new ImageIcon("plainbg.png");
        JLabel backgroundLabel = new JLabel(backgroundImage);
        setContentPane(backgroundLabel);

        imageIcon = new ImageIcon("dog.png");
        label = new JLabel(imageIcon);
        label.setBounds(350, 35, imageIcon.getIconWidth(), imageIcon.getIconHeight());
        add(label);

        ImageIcon imageIcon1 = new ImageIcon("enter.png");
        JLabel labels = new JLabel(imageIcon1);
        labels.setBounds(275, 235, imageIcon1.getIconWidth(), imageIcon1.getIconHeight());
        add(labels);

        Font font = new Font("Arial", Font.PLAIN, 18);
        textField = new JTextField();
        textField.setFont(font);
        textField.setBounds(372, 310, 150, 30);
        add(textField);

        left = new ImageIcon("arrleft.jpg");
        leftbtn = new JButton(left);
        leftbtn.setBorderPainted(false);
        leftbtn.setBounds(250, 115, 50, 50);

        right = new ImageIcon("arrright.jpg");
        rightbtn = new JButton(right);
        rightbtn.setBorderPainted(false);
        rightbtn.setBounds(575, 115, 50, 50);

        buttonImage = new ImageIcon("btbtn.png");
        imageButton = new JButton(buttonImage);
        imageButton.setBounds(320, 350, buttonImage.getIconWidth(), buttonImage.getIconHeight());

        add(leftbtn);
        add(rightbtn);
        add(imageButton);

        imageButton.addActionListener(this);
        leftbtn.addActionListener(this);
        rightbtn.addActionListener(this);

        setLayout(null);

    }

    public void actionPerformed(ActionEvent e) {
        String name = textField.getText();

        if (e.getSource() == imageButton) {
            if (name.isEmpty()) {
                JOptionPane.showMessageDialog(this, "Please enter a name", "Error", JOptionPane.ERROR_MESSAGE);
            } else if (!name.matches("^[a-zA-Z0-9]*$")) {
                JOptionPane.showMessageDialog(this, "Please only enter alpha numeric characters", "Error",
                        JOptionPane.ERROR_MESSAGE);
            } else if (name.length() > 10) {
                JOptionPane.showMessageDialog(this, "Name should not exist ten(10) characters", "Error",
                        JOptionPane.ERROR_MESSAGE);
            } else {
                Message main = new Message();

                try {
                    FileWriter writer = new FileWriter(name1);
                    writer.write(name);
                    writer.close();
                } catch (IOException ee) {
                    ee.printStackTrace();
                }

                setVisible(false);
                main.setVisible(true);
            }
        }

        if (e.getSource() == leftbtn) {
            if (i == 0) {
                imageIcon = new ImageIcon("cat.png");
                label.setIcon(imageIcon);
                i++;

                try {
                    FileWriter writer = new FileWriter(file);
                    writer.write("1");
                    writer.close();
                } catch (IOException ee) {
                    ee.printStackTrace();
                }

            } else if (i == 1) {
                imageIcon = new ImageIcon("dog.png");
                label.setIcon(imageIcon);
                i--;

                try {
                    FileWriter writer = new FileWriter(file);
                    writer.write("0");
                    writer.close();
                } catch (IOException ee) {
                    ee.printStackTrace();
                }
            }
        }

        if (e.getSource() == rightbtn) {
            if (i == 0) {
                imageIcon = new ImageIcon("cat.png");
                label.setIcon(imageIcon);
                i++;

                try {
                    FileWriter writer = new FileWriter(file);
                    writer.write("1");
                    writer.close();
                } catch (IOException ee) {
                    ee.printStackTrace();
                }

            } else if (i == 1) {
                imageIcon = new ImageIcon("dog.png");
                label.setIcon(imageIcon);
                i--;

                try {
                    FileWriter writer = new FileWriter(file);
                    writer.write("0");
                    writer.close();
                } catch (IOException ee) {
                    ee.printStackTrace();
                }
            }
        }
    }

    public static void main(String[] args) {
        Second window = new Second();
        window.setVisible(true);
    }
}
