import java.io.FileWriter;
import java.io.IOException;

public class PayrollSystem {
    public static void main(String[] args) {
        Employee[] employees = new Employee[5];
        employees[0] = new FullTimeEmployee("Alice Johnson", "E001", 60000);
        employees[1] = new PartTimeEmployee("Bob Smith", "E002", 20, 80);
        employees[2] = new CommissionEmployee("Carol Davis", "E003", 2000, 5000, 0.1);
        employees[3] = new FullTimeEmployee("David Brown", "E004", -5000);
        employees[4] = new CommissionEmployee("Eve Wilson", "E005", 1500, 8000, 0.15);
        double totalValidPayroll = 0;
        StringBuilder report = new StringBuilder();
        report.append("=== PAYROLL REPORT ===\n");
        report.append("Employee Payroll Summary:\n\n");
        for (Employee emp : employees) {
            double salary = emp.printPaySlip();
            totalValidPayroll += salary;
            report.append(emp.getClass().getSimpleName()).append(" - ");
            if (salary > 0) {
                report.append("$").append(String.format("%.2f", salary));
            } else {
                report.append("Invalid");
            }
            report.append("\n");
        }
        report.append("\n--- SUMMARY ---\n");
        report.append("Total Valid Monthly Payroll: $").append(String.format("%.2f", totalValidPayroll)).append("\n");
        try (FileWriter writer = new FileWriter("payroll_report.txt")) {
            writer.write(report.toString());
            System.out.println("\nReport written to payroll_report.txt");
        } catch (IOException e) {
            System.out.println("Error writing report: " + e.getMessage());
        }
    }
}
