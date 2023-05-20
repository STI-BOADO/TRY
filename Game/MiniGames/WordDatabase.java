package MiniGames;
import java.io.BufferedReader;
import java.io.FileReader;
import java.util.ArrayList;
import java.util.Random;
import java.util.Scanner;

public class WordDatabase {

    static ArrayList<String> words = new ArrayList<String>();
    static ArrayList<String> hints = new ArrayList<String>();
    static String word1;
    static String hint1;
    static int i;

    public static void main(String[] args) {
        try {
            BufferedReader wordfile = new BufferedReader(new FileReader("db\\words.txt"));
            Scanner scan = new Scanner(wordfile);
            while (scan.hasNextLine()) {
                String[] parts = scan.nextLine().split("-");
                String word = parts[0];
                String hint = parts[1];
                words.add(word);
                hints.add(hint);
            }
            scan.close();
        } catch (Exception e) {
            System.out.println("Message: " + e);
        }

        Random r = new Random();
        i = r.nextInt(words.size());
        word1 = words.get(i);
        hint1 = hints.get(i);

    }

    public static String getWord(){
        return word1;
    }

    public static String getHint(){
        return hint1;
    }
}