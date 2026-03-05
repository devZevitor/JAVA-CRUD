package repository;
import domain.Order;
import java.util.List;

public interface OrderRepository {
    // CRUD Order
    void save(Order order);
    Order search(Long idOrder);
    List<Order> list(Long idUser);
    void delete(Long idOrder);
    void update(Order order);
}
