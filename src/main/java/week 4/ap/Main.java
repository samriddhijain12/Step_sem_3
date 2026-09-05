import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Main {

    // Target method signature specified in the assignment
    public static int[][] threeSum(int[] nums) {
        if (nums == null || nums.length < 3) {
            return new int[0][0];
        }

        // 1. Sort the array first: O(n log n)
        Arrays.sort(nums);
        List<int[]> resultList = new ArrayList<>();

        // 2. Iterate for each fixed element
        for (int i = 0; i < nums.length - 2; i++) {
            // Optimization: If the smallest element is > 0, three positive numbers cannot sum to 0
            if (nums[i] > 0) {
                break;
            }

            // Skip duplicate values for the first element to avoid repetitive triplets
            if (i > 0 && nums[i] == nums[i - 1]) {
                continue;
            }

            // 3. Two pointers moving inward from both ends of the remaining subarray
            int left = i + 1;
            int right = nums.length - 1;

            while (left < right) {
                int sum = nums[i] + nums[left] + nums[right];

                if (sum == 0) {
                    resultList.add(new int[]{nums[i], nums[left], nums[right]});

                    // Skip duplicate values for the left pointer
                    while (left < right && nums[left] == nums[left + 1]) {
                        left++;
                    }
                    // Skip duplicate values for the right pointer
                    while (left < right && nums[right] == nums[right - 1]) {
                        right--;
                    }

                    // Progress pointers after recording the triplet
                    left++;
                    right--;
                } else if (sum < 0) {
                    left++; // Increase sum by moving left pointer forward
                } else {
                    right--; // Decrease sum by moving right pointer backward
                }
            }
        }

        // Convert the dynamic list to the exact int[][] primitive type requested
        return resultList.toArray(new int[resultList.size()][]);
    }

    // Driver main method to run the sample inputs from your image
    public static void main(String[] args) {
        // Test Case 1
        int[] nums1 = {-1, 0, 1, 2, -1, -4};
        int[][] res1 = threeSum(nums1);
        System.out.println("Input: nums = [-1, 0, 1, 2, -1, -4]");
        System.out.println("Output: " + Arrays.deepToString(res1));
        System.out.println();

        // Test Case 2
        int[] nums2 = {0, 0, 0};
        int[][] res2 = threeSum(nums2);
        System.out.println("Input: nums = [0, 0, 0]");
        System.out.println("Output: " + Arrays.deepToString(res2));
    }
}