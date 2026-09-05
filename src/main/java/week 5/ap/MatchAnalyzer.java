public class MatchAnalyzer {

    // Helper method to calculate the average score of a single match (row)
    private static double rowAverage(int[] row) {
        if (row == null || row.length == 0) {
            return 0.0; // Handles empty rows safely to prevent division by zero
        }
        
        int sum = 0;
        for (int runs : row) {
            sum += runs;
        }
        return (double) sum / row.length;
    }

    // Main classification method that builds the result string
    public static String classifyMatches(int[][] runsPerOver, int threshold) {
        if (runsPerOver == null || runsPerOver.length == 0) {
            return "";
        }

        StringBuilder result = new StringBuilder();

        for (int i = 0; i < runsPerOver.length; i++) {
            // Call the helper method exactly once per match
            double average = rowAverage(runsPerOver[i]);
            
            // Determine status based on the threshold
            String classification = (average >= threshold) ? "Power Surge" : "Normal";

            // Append the match result
            result.append("Match ").append(i).append(": ").append(classification);

            // Add the separator if it's not the final match
            if (i < runsPerOver.length - 1) {
                result.append(" | ");
            }
        }

        return result.toString();
    }

    // Optional main method to test the functionality with the example input
    public static void main(String[] args) {
        int[][] sampleInput = {
            {4, 6, 8},
            {10, 12, 14},
            {2, 3, 1}
        };
        int threshold = 8;

        String output = classifyMatches(sampleInput, threshold);
        System.out.println(output);
        // Expected Output: Match 0: Normal | Match 1: Power Surge | Match 2: Normal
    }
}