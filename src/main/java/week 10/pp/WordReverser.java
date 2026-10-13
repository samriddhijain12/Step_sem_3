import java.util.Scanner;

public class WordReverser {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String word = scanner.next();

        StringBuilder sb = new StringBuilder(word);
        String reversed = sb.reverse().toString();

        if (word.equals(reversed)) {
            System.out.println(reversed + " - palindrome");
        } else {
            System.out.println(reversed + " - not a palindrome");
        }
        
        scanner.close();
    }
}