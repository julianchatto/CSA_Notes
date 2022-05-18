public class HGPstudent {
    // Attributes ('this' keyword comes up here)
    private  String name;
    private int age;


    // All Methods
    // Constructor
    HGPstudent() {
        this.name = "Johnny";
        this.age = 18;
    }

    // Second constructor
    HGPstudent(String n, int a) {
        this.name = n;
        this.age = a;
    }

    // Getters and Setters: for every attribute

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }


    // ToString

    @Override
    public String toString() {
        return "HGPstudent{" +
                "name='" + name + '\'' +
                ", age=" + age +
                '}';
    }


    // Helper Methods
}
