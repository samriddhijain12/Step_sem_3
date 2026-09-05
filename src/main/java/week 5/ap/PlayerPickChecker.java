public class PlayerPickChecker {

    // Method to check for duplicate player names using nested loops
    static String findDuplicatePick(String[] playerNames) {
        // Outer loop selects a player name one by one
        for (int i = 0; i < playerNames.length; i++) {
            // Inner loop compares it ONLY against the names that come after it
            for (int j = i + 1; j < playerNames.length; j++) {
                // Use .equals() for string comparison instead of ==
                if (playerNames[i].equals(playerNames[j])) {
                    return "Duplicate Found: " + playerNames[i];
                }
            }
        }
        // If no duplicates are found after checking all pairs
        return "No Duplicates Found";
    }

    // Main method to test the functionality with the provided examples
    public static void main(String[] args) {
        // Example 1
        String[] lineup1 = {"Kohli", "Bumrah", "Kohli", "Rohit"};
        System.out.println("Input 1: {\"Kohli\", \"Bumrah\", \"Kohli\", \"Rohit\"}");
        System.out.println("Output 1: " + findDuplicatePick(lineup1));
        
        System.out.println(); // Blank line for readability

        // Example 2
        String[] lineup2 = {"Kohli", "Bumrah", "Rohit"};
        System.out.println("Input 2: {\"Kohli\", \"Bumrah\", \"Rohit\"}");
        System.out.println("Output 2: " + findDuplicatePick(lineup2));
    }
}