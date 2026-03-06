package repository;

import domain.Product;
import java.util.List;

public interface ProductRepository {
    Product save(Product product);
    Product search(Long idProduct);
    void delete(Long idProduct);
    Product update(Product product);
    List<Product> list();
}