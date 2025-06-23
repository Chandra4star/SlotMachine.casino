import java.util.Random;
import java.util.Scanner;

public class SlotMachineCasino {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        Random random = new Random();

        int balance = 100; // Starting balance
        int betAmount;

        System.out.println("🎰 Welcome to Chandra Shekhar's House Of Casino! 🎰");
        System.out.println("You have $" + balance + " in your account.");

        while (balance > 0) {
            System.out.println("\nEnter your bet amount (or enter 0 to quit): ");
            betAmount = scanner.nextInt();

            if (betAmount == 0) {
                System.out.println("Thank you for playing! You cash out with $" + balance);
                break;
            }

            if (betAmount > balance) {
                System.out.println("You don't have enough balance to place that bet.");
                continue;
            }

            balance -= betAmount;

            // Spin the slot machine - generate 3 random numbers between 1 and 5
            int slot1 = random.nextInt(5) + 1;
            int slot2 = random.nextInt(5) + 1;
            int slot3 = random.nextInt(5) + 1;

            System.out.println("Spinning... 🎲 🎲 🎲");
            System.out.println("| " + slot1 + " | " + slot2 + " | " + slot3 + " |");

            // Winning rules
            if (slot1 == slot2 && slot2 == slot3) {
                // Jackpot - all three match
                int winnings = betAmount * 10;
                balance += winnings;
                System.out.println("🎉 JACKPOT! You won $" + winnings + "! Your new balance is $" + balance);
            } else if (slot1 == slot2 || slot2 == slot3 || slot1 == slot3) {
                // Small win - two match
                int winnings = betAmount * 2;
                balance += winnings;
                System.out.println("😊 You matched two! You won $" + winnings + ". Your new balance is $" + balance);
            } else {
                // No win
                System.out.println("😞 No match. Better luck next time! Your balance is $" + balance);
            }
        }

        if (balance <= 0) {
            System.out.println("You're out of money! Game over.");
        }

        scanner.close();
    }
}
