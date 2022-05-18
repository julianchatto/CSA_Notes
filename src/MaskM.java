import java.util.Scanner;

public class MaskM {
    public static void main(String[] args) {
        Scanner reader = new Scanner(System.in);

        System.out.println("Hello, what is your name?");
            String name = reader.nextLine().toUpperCase(); //.tolowercase for converiting to lowercase

        System.out.println("Are you 12 or older?");
            boolean age = reader.nextBoolean();

        if (age == true) {
            System.out.println("Are you vaccinated?");
                boolean vaccinated = reader.nextBoolean();
            if (vaccinated == false) {
                System.out.println(name + ", you need to wear a mask");

            } else {
                System.out.println(name + ", you don't need a mask!");
            }
        } else {
            System.out.println(name + ", you need to wear your mask.");
        }

        boolean vaccinated = true; // this wont do anything

        if (age == true || vaccinated == true) { //just to show how to use an or (use && for and)
            System.out.println("yes");
        }
    }


}
