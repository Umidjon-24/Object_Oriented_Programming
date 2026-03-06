import java.util.Scanner;

public class week1_2 {
    public static void main(String[] args){
        //Problem 3
        double width = 4.5;
        double length = 7.9;
        double area = width * length;
        double perimeter = 2 * (width + length);
        System.out.printf("Area: %f%nPerimeter: %f%n", area, perimeter);

        //Problem 4
        Scanner input = new Scanner(System.in);
        System.out.print("Enter the radius and length of a cylinder: ");
        double radius = input.nextDouble();
        double length_4 = input.nextDouble();
        double area_4 = radius * radius * Math.PI;
        double volume_4 = area_4 * length_4;

        System.out.printf("The area is %.4f%nThe volume is %.1f", area_4, volume_4);
        input.close();

        //Problem 5
        System.out.print("Enter the length of side and height of the Equilateral triangle: ");
        double side_5 = input.nextDouble();
        double height_5 = input.nextDouble();
        double area_5 = Math.pow(3,0.5)/4 * Math.pow(side_5, 2);
        double volume_5 = area_5 * height_5;

        System.out.printf("The area is %.2f%nThe volume of the Triangular prism is %.2f%n", area_5, volume_5);

        //Problem 6
        System.out.print("Enter the cost of the meal: ");
        double cost = input.nextDouble();
        double tax = cost * 0.12;
        double tip = cost * 0.18;
        System.out.printf("The meal cost: %.2f%nThe tax amount: %.2f%nThe tip amount: %.2f%nThe total cost: %.2f%n", cost, tax, tip, cost+tax+tip);

        //Problem 7
        System.out.print("Enter the driving distance: ");
        double distance = input.nextDouble();
        System.out.print("Enter the driving distance: ");
        double miles = input.nextDouble();
        System.out.print("Enter the driving distance: ");
        double price = input.nextDouble();
        System.out.printf("The cost of driving is $%.2f%n", distance/miles*price);

        //Problem 8
        System.out.print("Enter the number: ");
        Integer num = input.nextInt();
        Integer sum=0;
        while (num>0){
            sum = sum + num%10;
            num = num/10;
        }
        System.out.printf("The sum of digits is %d", sum);

        //Problem 9
        System.out.print("Enter the first number: ");
        Integer num_1 = input.nextInt();
        System.out.print("Enter the second number: ");
        Integer num_2 = input.nextInt();
        System.out.print("Enter the third number: ");
        Integer num_3 = input.nextInt();
        Integer max_1 = Math.max(num_1, num_2);
        Integer max = Math.max(max_1, num_3);
        Integer min_1 = Math.min(num_1, num_2);
        Integer min = Math.min(min_1, num_3);
        Integer middle = (num_3+num_2+num_1) - max - min;
        System.out.printf("The max is %d%nThe min is %d%nThe middle is %d%n", max, min, middle);
    }
}
