package model;

public class ExpressShipment extends Shipment{
    public ExpressShipment(String id, String sender, String receiver, double weight) {
        super(id, sender, receiver, weight);
    }

    @Override
    public double calculateCost() {
        return weight * 15000 + 20000;
    }
}
