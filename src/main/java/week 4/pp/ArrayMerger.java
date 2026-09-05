public class ArrayMerger {

    public static int[] mergeSortedArrays(int[] arr1, int[] arr2) {
        // Create a new empty result array with the combined size of both arrays
        int[] result = new int[arr1.length + arr2.length];
        
        // Keep one index pointer for each array, starting at 0
        int i = 0; // Pointer for arr1
        int j = 0; // Pointer for arr2
        int k = 0; // Pointer for the result array

        // Loop while there are elements remaining in BOTH arrays
        while (i < arr1.length && j < arr2.length) {
            // Compare elements, copy the smaller one, and advance pointers
            if (arr1[i] <= arr2[j]) {
                result[k] = arr1[i];
                i++;
            } else {
                result[k] = arr2[j];
                j++;
            }
            k++;
        }

        // Copy any remaining elements from arr1, if any exist
        while (i < arr1.length) {
            result[k] = arr1[i];
            i++;
            k++;
        }

        // Copy any remaining elements from arr2, if any exist
        while (j < arr2.length) {
            result[k] = arr2[j];
            j++;
            k++;
        }

        // Return the fully merged, fully sorted result array
        return result;
    }

    // Main method to test the sample inputs provided in the image
    public static void main(String[] args) {
        // Test Case 1: arr1 =, arr2 = [2, 4, 6]
        int[] arr1 = {1, 3, 5};
        int[] arr2 = {2, 4, 6};
        int[] res1 = mergeSortedArrays(arr1, arr2);
        System.out.print("Output 1: ");
        printArray(res1); // Expected: [1, 2, 3, 4, 5, 6]

        // Test Case 2: arr1 = [], arr2 = [1, 2, 3]
        int[] arr3 = {};
        int[] arr4 = {1, 2, 3};
        int[] res2 = mergeSortedArrays(arr3, arr4);
        System.out.print("Output 2: ");
        printArray(res2); // Expected: [1, 2, 3]
    }

    // Helper method to display arrays
    private static void printArray(int[] arr) {
        System.out.print("[");
        for (int i = 0; i < arr.length; i++) {
            System.out.print(arr[i]);
            if (i < arr.length - 1) System.out.print(", ");
        }
        System.out.println("]");
    }
}