/*
Name:
Date:
==========Log==========
1/27/2022 (Person 1): Created doc and setup
....


 */


import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.Arrays;

public class Cheetsheet {
    public static void main(String[] args) {
        // TODO: Variables
        // Integers, Double, String, Booleans
        int myAge = 5;
        double currency = 3.5469;
        boolean isRaining = true;
        boolean sunnyOutside = false;
        String fullName = "Kevin Burke";
        String favoriteColor = "Blue";



        // TODO: Print Information
        System.out.println("Our principal is " + fullName + " and he is nice.");
        System.out.print("Prints without hitting \"ENTER\" at the end");
        System.out.println("Same \nline as \t above");
        System.out.println(String.format("I have $%.2f in my pocket.",currency)); //%.2f rounds currency to 2 decimals, and %f looks for whats after comma
        System.out.println(String.format("I have $%.1f in my pocket. It is worth $%.2f.", currency,currency));

        // TODO: Conditionals
        if (isRaining) {
            System.out.println("Get your umbrella");
        }

        if (sunnyOutside && !isRaining) {
            System.out.println("Put umbrella away!");
        }

        if (myAge < 10 || sunnyOutside) {
            System.out.println("Play Outside!");
        } else if (currency > 10  && favoriteColor.equals("blue")) {
            System.out.println("Go buy a blue shirt.");
        } else {
            System.out.println("This will run if top conditions are FALSE");
        }

        // TODO: Arrays
        // Index: 0, 1, 2, 3, 4; length: 5
        double[] foodCosts = new double[5]; // [0.0, 0.0, 0.0, 0.0, 0.0]
        foodCosts[0] = 3.52;

        double[] foodCosts2 = {3.52, 1.03, 6.99, 3.27, 4.98};
        int numOfItems = foodCosts2.length;
        double firstItem = foodCosts2[0];
        double lastItem = foodCosts2[foodCosts2.length-1];

        // Printing arrays (Can't use this on AP Exam
        System.out.println(Arrays.toString(foodCosts2));

        // TODO: Loops
        // Loop a number of times; 20 times
        for (int i = 0; i < 20; i++) {
            System.out.println("I'm looping");
        }

        // Print out items from a list enhanced for loop because INDEX doesn't matter
        for (double cost : foodCosts2) {
            System.out.println(cost);
        }

        // TODO: 2D Arrays
        // int[ROWS][COLS]
        int[][] binaryPlayground = new int[3][3];
        binaryPlayground[1][1] = 1;
        String [][] ttt = {{"O", "-", "-"},
                          {"O", "X", "-"},
                          {"-", "-", "-"}};
        ttt[2][0] = "X";

        for (int i = 0; i < ttt.length; i++) {
            for (int j = 0; j < ttt[0].length; j++) {
                System.out.print(ttt[i][j] + " ");
            }
            System.out.println();
        }

        // TODO: ARRAY LIST
        // almost the same as array
        // but...the length is flexible. They are slower. Can't use primitive variables
        // to use primitive data types, apply an OBJECT wrapper. Integer, Float, Double

        ArrayList<Integer> ages = new ArrayList<Integer>();
        ages.add(18);
        ages.add(17);
        ages.add(21);
        ages.add(6);
        // Add to an index: "Cut in Line" (push everything to the right)
        ages.add(2,15);
        System.out.println(ages);
        ages.remove(1);
        ages.set(1, 22);
        System.out.println(ages);
        // Calculate size of an arrayList
        System.out.println("Length: " + ages.size());



    }
}
