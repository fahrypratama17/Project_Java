import formatter.SimpleReceiptFormatter;
import model.*;
import service.PaymentService;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        PaymentService service = new PaymentService((new SimpleReceiptFormatter()));

        boolean running = true;

        while (running) {
            try {
                System.out.print("Jumlah bayar: ");
                double amount = Double.parseDouble(input.nextLine());

                System.out.println("=== MENU PEMBAYARAN ===");
                for (PaymentType type : PaymentType.values()) {
                    System.out.println(type.getCode() + ". " + type.getLabel());
                }
                System.out.print("Pilih: ");

                int choice = Integer.parseInt(input.nextLine());
                PaymentType type = PaymentType.fromCode(choice);

                AbstractPayment payment = null;

                switch (type) {
                    case CASH:
                        payment = new CashPayment();
                        break;
                    case BANK_TRANSFER:
                        System.out.print("Nama Bank: ");
                        payment = new BankTransferPayment(input.nextLine());
                        break;
                    case E_WALLET:
                        System.out.print("Nama E-Wallet: ");
                        payment = new EWalletPayment(input.nextLine());
                        break;
                    case EXIT:
                        running = false;
                        continue;
                    default:
                        throw new IllegalArgumentException("Pilihan tidak valid");
                }

                service.process(payment, amount);
            } catch (NumberFormatException e) {
                System.out.println("❌ Input harus angka.");
            } catch (Exception e) {
                System.out.println("❌ Error: " + e.getMessage());
            }

            System.out.println();
        }

        input.close();
        System.out.println("Keluar Program...\nProgram Selesai...\nSelamat Tinggal");
    }
}