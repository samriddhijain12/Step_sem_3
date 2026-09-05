public class DuplicateChecker {

    // Method to check for duplicates using two nested loops as specified
    public static boolean containsDuplicate(int[] nums) {
        // Outer loop selects the first element of the pair
        for (int i = 0; i < nums.length; i++) {
            // Inner loop selects the second element of the pair
            for (int j = i + 1; j < nums.length; j++) {
                // Early exit: if a duplicate value is found, return true immediately
                if (nums[i] == nums[j]) {
                    return true;
                }
            }
        }
        // Return false if the loops complete without finding any duplicates
        return false;
    }

    public static void main(String[] args) {
        // Test Case 1 from Sample Input
        int[] nums1 = {1, 2, 3, 1};
        System.out.println("Input: nums = [1, 2, 3, 1]");
        System.out.println("Output: " + containsDuplicate(nums1)); 
        System.out.println(); // Prints a blank line

        // Test Case 2 from Sample Input
        int[] nums2 = {1, 2, 3, 4};
        System.out.println("Input: nums = [1, 2, 3, 4]");
        System.out.println("Output: " + containsDuplicate(nums2));
    }
}
