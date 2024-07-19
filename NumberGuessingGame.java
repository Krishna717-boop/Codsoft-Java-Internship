import java.util.Random;
import java.util.Scanner;

public class NumberGuessingGame {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        Random random = new Random();
        int score = 0;

        do {
            int secretNumber = random.nextInt(100) + 1;
            int attempts = 0;
            int guess;

            System.out.println("I've conjured a mystical number between 1 and 100. Can you unveil it?");

            do {
                System.out.print("What's your intuition telling you? ");
                guess = scanner.nextInt();
                attempts++;

                if (guess < secretNumber) {
                    System.out.println("Aim higher! The number is greater than your guess.");
                } else if (guess > secretNumber) {
                    System.out.println("Easy there! The number is smaller than that.");
                } else {
                    System.out.println("Eureka! You've unveiled the mystical number in " + attempts + " attempts.");
                    score++;
                }
            } while (guess != secretNumber && attempts < 10);

            if (guess != secretNumber) {
                System.out.println("The mystical forces were too strong this time. The number was " + secretNumber);
            }

            System.out.println("Your mystic power level: " + score);
            System.out.print("Shall we embark on another mystical journey? (yes/no): ");
        } while (scanner.next().equalsIgnoreCase("yes"));

        System.out.println("Thank you for playing the Mystical Number Game! Final power level: " + score);
        scanner.close();
    }
}