package co.com.marimaro.store.domain.usecase.product;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import co.com.marimaro.store.domain.model.product.Category;
import co.com.marimaro.store.domain.model.product.Product;
import co.com.marimaro.store.domain.model.product.gateway.ProductRepository;

import java.util.List;
import java.util.Optional;

@RequiredArgsConstructor
@Service
public class ProductUseCase {
    private final ProductRepository repository;

    public List<Product> getAll() {
        return repository.getAll();
    }

    public Optional<Product> getProductById(Long id) {
        return repository.getProduct(id);
    }

    public Optional<Category> getProductsByCategory(Long categoryId) {
        return repository.getByCategory(categoryId);
    }

    public Product save(Product product) {
        if (product.getId() == null) {
            return repository.create(product);
        }
        return repository.getProduct(product.getId())
                .map(repository::update)
                .orElseGet(() -> {
                    product.setId(null);
                    return repository.create(product);
                });
    }

    public Product create(Product product) {
        return repository.create(product);
    }

    public Product update(Product product) {
        return getProductById(product.getId())
                .map(repository::update).orElse(null);
    }

    public boolean delete(Long id) {
        return getProductById(id).map(product -> { // Si el map se ejecuta es porque el producto existe.
            repository.delete(id);
            return true;
        }).orElse(false);
    }
}
