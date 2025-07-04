package co.com.marimaro.store.domain.service;

import co.com.marimaro.store.domain.Product;
import co.com.marimaro.store.domain.repository.ProductRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class ProductService {
    @Autowired
    private ProductRepository repository;

    public List<Product> getAll() {
        return repository.getAll();
    }

    public Optional<Product> getProductById(Long id) {
        return repository.getProduct(id);
    }

    public Optional<List<Product>> getProductsByCategory(Long categoryId) {
        return repository.getByCategory(categoryId);
    }

    public Product create(Product product) {
        return repository.save(product);
    }

    public boolean delete(Long id) {
        return getProductById(id).map(product -> { // Si el map se ejecuta es porque el producto existe.
            repository.delete(id);
            return true;
        }).orElse(false);
    }
}
