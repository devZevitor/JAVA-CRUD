package domain;

public class OrderItem {
    private Long idProduct;
    private String productName;
    private Double unitPrice;
    private Integer quantity;

    public OrderItem(Long idProduct, String productName, Double unitPrice, Integer quantity) {
        this.idProduct = idProduct;
        this.productName = productName;
        this.unitPrice = unitPrice;
        this.quantity = quantity;
    }

    public Long getIdProduct() {
        return this.idProduct;
    }

    public String getProductName() { return this.productName; }

    public Double getSubTotal() {
        return this.unitPrice * this.quantity;
    }

    public Double getUnitPrice() {
        return this.unitPrice;
    }

    public Integer getQuantity() {
        return this.quantity;
    }

    @Override
    public String toString() {
        return "OrderItem {"+
                " idProduct=" + this.idProduct + ", " +
                " productName=" + this.productName + ", " +
                " unitPrice=" + this.unitPrice + ", " +
                " quantity=" + this.quantity + ", " +
                " }";
    }
}
