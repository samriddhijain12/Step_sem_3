import java.util.Scanner;

public class DigitSumAndReverse {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int num = scanner.nextInt();

        int sum = 0;
        int reversedNum = 0;
        int temp = num;

        while (temp > 0) {
            int digit = temp % 10;
            sum += digit;
            reversedNum = reversedNum * 10 + digit;
            temp /= 10;
        }

        System.out.println("Sum of digits: " + sum);
        System.out.println("Reverse: " + reversedNum);
        
        scanner.close();
    }
}