package service;

import model.Shipment;

public class ShipmentService {
    public void sendShipment (Shipment shipment) {
        Thread t = new Thread(new DeliveryTask(shipment));
        t.start();
    }
}
