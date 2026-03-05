package domain;

public enum OrderState {
    PENDING("PENDING"),
    FINISHED("FINISHED"),
    CANCELED("CANCELED"),
    PAYMENT("PAYMENT");

    private String description;
    OrderState(String description){
        this.description = description;
    }

    public void setDescription(OrderState newStatus) {
        this.description = newStatus.description;
    }
    public String getDescription() {
        return this.description;
    }
}
