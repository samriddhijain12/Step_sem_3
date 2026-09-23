// Main.java
public class p1 {
    public static void main(String[] args) {
        // Sample Input/Output Verification
        
        // 1. Initialize Scorecard with a fixed count of 4 questions
        Scorecard sc = new Scorecard(4);

        // 2. Record individual answers sequentially
        sc.recordAnswer(true);  // correct
        sc.recordAnswer(true);  // correct
        sc.recordAnswer(false); // wrong
        sc.recordAnswer(true);  // correct

        // 3. Print the final score (Expected Output: 3)
        System.out.println("sc.getScore() -> " + sc.getScore()); 

        // 4. Test overflow boundary constraint (should be ignored)
        sc.recordAnswer(true); 
        System.out.println("Score after attempting extra answer: " + sc.getScore());
    }
}

// Complete Scorecard Class Implementation
class Scorecard {
    // Encapsulation: Private members ensure internal data stays hidden
    private final boolean[] results;
    private int recordedCount;

    // Constructor defines the fixed total number of questions
    public Scorecard(int totalQuestions) {
        this.results = new boolean[totalQuestions];
        this.recordedCount = 0;
    }

    // Records the next answer's result (true for correct, false for incorrect)
    public void recordAnswer(boolean isCorrect) {
        // Constraint: Ignore answers if the question capacity is reached
        if (recordedCount >= results.length) {
            return; 
        }
        
        results[recordedCount] = isCorrect;
        recordedCount++;
    }

    // Calculates and exposes only the tally of correct answers
    public int getScore() {
        int score = 0;
        for (int i = 0; i < recordedCount; i++) {
            if (results[i]) {
                score++;
            }
        }
        return score;
    }
}