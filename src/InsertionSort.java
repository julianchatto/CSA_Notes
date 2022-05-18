import java.util.Arrays;
import java.util.Random;

public class InsertionSort {
    static void sort(int arr[])
    {
        int n = arr.length;
        for (int i = 1; i < n; ++i) {
            int key = arr[i];
            int j = i - 1;

            /* Move elements of arr[0..i-1], that are
               greater than key, to one position ahead
               of their current position */
            while (j >= 0 && arr[j] > key) {
                arr[j + 1] = arr[j];
                j = j - 1;
            }
            arr[j + 1] = key;
        }
    }

    public static void main(String[] args) {
        int[] hundoInts = new int[100000];
        Random r = new Random();

        for (int i = 0; i < hundoInts.length; i++) {
            hundoInts[i] = r.nextInt(1000)+1;
        }

        long startT = System.currentTimeMillis();
        sort(hundoInts);
        long endT = System.currentTimeMillis();
        System.out.println("Time Algo took: " + (endT-startT) + " ms");


    }
}
