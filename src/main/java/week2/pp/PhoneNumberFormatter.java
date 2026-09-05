public class PhoneNumberFormatter {

    public static String maskPhoneNumber(String phone) {
        // 1. Validate that the input is exactly 10 digits and entirely numeric
        if (phone == null || phone.length() != 10 || !phone.matches("\\d+")) {
            return "Invalid phone number";
        }

        // 2. Extract the last 4 digits
        String lastFourDigits = phone.substring(6);

        // 3. Build the masked version using StringBuilder
        StringBuilder sb = new StringBuilder();
        sb.append("XXXXXX"); // Six masks
        sb.insert(6, "-");   // Insert "-" between the mask and the last 4 digits
        sb.append(lastFourDigits);

        return sb.toString();
    }

    // Main method to test the logic with sample inputs
    public static void main(String[] args) {
        // Test case 1: Valid 10-digit number
        String input1 = "9876543210";
        System.out.println("Input: " + input1);
        System.out.println("Output: " + maskPhoneNumber(input1));
        System.out.println();

        // Test case 2: Invalid short number
        String input2 = "98765";
        System.out.println("Input: " + input2);
        System.out.println("Output: " + maskPhoneNumber(input2));
    }
}
