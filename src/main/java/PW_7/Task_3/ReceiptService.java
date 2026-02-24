package PW_7.Task_3;

import java.io.IOException;

public class ReceiptService {

    public void generate(int orderId) {
        try (ReceiptWriter writer = new ReceiptWriter()) {
            writer.writeLine("Receipt for order " + orderId);
        } catch (IOException e) {
            throw new ReceiptGenerationException("Cannot generate receipt for order " + orderId, e);
        }
    }
}