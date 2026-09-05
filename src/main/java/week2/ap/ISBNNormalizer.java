public class ISBNNormalizer{

    public static String normalizeCode(String raw) {
        if (raw == null) {
            return "";
        }
        
        
        String trimmed = raw.trim();
        if (trimmed.length() < 3) {
            return trimmed.toUpperCase();
        }
        
        // Uppercase only the first 3 characters using substring() + concatenation
        String firstThree = trimmed.substring(0, 3).toUpperCase();
        String rest = trimmed.substring(3);
        
        return firstThree + rest;
    }

    public static String validateAndFormat(String code) {
        // 1. Check length
        if (code.length() != 13) {
            return "Invalid: wrong length";
        }

        // 2. Validate first 3 characters are letters (no regex loop)
        for (int i = 0; i < 3; i++) {
            if (!Character.isLetter(code.charAt(i))) {
                return "Invalid: publisher code must be 3 letters";
            }
        }

        // 3. Validate remaining 10 characters are digits (no regex loop)
        for (int i = 3; i < 13; i++) {
            if (!Character.isDigit(code.charAt(i))) {
                return "Invalid: non-digit body";
            }
        }

        // 4. Format components using StringBuilder
        String pubCode = code.substring(0, 3);
        String year = code.substring(3, 7);
        String catalog = code.substring(7, 13);

        StringBuilder sb = new StringBuilder();
        sb.append("[").append(pubCode).append("] ");
        sb.append("YEAR: ").append(year).append(" | ");
        sb.append("CATALOG: ").append(catalog);

        return sb.toString();
    }

    // Driver method to test sample inputs
    public static void main(String[] args) {
        // Test case 1: Valid input with spaces and lowercase letters
        String input1 = "  pen2026004251 ";
        String normalized1 = normalizeCode(input1);
        System.out.println("Input:  \"" + input1 + "\"");
        System.out.println("Output: " + validateAndFormat(normalized1));
        System.out.println();

        // Test case 2: Invalid publisher code (contains a digit)
        String input2 = "12N2026004251";
        String normalized2 = normalizeCode(input2);
        System.out.println("Input:  \"" + input2 + "\"");
        System.out.println("Output: " + validateAndFormat(normalized2));
    }
}