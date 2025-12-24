package model;

public class RegularShipment extends Shipment {
    public RegularShipment(String id, String sender, String receiver, double weight) {
        super(id, sender, receiver, weight);
    }

    @Override
    public double calculateCost() {
        return weight * 10000;
    }
}