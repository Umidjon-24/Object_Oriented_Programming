import java.util.Scanner;

public class Main{
    public static void main(String[] args) {
//    problem1(args);
//    problem3();
//    problem4();
//    problem5();
//    problem6();
//        problem7();
//        problem12();
//        problem11();
        problem10();



    }
    private static void problem1(String[] args) {
        int total = 0;
        for (int i = 0; i < args.length; i++) {
            total += Integer.parseInt(args[i]);
        }
        System.out.printf("Total: " + total + "%n");
    }
    private static void problem3() {
        Scanner input = new Scanner(System.in);
        int score = input.nextInt();
        if (score < 0 || score > 100) System.out.print("Invalid score");
        else if (score >= 90) System.out.print("Score: A");
        else if (score >= 80) System.out.print("Score: B");
        else if (score >= 70) System.out.print("Score: C");
        else if (score >= 60) System.out.print("Score: D");
        else System.out.print("Score: F");
    }

    private static void problem4(){
        Scanner input = new Scanner(System.in);
        int weight = input.nextInt();
        int height = input.nextInt();
        int bmi = weight / Math.powExact(height, 2);
        if (bmi >= 30) System.out.print("Obese");
        else if (bmi > 25) System.out.print("Overweight");
        else if (bmi > 18) System.out.print("Normal weight");
        else System.out.print("Underweight");

    }
    private static void problem5(){
        Scanner input = new Scanner(System.in);
        int count = input.nextInt();
        long total = 0;
        for (int i=0; i<= count; i++){
            total += (long) Math.powExact(i, 2);
        }
        System.out.printf("Sum: " + total);
    }

    private static void problem6(){
        Scanner input = new Scanner(System.in);
        int num = input.nextInt();
        long result = 1;
        for (int i=1; i<=num; i++){
            result = (long) i * i;
        }
        System.out.printf("Factorial of %d is %d", num, result);
    }

    private static void problem7(){
        Scanner input = new Scanner(System.in);
        int num = input.nextInt();
        int temp = num;
        int count = 0;
        while (num > 0){
            num /= 10;
            count++;
        }
        System.out.printf("%d has %d digits", temp, count);
    }

    private static void problem12(){
        Scanner input = new Scanner(System.in);
        int year = input.nextInt();
        if (year%400 == 0 || (year%4==0 && year%100 != 0)) System.out.printf("The year is leap");
        else System.out.printf("Not leap");
    }

    private static void problem11(){
        Scanner input = new Scanner(System.in);
        int max = 50;
        int min = 0;
        int guess = (int)(Math.random()*(max - min +1)) + min;
        for (int i=0; i<5; i++){
            int num = input.nextInt();
            if (num > guess) System.out.printf("Too big%n");
            else if (num < guess) System.out.printf("Too low%n");
            else{
                System.out.printf("Correct");
                return;
            }

        }
        System.out.printf("Game is over%nThe guess is %d", guess);
    }

    private static void problem10(){
        int head = 0, tail = 0;
        for(int i=0;i<100;i++){
            int coin = (int)(Math.random()*2);
            if(coin==1) head++;
            else tail++;
        }
        System.out.println(head+" "+tail);
    }





}
