public class conditionals {
    public static void main(String[] args) {
        // learning conditionals

        int age = 16;
        boolean withAdult = true;
        boolean sneakIn = true;
        String name = "Brandon";
        // Rated R
        // Option 1

        if (age >= 18 || sneakIn) { // || for an this or that
            System.out.println("You can go to this movie!");
        } else  {
            //Younger than 18
            if(withAdult) {
                System.out.println("You can go in with your parent.");
            } else    {
                System.out.println("you need adult supervision. Get out.");

            }
        }

        // How to determine if a string equals another string, NOT ==
        System.out.println("Thank you for coming to the movie!");
        if (name.equals("Brandon")) {
            System.out.println("Nice to meet you " +name);

        }
    }

}


//int division
