public class WarehouseBalancer{

    public static void analyzeInventory(int[] sectionA, int[] sectionB) {
        int totalA = 0;
        int totalB = 0;
        
        int highestQuantity = Integer.MIN_VALUE;
        String highestSection = "";
        int highestIndex = -1;

        // Loop through both arrays simultaneously since they have equal length
        for (int i = 0; i < sectionA.length; i++) {
            // Accumulate sums
            totalA += sectionA[i];
            totalB += sectionB[i];

            // Check max for Section A
            if (sectionA[i] > highestQuantity) {
                highestQuantity = sectionA[i];
                highestSection = "Section A";
                highestIndex = i;
            }

            // Check max for Section B
            if (sectionB[i] > highestQuantity) {
                highestQuantity = sectionB[i];
                highestSection = "Section B";
                highestIndex = i;
            }
        }

        // Determine balancing status
        String status = (totalA == totalB) ? "Balanced" : "Not Balanced";

        // Format and print output (Converting 0-based index to 1-based item number)
        int itemNumber = highestIndex + 1;
        System.out.printf("Section A Total: %d | Section B Total: %d | Status: %s | Highest Quantity: %d (%s, Item %d)\n",
                totalA, totalB, status, highestQuantity, highestSection, itemNumber);
    }

    public static void main(String[] args) {
        // Test with the sample input from the image
        int[] sectionA = {20, 15, 30};
        int[] sectionB = {25, 10, 30};

        analyzeInventory(sectionA, sectionB);
    }
}