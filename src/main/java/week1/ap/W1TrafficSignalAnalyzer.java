public class W1TrafficSignalAnalyzer{

    public static void findLongestStreak(String signalLog) {
        // Handle edge case for empty or null input
        if (signalLog == null || signalLog.isEmpty()) {
            System.out.println("Longest Streak: None");
            return;
        }

        // Initialize tracking variables
        char maxChar = signalLog.charAt(0);
        int maxStreak = 1;

        char currentChar = signalLog.charAt(0);
        int currentStreak = 1;

        // Traverse the string starting from the second character
        for (int i = 1; i < signalLog.length(); i++) {
            if (signalLog.charAt(i) == currentChar) {
                // Increment streak if the character matches the current one
                currentStreak++;
            } else {
                // Check if the finished streak is the longest so far
                if (currentStreak > maxStreak) {
                    maxStreak = currentStreak;
                    maxChar = currentChar;
                }
                // Reset tracker for the new character streak
                currentChar = signalLog.charAt(i);
                currentStreak = 1;
            }
        }

        // Final check after loop ends to catch the last streak sequence
        if (currentStreak > maxStreak) {
            maxStreak = currentStreak;
            maxChar = currentChar;
        }

        // Print the result matching the sample output format
        System.out.println("Longest Streak: '" + maxChar + "' repeated " + maxStreak + " times");
    }

    public static void main(String[] args) {
        // Test Case 1
        System.out.print("Input: \"RRGGGYRR\" -> ");
        findLongestStreak("RRGGGYRR");

        // Test Case 2
        System.out.print("Input: \"RRRRYYGG\" -> ");
        findLongestStreak("RRRRYYGG");
    }
}