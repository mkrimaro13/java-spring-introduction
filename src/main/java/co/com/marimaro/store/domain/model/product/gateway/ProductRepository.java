package co.com.marimaro.store.domain.model.product.gateway;

import java.util.List;
import java.util.Optional;

import co.com.marimaro.store.domain.model.product.Product;

public interface ProductRepository {
    List<Product> getAllFiltering(ProductSearchCriteria filters);

    Optional<Product> getProduct(Long productId);

    Product create(Product product);

    Product update(Product product);

    void delete(Long productId);
}
