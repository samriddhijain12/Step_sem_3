public class Solution {
    public int[] twoSum(int[] nums, int target) {
        // Outer loop iterates through each element in the array
        for (int i = 0; i < nums.length; i++) {
            // Inner loop checks every subsequent element to form unique pairs
            for (int j = i + 1; j < nums.length; j++) {
                // If the sum matches the target, return their indices immediately
                if (nums[i] + nums[j] == target) {
                    return new int[]{i, j};
                }
            }
        }
        // Return an empty array if no pair is found (guaranteed not to hit based on constraints)
        return new int[]{};
    }
}