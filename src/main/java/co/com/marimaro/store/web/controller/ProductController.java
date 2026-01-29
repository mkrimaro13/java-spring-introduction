package co.com.marimaro.store.web.controller;

import co.com.marimaro.store.domain.product.Product;
import co.com.marimaro.store.persistance.mapper.CategoryMapper;
import co.com.marimaro.store.persistance.mapper.ProductMapper;
import co.com.marimaro.store.usecase.product.ProductUseCase;
import co.com.marimaro.store.web.dto.response.product.CategoryDTO;
import co.com.marimaro.store.web.dto.response.product.DetailedProductDTO;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RequiredArgsConstructor
@RestController
@RequestMapping("/products")
public class ProductController {
    public final ProductUseCase productService;
    public final ProductMapper productMapper;
    public final CategoryMapper categoryMapper;

    @GetMapping("")
    public ResponseEntity<List<DetailedProductDTO>> getAllDetailed() {
        return ResponseEntity.ok(productService.getAll().stream().map(productMapper::toDetailedProductDTO).toList());
    }

    @GetMapping("/{id}/details")
    public ResponseEntity<DetailedProductDTO> getById(@PathVariable Long id) {
        return productService.getProductById(id)
                .map(product -> ResponseEntity.ok(productMapper.toDetailedProductDTO(product)))
                .orElse(new ResponseEntity<>(HttpStatus.NO_CONTENT));
    }

    @GetMapping("/by/category/{id}")
    public ResponseEntity<CategoryDTO> getByCategory(@PathVariable Long id) {
        return productService.getProductsByCategory(id)
                .map(category -> ResponseEntity.ok(categoryMapper.toDto(category)))
                .orElse(new ResponseEntity<>(HttpStatus.NO_CONTENT));
    }

    @PostMapping("")
    public ResponseEntity<Product> create(@RequestBody Product product) {
        return new ResponseEntity<>(productService.create(product), HttpStatus.CREATED);
    }

    @DeleteMapping("")
    public ResponseEntity<?> deactivate(Long id) {
        return productService.delete(id)
                ? ResponseEntity.ok().build()
                : ResponseEntity.notFound().build();

    }
}
