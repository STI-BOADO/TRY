import java.io.BufferedReader;
import java.io.FileReader;
import java.util.ArrayList;
import java.util.Random;
import java.util.Scanner;

public class LabExer6A {
    public static void main(String[] args) {
        try {
            ArrayList<String> words = new ArrayList<String>();
            try {
                BufferedReader wordfile = new BufferedReader(new FileReader("words.txt"));
                Scanner scan = new Scanner(wordfile);
                while (scan.hasNextLine()) {
                    String parts = scan.nextLine();
                    String word = parts;
                    words.add(word);
                }
                scan.close();
            } catch (Exception e) {
                System.out.println("Message: " + e);
            }

            Random r = new Random();
            int i = r.nextInt(words.size());
            String huhulaan = words.get(i);

            char[] letters = new char[huhulaan.length()];
            for (int j = 0; j < letters.length; j++) {
                letters[j] = '_';
            }

            boolean correct = false;
            int tryguess = 10;
            int score = 10;
            Scanner scan = new Scanner(System.in);
            while (!correct && tryguess > 0) {
                try {
                System.out.println(letters);
                System.out.println("Guess a letter:");
                char hula = scan.nextLine().charAt(0);
                String hulaa = hula + "";
                if(!hulaa.matches("[a-zA-Z]")){
                    throw new LetterOnlyException();
                }
                boolean tama = false;
                for (int k = 0; k < huhulaan.length(); k++) {
                    if (huhulaan.charAt(k) == hula) {
                        letters[k] = hula;
                        tama = true;
                    }
                }
                if (tama) {
                    System.out.println("Correct!");
                } else {
                    System.out.println("Incorrect!");
                    tryguess--;
                    score--;
                }

                if (String.valueOf(letters).equals(huhulaan)) {
                    correct = true;
                }
            } catch (LetterOnlyException e){
                System.out.println(e.getMessage());
            } catch (Exception e){
                System.out.println(e.getMessage());
            }
            }

            if (correct) {
                System.out.println("Congratulations! You guessed the word: " + huhulaan);
                System.out.println("Your score is: " + score);
            } else {
                System.out.println("Game over! The word was: " + huhulaan);
                System.out.println("Your score is: " + score);
            }
            scan.close();
        } catch (Exception e) {
            System.out.println("Error occured!");
            System.out.print(e.getMessage());
        }
    }
}

class LetterOnlyException extends Exception{
    LetterOnlyException(){
        super("Please only enter letters!");
    }
}
