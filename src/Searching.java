import java.util.Arrays;
import java.util.Random;

public class Searching {

    public static void main(String[] args) {
        int[] hundoInts = new int[1000000];
        Random r = new Random();

        for (int i = 0; i < hundoInts.length; i++) {
            hundoInts[i] = r.nextInt(1000)+1;
        }
        System.out.println(Arrays.toString(hundoInts));

        // Searching
        // Linear Search: Loop through every number until you find number you want. Print out index
        // Print -1 if it is not found
        int indexFound = -1;
        int numIWant = 5000;
        long startT = System.currentTimeMillis();

        for (int i = 0; i < hundoInts.length; i++) {
            if (hundoInts[i] == numIWant) {
                indexFound = i;
                break;
            }
        }
        long endT = System.currentTimeMillis();
        System.out.println("Time Algo took: " + (endT-startT) + " ms");
        System.out.println("Number found at: " + indexFound);
    }
}

