public class p3 {

    public static int countInBand(int[] scores, int low, int high) {
        int lowerIndex = findLowerBound(scores, low);
        int upperIndex = findUpperBound(scores, high);

        return upperIndex - lowerIndex;
    }

    // Finds the first index where score >= target (Lower Bound)
    private static int findLowerBound(int[] scores, int target) {
        int left = 0;
        int right = scores.length;

        while (left < right) {
            int mid = left + (right - left) / 2;
            if (scores[mid] >= target) {
                right = mid;
            } else {
                left = mid + 1;
            }
        }
        return left;
    }

    // Finds the first index where score > target (Upper Bound)
    private static int findUpperBound(int[] scores, int target) {
        int left = 0;
        int right = scores.length;

        while (left < right) {
            int mid = left + (right - left) / 2;
            if (scores[mid] > target) {
                right = mid;
            } else {
                left = mid + 1;
            }
        }
        return left;
    }

    public static void main(String[] args) {
        int[] scores = {35, 42, 42, 50, 58, 58, 58, 63, 71, 88};

        System.out.println(countInBand(scores, 42, 58)); // Output: 6
        System.out.println(countInBand(scores, 90, 100)); // Output: 0
    }
}
