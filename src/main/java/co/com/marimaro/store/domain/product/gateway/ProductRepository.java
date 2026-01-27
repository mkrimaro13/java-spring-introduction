package co.com.marimaro.store.domain.product.gateway;

import java.util.List;
import java.util.Optional;

import co.com.marimaro.store.domain.product.Product;

public interface ProductRepository {
    List<Product> getAll();

    Optional<List<Product>> getByCategory(Long categoryId);

    Optional<Product> getProduct(Long productId);

    Product create(Product product);

    Product update(Product product);

    void delete(Long productId);
}
