public class PasswordChecker {
    // Requirements: Store the password privately with no getter, and ensure it's unchangeable
    private final String password;

    /**
     * Constructor: Takes the password as a string once during object creation.
     */
    public PasswordChecker(String password) {
        this.password = password;
    }

    /**
     * Requirement: Provide a method that returns only a strength label based on length.
     * Under 6 characters -> "Weak"
     * 6-9 characters -> "Medium"
     * 10+ characters -> "Strong"
     */
    public String getStrength() {
        if (this.password == null) {
            return "Weak";
        }

        int length = this.password.length();

        if (length < 6) {
            return "Weak";
        } else if (length <= 9) {
            return "Medium";
        } else {
            return "Strong";
        }
    }

    /**
     * Execution Main Method matching the exact sample input and expected behavior.
     */
    public static void main(String[] args) {
        // Sample Test Case 1: 4-character password
        PasswordChecker pc = new PasswordChecker("abcd");
        System.out.println("pc.getStrength() -> \"" + pc.getStrength() + "\""); // Expected: "Weak"

        // Sample Test Case 2: 8-character password (Expected Behavior check)
        PasswordChecker pcMedium = new PasswordChecker("abcdefgh");
        System.out.println("pcMedium.getStrength() -> \"" + pcMedium.getStrength() + "\""); // Expected: "Medium"

        // Sample Test Case 3: 10-character password
        PasswordChecker pc2 = new PasswordChecker("abcdefghij");
        System.out.println("pc2.getStrength() -> \"" + pc2.getStrength() + "\""); // Expected: "Strong"
    }
}