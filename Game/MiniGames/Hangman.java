package MiniGames;

import java.awt.Color;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import java.util.HashSet;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JTextArea;
import javax.swing.JTextField;
import javax.swing.JTextPane;
import javax.swing.SwingUtilities;
import javax.swing.text.SimpleAttributeSet;
import javax.swing.text.StyleConstants;
import javax.swing.text.StyledDocument;

import LoadingScreens.returntomm;

public class Hangman extends JFrame implements ActionListener {

    ImageIcon hang, hang1, hang2, hang3, hang4, hang5, hang6, hang7, hang8;
    JButton submit;
    JTextPane answer;
    String word, gword;
    JTextField guess;
    JLabel hanglabel;
    int a = 0;
    private HashSet<Character> guessedLetters = new HashSet<>();

    public Hangman() {

        setTitle("PAWSTRONAUT - HANGMAN");
        setSize(1350, 750);
        setLocationRelativeTo(null);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setResizable(false);

        ImageIcon backgroundImage = new ImageIcon("images\\plainbg.png");
        JLabel backgroundLabel = new JLabel(backgroundImage);
        setContentPane(backgroundLabel);

        hang = new ImageIcon("images\\hm1.png");
        hang1 = new ImageIcon("images\\hm2.png");
        hang2 = new ImageIcon("images\\hm3.png");
        hang3 = new ImageIcon("images\\hm4.png");
        hang4 = new ImageIcon("images\\hm5.png");
        hang5 = new ImageIcon("images\\hm6.png");
        hang6 = new ImageIcon("images\\hm7.png");
        hang7 = new ImageIcon("images\\hm8.png");
        hang8 = new ImageIcon("images\\hm9.png");
        hanglabel = new JLabel();
        hanglabel.setBounds(getWidth() / 2 - 540 / 2, getHeight() / 2 - 462 / 2 - 100, 600, 462);
        add(hanglabel);

        WordDatabase.main(null);
        word = WordDatabase.getWord();

        JTextArea hname = new JTextArea("HINT: ");
        hname.setBackground(null);
        hname.setEditable(false);
        Font f = new Font("Arial", Font.BOLD, 40);
        hname.setFont(f);
        hname.setOpaque(false);
        hname.setForeground(Color.WHITE);
        hname.setBounds(150, 50, 120, 50);
        add(hname);

        String hintString = WordDatabase.getHint();
        JTextPane hint = new JTextPane();
        hint.setText(hintString);
        hint.setBounds(150, 100, 300, 150);
        Font font = new Font("ARIAL", Font.BOLD, 20);
        hint.setFont(font);
        StyledDocument doc = hint.getStyledDocument();
        SimpleAttributeSet center = new SimpleAttributeSet();
        StyleConstants.setAlignment(center, StyleConstants.ALIGN_CENTER);
        doc.setParagraphAttributes(0, doc.getLength(), center, false);
        hint.setEditable(false);
        hint.setBackground(Color.GRAY);
        add(hint);

        char[] letters = new char[word.length()];
        for (int j = 0; j < letters.length; j++) {
            letters[j] = '?';
        }

        gword = new String(letters);
        guess = new JTextField(gword);
        guess.setBackground(null);
        guess.setEditable(false);
        guess.setOpaque(false);
        Font f1 = new Font("Arial", Font.BOLD, 40);
        guess.setFont(f1);
        guess.setBorder(null);
        guess.setHorizontalAlignment(JTextField.CENTER);
        guess.setForeground(Color.WHITE);
        guess.setBounds(getWidth() / 2 - 300 / 2, getHeight() / 2 - 50 / 2 + 140, 300, 50);

        add(guess);

        JTextArea gname = new JTextArea("ENTER ANSWER HERE: ");
        gname.setBackground(null);
        gname.setEditable(false);
        Font f2 = new Font("Arial", Font.BOLD, 20);
        gname.setFont(f2);
        gname.setOpaque(false);
        gname.setForeground(Color.WHITE);
        gname.setBounds(getWidth() / 2 - 300 / 2, getHeight() / 2 - 50 / 2 + 200, 250, 50);
        add(gname);

        answer = new JTextPane();
        answer.setBackground(Color.WHITE);
        answer.setFont(f2);
        answer.setForeground(Color.BLACK);
        answer.setBounds(getWidth() / 2 - 300 / 2 + 250, getHeight() / 2 - 50 / 2 + 195, 30, 30);
        StyledDocument doc2 = answer.getStyledDocument();
        SimpleAttributeSet center2 = new SimpleAttributeSet();
        StyleConstants.setAlignment(center2, StyleConstants.ALIGN_CENTER);
        doc2.setParagraphAttributes(0, doc2.getLength(), center2, false);
        add(answer);

        submit = new JButton("SUBMIT");
        submit.setBounds(getWidth() / 2 - 300 / 2 + 300, getHeight() / 2 - 50 / 2 + 195, 100, 30);

        add(submit);
        submit.addActionListener(this);

        answer.addKeyListener(new KeyAdapter() {
            public void keyPressed(KeyEvent e) {
                if (e.getKeyCode() == KeyEvent.VK_ENTER) {
                    SwingUtilities.invokeLater(new Runnable() {
                        public void run() {
                            try {
                                Thread.sleep(50); // Delay the doClick() method by 50 milliseconds
                            } catch (InterruptedException ex) {
                                ex.printStackTrace();
                            }
                            submit.doClick(); // Trigger the submit button click
                        }
                    });
                }
            }
        });

        setVisible(true);
    }

