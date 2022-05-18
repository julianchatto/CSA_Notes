import java.util.Arrays;
import java.util.Random;

public class BubbleSort {
    static void bubbleSort(int arr[])
    {
        int n = arr.length;
        for (int i = 0; i < n-1; i++)
            for (int j = 0; j < n-i-1; j++)
                if (arr[j] > arr[j+1])
                {
                    // swap arr[j+1] and arr[j]
                    int temp = arr[j];
                    arr[j] = arr[j+1];
                    arr[j+1] = temp;
                }
    }
    public static void main(String[] args) {
        int[] hundoInts = new int[2147483647];

        Random r = new Random();

        for (int i = 0; i < hundoInts.length; i++) {
            hundoInts[i] = r.nextInt(1000)+1;
        }

        long startT = System.currentTimeMillis();
        bubbleSort(hundoInts);
        long endT = System.currentTimeMillis();
        System.out.println("Time Algo took: " + (endT-startT) + " ms");
//        System.out.println(Arrays.toString(hundoInts));
    }
}
