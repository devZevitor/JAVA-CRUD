package repository;

import domain.Product;
import java.util.ArrayList;
import java.util.List;

public class ProductRepositoryImplementation implements ProductRepository {
    private List<Product> products = new ArrayList<>();

    @Override
    public Product save(Product product) {
        products.add(product);
        return product;
    }

    @Override
    public Product search(Long idProduct) {
        return products.stream()
                .filter(pr -> pr.getIdProduct().equals(idProduct))
                .findFirst()
                .orElse(null);
    }

    @Override
    public void delete(Long idProduct) {
        products.removeIf(pr -> pr.getIdProduct().equals(idProduct));
    }

    @Override
    public Product update(Product product) {
        delete(product.getIdProduct());
        return save(product);
    }

    @Override
    public List<Product> list() {
        return products;
    }
}