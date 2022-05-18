import java.util.Random;

public class randomexampels {
    public static void main(String[] args) {
        //Random tests
        // AP EXAM way: using math module
        //Random DOUBLE to 15 decimal places, from 0 to 1 (NOT inc. 1)
        double rand1 = Math.random();

        for (int i = 0; i < 50; i++) {
            int random1 = (int) Math.floor((Math.random() * 10) + 1);
            System.out.println(random1);
        }
        Random r = new Random();
        //int random2 = r.nextInt(10) + 1;

        for (int i = 0; i < 5000; i++) {
            int random2 = r.nextInt(50);
            System.out.println(random2);
        }



    }

}



