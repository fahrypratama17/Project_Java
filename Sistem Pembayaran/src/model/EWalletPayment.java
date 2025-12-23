package model;

public class EWalletPayment extends AbstractPayment {
    private String walletName;

    public EWalletPayment (String walletName) {
        super("E-WALLET");
        this.walletName = walletName;
    }

    public String getWalletName() {
        return walletName;
    }

    @Override
    public String getExtraInfo() {
        return "E-Wallet: " + walletName;
    }
}
