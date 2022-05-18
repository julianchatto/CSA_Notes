public class InheritExamples {
    public static void main(String[] args) {
        // creates shapes and play with them
        Triangle t1 = new Triangle(3,180);
    }
}


class Polygon {
    private int numOfSides;
    private int sumOfAngles;


    Polygon() {
        numOfSides = 0;
        sumOfAngles = 0;
    }

    Polygon(int ns, int sa) {
        numOfSides = ns;
        sumOfAngles = sa;
    }



}
class Triangle extends Polygon {
    Triangle() {

    }

    Triangle(int ns, int sa) {
        super(ns, sa);
    }
}