import java.util.Scanner;

public class week2_2 {
    public static void main(String[] args) {

//    problem1();
//    problem2();
//    problem3();
//    problem4();
//    problem5();
//    problem6();
//    problem7();
//    problem8();
//    problem9();
        problem10();
    }
        public static void problem1(){
            Scanner input = new Scanner(System.in);
            System.out.print("Enter the number of cappuccinos: ");
            int cappuccino = input.nextInt();
            System.out.print("Enter the number of muffins: ");
            int muffin = input.nextInt();

            double cost = (4.5 * cappuccino + 3 * muffin)*1.08 + 5.0;

            System.out.printf("Input: %d cappuccinos, %d muffins%n", cappuccino, muffin);
            System.out.printf("Output: Grand Total: %.2f", cost);
            input.close();
        }
        public static void problem2(){
        Scanner input = new Scanner(System.in);
        System.out.print("Enter the distance: ");
        double distance = input.nextDouble();
        System.out.print("Enter the fuel consumption of your car per 100 km: ");
        double fuel_consumption = input.nextDouble();
        double fuel_needed = (distance/100)*fuel_consumption;
        double cost = fuel_needed*12500;
            System.out.printf("Distance: %.0f km%n", distance);
            System.out.printf("Fuel Needed: %.2f Liters%n", fuel_needed);
            System.out.printf("Total cost: %.2f UZS", cost);
            input.close();
        }
    public static void problem3(){
        Scanner input = new Scanner(System.in);
        System.out.print("Enter the seconds: ");
        int seconds = input.nextInt();
        int hours = seconds/3600;
        seconds -= hours*3600;
        int minutes = seconds/60;
        seconds -= minutes*60;
        System.out.printf("%d hours, %d minutes, %d seconds", hours, minutes, seconds);
        input.close();
    }
    public static void problem4(){
        Scanner input = new Scanner(System.in);
        System.out.print("Enter your age: ");
        int age = input.nextInt();
        if (age>=65) System.out.print("Ticket price: 10$");
        else if (age>=18) System.out.print("Ticket price: 15$");
        else if (age>=13) System.out.print("Ticket price: 10$");
        else System.out.print("Ticket price: 7$");
        input.close();
    }
    public static void problem5(){
        Scanner input = new Scanner(System.in);
        System.out.print("Enter the year: ");
        int year = input.nextInt();
        if ((year%4 == 0) && (year%100 !=0) || year%400==0) System.out.print("Leap Year");
        else System.out.print("Not a Leap Year");
        input.close();
    }
    public static void problem6(){
        Scanner input = new Scanner(System.in);
        System.out.print("Enter your package weight: ");
        double weight = input.nextDouble();
        if (weight >= 10) System.out.printf("Shipping cost: $%.2f",10 + (weight-10)*2);
        else if (weight>=2) System.out.print("Shipping cost: $10.00");
        else System.out.print("Shipping cost: $5.00");
        input.close();
    }
    public static void problem7(){
        Scanner input = new Scanner(System.in);
        int count = 0;
        int pin = 1111;

        while(count != 3) {
            System.out.print("Enter PIN: ");
            int user = input.nextInt();
            if (pin == user) {
                System.out.print("Access Granted");
                break;
            }
            else System.out.printf("Try again%n");
            count++;
        }
        if (count==3) System.out.print("Account Locked");
        input.close();
    }
    public static void problem8(){
        Scanner input = new Scanner(System.in);
        int year = 1;
        System.out.print("Enter the population: ");
        double pop = input.nextDouble();
        double future = 2*pop;
        while(pop <= future) {
            pop *= 1.05;
            System.out.printf("Year %d: %.0f%n", year, pop);
            year++;
        }
        System.out.printf("It will take %d years to double.", year-1);
        input.close();
    }
    public static void problem9(){
        for (int i=1; i<=50; i++){
            if (i%3==0 && i%5 == 0) System.out.print("FizzBuzz");
            else if (i%3==0) System.out.print("Fizz");
            else if (i%5==0) System.out.print("Buzz");
            else System.out.print(i);
            System.out.print(", ");
        }
    }
    public static void problem10(){
        Scanner input = new Scanner(System.in);
        System.out.print("Enter the amount: ");
        double amount = input.nextDouble();
        System.out.print("Enter the number of years: ");
        int years = input.nextInt();
        for (int i=1; i<=years; i++){
            amount *=1.05;
            System.out.printf("Year %d: $%.2f%n", i, amount);
        }
        input.close();
    }
}
