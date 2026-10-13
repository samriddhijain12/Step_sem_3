public class Solution {

    public static void busiestRow(int[][] grid) {
        int r = grid.length;
        int c = grid[0].length;

        int maxTotal = -1;
        int maxRowIndex = -1;

        // Traverse each row
        for (int i = 0; i < r; i++) {
            int currentTotal = 0;
            // Sum elements in the current row
            for (int j = 0; j < c; j++) {
                currentTotal += grid[i][j];
            }

            // Strictly larger check ensures tie-breaking goes to the smaller row index
            if (currentTotal > maxTotal) {
                maxTotal = currentTotal;
                maxRowIndex = i;
            }
        }

        System.out.println("Row " + maxRowIndex + ", Total " + maxTotal);
    }

    public static void main(String[] args) {
        int[][] grid = {
            {2, 0, 1},
            {3, 3, 1},
            {1, 1, 1}
        };

        busiestRow(grid); // Output: Row 1, Total 7
    }
}