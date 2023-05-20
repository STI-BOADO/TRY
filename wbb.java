import java.util.InputMismatchException;
import java.util.Scanner;

public class wbb {

    static Scanner scan = new Scanner(System.in);

    public static void main(String[] args) {
        System.out.println("Hello!");
        Boolean notExiting = true;
        while (notExiting) {
            System.out.println("Please select an option");
            System.out.println("Press 1 for login, 2 for exit: ");
            int option = scan.nextInt();
            if(option == 1){
                StudIDenter();
            } else if(option == 2){
                System.out.println("Exiting...");
                notExiting = false;
            }
        }
    }

    public static void StudIDenter() {
        System.out.println("==============LOGIN==============");
        System.out.println("Please enter your student number: (xxxx-xx-xxx)");
        try {
            String snumber = scan.next();
            if (snumber.matches("[0-9]{4}-[0-9]{2}-[0-9]{3}")) {
                System.out.println("======You have successfully logged in!======");
                System.out.println("===========RETURNING TO MAINMENU===========");
            } else {
                System.out.println("Please follow number format!");
                System.out.println("===========RETURNING TO MAINMENU===========");
            }
        } catch (InputMismatchException e) {
            System.out.println("Please follow number format!");
            System.out.println("===========RETURNING TO MAINMENU===========");
        }

    }
}