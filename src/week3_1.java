import java.util.Arrays;
import java.util.Scanner;

public class week3_1 {
    public static void main(){
        Scanner input = new Scanner(System.in);

//        String rv = problem1("Fine");
//        System.out.printf(rv);

//        int count = count("Welcome", 'e');
//        System.out.print(count);

//        problem3("I am Umidjon");

//        double[] array = {2, 1, 3, 4, 1, 0};
//        int index = indexOfSmallestElement(array);
//        System.out.print(index);

//        String sorted = sort("UMIDJON");
//        System.out.printf(sorted);

        System.out.print("Enter the number of values: ");
        int size = input.nextInt();
        int[] values = new int[size];
        System.out.print("Enter the values: ");
        for (int i=0; i<size; i++){
            values[i] = input.nextInt();
        }
        boolean bool = isConsecutiveFour(values);
        if(bool) System.out.print("The list has consecutive fours");
        else System.out.print("The list does not have consecutive fours");

    }
    public static String problem1(String s){
        StringBuilder sb = new StringBuilder(s);
        return sb.reverse().toString();
    }
    public static int count(String str, char a){
        int count = 0;
        for (int i=0; i<str.length(); i++){
            if (str.charAt(i) == a){
               count++;
            }
        }
        return count;
    }

    public static void problem3(String str){
        int nLower = 0;
        int nUpper = 0;
        for (int i=0; i<str.length(); i++){
            if(Character.isUpperCase(str.charAt(i))) nUpper++;
            else if (Character.isLowerCase(str.charAt(i))) nLower++;

        }
        System.out.printf("Uppercase: %d%nLowercase: %d", nUpper, nLower);
    }

    public static int indexOfSmallestElement(double[] array){
        int minIndex=0;
        double temp = array[0];
        for (int i=1; i<array.length; i++){
            if(temp>array[i]) {
                temp=array[i];
                minIndex=i;
            }
        }
        return minIndex;
    }

    public static String sort(String s){
        char[] charArray = s.toCharArray();
        Arrays.sort(charArray);
        return new String(charArray);
    }

    public static boolean isConsecutiveFour(int[] values){
        int count=0;
        for (int i=0; i<values.length-1; i++){
            if (values[i] == values[i+1]) count++;
        }
        if (count == 3) return true;
        else return false;
    }

    public static int[] removeDuplicates(int[] arr){
        int[] array={};
        for

        }
        }
    }
}
