import java.util.Random;
import java.util.Scanner;

public class WheelOfFortune {
    public static void main(String[] args) {

        // 1: bankrupt; 2: free play; -1 lose a turn
        int[] wheel = {1, 650, 2, 700, -1, 800, 500, 650, 500, 900, 1, 5000, 500, 600, 700, 600, 650, 500, 700, 500, 600, 550, 500, 600};
        int user1_money = 0;



        // Randomly choose wheel slice
        Random r = new Random();
        int wheelResult = wheel[r.nextInt(24)];
        System.out.println(wheelResult);


        // Board options
        String[] things = {"COMPUTER MOUSE PAD", "HEATED CAR SEAT", "VACUUM CLEANER", "CHAIR", "MOUSE"};

        String[] board = new String[things[0].length()];


        //Attempt #1: CONFUSING...BUT IT WORKS
        // Create a board of dashes
//        for (int i = 0; i < things[0].length(); i++) {
//            char[] tempPhrase = things[0].toCharArray();
//            if (Character.toString(tempPhrase[i]).equals(" ")) {
//                board[i] = " ";
//            } else {
//                board[i] = "-";
//            }
//        }

        // Attempt #2
        for (int i = 0; i < things[0].length(); i++) {
            if (things[0].substring(i, i+1).equals(" ")) {
                board[i] = " ";
            } else {
                board[i] = "-";
            }
        }
        Scanner s = new Scanner(System.in);
        // print board
        for (String letter: board) {
            System.out.print(letter + " ");
        }
        System.out.println("You spun the wheel and got: " + wheelResult);
        System.out.println("You currently have $" + user1_money);
        System.out.println("Would you like to guess the word or a letter?\n1.Word\n2.Letter");
        int userInputInt = s.nextInt();
        if (userInputInt == 1) {
            System.out.println("Enter the word");
            String userInput = s.nextLine().toUpperCase();
            if (things[0].equals(userInput)) {
                for (int i = 0; i < things.length; i++) {
                    board[i] = things[0].substring(i, i+1);
                }
            }
        } else {
            System.out.println("Guess a letter");
            String userInput = s.next().toUpperCase();
            for (int i = 0; i < things[0].length(); i++ ) {
                if (things[0].substring(i, i+1).equals(userInput)) {
                    board[i] = userInput;
                }
            }
        }
        String userInput = s.next().toUpperCase();
        System.out.println("Guess a letter");



        int letterCount = 0;
        for (int i = 0; i < things[0].length(); i++ ) {
            if (things[0].substring(i, i+1).equals(userInput)) {
                board[i] = userInput;
                letterCount++;
            }
        }

        for (String letter: board) {
            System.out.print(letter + " ");
        }

        if (wheelResult!= -1 || wheelResult!= 1 || wheelResult!= 2) {
            user1_money += wheelResult * letterCount;
        }
        if (wheelResult == 1) {
            user1_money = 0;
        }

        System.out.println("Your money is: " + user1_money);







    }
}
