public class WordReversalEncoder{

    public static String reverseEachWord(String sentence) {
        // 1. Split the sentence into words using a single space
        String[] words = sentence.split(" ");
        StringBuilder result = new StringBuilder();

        // 2. Process each word
        for (int i = 0; i < words.length; i++) {
            String word = words[i];
            StringBuilder reversedWord = new StringBuilder();

            // 3. Build the reverse using a loop as requested
            for (int j = word.length() - 1; j >= 0; j--) {
                reversedWord.append(word.charAt(j));
            }

            // 4. Join the reversed words back together with spaces
            result.append(reversedWord);
            if (i < words.length - 1) {
                result.append(" ");
            }
        }

        return result.toString();
    }

    // Main method to test the sample input
    public static void main(String[] args) {
        String input = "hello club";
        String output = reverseEachWord(input);
        
        System.out.println("Input:  \"" + input + "\"");
        System.out.println("Output: \"" + output + "\"");
    }
}