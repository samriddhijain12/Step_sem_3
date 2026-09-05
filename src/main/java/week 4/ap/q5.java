public class q5{
    
    // Method signature requested in the worksheet
    public int findMin(int[] nums) {
        int left = 0;
        int right = nums.length - 1;

        // Binary search execution loop
        while (left < right) {
            int mid = left + (right - left) / 2;

            // If the middle element is greater than the rightmost element, 
            // the pivot inflection point and the minimum are in the right half.
            if (nums[mid] > nums[right]) {
                left = mid + 1;
            } 
            // Otherwise, the right half is properly sorted, 
            // meaning the minimum element is either at 'mid' or to its left.
            else {
                right = mid;
            }
        }

        // When left == right, both pointers converge onto the minimum element.
        return nums[left];
    }

    // Main execution framework to test sample configurations
    public static void main(String[] args) {
        q5 solver = new q5();

        // Sample Input 1
        int[] nums1 = {3, 4, 5, 1, 2};
        System.out.println("Input:  [3, 4, 5, 1, 2]");
        System.out.println("Output: " + solver.findMin(nums1)); 
        System.out.println();

        // Sample Input 2
        int[] nums2 = {4, 5, 6, 7, 0, 1, 2};
        System.out.println("Input:  [4, 5, 6, 7, 0, 1, 2]");
        System.out.println("Output: " + solver.findMin(nums2)); 
        System.out.println();

        // Sample Input 3 (No rotation actually occurred)
        int[] nums3 = {11, 13, 15, 17};
        System.out.println("Input:  [11, 13, 15, 17]");
        System.out.println("Output: " + solver.findMin(nums3) + " (no rotation)");
    }
}