

public class Profit{
    
    public int maxProfit(int[] prices) {
        // Handle edge case: if there are no prices or only 1 day, no trade can be made
        if (prices == null || prices.length <= 1) {
            return 0;
        }
        
        // Track the lowest price seen so far, initialized to the first day's price
        int minPrice = prices[0];
        
        // Track the running maximum profit found across the array
        int maxProfit = 0;
        
        // Walk through the array once, starting from the second day
        for (int i = 1; i < prices.length; i++) {
            // Update the lowest price seen so far
            if (prices[i] < minPrice) {
                minPrice = prices[i];
            } else {
                // Calculate potential profit if sold today
                int currentProfit = prices[i] - minPrice;
                
                // Keep running record of the largest profit seen
                if (currentProfit > maxProfit) {
                    maxProfit = currentProfit;
                }
            }
        }
        
        return maxProfit;
    }

    // Main method to verify the sample inputs/outputs
    public static void main(String[] args) {
    Profit sol = new Profit();
        
        // Sample Input 1
        int[] prices1 = {7, 1, 5, 3, 6, 4};
        System.out.println("Output 1: " + sol.maxProfit(prices1)); // Expected: 5
        
        // Sample Input 2
        int[] prices2 = {7, 6, 4, 3, 1};
        System.out.println("Output 2: " + sol.maxProfit(prices2)); // Expected: 0
    }
}