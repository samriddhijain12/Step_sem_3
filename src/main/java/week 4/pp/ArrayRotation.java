public class ArrayRotation {

    public static int[] rotateArray(int[] nums, int k) {
        // Handle empty or single-element arrays to avoid division by zero or unnecessary work
        if (nums == null || nums.length <= 1) {
            return nums;
        }

        // Step 1: First reduce k using k = k % nums.length
        k = k % nums.length;

        // Step 2: Create a new array of the same size
        int[] newArray = new int[nums.length];

        // Step 3: Compute the new position for every index i and place the elements
        for (int i = 0; i < nums.length; i++) {
            newArray[(i + k) % nums.length] = nums[i];
        }

        // Step 4: Copy the values from the new array back into nums
        for (int i = 0; i < nums.length; i++) {
            nums[i] = newArray[i];
        }

        // Return the modified array as per the suggested method signature
        return nums;
    }

    // Main method to test with the provided sample inputs
    public static void main(String[] args) {
        // Sample Input 1
        int[] nums1 = {1, 2, 3, 4, 5, 6, 7};
        int k1 = 3;
        int[] result1 = rotateArray(nums1, k1);
        System.out.print("Output 1: ");
        printArray(result1); // Expected: [5, 6, 7, 1, 2, 3, 4]

        // Sample Input 2
        int[] nums2 = {1, 2};
        int k2 = 3;
        int[] result2 = rotateArray(nums2, k2);
        System.out.print("Output 2: ");
        printArray(result2); // Expected: [2, 1]
    }

    private static void printArray(int[] arr) {
        System.out.print("[");
        for (int i = 0; i < arr.length; i++) {
            System.out.print(arr[i] + (i < arr.length - 1 ? ", " : ""));
        }
        System.out.println("]");
    }
}