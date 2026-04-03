import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

public class StudentFileReader {
    public static void main(String[] args) {
        try {
            File file = new File("students.txt");
            Scanner scanner = new Scanner(file);
            System.out.println("Name\t\tGPA\tMajor");
            System.out.println("----------------------------------------");
            int count = 0;
            while (scanner.hasNextLine()) {
                String line = scanner.nextLine();
                Scanner lineScanner = new Scanner(line); 
                String firstName = lineScanner.next();
                String lastName = lineScanner.next();
                double gpa = lineScanner.nextDouble();
                String major = lineScanner.next();
                System.out.println(firstName + " " + lastName + "\t" + gpa + "\t" + major);
                count++; 
                lineScanner.close();
            } 
            System.out.println("\nTotal students: " + count);
            scanner.close(); 
        } catch (FileNotFoundException e) {
            System.out.println("Error: students.txt file not found.");
        }
    }
}
