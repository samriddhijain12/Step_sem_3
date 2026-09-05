import java.util.Arrays;

public class Q1{

    // Method to modify the caller's original array directly
    static void applyMultipliers(double[] playerScores, int captainIndex, int viceCaptainIndex) {
        // Double the score of the captain
        playerScores[captainIndex] *= 2.0;
        
        // Multiply the score of the vice-captain by 1.5
        playerScores[viceCaptainIndex] *= 1.5;
    }

    // Main method to test the implementation with the example given
    public static void main(String[] args) {
        double[] scores = {40, 55, 30, 62};
        
        System.out.println("Original Scores: " + Arrays.toString(scores));
        
        // Apply multipliers where captain index is 1 and vice-captain index is 3
        applyMultipliers(scores, 1, 3);
        
        // Print modified scores to verify the output
        System.out.println("Modified Scores: " + Arrays.toString(scores));
    }
}
