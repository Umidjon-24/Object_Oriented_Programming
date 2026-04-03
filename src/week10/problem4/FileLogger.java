import java.io.PrintWriter;
import java.io.IOException;
import java.util.Date;

public class FileLogger {
    public static void writeLog(String filename, String message) {
        PrintWriter writer = null;
        try {
            writer = new PrintWriter(filename);
            Date timestamp = new Date();
            writer.println(timestamp + ": " + message);
            throw new RuntimeException("Simulated write error");
            
        } catch (IOException e) {
            System.out.println("IO Error: " + e.getMessage());
        } finally {
            if (writer != null) {
                writer.close();
                System.out.println("Logger closed.");
            }
        }
    }
    
    public static void main(String[] args) {
        try {
            writeLog("log.txt", "Application started");
        } catch (RuntimeException e) {
            System.out.println("Error: " + e.getMessage());
        }
    }
}
