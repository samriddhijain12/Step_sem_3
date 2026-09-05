import java.util.*;

public class WordFrequencyReport{

    public static void printFilteredWordFrequency(String feedback) {
        // 1. Define the fixed list of stop words
        Set<String> stopWords = new HashSet<>(Arrays.asList("the", "was", "and", "a", "is", "of", "in"));

        // 2. Normalize: convert to lowercase, strip periods and commas
        String cleanedText = feedback.toLowerCase().replace(".", "").replace(",", "");

        // 3. Split the cleaned text into words using whitespace pattern
        String[] words = cleanedText.split("\\s+");

        // 4. Count the frequency of remaining unique words
        Map<String, Integer> frequencyMap = new HashMap<>();
        for (String word : words) {
            if (!word.isEmpty() && !stopWords.contains(word)) {
                frequencyMap.put(word, frequencyMap.getOrDefault(word, 0) + 1);
            }
        }

        // 5. Sort by count in descending order
        List<Map.Entry<String, Integer>> list = new ArrayList<>(frequencyMap.entrySet());
        list.sort((a, b) -> b.getValue().compareTo(a.getValue()));

        // 6. Print each unique word with its count
        for (Map.Entry<String, Integer> entry : list) {
            System.out.println(entry.getKey() + ": " + entry.getValue());
        }
    }

    // Main method to test the sample input
    public static void main(String[] args) {
        String sampleInput = "The mentor was great, the session was great and clear.";
        printFilteredWordFrequency(sampleInput);
    }
}
