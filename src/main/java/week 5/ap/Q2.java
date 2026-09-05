public class Q2{
    public static String findMinMaxSpread(int[] scores) {
        // Initialize min and max with the first element of the array
        int min = scores[0];
        int max = scores[0];
        
        // Loop through the array starting from the second element
        for (int i = 1; i < scores.length; i++) {
            if (scores[i] < min) {
                min = scores[i];
            }
            if (scores[i] > max) {
                max = scores[i];
            }
        }
        
        // Calculate the spread
        int spread = max - min;
        
        // Return the formatted result matching the example output
        return "Min: " + min + " | Max: " + max + " | Spread: " + spread;
    }

    // Main method to test the functionality
    public static void main(String[] args) {
        int[] exampleScores = {45, 82, 79, 90, 33, 90, 61};
        System.out.println(findMinMaxSpread(exampleScores));
        // Output: Min: 33 | Max: 90 | Spread: 57
    }
}