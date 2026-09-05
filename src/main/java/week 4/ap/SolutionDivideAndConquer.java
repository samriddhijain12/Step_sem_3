public class SolutionDivideAndConquer {
    public int maxSubArray(int[] nums) {
        return divideAndConquer(nums, 0, nums.length - 1);
    }

    private int divideAndConquer(int[] nums, int left, int right) {
        // Base case: only one element
        if (left == right) {
            return nums[left];
        }

        int mid = left + (right - left) / 2;

        // Find max subarray sums in left half, right half, and crossing the midpoint
        int leftMax = divideAndConquer(nums, left, mid);
        int rightMax = divideAndConquer(nums, mid + 1, right);
        int crossMax = maxCrossingSum(nums, left, mid, right);

        // Return the overall maximum among the three possible cases
        return Math.max(Math.max(leftMax, rightMax), crossMax);
    }

    private int maxCrossingSum(int[] nums, int left, int mid, int right) {
        // 1. Calculate max sum extending to the left from mid
        int sum = 0;
        int leftSum = Integer.MIN_VALUE;
        for (int i = mid; i >= left; i--) {
            sum += nums[i];
            if (sum > leftSum) {
                leftSum = sum;
            }
        }

        // 2. Calculate max sum extending to the right from mid + 1
        sum = 0;
        int rightSum = Integer.MIN_VALUE;
        for (int i = mid + 1; i <= right; i++) {
            sum += nums[i];
            if (sum > rightSum) {
                rightSum = sum;
            }
        }

        // Return combined sum of the crossing subarray segments
        return leftSum + rightSum;
    }
}
