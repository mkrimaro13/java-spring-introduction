package co.com.marimaro.store.persistance.service;

import co.com.marimaro.store.domain.model.product.Product;
import co.com.marimaro.store.domain.model.product.gateway.ProductRepository;
import co.com.marimaro.store.domain.model.product.gateway.ProductSearchCriteria;

import java.util.List;
import java.util.Optional;

import co.com.marimaro.store.persistance.mapper.ProductMapper;
import co.com.marimaro.store.persistance.repository.Producto.ProductoRepository;
import co.com.marimaro.store.persistance.repository.Producto.ProductoSpecification;
import lombok.RequiredArgsConstructor;

import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Repository;

@RequiredArgsConstructor
@Repository
public class ProductoService implements ProductRepository {
    private final ProductoRepository productoRepository;

    private final ProductMapper productMapper;

    @Override
    public List<Product> getAllFiltering(ProductSearchCriteria criteria) {
        Pageable pageable = PageRequest.of(criteria.page_number(), criteria.page_size());
        List<Product> data = productoRepository
                .findAll(ProductoSpecification.filterBy(productMapper.toPersistence(criteria)), pageable)
                .stream()
                .map(productMapper::toDomain)
                .toList();
        data.forEach(System.out::println);
        return data;
    }

    @Override
    public Optional<Product> getProduct(Long productId) {
        return productoRepository.findById(productId != null ? productId : 0).map(productMapper::toDomain);
    }

    @Override
    public Product create(Product product) {
        if (product == null) {
            throw new IllegalArgumentException("La entidad a crear no puede ser nula");
        }
        return productMapper.toDomain(productoRepository.save(productMapper.toEntity(product)));
    }

    @Override
    public Product update(Product product) {
        return null;
    }

    @SuppressWarnings("null")
    @Override
    public void delete(Long productId) {
        productoRepository.deleteById(productId);
    }
}
