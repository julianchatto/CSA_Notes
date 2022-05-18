import java.util.Arrays;
import java.util.Random;

public class BinarySearch {
    // Sort/Search methods go here
    // (remember to make them STATIC)
    static int binarySearch(int arr[], int x) {
        int l = 0, r = arr.length - 1;
        while (l <= r) {
            int m = l + (r - l) / 2;

            // Check if x is present at mid
            if (arr[m] == x)
                return m;

            // If x greater, ignore left half
            if (arr[m] < x)
                l = m + 1;

                // If x is smaller, ignore right half
            else
                r = m - 1;
        }

        // if we reach here, then element was
        // not present
        return -1;
    }
    static int linSearch(int arr[], int x) {
        for (int i = 0; i< arr.length; i++) {
            if (arr[i] == x) {
                return i;
            }
        }
        return -1;
    }

    // put more sort/search methods here:

    // Main method to run algorithms
    public static void main(String[] args) {
        int[] hundoInts = new int[10000000];
        Random r = new Random();
        int[] longest = new int[214748364];

        for (int i = 0; i < hundoInts.length; i++) {
            hundoInts[i] = r.nextInt(1000)+1;
        }

        // Use one of your methods from above
        Arrays.sort(hundoInts);
        //int binSearchResult = binarySearch(hundoInts, 10001);
        // Start Timer
        long startT = System.currentTimeMillis();
        int binSearchResult = binarySearch(hundoInts, 10001);
        // stop timer
        long endT = System.currentTimeMillis();
        System.out.println("Time Algo took: " + (endT-startT) + " ms");

        // print out any pertinent information


    }
}
