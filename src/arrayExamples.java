public class arrayExamples {
    public static void main(String[] args) {
        // examples of arrays
        int num = 5;

        // creates an empty ARRAY (list) of 10 integers
        // default value for integers is....0
        // 0,0,0,0,0,0,0,0,0,0
        int[] grades = new int[10];
        int[] gradesProj2 = {100,91,50,100,100};
        String[] names = {"Bobby", "Jimmy", "Karl", "jimbo", "lucy"};

        //assign a value in the list
        grades[3] = 100;

        //LOOP through array to print out each INDIVIDUAL piece
        for (int i=0; i < grades.length; i++) {
            System.out.println(grades[i]);

        }



        System.out.println(grades); // can not just PRINT arrays....

        // Modify: Loop through the grades and give extra credit
        for(int i=0; i < gradesProj2.length; i++) {
            gradesProj2[i] *= 1.03;
            // i = 1, gradesProje[1] = 91, = 91 * 1.03
        }
        // Print: Print out the new extra credit grades
        for (int i=0; i < gradesProj2.length; i++) {
            System.out.println(names[i] + " your grade is " +gradesProj2[i]);

        }
    }
}
