package data.models;

import java.time.LocalDateTime;
import java.util.List;

public class Package {
    private int id;
    private double weightInGram;
    private User senderDetails;
    private User receiverDetails;
    private LocalDateTime timeStamp;
    private List<Event> status;
    private boolean payOnDelivery;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public double getWeightInGram() {
        return weightInGram;
    }

    public void setWeightInGram(double weightInGram) {
        this.weightInGram = weightInGram;
    }

    public User getSenderDetails() {
        return senderDetails;
    }

    public void setSenderDetails(User senderDetails) {
        this.senderDetails = senderDetails;
    }

    public User getReceiverDetails() {
        return receiverDetails;
    }

    public void setReceiverDetails(User receiverDetails) {
        this.receiverDetails = receiverDetails;
    }

    public LocalDateTime getTimeStamp() {
        return timeStamp;
    }

    public void setTimeStamp(LocalDateTime timeStamp) {
        this.timeStamp = timeStamp;
    }

    public List<Event> getStatus() {
        return status;
    }

    public void setStatus(List<Event> status) {
        this.status = status;
    }

    public boolean isPayOnDelivery() {
        return payOnDelivery;
    }

    public void setPayOnDelivery(boolean payOnDelivery) {
        this.payOnDelivery = payOnDelivery;
    }
}
