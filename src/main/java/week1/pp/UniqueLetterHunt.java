 import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

public class UniqueLetterHunt {

    /**
     * Finds the first character that appears exactly once in the given text.
     * Returns '\0' (null character) if no unique character is found.
     */
    public static char findFirstNonRepeatingChar(String text) {
        // Step 1: Compute the frequency of every character using a HashMap
        Map<Character, Integer> frequencyMap = new HashMap<>();
        
        for (char c : text.toCharArray()) {
            frequencyMap.put(c, frequencyMap.getOrDefault(c, 0) + 1);
        }
        
        // Step 2: Scan the string left to right to find the first character with frequency 1
        for (char c : text.toCharArray()) {
            if (frequencyMap.get(c) == 1) {
                return c; // Early-exit as soon as the first unique character is found
            }
        }
        
        // Return null character indicator if no match exists
        return '\0';
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        
        System.out.print("Enter a word or short sentence: ");
        String input = scanner.nextLine();
        
        // Find the unique character
        char result = findFirstNonRepeatingChar(input);
        
        // Step 3: Print the result or a clear message
        if (result != '\0') {
            System.out.println("First Non-Repeating Character: '" + result + "'");
        } else {
            System.out.println("No Non-Repeating Character Found");
        }
        
        scanner.close();
    }
} 
