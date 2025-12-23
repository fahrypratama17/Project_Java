package model;

import service.PaymentService;

public enum PaymentType {
    CASH(1, "Cash"),
    BANK_TRANSFER(2, "Bank Transfer"),
    E_WALLET(3, "E-Wallet"),
    EXIT(0, "Keluar");

    private final int code;
    private final String label;

    PaymentType(int code, String label) {
        this.code = code;
        this.label = label;
    }

    public int getCode() {
        return code;
    }

    public String getLabel() {
        return label;
    }

    public static PaymentType fromCode(int code) {
        for (PaymentType type : values()) {
            if (type.code == code) {
                return type;
            }
        }
        throw new IllegalArgumentException("Pilihan tidak tersedia");
    }
}