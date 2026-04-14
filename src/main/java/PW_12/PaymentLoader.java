package PW_12;

import java.io.BufferedReader;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.ArrayList;
import java.util.List;

enum PaymentStatus { NEW, PAID, FAILED }
record Payment(String id, String email, PaymentStatus status, long amountCents) {}
record LoadResult(List<Payment> payments, int invalidLines) {}

public class PaymentLoader {
    public static LoadResult loadWithStats(Path csv) {
        List<Payment> paymentList = new ArrayList<>();
        int invalidLines = 0;
        try (BufferedReader bufferedReader = Files.newBufferedReader(csv)) {
            String line = bufferedReader.readLine();
            if (line == null) return new LoadResult(paymentList, invalidLines);

            while ((line = bufferedReader.readLine()) != null) {
                if (line.isBlank()) { invalidLines++; continue; }
                try {
                    String[] parts = line.split(",");
                    if (parts.length != 4) {invalidLines++; continue; }
                    String id = parts[0].trim();
                    String email = parts[1].trim();
                    PaymentStatus paymentStatus = PaymentStatus.valueOf(parts[2].trim().toUpperCase());
                    long amountCents = Long.parseLong(parts[3].trim());

                    paymentList.add(new Payment(id, email, paymentStatus, amountCents));

                } catch (IllegalArgumentException e) {
                    invalidLines++;
                }
            }
        } catch (Exception e) {
            throw new RuntimeException("Помилка обробки файлу: " + e.getMessage(), e);
        }

        return new LoadResult(paymentList, invalidLines);
    }
}