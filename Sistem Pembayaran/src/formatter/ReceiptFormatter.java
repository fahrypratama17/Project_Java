package formatter;

import model.AbstractPayment;

public interface ReceiptFormatter {
    String format(AbstractPayment payment, double amount, String extraInfo);
}
