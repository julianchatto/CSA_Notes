import java.util.Scanner; // imported so that user input can be gathered

public class CSAProj1 {
    public static void main(String[] args) {
        Scanner reader = new Scanner(System.in); // Creates a Scanner OBJECT to use in your program, named 'reader'

        double salary; // defines the variable salary as a double

        System.out.print("Hey! What's your name?\t"); // asks user for name
            String usersName = reader.nextLine(); // defines the variable usersName as a string and collects users name

        System.out.print("\nHello " + usersName + ". \nCan you tell me how old you are?\t"); // prints users name and asks for age
            int age = reader.nextInt(); // defines the variable age as an integer and collects users age

        if (age <= 18) { // if else statement; if users age is 18 or under they follow the first path
            System.out.print("\nWoah there youngster, looks like you are "
                    + age
                    + "!\nI would like to know how much money you make in a year, but if you are not working yet, you can enter 00.\t"); // prints users age and asks if they are working and their salary (if applicable)
                salary = reader.nextDouble(); // collects users salary

            if (salary == 00) { // if salary is listed as not working yet, they follow this path
                System.out.println("\nBeing unemployed at your age is perfectly okay!"); // prints that user is unemployed
            } else { // if not unemployed, user follows this path
                System.out.println("\nBeautiful, you're making $" + salary + "!"); // prints users salary
            }

        } else if (age <=65) { // if user is above 18 but 65 or younger, they follow this path
            System.out.print("\nAt " + age + ", you're in your prime. \nIf you don't mind me asking, how much money do you make in a year?\t"); //prints users age and asks for salary
                salary = reader.nextDouble(); // collects users salary
                    System.out.println("\nWow, $" + salary + " in a year!"); // prints users salary

        } else { // if they are over 65, they follow this path
            System.out.print("\nWow, you are " + age + "! \nIf you've retired please enter 00, if not please tell me your salary.\t"); // prints users age and asks if they are retired and for salary (if applicable)
                salary = reader.nextDouble(); // collects users salary

            if (salary == 00) { // if retired, they follow this path
                System.out.println("\nCongrats on being retired, I'm sure you've worked hard your whole life!"); // prints that the user is retired
            } else { // if not retired, they follow this path
                System.out.println("\nDang, $" + salary + " is a lot of money."); // prints users salary
            }
        }


        System.out.print("\nIf you would like to use a BMI calculator, enter 1, if not, enter 2.\t"); // asks user if they want to use the BMI calculator
        int bmiYN = reader.nextInt(); // defines the variable bmiYN as an integer and collects users input on if they want to use the calculator

        if (bmiYN == 1) { // if else statement; if user wants to use calculator they follow this path
            System.out.print("\nWelcome to a BMI calculator. Enter 1 if you'd like to use the imperial system and 2 for the metric system.\t"); // asks user for measurement system
                int measurementSystem = reader.nextInt(); // defines the variable measurementSystem as an integer

                if (measurementSystem == 1) { // conditional; if user wants to use the imperial system they follow this path
                    System.out.print("\nAwesome, you've chosen the imperial system. Please enter your height in inches.\t"); // asks user to enter the feet part of their height
                        int height = reader.nextInt(); // defines the variable height as an integer and collects users height

                    System.out.print("Now enter your weight in pounds.\t"); // asks user for their weight
                        double weight = reader.nextDouble(); // defines the variable weight as a double and collects users weight
                        double bmiCalculation = ((weight*0.453592)/Math.pow(((height*0.0254)),2)); // calculates BMI and defines the variable bmiCalculation

                    System.out.print("\nYour BMI is: " + Math.round(bmiCalculation)); // prints and rounds users BMI

                } else { // for the metric system, users follow this path
                    System.out.print("\nAwesome, you've chosen the metric system. Please enter your height in centimeters.\t"); // asks user to enter the feet part of their height
                        int height = reader.nextInt(); // defines the variable heightFeet as an integer and collects users height (ft)

                    System.out.print("Finally, enter your weight in kilograms.\t"); // asks user for their weight
                        double weight = reader.nextDouble(); // defines the variable weight as a double and collects users weight
                        double bmiCalculation = ((weight)/(Math.pow((height*.01),2))); // calculates BMI and defines the variable bmiCalculation

                    System.out.print("\nYour BMI is: " + Math.round(bmiCalculation)); // prints and rounds users BMI
                }

        } else { // if user doesn't want to use calculator they follow this path
            System.out.print("\nThat's okay, see you next time."); // prints statement if they don't want to use the calculator
        }





    }


}
