public class CustomerNameReversal {

    // Method to reverse the given customer name
    public static String reverseCustomerName(String customerName) {
        // Handle null or empty string cases safely
        if (customerName == null || customerName.isEmpty()) {
            return customerName;
        }
        
        // Convert string to character array for manipulation
        char[] characters = customerName.toCharArray();
        int left = 0;
        int right = characters.length - 1;
        
        // Swap characters from both ends moving towards the middle
        while (left < right) {
            char temp = characters[left];
            characters[left] = characters[right];
            characters[right] = temp;
            left++;
            right--;
        }
        
        // Reconstruct and return the reversed string
        return new String(characters);
    }

    public static void main(String[] args) {
        // Sample Input
        String inputName = "Sunil";
        
        // Call the method to reverse the name
        String reversedName = reverseCustomerName(inputName);
        
        // Print output exactly as specified in the sample
        System.out.println("Original Name: " + inputName);
        System.out.println("Reversed Name: " + reversedName);
    }
}
