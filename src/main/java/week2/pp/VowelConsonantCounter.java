public class VowelConsonantCounter{

    public static void countVowelsAndConsonants(String text) {
        int vowels = 0;
        int consonants = 0;

        // Loop through each character using length() and charAt()
        for (int i = 0; i < text.length(); i++) {
            char ch = text.charAt(i);

            // Ignore spaces as required by the task
            if (ch == ' ') {
                continue;
            }

            // Case-insensitive check by converting to lowercase
            char lowerCh = Character.toLowerCase(ch);

            // Check if the character is a vowel
            if (lowerCh == 'a' || lowerCh == 'e' || lowerCh == 'i' || lowerCh == 'o' || lowerCh == 'u') {
                vowels++;
            } 
            // Since the input only contains letters and spaces, if it isn't a space or vowel, it's a consonant
            else {
                consonants++;
            }
        }

        // Print the output matching the sample format
        System.out.println("Vowels: " + vowels + " | Consonants: " + consonants);
    }

    public static void main(String[] args) {
        // Test with the sample input from the image
        countVowelsAndConsonants("Java Programming");
    }
}
