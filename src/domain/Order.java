package domain;

import java.util.List;

public class Order {

    private Long idOrder;
    private Long userId;
    private List<OrderItem> items;
    private OrderState state;

    public Order(Long idOrder, Long userId, List<OrderItem> items, OrderState state) {
        this.idOrder = idOrder;
        this.userId = userId;
        this.items = items;
        this.state = state;
    }

    public Long getIdUser() {
        return this.userId;
    }

    public Long getIdOrder() {
        return this.idOrder;
    }

    public List<OrderItem> getItems() {
        return this.items;
    }

    public OrderState getState() {
        return this.state;
    }
}