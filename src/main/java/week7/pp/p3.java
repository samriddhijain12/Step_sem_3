// Main class to test the AttendanceSheet functionality
public class p3{
    public static void main(String[] args) {
        // Create an attendance sheet for up to 30 students
        AttendanceSheet sheet = new AttendanceSheet(30);

        // Mark students present (including a duplicate)
        sheet.markPresent("Ana");
        sheet.markPresent("Ben");
        sheet.markPresent("Ana"); // Duplicate, should be ignored

        // Check and display the total present count
        System.out.println("sheet.getPresentCount() -> " + sheet.getPresentCount()); // Expected: 2

        // Verify if specific students are marked present
        System.out.println("sheet.isPresent(\"Ben\") -> " + sheet.isPresent("Ben")); // Expected: true
        System.out.println("sheet.isPresent(\"Chen\") -> " + sheet.isPresent("Chen")); // Expected: false
    }
}

// Complete AttendanceSheet class design
class AttendanceSheet {
    // Private fields to encapsulate the data completely
    private String[] presentStudents;
    private int currentSize;

    // Constructor to initialize the sheet with a fixed maximum class size
    public AttendanceSheet(int maxClassSize) {
        this.presentStudents = new String[maxClassSize];
        this.currentSize = 0;
    }

    /**
     * Marks a student as present if they are not already in the list
     * and the list has available capacity.
     */
    public void markPresent(String name) {
        // Edge case handling for null inputs
        if (name == null) {
            return;
        }

        // Prevent duplicate entries by checking if the student is already present
        if (isPresent(name)) {
            return; 
        }

        // Boundary check to ensure we don't exceed the array size
        if (currentSize < presentStudents.length) {
            presentStudents[currentSize] = name;
            currentSize++;
        } else {
            System.out.println("Error: Attendance sheet is full.");
        }
    }

    /**
     * Returns the total count of unique present students.
     */
    public int getPresentCount() {
        return currentSize;
    }

    /**
     * Checks whether a specific name exists in the internal array.
     */
    public boolean isPresent(String name) {
        if (name == null) {
            return false;
        }

        // Loop through only the registered elements internally
        for (int i = 0; i < currentSize; i++) {
            if (presentStudents[i].equalsIgnoreCase(name)) {
                return true;
            }
        }
        return false;
    }
}