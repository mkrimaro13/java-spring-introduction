package co.com.marimaro.store.persistance;

import co.com.marimaro.store.domain.Product;
import co.com.marimaro.store.domain.repository.ProductRepository;
import co.com.marimaro.store.persistance.crud.ProductoCrudRepository;
import co.com.marimaro.store.persistance.entity.Producto;

import java.util.List;
import java.util.Optional;

import co.com.marimaro.store.persistance.mapper.ProductMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

@Repository
public class ProductoRepository implements ProductRepository {
    @Autowired
    private ProductoCrudRepository productoRepository;
    @Autowired
    private ProductMapper productMapper;

    public List<Product> getAll() {
        return productMapper.toProducts((List<Producto>) productoRepository.findAll());
    }

    @Override
    public Optional<List<Product>> getByCategory(Long categoryId) {
        return Optional.of(productMapper.toProducts(productoRepository.findByIdCategoriaOrderByNombreAsc(categoryId)));
    }

    @Override
    public Optional<List<Product>> getScarseProducts(int quantity) {
        return productoRepository.findByStockLessThanAndEstado(quantity, true).map((productMapper::toProducts));
    }

    @Override
    public Optional<Product> getProduct(Long productId) {
        return productoRepository.findById(productId).map(productMapper::toProduct);
    }

    @Override
    public Product save(Product product) {
        return productMapper.toProduct(productoRepository.save(productMapper.toProducto(product)));
    }

    @Override
    public void delete(Long productId) {
        productoRepository.deleteById(productId);
    }

    public static class CompraRepository {
    }
}
