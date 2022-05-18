public class recursiveCalls {
    // Helper methods
    // Iteratively calculates the sum
    // 6 = 6 + 5 + 4 + 3 + 2 + 1 ====> 21
    static int sum(int n){
        int sum = 0;
        for (int x = n; x > 0; x--) {
            sum += x;
        }
        return sum;
    }

    static int recSum(int n) {
        if (n == 0) {
            // terminating condition (the function stops looping)
            return n;
        } else {
            // Recursive call...repeats while n > 0
            return n + recSum(n-1);
        }
    }
    static int rFact(int n) {
        if (n == 0) {
            // terminating condition (the function stops looping)
            return 1;
        } else {
            // Recursive call...repeats while n > 0
            return n * rFact(n-1);
        }
    }


    public static void main(String[] args) {
        System.out.println(sum(6));
        System.out.println(recSum(6));
        System.out.println(rFact(31));
    }
}
