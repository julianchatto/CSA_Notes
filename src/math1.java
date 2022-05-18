public class math1 {
    public static void main(String[] args) {
        int b = -17;
        int a = 6;
        int c = 12;


        double quadFormPlus = ((-b+(Math.sqrt(b*b-4*a*c)))/(2*a));

        double quadFormMinus = ((-b-(Math.sqrt(b*b-4*a*c)))/(2*a));
        System.out.println(quadFormPlus);
        System.out.println(quadFormMinus);

    }
}
