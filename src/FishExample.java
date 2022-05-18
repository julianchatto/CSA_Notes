import java.util.Arrays;
import java.util.Random;

public class FishExample {
    public static void main(String[] args) {
        // Create a River
        String[] river = {"", "", "FISH", "", ""};

        // generate a fish
        for (int i = 0; i < river.length; i++) {
            //Step through the entire river
            // Run some movement code if you see a fish
            if (river[i].equals("FISH")) {
                //Try to randomly move
                Random r = new Random();
                int random1 = r.nextInt(3)+1; //1,2,3
                if(random1 == 1) {
                    //Move left
                    river[i] = "";
                    river[i-=1] = "FISH";
                } else if (random1 == 2) {
                    // Move Right
                    river[i] = "";
                    river[i+=1] = "FISH";

                } else {
                    // Stay Put
                }

            }
        }

        // Show River: Typically a for loop
        //Shortcut for showing an array
        System.out.println(Arrays.toString(river));


    }
}
