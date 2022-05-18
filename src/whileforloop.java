import java.util.Scanner;

public class whileforloop {
    public static void main(String[] args) {


        // how to repeat code a certain number of times


        //while loop:
        //use this: when I don't know how many times it will loop
        // For example, USER controls the loop, or randomness controls loop

        int counter = 0;

        while (counter < 5) {
            // repeat
            System.out.println("hello");
            counter = counter + 1; // can also say counter += 1; (the 1 in the option to the left can be any number also can do -=, *=, /=) or counter++; (can also be counter--)
        }

        // user input for while loop
        Scanner scan = new Scanner(System.in);
        String userAnswer = "Y";
        int retryCounter = 0;
        System.out.println("Welcome to my program.");

        while ((userAnswer.equals("Y") || userAnswer.equals("YES")) && retryCounter < 3) {
            System.out.println("Playing a game...");


            System.out.println("would you like to keep playing? (Y/N)");
            userAnswer = scan.nextLine().toUpperCase();
            retryCounter++;

        }

        // if user is done:

        System.out.println("Thanks for playing, play again sometime.");


        //For loop
        //use when the programmer want to set a specific num of loops

        for (int x = 0; x < 10; x++) {
            //1.  set up counter (x)
            // 2. condition for how long it loops
            // 3. incrementing (adding to) the counter

            System.out.println(x);
        }





    }

}
