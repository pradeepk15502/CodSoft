import java.util.Random;
import java.util.Scanner;

public class NumberGuessingGame {
    private static final int MAX_ATTEMPTS = 10;
    private static final int MIN_NUMBER = 1;
    private static final int MAX_NUMBER = 100;
    private int score;

    public NumberGuessingGame() {
        score = 0;
    }

    private int generateRandomNumber() {
        Random random = new Random();
        return random.nextInt(MAX_NUMBER - MIN_NUMBER + 1) + MIN_NUMBER;
    }

    private void playRound() {
        int numberToGuess = generateRandomNumber();
        int attemptsLeft = MAX_ATTEMPTS;
        Scanner scanner = new Scanner(System.in);

        System.out.println("Guess the number between " + MIN_NUMBER + " and " + MAX_NUMBER + ". You have " + MAX_ATTEMPTS + " attempts.");

        while (attemptsLeft > 0) {
            System.out.print("Enter your guess: ");
            int userGuess = scanner.nextInt();

            if (userGuess == numberToGuess) {
                System.out.println("Congratulations! You've guessed the correct number.");
                score += attemptsLeft;
                break;
            } else if (userGuess < numberToGuess) {
                System.out.println("Too low.");
            } else {
                System.out.println("Too high.");
            }

            attemptsLeft--;
            System.out.println("Attempts left: " + attemptsLeft);

            if (attemptsLeft == 0) {
                System.out.println("You've run out of attempts. The number was: " + numberToGuess);
            }
        }
    }

    public void startGame() {
        Scanner scanner = new Scanner(System.in);

        while (true) {
            playRound();

            System.out.print("Do you want to play another round? (yes/no): ");
            String response = scanner.next();
            if (!response.equalsIgnoreCase("yes")) {
                break;
            }
        }

        System.out.println("Game over! Your total score is: " + score);
    }

    public static void main(String[] args) {
        NumberGuessingGame game = new NumberGuessingGame();
        game.startGame();
    }
}
