public class ATMAssignment {

    public static void checkPinLength(String pin) {
        // Get the length of the PIN string
        int length = pin.length();

        // Check if the length is exactly 4
        if (length != 4) {
            System.out.println("Invalid PIN — must be exactly 4 digits.");
        } else {
            System.out.println("PIN length OK.");
        }
    }

    // Main method to test the solution with sample inputs
    public static void main(String[] args) {
        // Test case 1
        checkPinLength("482");
        
        // Test case 2
        checkPinLength("4820");
    }
}