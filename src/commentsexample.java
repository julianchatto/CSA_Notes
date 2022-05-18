import java.util.Scanner;

public class commentsexample {
    public static void main(String[] args) {

        // store all variables for the program
        Scanner scan = new Scanner(System.in);
        String userAnswer = "Y";
        int retryCounter = 0;

        System.out.println("Welcome to my program.");

        // loops while user inputs y or yes
        // they have 3 replays available
        while ((userAnswer.equals("Y") || userAnswer.equals("YES")) && retryCounter < 3) {
            System.out.println("Playing a game...");


            System.out.println("would you like to keep playing? (Y/N)");
            userAnswer = scan.nextLine().toUpperCase();
            retryCounter++;

        }
        // if user is done:

        System.out.println("Thanks for playing, play again sometime.");
    }


}
