import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.File;
import java.util.Scanner;

import javax.sound.sampled.AudioInputStream;
import javax.sound.sampled.AudioSystem;
import javax.sound.sampled.Clip;
import javax.swing.*;

public class Message extends JFrame implements ActionListener {

   private ImageIcon backgroundImage, field;
   private ImageIcon cat, dog, mute, muted;
   private JLabel label, labels;
   private int number;
   private String name;
   private JButton go, muteButton;
   private ImageIcon gogo;
   private Clip clip;
   private boolean isMuted = false;


   public Message(){
      File file = new File("Icon.txt");
      File file1 = new File("name.txt");

      setTitle("My Space Friend");
      setSize(900, 500);
      setLocationRelativeTo(null);
      setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
      setResizable(false);

      mute = new ImageIcon("images\\audio-speaker.png");
        muted = new ImageIcon("images\\mute.png");
        muteButton = new JButton(mute);
        muteButton.setBorder(null);
        muteButton.addActionListener(this);
        muteButton.setBounds(860, 440, 20, 20);
        add(muteButton);

        try {
            File file11 = new File("images\\bgm.wav");
            AudioInputStream audioStream = AudioSystem.getAudioInputStream(file11);

            clip = AudioSystem.getClip();
            clip.open(audioStream);
            clip.loop(Clip.LOOP_CONTINUOUSLY);
        } catch (Exception e) {
            e.printStackTrace();
        }

      try {
         Scanner scanner = new Scanner(file1);

         name = scanner.nextLine();

         scanner.close();

      } catch (Exception e) {
         e.printStackTrace();
      }

      field = new ImageIcon("images\\field.png");
      backgroundImage = new ImageIcon("images\\plainbg.png");
      JLabel backgroundLabel = new JLabel(backgroundImage);
      setContentPane(backgroundLabel);

      JTextArea textField = new JTextArea();
      textField.setLineWrap(true);
      textField.setWrapStyleWord(true);
      textField.setText("HELLO THERE! I'M " + name.toUpperCase() + ", I WILL BE YOUR PAW FRIEND. I'VE BEEN SENT HERE AS A GUIDE FOR PEOPLE LIKE YOU WHO WANTS TO EXPLORE THE SPACE. YOU CAN LEARN A LOT ABOUT LIVING IN SPACE WITH ME. COME ON AND JOIN ME IN MY ADVENTURE!" );
      textField.setEditable(false);
      Font font = new Font("Arial", Font.BOLD, 24);
      textField.setFont(font);
      textField.setOpaque(false);
      textField.setBorder(null);
      textField.setBounds(110, 55, field.getIconWidth() - 20, field.getIconHeight() - 10);
      textField.setAlignmentY(JTextArea.TOP_ALIGNMENT);
      add(textField);

      gogo = new ImageIcon("images\\gobe.png");
      go = new JButton(gogo);
      go.setBorder(null);
      go.setBounds(650, 350, gogo.getIconWidth(), gogo.getIconHeight());
      go.addActionListener(this);
      go.setEnabled(true);
      add(go);

      JLabel lapel = new JLabel(field);
      lapel.setBounds(100, 50, field.getIconWidth(), field.getIconHeight());
      add(lapel);

      try {
         Scanner scanner = new Scanner(file);

         number = scanner.nextInt();

         scanner.close();

      } catch (Exception e) {
         e.printStackTrace();
      }

      cat = new ImageIcon("images\\Catnip.png");
      dog = new ImageIcon("images\\Dognip.png");
      if(number == 0){
        label = new JLabel(dog);
        label.setBounds(75, 320, dog.getIconWidth(), dog.getIconHeight());
        add(label);
      } else {
        labels = new JLabel(cat);
        labels.setBounds(75, 320, cat.getIconWidth(), cat.getIconHeight());
        add(labels);
      }

      setLayout(null);
   }

   public void actionPerformed(ActionEvent e) {
      if(e.getSource() == go){
      mainmenu mainmenu = new mainmenu();
      clip.stop();
      setVisible(false);
      mainmenu.setVisible(true);
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

   public static void main(String[] args) {
      Message message = new Message();
      message.setVisible(true);
   }

}