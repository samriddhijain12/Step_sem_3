// Define the Course class
class Course {
    // Fields
    String code;
    String title;
    int credits;
    int labCredits;

    // Four-argument constructor setting all fields directly
    public Course(String code, String title, int credits, int labCredits) {
        this.code = code;
        this.title = title;
        this.credits = credits;
        this.labCredits = labCredits;
    }

    // Three-argument constructor that chains to the four-argument constructor
    public Course(String code, String title, int credits) {
        this(code, title, credits, 0); // Chains via this(...) setting labCredits to 0
    }

    // Method to calculate total credits
    public int totalCredits() {
        return this.credits + this.labCredits;
    }
}

// Main class to test the functionality
public class p2 {
    public static void main(String[] args) {
        // 1. Create a course using the 3-argument constructor (theory-only)
        Course course1 = new Course("21CSC201J", "Data Structures", 4);
        
        // 2. Create a course using the 4-argument constructor (with lab credits)
        Course course2 = new Course("21CSC205L", "DSA Lab", 3, 1);

        // Print the outputs matching the sample output format
        System.out.println(course1.code + " total credits: " + course1.totalCredits());
        System.out.println(course2.code + " total credits: " + course2.totalCredits());
    }
}
