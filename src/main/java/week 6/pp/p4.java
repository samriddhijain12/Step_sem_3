class Student {
    // Instance fields (unique for each student)
    String name;
    int attendance;

    // Static fields (shared by all student objects)
    static String collegeName = "SRM Institute of Science and Technology";
    static int studentCount = 0;

    // Constructor
    public Student(String name, int attendance) {
        this.name = name;
        this.attendance = attendance;
        // Increment the shared student counter every time an object is created
        studentCount++;
    }

    // Static method to print shared college information
    static void printCollegeInfo() {
        System.out.println(collegeName);
        System.out.println("Students created: " + studentCount);
    }
}

public class p4
 {
    public static void main(String[] args) {
        // Create two Student objects
        Student student1 = new Student("Alice", 85);
        Student student2 = new Student("Bob", 90);

        // Call printCollegeInfo() through the class name, not the objects
        Student.printCollegeInfo();
    }
}