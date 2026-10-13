public class p4{

    public static int secondHighest(int[] scores) {
        int highest = -1;
        int second = -1;

        for (int score : scores) {
            if (score > highest) {
                // Current score is greater than the highest seen so far
                second = highest;
                highest = score;
            } else if (score < highest && score > second) {
                // Current score is less than highest but greater than second
                second = score;
            }
        }

        return second;
    }

    public static void main(String[] args) {
        int[] scores1 = {45, 78, 92, 78, 60};
        System.out.println(secondHighest(scores1)); // Output: 78

        int[] scores2 = {50, 50, 50};
        System.out.println(secondHighest(scores2)); // Output: -1
    }
}