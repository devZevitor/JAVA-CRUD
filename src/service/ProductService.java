package service;
import domain.Product;
import repository.ProductRepository;

import java.util.List;

public class ProductService {

    private ProductRepository repository;
    public ProductService(ProductRepository repository) { this.repository = repository; }

    public Product createProduct(String name, String description, Double price) {
        Long idProduct = System.currentTimeMillis();
        if(name == null || description == null || price == null){
            throw new IllegalArgumentException("Erro ao criar produto: idProduct, name, description e price não podem ser nulos");
        }

        Product product = new Product(idProduct, name, description, price);
        repository.save(product);
        return product;
    }

    public List<Product> list() {
        return repository.list();
    }

    public Product search(Long idProduct) {
        return repository.search(idProduct);
    }

    public void delete(Long idProduct) {
        repository.delete(idProduct);
    }

    public Product update(Product product) {
        return repository.update(product);
    }
}