    public static void main(String[] args) {
        new Hangman();
    }

    private boolean alreadyGuessed(char c) {
        return guessedLetters.contains(c);
    }

    public void actionPerformed(ActionEvent e) {
        String guessString = answer.getText().toLowerCase();
        if (e.getSource() == submit) {
            if (!guessString.isEmpty()) {
                char guessChar = guessString.charAt(0);
                if (Character.isLetter(guessChar) && !alreadyGuessed(guessChar)) {
                    guessedLetters.add(guessChar);

                    Boolean found = false;
                    char[] letters1 = guess.getText().toLowerCase().toCharArray();
                    for (int i = 0; i < word.length(); i++) {
                        if (word.charAt(i) == guessChar) {
                            letters1[i] = guessChar;
                            found = true;
                        }
                    }
                    if (found) {
                        gword = new String(letters1);
                        guess.setText(gword);
                    } else {
                        a++;
                        if (a == 1) {
                            hanglabel.setIcon(hang);
                        } else if (a == 2) {
                            hanglabel.setIcon(hang1);
                        } else if (a == 3) {
                            hanglabel.setIcon(hang2);
                        } else if (a == 4) {
                            hanglabel.setIcon(hang3);
                        } else if (a == 5) {
                            hanglabel.setIcon(hang4);
                        } else if (a == 6) {
                            hanglabel.setIcon(hang5);
                        } else if (a == 7) {
                            hanglabel.setIcon(hang6);
                        } else if (a == 8) {
                            hanglabel.setIcon(hang7);
                        } else if (a == 9) {
                            hanglabel.setIcon(hang8);
                            int choice = JOptionPane.showOptionDialog(null,
                                    "You Lost!\nThe word was: " + word.toUpperCase() + "\nRetry?", "Hangman",
                                    JOptionPane.YES_NO_OPTION, JOptionPane.QUESTION_MESSAGE, null, null, null);
                            if (choice == JOptionPane.YES_OPTION) {
                                dispose();
                                new Hangman();
                            } else {
                                returntomm rtm = new returntomm();
                                rtm.setVisible(true);
                                dispose();
                            }
                        }

                    }
                    answer.setText("");
                    answer.requestFocus();
                    if (guess.getText().equals(word)) {
                        int choice = JOptionPane.showOptionDialog(null, "Congratulations!\nYou Won!\nPlay Again?", "Hangman", JOptionPane.YES_NO_OPTION, JOptionPane.QUESTION_MESSAGE, null, null, null);
                        if (choice == JOptionPane.YES_OPTION) {
                            dispose();
                            new Hangman();
                        } else {
                            returntomm rtm = new returntomm();
                            rtm.setVisible(true);
                            dispose();
                        }
                    }
                } else {
                    JOptionPane.showMessageDialog(null, "Please enter a valid letter that hasn't been guessed yet!");
                }
            } else {
                JOptionPane.showMessageDialog(null, "Please enter a letter!");
            }
        }
    }
}
