package formatter;

import model.Shipment;

public interface ReceiptFormatter {
    String format(Shipment shipment);
}
