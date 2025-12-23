package model;

public class BankTransferPayment extends AbstractPayment {
    private String bankName;

    public BankTransferPayment (String bankName) {
        super("BANK TRANSFER");
        this.bankName = bankName;
    }

    public String getBankName() {
        return bankName;
    }

    @Override
    public String getExtraInfo() {
        return "Bank: " + bankName;
    }
}
