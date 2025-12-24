package model;

import java.time.LocalDateTime;

public abstract class Shipment {
    protected String id;
    protected String sender;
    protected String receiver;
    protected double weight;
    protected LocalDateTime createdAt;

    protected Shipment(String id, String sender, String receiver, double weight) {
       this.id = id;
       this.sender = sender;
       this.receiver = receiver;
       this.weight = weight;
       this.createdAt = LocalDateTime.now();
    }

    public abstract double calculateCost();

    public String getId() { return id; }
    public String getSender() { return sender; }
    public String getReceiver() { return receiver; }
    public LocalDateTime getCreatedAt() { return createdAt; }
}
