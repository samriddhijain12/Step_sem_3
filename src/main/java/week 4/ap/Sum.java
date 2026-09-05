import java.util.HashMap;

public class Sum{
    
    // Method to solve the Subarray Sum Equals K problem
    public static int subarraySum(int[] nums, int k) {
        // Map to store (prefixSum -> frequency)
        HashMap<Integer, Integer> map = new HashMap<>();
        
        // Base case: An empty prefix before the array starts has a sum of 0
        map.put(0, 1);
        
        int currentSum = 0;
        int totalSubarrays = 0;
        
        for (int num : nums) {
            // Update the running prefix sum
            currentSum += num;
            
            // Check if (currentSum - k) exists in the history of prefix sums
            if (map.containsKey(currentSum - k)) {
                totalSubarrays += map.get(currentSum - k);
            }
            
            // Record the frequency of the current running sum in the map
            map.put(currentSum, map.getOrDefault(currentSum, 0) + 1);
        }
        
        return totalSubarrays;
    }

    public static void main(String[] args) {
        // Sample Test Case 1
        int[] nums1 = {1, 1, 1};
        int k1 = 2;
        System.out.println("Test Case 1 Output: " + subarraySum(nums1, k1)); // Expected: 2

        // Sample Test Case 2
        int[] nums2 = {1, -1, 0};
        int k2 = 0;
        System.out.println("Test Case 2 Output: " + subarraySum(nums2, k2)); // Expected: 3
    }
}