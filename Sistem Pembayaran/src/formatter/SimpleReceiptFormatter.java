package formatter;

import model.AbstractPayment;

public class SimpleReceiptFormatter implements ReceiptFormatter {
    @Override
    public String format(AbstractPayment payment, double amount, String extraInfo) {
        StringBuilder sb = new StringBuilder();

        sb.append("=== STRUK PEMBAYARAN ===\n");
        sb.append("Metode : ").append(payment.getPaymentName()).append("\n");

        if (extraInfo != null) {
            sb.append("Detail : ").append(payment.getPaymentName()).append("\n");
        }

        sb.append("Total  : ").append(amount).append("\n");
        sb.append("Waktu  : ").append(payment.getTime()).append("\n");
        sb.append("========================\n");

        return sb.toString();
    }
}
