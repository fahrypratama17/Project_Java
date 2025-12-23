package model;

import java.time.LocalDateTime;

public abstract class AbstractPayment implements PaymentMethod{
    protected String paymentName;
    protected LocalDateTime time;

    public AbstractPayment (String paymentName) {
        this.paymentName = paymentName;
        this.time = LocalDateTime.now();
    }

    public String getPaymentName() {
        return paymentName;
    }

    public LocalDateTime getTime() {
        return time;
    }
}
