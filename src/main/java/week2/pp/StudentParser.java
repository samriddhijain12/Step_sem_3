public class StudentParser {

    public static void parseStudentRecord(String csvLine) {
        // Use split(",") to break the CSV line into fields
        String[] fields = csvLine.split(",");

        // Validate that exactly 3 fields are present
        if (fields.length != 3) {
            System.out.println("Invalid Record");
        } else {
            // Print the formatted record exactly as shown in the output sample
            System.out.println("Name: " + fields[0].trim() + 
                               " | Roll No: " + fields[1].trim() + 
                               " | Dept: " + fields[2].trim());
        }
    }

    // Main method to test both sample inputs
    public static void main(String[] args) {
        // Test Case 1: Valid Input
        String validInput = "Ananya Verma,RA2211003010123,CSE";
        System.out.println("--- Test Case 1 ---");
        parseStudentRecord(validInput);

        // Test Case 2: Invalid Input
        String invalidInput = "Ananya Verma,CSE";
        System.out.println("\n--- Test Case 2 ---");
        parseStudentRecord(invalidInput);
    }
}