import java.util.Arrays;

public class Problem5 {

    static class Candidate implements Comparable<Candidate> {

        String name;
        double cgpa;
        int codingScore;

        Candidate(String name, double cgpa, int codingScore) {
            this.name = name;
            this.cgpa = cgpa;
            this.codingScore = codingScore;
        }

        static boolean isEligible(double cgpa) {
            return cgpa >= 8.0;
        }

        static boolean isEligible(double cgpa, int codingScore) {
            return cgpa >= 7.0 && codingScore >= 60;
        }

        double compositeScore() {
            return (cgpa * 10) + (codingScore * 0.5);
        }

        @Override
        public int compareTo(Candidate other) {
            return Double.compare(
                other.compositeScore(),
                this.compositeScore()
            );
        }
    }

    static String shortlistAndRank(Candidate[] candidates) {

        Candidate[] shortlisted =
            new Candidate[candidates.length];

        int count = 0;

        for (Candidate c : candidates) {

            if (Candidate.isEligible(c.cgpa) ||
                Candidate.isEligible(c.cgpa, c.codingScore)) {

                shortlisted[count] = c;
                count++;
            }
        }

        Candidate[] result =
            Arrays.copyOf(shortlisted, count);

        Arrays.sort(result);

        String output = "";

        for (int i = 0; i < result.length; i++) {

            if (i > 0) {
                output += " | ";
            }

            output += (i + 1) + ". "
                    + result[i].name
                    + " ("
                    + String.format("%.1f",
                        result[i].compositeScore())
                    + ")";
        }

        return output;
    }

    public static void main(String[] args) {

        Candidate[] candidates = {

            new Candidate("Aisha", 8.2, 40),
            new Candidate("Rohit", 6.8, 65),
            new Candidate("Meena", 6.0, 90),
            new Candidate("Karan", 7.5, 20)
        };

        System.out.println(
            shortlistAndRank(candidates)
        );
    }
}