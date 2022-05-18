public class functionexample1 {
    public static void main(String[] args) {
        // runs the main function
        welcome();

        areaOfTriangle(10,13.8);

        System.out.println("PROGRAM END");
    }

    // our first custom function
    static void welcome() {
        System.out.println("Welcome");
        System.out.println("Thanks for using my game.");
        System.out.println("Have a good day.");
    }

    static double areaOfTriangle(double b, double h) {
        double answer = .5 *  b * h;
        System.out.println(answer);

        return answer;
    }

}



