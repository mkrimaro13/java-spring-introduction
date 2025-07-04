package co.com.marimaro.store.domain.repository;

import java.util.List;
import java.util.Optional;

import co.com.marimaro.store.domain.Product;

public interface ProductRepository {
    List<Product> getAll();

    Optional<List<Product>> getByCategory(Long categoryId);

    Optional<List<Product>> getScarseProducts(int quantity);

    Optional<Product> getProduct(Long productId);

    Product save(Product product);

    void delete(Long productId);
}
