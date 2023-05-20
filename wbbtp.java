import java.util.Scanner;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class wbbtp {
    public static void main(String[] args) {
        Boolean end = true;
        System.out.println("Welcome");
        while (end) {
            Scanner scan = new Scanner(System.in);
            System.out.println("Please type STOPNAPLEASE to exit");
            String exit = "stopnaplease";
            System.out.print("Enter the first word: ");
            String word1 = scan.next().toLowerCase();

            if (word1.equalsIgnoreCase(exit)) {
                System.out.print("Exiting..");
                end = false;
                break;
            }

            System.out.print("Enter the second word: ");
            String word2 = scan.next().toLowerCase();

            if (word2.equalsIgnoreCase(exit)) {
                System.out.print("Exiting..");
                end = false;
                break;
            }

            String sub = word1.substring(word1.length() - 2);
            Pattern p = Pattern.compile("[a-zA-Z]{1,2}" + sub + "");
            Matcher match = p.matcher(word2);
            if (match.matches()) {
                System.out.println(word2 + " rhymes with " + word1);
            } else {
                System.out.println("I'm not sure! Sorry!");
            }
            System.out.println();
        }
    }
}
