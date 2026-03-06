import java.util.Random;
import java.util.Scanner;

public class GuessNumber {
    public static void main(String[] args){
        Random random = new Random();
        int number = random.nextInt(101) + 1;
        int score = 100;
        Scanner input = new Scanner(System.in);
        while(score != 0){
            System.out.print("Guess: ");
            int guess = input.nextInt();
            if (guess == number){
                System.out.printf("You win%nFinal score: %d%n", score);
                break;
            }
            else if(guess > number) System.out.printf("Lower!%n");
            else System.out.printf("Higher!%n");
            score -= 10;
        }
        if (score == 0) System.out.print("You lost");
    }
}
