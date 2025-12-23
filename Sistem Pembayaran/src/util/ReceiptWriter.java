package util;

import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;

public class ReceiptWriter {
    public static void save(String receipt) {
        try (BufferedWriter writer = new BufferedWriter(new FileWriter("receipt.txt", true))) {
            writer.write(receipt);
            writer.newLine();
        } catch (IOException e) {
            System.out.println("Gagal menyimpan struk");
        }
    }
}