import java.util.Random;

public class SelectSort {
    // Java program for implementation of Selection Sort

    /* This code is contributed by Rajat Mishra*/

    public static void main(String[] args) {
        SelectionSort ss = new SelectionSort();
        int[] hundoInts = new int[100000];
        Random r = new Random();
        int[] longest = new int[214748364];

        for (int i = 0; i < hundoInts.length; i++) {
            hundoInts[i] = r.nextInt(1000)+1;
        }
        long startT = System.currentTimeMillis();
        ss.sort(hundoInts);

        // stop timer
        long endT = System.currentTimeMillis();

        System.out.println("Time Algo took: " + (endT-startT) + " ms");




    }
}
class SelectionSort
{
    void sort(int arr[])
    {
        int n = arr.length;

        // One by one move boundary of unsorted subarray
        for (int i = 0; i < n-1; i++)
        {
            // Find the minimum element in unsorted array
            int min_idx = i;
            for (int j = i+1; j < n; j++)
                if (arr[j] < arr[min_idx])
                    min_idx = j;

            // Swap the found minimum element with the first
            // element
            int temp = arr[min_idx];
            arr[min_idx] = arr[i];
            arr[i] = temp;
        }
    }

        // Prints the array
        void printArray(int arr[])
        {
            int n = arr.length;
            for (int i=0; i<n; ++i)
                System.out.print(arr[i]+" ");
            System.out.println();
        }

//        // Driver code to test above
//        public static void main(String args[])
//        {
//            SelectionSort ob = new SelectionSort();
//            int arr[] = {64,25,12,22,11};
//            ob.sort(arr);
//            System.out.println("Sorted array");
//            ob.printArray(arr);
//        }
}
