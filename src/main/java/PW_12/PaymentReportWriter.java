package PW_12;

import java.io.BufferedWriter;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.StandardCopyOption;
import java.util.List;

public class PaymentReportWriter {
    public static void writeReport(Path out, List<Payment> payments, int invalidLines){
        long paidTotalCents = 0;
        int countNew = 0;
        int countFailed = 0;
        int countPaid = 0;

        for (Payment payment : payments) {
            switch (payment.status()){
                case NEW -> countNew++;
                case PAID -> { countPaid++; paidTotalCents += payment.amountCents(); }
                case FAILED -> countFailed++;
            }
        }

        Path tempFile = out.resolveSibling(out.getFileName() + ".tmp");
        try (BufferedWriter writer = Files.newBufferedWriter(tempFile)) {
            writer.write("invalidLines=" + invalidLines);
            writer.newLine();
            writer.write("paidTotalCents=" + paidTotalCents);
            writer.newLine();
            writer.write("NEW=" + countNew + ", PAID=" + countPaid + ", FAILED=" + countFailed);
            writer.newLine();
        } catch (IOException e) {
            throw new RuntimeException("Помилка запису у тимчасовий файл: " + e.getMessage(), e);
        }

        try {
            Files.move(tempFile, out, StandardCopyOption.REPLACE_EXISTING, StandardCopyOption.ATOMIC_MOVE);
        } catch (IOException e) {
            throw new RuntimeException("Помилка атомарного переміщення: " + e.getMessage(), e);
        }
    }
}
