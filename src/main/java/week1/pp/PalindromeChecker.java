
import java.util.Scanner;

public class PalindromeChecker {

    public static void main(String[] args) {
        // Test with sample inputs
        testPalindrome("madam");
        testPalindrome("hello");
    }

    private static void testPalindrome(String input) {
        boolean iterativeResult = isPalindromeIterative(input);
        boolean recursiveResult = isPalindromeRecursive(input);
        boolean arrayReversalResult = isPalindromeArrayReversal(input);

        String iterStr = iterativeResult ? "Palindrome" : "Not Palindrome";
        String recurStr = recursiveResult ? "Palindrome" : "Not Palindrome";
        String arrRevStr = arrayReversalResult ? "Palindrome" : "Not Palindrome";

        System.out.println("Input: \"" + input + "\"");
        System.out.println("Iterative: " + iterStr + " | Recursive: " + recurStr + " | Array Reversal: " + arrRevStr);
        System.out.println();
    }

    /**
     * Approach 1: Iterative Check
     * Compares characters from both ends moving toward the middle.
     */
    public static boolean isPalindromeIterative(String text) {
        if (text == null) return false;
        
        int left = 0;
        int right = text.length() - 1;

        while (left < right) {
            if (text.charAt(left) != text.charAt(right)) {
                return false;
            }
            left++;
            right--;
        }
        return true;
    }

    /**
     * Approach 2: Recursive Check
     * Recursively compares the first and last characters, shrinking the substring.
     */
    public static boolean isPalindromeRecursive(String text) {
        if (text == null) return false;
        // Base case: a string of length 0 or 1 is always a palindrome
        if (text.length() <= 1) {
            return true;
        }
        
        // Check outer characters
        if (text.charAt(0) != text.charAt(text.length() - 1)) {
            return false;
        }
        
        // Recursive call with the inner substring
        return isPalindromeRecursive(text.substring(1, text.length() - 1));
    }

    /**
     * Approach 3: Array Reversal Check
     * Converts to a character array, reverses it, and compares it to the original.
     */
    public static boolean isPalindromeArrayReversal(String text) {
        if (text == null) return false;
        
        char[] originalArray = text.toCharArray();
        int len = originalArray.length;
        char[] reversedArray = new char[len];

        // Populate the reversed array
        for (int i = 0; i < len; i++) {
            reversedArray[i] = originalArray[len - 1 - i];
        }

        // Compare the reversed array back to the original string
        String reversedText = new String(reversedArray);
        return text.equals(reversedText);
    }
}
