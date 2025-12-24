package formatter;

import model.Shipment;

public class TextReceiptFormatter implements ReceiptFormatter{

    @Override
    public String format(Shipment s) {
        StringBuilder sb = new StringBuilder();

        sb.append("=== STRUK PENGIRIMAN ===");
        sb.append("ID        : ").append(s.getId()).append("\n");
        sb.append("Pengirim  : ").append(s.getSender()).append("\n");
        sb.append("Penerima  : ").append(s.getReceiver()).append("\n");
        sb.append("Biaya     : ").append(s.calculateCost()).append("\n");
        sb.append("Waktu     : ").append(s.getCreatedAt()).append("\n");
        sb.append("========================\n");

        return sb.toString();
    }
}
