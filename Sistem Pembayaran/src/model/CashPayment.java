package model;

public class CashPayment extends AbstractPayment{
    public CashPayment() {
        super("CASH");
    }

    @Override
    public String getExtraInfo() {
        return "Pembayaran tunai";
    }
}
