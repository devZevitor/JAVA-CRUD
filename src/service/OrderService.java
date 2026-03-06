package service;

import domain.Order;
import domain.OrderItem;
import domain.OrderState;
import domain.Product;
import repository.OrderRepository;
import java.util.ArrayList;
import java.util.List;

public class OrderService {

    private OrderRepository repository;
    public OrderService(OrderRepository repository){
        this.repository = repository;
    }

    public Order createOrder(Long userId, List<Product> products, List<Integer> quantities){
        Long idOrder = System.currentTimeMillis();
        List<OrderItem> items = new ArrayList<>();
        OrderState state = OrderState.PENDING;

        if(userId == null || products == null || products.isEmpty() || quantities == null ){ throw new IllegalArgumentException("Erro ao criar pedido: userId, products e quantities não podem ser nulos");}
        if(products.size() != quantities.size()){ throw new IllegalArgumentException("Lista de produtos e quantidades devem ter o mesmo tamanho"); }

        for(int i = 0; i < products.size(); i++){
            Product product = products.get(i);
            int quantity = quantities.get(i);

            if(quantity <= 0) { throw new IllegalArgumentException("Erro a quantidade do produto é nula"); };
            items.add(new OrderItem(product.getIdProduct(), product.getName(), product.getPrice(), quantity));
        }

        Order order = new Order(idOrder, userId, items, state);
        repository.save(order);
        return order;
    }

    public List<Order> list(Long idUser){
        return repository.list(idUser);
    }

    public Order search(Long idOrder) {
        return repository.search(idOrder);
    }

    public void delete(Long idOrder) {
        repository.delete(idOrder);

    }

    public Order update(Order order) {
        return repository.update(order);
    }
}
