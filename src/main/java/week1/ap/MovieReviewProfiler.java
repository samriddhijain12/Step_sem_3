public class MovieReviewProfiler{

    public static void classifyWordLengths(String review) {
        // Initialize counter variables
        int shortCount = 0;
        int mediumCount = 0;
        int longCount = 0;

        // Split the string into individual words by whitespace
        // \\s+ handles single or multiple spaces between words
        String[] words = review.split("\\s+");

        // Iterate through each word
        for (String word : words) {
            // Remove punctuation characters to get accurate word lengths
            String cleanWord = word.replaceAll("[^a-zA-Z]", "");
            int length = cleanWord.length();

            // Skip empty strings (e.g., if a word was just punctuation)
            if (length == 0) {
                continue;
            }

            // Categorize the word based on its length
            if (length >= 1 && length <= 4) {
                shortCount++;
            } else if (length >= 5 && length <= 8) {
                mediumCount++;
            } else if (length >= 9) {
                longCount++;
            }
        }

        // Print the final counts in the requested format
        System.out.println("Short: " + shortCount + " | Medium: " + mediumCount + " | Long: " + longCount);
    }

    public static void main(String[] args) {
        // Test case from the sample input
        String sampleInput = "This movie was absolutely fantastic and thrilling";
        classifyWordLengths(sampleInput);
    }
}