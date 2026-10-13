class Student {
    private String name;
    private int[] marks;

    public Student(String name, int[] marks) {
        this.name = name;
        this.marks = marks;
    }

    public double calculateAverage() {
        int sum = 0;
        for (int mark : marks) {
            sum += mark;
        }
        return (double) sum / marks.length;
    }

    public char getGrade(double average) {
        if (average >= 75) {
            return 'B';
        } else if (average >= 60) {
            return 'C';
        } else if (average >= 40) {
            return 'D';
        } else {
            return 'F';
        }
    }

    public void displayResultCard() {
        double avg = calculateAverage();
        char grade = getGrade(avg);
        System.out.printf("%s: Average %.1f, Grade %c%n", name.toUpperCase(), avg, grade);
    }
}

public class StudentResultCardGenerator {
    public static void main(String[] args) {
        // Sample Test Case 1
        Student student1 = new Student("Asha", new int[]{80, 90, 70});
        student1.displayResultCard();

        // Sample Test Case 2
        Student student2 = new Student("Ravi", new int[]{60, 55, 50});
        student2.displayResultCard();
    }
}