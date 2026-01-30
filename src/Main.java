//TIP To <b>Run</b> code, press <shortcut actionId="Run"/> or
// click the <icon src="AllIcons.Actions.Execute"/> icon in the gutter.
public class Main {
    public static void main(String[] args) {
//        System.out.printf("Hi, %05d%n", 12);
//        System.out.printf("%3$d %2$d %1$d%n", 1, 2, 3);
//        System.out.printf("%,d%n", 123456789);

        System.out.printf("---------------------------------%n");
        System.out.printf("| %-10s |%-10s |%s  |%n", "CATEGORY", "NAME", "BITS");
        System.out.printf("---------------------------------%n");
        System.out.printf("| %-10s |%-10s |%04d  |%n", "Floating", "double", 64);
        System.out.printf("| %-10s |%-10s |%04d  |%n", "Floating", "float", 32);
        System.out.printf("| %-10s |%-10s |%04d  |%n", "Integral", "long", 64);
        System.out.printf("| %-10s |%-10s |%04d  |%n", "Integral", "int", 32);
        System.out.printf("| %-10s |%-10s |%04d  |%n", "Integral", "char", 16);
        System.out.printf("| %-10s |%-10s |%04d  |%n", "Integral", "short", 16);
        System.out.printf("| %-10s |%-10s |%04d  |%n", "Integral", "byte", 8);
        System.out.printf("| %-10s |%-10s |%04d  |%n", "Boolean", "boolean", 1);
        System.out.printf("---------------------------------%n");
        }
    }
