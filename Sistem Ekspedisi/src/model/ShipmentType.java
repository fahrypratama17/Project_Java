package model;

public enum ShipmentType {
    REGULAR(1, "Regular"),
    EXPRESS(2, "Express"),
    EXIT(0, "Keluar");

    private final int code;
    private final String label;

    ShipmentType(int code, String label) {
        this.code = code;
        this.label = label;
    }

    public int getCode() {
        return code;
    }

    public String getLabel() {
        return label;
    }

    public static ShipmentType fromCode(int code) {
        for (ShipmentType type : values()) {
            if (type.code == code) {
                return type;
            }
        }
        throw  new IllegalArgumentException("Pilihan tidak valid");
    }
}
