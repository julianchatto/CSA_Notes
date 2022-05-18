public class StudentSetup {
    public static void main(String[] args) {
        // Set up students and modify their info
        HGPstudent stud1 = new HGPstudent();
        System.out.println(stud1.getName());
        stud1.setName("Jack");
        stud1.setAge(18);
        System.out.println("New name: " +  stud1.getName());

        // Student 2
        HGPstudent stud2 = new HGPstudent("Tom", 21);
        System.out.println(stud2.toString());

        //Not allowed because of private variables
        //System.out.println(stud1.name);

        System.out.println(stud1.toString());

        // play with bank account
        BankAccount ba1 = new BankAccount();
        System.out.println(ba1.toString());

        BankAccount ba2 = new BankAccount("Tom", 300.56);
        System.out.println(ba1.toString());
    }
}
