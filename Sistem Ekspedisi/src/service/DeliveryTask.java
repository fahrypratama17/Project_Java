package service;

import model.Shipment;

public class DeliveryTask implements Runnable{
    private Shipment shipment;

    public DeliveryTask(Shipment shipment) {
        this.shipment = shipment;
    }

    @Override
    public void run() {
        System.out.println("Mengirim paket ID " + shipment.getId());
        try {
            Thread.sleep(2000);
        } catch (InterruptedException e) {
            System.err.println("Pengiriman tertanggung");
        }
        System.out.println("Paket ID " + shipment.getId() + " terkirim");
    }
}