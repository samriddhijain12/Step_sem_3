import java.util.Random;

public class BmiCalculator {

    public static void main(String[] args) {
        // Size of the team (suggested: 10)
        int teamSize = 10;
        
        // Parallel arrays to store data
        double[] heights = new double[teamSize];
        double[] weights = new double[teamSize];
        
        // Random generator to simulate live-demo data
        Random random = new Random();
        
        for (int i = 0; i < teamSize; i++) {
            // Generates heights between 1.50m and 1.95m
            heights[i] = 1.50 + (random.nextDouble() * 0.45);
            // Generates weights between 45kg and 110kg
            weights[i] = 45.0 + (random.nextDouble() * 65.0);
        }
        
        // Print the corporate wellness report table
        printWellnessReport(heights, weights);
    }

    /**
     * Classifies the health status based on the calculated BMI value.
     */
    public static String getBmiStatus(double bmi) {
        if (bmi < 18.5) {
            return "Underweight";
        } else if (bmi <= 24.9) {
            return "Normal";
        } else if (bmi <= 29.9) {
            return "Overweight";
        } else {
            return "Obese";
        }
    }

    /**
     * Iterates through the arrays, calculates BMI, and displays a formatted table.
     */
    public static void printWellnessReport(double[] heights, double[] weights) {
        // Print the table header
        System.out.println("================================================================");
        System.out.printf("%-12s | %-11s | %-11s | %-6s | %-12s\n", 
                "Person", "Height (m)", "Weight (kg)", "BMI", "Status");
        System.out.println("================================================================");
        
        // Process and display records for each person
        for (int i = 0; i < heights.length; i++) {
            double height = heights[i];
            double weight = weights[i];
            
            // Formula: BMI = weight / (height * height)
            double bmi = weight / (height * height);
            
            // Get classification string
            String status = getBmiStatus(bmi);
            
            // Format labels and print rows with aligned margins
            String personLabel = "Person " + (i + 1);
            System.out.printf("%-12s | %-11.2f | %-11.2f | %-6.2f | %-12s\n", 
                    personLabel, height, weight, bmi, status);
        }
        System.out.println("================================================================");
    }
}