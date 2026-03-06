package repository;
import domain.Order;
import java.util.List;
import java.util.ArrayList;

public class OrderRepositoryImplementation implements OrderRepository{

    private List<Order> orders = new ArrayList<>();

    @Override
    public Order save(Order order) {
        orders.add(order);
        System.out.println("Pedido salvo");
        return order;
    }

    @Override
    public Order search(Long idOrder) {

        return orders.stream()
                .filter(o -> o.getIdOrder().equals(idOrder))
                .findFirst()
                .orElse(null);
    }

    @Override
    public List<Order> list(Long idUser) {
        return orders.stream()
                .filter(o -> o.getIdUser().equals(idUser))
                .toList();
    }

    @Override
    public void delete(Long idOrder) {
        orders.removeIf(o -> o.getIdOrder().equals(idOrder));
        System.out.println("Pedido deletado");
    }

    @Override
    public Order update(Order order) {
        delete(order.getIdOrder());
        System.out.println("Pedido atualizado");
        return save(order);
    }
}