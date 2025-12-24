import formatter.ReceiptFormatter;
import formatter.TextReceiptFormatter;
import model.ExpressShipment;
import model.RegularShipment;
import model.Shipment;
import model.ShipmentType;
import service.ShipmentService;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        ReceiptFormatter formatter = new TextReceiptFormatter();
        ShipmentService service = new ShipmentService();

        boolean running = true;

        while (running) {
            System.out.println("=== MENU EKSPEDISI ===");
            for (ShipmentType type : ShipmentType.values()) {
                System.out.println(type.getCode() + ". " + type.getLabel());
            }

            System.out.print("Pilih: ");

            try {
                ShipmentType type = ShipmentType.fromCode(Integer.parseInt(input.nextLine()));

                if (type == ShipmentType.EXIT) break;

                System.out.print("ID Paket: ");
                String id = input.nextLine();
                System.out.print("Pengirim: ");
                String sender = input.nextLine();
                System.out.print("Penerima: ");
                String receiver = input.nextLine();
                System.out.println("Berat (kg): ");
                double weight = Double.parseDouble(input.nextLine());

                Shipment shipment = (type == ShipmentType.REGULAR)
                        ? new RegularShipment(id, sender, receiver, weight)
                        : new ExpressShipment(id, sender, receiver, weight);

                System.out.println(formatter.format(shipment));
                service.sendShipment(shipment);

            } catch (Exception e) {
                System.out.print("Input tidak valid!");
            }
        }
        input.close();
    }
}