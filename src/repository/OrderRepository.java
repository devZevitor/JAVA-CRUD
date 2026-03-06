package repository;
import domain.Order;
import java.util.List;

public interface OrderRepository {
    // CRUD Order
    Order save(Order order);
    Order search(Long idOrder);
    List<Order> list(Long idUser);
    void delete(Long idOrder);
    Order update(Order order);
}
