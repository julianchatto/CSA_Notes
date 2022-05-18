import java.util.Arrays;
import java.util.Scanner;

public class Array2dExamples {
    public static void main(String[] args) {
        // 2D Array Examples
        String[][] map = {{"H","G","G"},
                          {"G","G","G"},
                          {"G","G","G"}};

        Scanner scan = new Scanner(System.in);

        while(true) {
            // Let user move the hero: right, down
            System.out.println("Where would you like to move? (right, down...)");
            String userInput = scan.next();
            switch(userInput) {
                case "right":
                    moveRight(map);
                    break;
                case "down":
                    moveDown(map);
                    break;
                default:
                    break;

            }
            // ROW-MAJOR TRAVERSAL
            for(int row = 0; row < 3; row++) {
                // For row 0...
                System.out.println(""); // Hit enter
                for(int col = 0; col <3; col++){
                    // Individual values in 2d Array
                    System.out.print(map[row][col] + " ");
                }
            }
        }
        // Print it out: It's not that easy
        // System.out.println(Arrays.toString(map));



    }

    public static void moveRight(String[][] m) {
        int heroRow = 0;
        int heroCol = 0;

        // Find the hero
        for(int row = 0; row < 3; row++) {
            for(int col = 0; col < 3; col++){
                if (m[row][col].equals("H")) {
                    heroRow = row;
                    heroCol = col;
                    break;
                }
            }
        }
        // Move location 1 spot right
        m[heroRow][heroCol+1] = "H";

        // Replace hero with grass
        m[heroRow][heroCol] = "G";
    }
    public static void moveDown(String[][] m) {
        // make this later
    }
}
