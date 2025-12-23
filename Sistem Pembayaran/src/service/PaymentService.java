package service;

import formatter.ReceiptFormatter;
import model.AbstractPayment;
import util.ReceiptWriter;

public class PaymentService {
    private ReceiptFormatter formatter;

    public PaymentService (ReceiptFormatter formatter) {
        this.formatter = formatter;
    }

    public void process(AbstractPayment payment, double amount) {
        String receipt = formatter.format(payment, amount, payment.getExtraInfo());

        System.out.println(receipt);
        ReceiptWriter.save(receipt);
    }
}
