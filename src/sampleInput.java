import java.util.Scanner;

public class sampleInput {
    public static void main(String[] args) {

        // Creates a Scanner OBJECT to use in your program, named 'scan'
        // you only need this once in your program
        /// gives you the ability to take in user data
        Scanner scan = new Scanner(System.in);

        //ToDo: Take in String from a user

        System.out.println("what is your name?");

        // creates a blinking cursor where you can type something
        // saves the information in the variable on the left
        String myName = scan.nextLine();

        System.out.println("Hello " + myName + "!");
    }
}
