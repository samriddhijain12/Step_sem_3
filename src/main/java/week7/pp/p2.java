
class Locker {
    // Fixed locker number, initialized at creation
    private final int lockerNumber;
    
    // Private combination code (Write-only, no getter)
    private String combinationCode;

    /**
     * Constructor to initialize the locker
     * @param lockerNumber The permanent ID number of the locker
     * @param initialCode The starting combination code
     */
    public Locker(int lockerNumber, String initialCode) {
        this.lockerNumber = lockerNumber;
        this.combinationCode = initialCode;
    }

    /**
     * Changes the locker combination code only if the current code is entered correctly.
     * 
     * @param oldCode The current combination code to verify identity
     * @param newCode The new combination code to set
     * @return true if the code was successfully changed, false otherwise
     */
    public boolean changeCode(String oldCode, String newCode) {
        // Hint 2: Check the old code first before modifying the field
        if (this.combinationCode.equals(oldCode)) {
            this.combinationCode = newCode;
            return true; // Operation success
        }
        
        return false; // Rejected, combination code stays unchanged
    }

    /**
     * Public getter for the fixed locker number.
     * @return The permanent locker number
     */
    public int getLockerNumber() {
        return this.lockerNumber;
    }
}

// ==========================================
// 2. MAIN RUNNER CLASS (FOR TESTING)
// ==========================================
public class p2{
    public static void main(String[] args) {
        System.out.println("--- Starting Locker Code Test --- \n");

        // 1. Create a new locker object matching the sample input
        // Locker l = new Locker(101, "1234");
        Locker l = new Locker(101, "1234");
        System.out.println("Locker created successfully with ID: " + l.getLockerNumber());

        // 2. Test Case 1: Changing code with the CORRECT current code
        // l.changeCode("1234", "5678") -> success
        boolean test1 = l.changeCode("1234", "5678");
        System.out.print("l.changeCode(\"1234\", \"5678\") -> ");
        if (test1) {
            System.out.println("success");
        } else {
            System.out.println("rejected");
        }

        // 3. Test Case 2: Changing code with a WRONG current code
        // l.changeCode("0000", "9999") -> rejected
        boolean test2 = l.changeCode("0000", "9999");
        System.out.print("l.changeCode(\"0000\", \"9999\") -> ");
        if (test2) {
            System.out.println("success");
        } else {
            System.out.println("rejected (code is still \"5678\")");
        }
        
        System.out.println("\n--- Test Complete ---");
    }
}