import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;

import javax.swing.*;

public class Second extends JFrame implements ActionListener, MouseListener {

    private ImageIcon imageIcon;
    private ImageIcon backgroundImage;
    private JTextField textField;
    private JLabel label;
    private ImageIcon left, right, enter, darkenter;
    private JButton leftbtn, rightbtn, imageButton;
    private int i = 0;
    private File file, name1;

    public Second() {
        setTitle("My Space Friend");
        setSize(900, 500);
        setLocationRelativeTo(null);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setResizable(false);

        file = new File("Icon.txt");
        name1 = new File("name.txt");

        try {
            FileWriter writer = new FileWriter(file);
            writer.write("0");
            writer.close();
        } catch (IOException ee) {
            ee.printStackTrace();
        }

        backgroundImage = new ImageIcon("images\\plainbg.png");
        JLabel backgroundLabel = new JLabel(backgroundImage);
        setContentPane(backgroundLabel);

        imageIcon = new ImageIcon("images\\dog.png");
        label = new JLabel(imageIcon);
        label.setBounds(350, 35, imageIcon.getIconWidth(), imageIcon.getIconHeight());
        add(label);

        ImageIcon imageIcon1 = new ImageIcon("images\\enter.png");
        JLabel labels = new JLabel(imageIcon1);
        labels.setBounds(275, 235, imageIcon1.getIconWidth(), imageIcon1.getIconHeight());
        add(labels);

        Font font = new Font("Arial", Font.PLAIN, 18);
        textField = new JTextField();
        textField.setFont(font);
        textField.setBounds(372, 310, 150, 30);
        add(textField);

        left = new ImageIcon("images\\arrleft.jpg");
        leftbtn = new JButton(left);
        leftbtn.setBorderPainted(false);
        leftbtn.setBounds(250, 115, 50, 50);

        right = new ImageIcon("images\\arrright.jpg");
        rightbtn = new JButton(right);
        rightbtn.setBorderPainted(false);
        rightbtn.setBounds(575, 115, 50, 50);

        enter = new ImageIcon("images\\btbtn.png");
        darkenter = new ImageIcon("images\\darkdark.png");
        imageButton = new JButton(enter);
        imageButton.setBorder(null);
        imageButton.setBounds(320, 350, enter.getIconWidth(), enter.getIconHeight());

        add(leftbtn);
        add(rightbtn);
        add(imageButton);

        imageButton.addActionListener(this);
        leftbtn.addActionListener(this);
        rightbtn.addActionListener(this);
        imageButton.addMouseListener(this);

        setLayout(null);

    }

    public void actionPerformed(ActionEvent e) {
        String name = textField.getText();

        try {
            FileWriter writer = new FileWriter(name1);
            writer.write(name);
            writer.close();
        } catch (IOException ee) {
            ee.printStackTrace();
        }

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

                setVisible(false);
                main.setVisible(true);
            }
        }

        if (e.getSource() == leftbtn) {
            if (i == 0) {
                imageIcon = new ImageIcon("images\\cat.png");
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
                imageIcon = new ImageIcon("images\\dog.png");
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
            else if (e.getSource() == rightbtn) {
            if (i == 0) {
                imageIcon = new ImageIcon("images\\cat.png");
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
                imageIcon = new ImageIcon("images\\dog.png");
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
        // TODO Auto-generated method stub
        imageButton.setIcon(enter);
    }
}