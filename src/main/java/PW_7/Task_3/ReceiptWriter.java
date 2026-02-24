package PW_7.Task_3;

import java.io.IOException;

public class ReceiptWriter implements AutoCloseable {

    public void writeLine(String line) throws IOException {
        System.out.println(line);
        throw new IOException("Simulated write error");
    }

    @Override
    public void close() {
        System.out.println("ReceiptWriter is closed automatically");
    }
}