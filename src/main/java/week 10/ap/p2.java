import java.util.Arrays;

public class p2{

    public static String[] rotateRoster(String[] names, int k) {
        int n = names.length;
        if (n == 0) return names;

        // Reduce k to avoid unnecessary full rotations
        k = k % n;

        String[] result = new String[n];

        // Place each element directly at its new position
        for (int i = 0; i < n; i++) {
            int newIndex = (i + k) % n;
            result[newIndex] = names[i];
        }

        return result;
    }

    public static void main(String[] args) {
        String[] names1 = {"A", "B", "C", "D", "E"};
        System.out.println(Arrays.toString(rotateRoster(names1, 2))); 
        // Output: [D, E, A, B, C]

        String[] names2 = {"A", "B", "C", "D", "E"};
        System.out.println(Arrays.toString(rotateRoster(names2, 7))); 
        // Output: [D, E, A, B, C]
    }
}