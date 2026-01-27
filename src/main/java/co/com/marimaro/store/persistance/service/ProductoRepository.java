package co.com.marimaro.store.persistance.service;

import co.com.marimaro.store.domain.product.Product;
import co.com.marimaro.store.domain.product.gateway.ProductRepository;
import co.com.marimaro.store.persistance.repository.ProductoCrudRepository;
import co.com.marimaro.store.persistance.entity.product.Producto;

import java.util.List;
import java.util.Optional;

import co.com.marimaro.store.persistance.mapper.ProductMapper;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Repository;

@RequiredArgsConstructor
@Repository
public class ProductoRepository implements ProductRepository {
    private final ProductoCrudRepository productoRepository;
    private final ProductMapper productMapper;

    public List<Product> getAll() {
        return productMapper.toProducts((List<Producto>) productoRepository.findAll());
    }

    @Override
    public Optional<List<Product>> getByCategory(Long categoryId) {
        return Optional.of(productMapper.toProducts(productoRepository.findyProductosByCategorias_Id(categoryId)));
    }

    @Override
    public Optional<Product> getProduct(Long productId) {
        return productoRepository.findById(productId).map(productMapper::toProduct);
    }

    @Override
    public Product create(Product product) {
        return productMapper.toProduct(productoRepository.save(productMapper.toProducto(product)));
    }

    @Override
    public Product update(Product product) {
        return null;
    }

    @Override
    public void delete(Long productId) {
        productoRepository.deleteById(productId);
    }

    public static class CompraRepository {
    }
}
