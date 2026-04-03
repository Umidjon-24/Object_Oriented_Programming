import java.io.FileWriter;
import java.io.File;
import java.io.IOException;

public class StudentFileWriter {
    public static void main(String[] args) {
        File file = new File("students.txt");
        
        if (file.exists()) {
            System.out.println("Warning: students.txt already exists.");
        } 
        try (FileWriter writer = new FileWriter("students.txt")) {
            writer.write("Ali Karimov 3.85 ComputerScience\n");
            writer.write("Umidjon Xusanov 4.23 Economics\n");
            writer.write("Foziljon Alisherov 3.99 Economics\n");
            writer.write("Abdurakhmon Mukhibbillaev 3.8 Economics\n");
            writer.write("John Doe 3.95 Engineering\n");  
            System.out.println("File written successfully.");
        } catch (IOException e) {
            System.out.println("Error writing file: " + e.getMessage());
        }
    }
}
