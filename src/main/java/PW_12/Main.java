package PW_12;

import java.nio.file.Path;

public class Main {
    static void main() {
        // task 1
        Path csvPath = Path.of("payments.csv");

        LoadResult result = PaymentLoader.loadWithStats(csvPath);

        System.out.println("\nЗавдання 1:");
        System.out.println("Валідні платежі: " + result.payments().size());
        System.out.println("Невалідні рядки (invalidLines): " + result.invalidLines());

        // task 2
        Path reportPath = Path.of("report.txt");
        PaymentReportWriter.writeReport(reportPath, result.payments(), result.invalidLines());
    }
}
