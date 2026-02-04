package co.com.marimaro.store.domain.usecase.product;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;

import org.springframework.stereotype.Service;

import co.com.marimaro.store.domain.model.product.Product;
import co.com.marimaro.store.domain.model.product.gateway.ProductRepository;
import co.com.marimaro.store.domain.model.product.gateway.ProductSearchCriteria;

import java.util.List;
import java.util.Optional;

@Slf4j
@RequiredArgsConstructor
@Service
public class ProductUseCase {
    private final ProductRepository repository;

    public List<Product> getAllFiltering(ProductSearchCriteria criteria) {
        return repository.getAllFiltering(criteria);
    }

    public Optional<Product> getProductById(Long id) {
        return repository.getProduct(id);
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
