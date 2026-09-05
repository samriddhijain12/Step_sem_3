public class W1SeatChecker{

    public static void checkDuplicateSeats(int[] seatNumbers) {
        boolean duplicateFound = false;

        // Nested loops to compare every element with every other element
        for (int i = 0; i < seatNumbers.length; i++) {
            for (int j = i + 1; j < seatNumbers.length; j++) {
                // Check if a duplicate is found
                if (seatNumbers[i] == seatNumbers[j]) {
                    System.out.println("Duplicate Seat Number Found: " + seatNumbers[i]);
                    duplicateFound = true;
                    return; // Exit immediately after finding the first duplicate
                }
            }
        }

        // If the loop finishes without finding any duplicate
        if (!duplicateFound) {
            System.out.println("No Duplicate Seats Found");
        }
    }

    // Main method to test the functionality with sample inputs
    public static void main(String[] args) {
        // Test Case 1: Contains duplicate
        int[] input1 = {101, 102, 103, 102, 105};
        System.out.print("Input 1 Output: ");
        checkDuplicateSeats(input1);

        // Test Case 2: No duplicates
        int[] input2 = {101, 102, 103, 104, 105};
        System.out.print("Input 2 Output: ");
        checkDuplicateSeats(input2);
    }
}