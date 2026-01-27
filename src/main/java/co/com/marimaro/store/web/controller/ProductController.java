package co.com.marimaro.store.web.controller;

import co.com.marimaro.store.domain.product.Product;
import co.com.marimaro.store.persistance.mapper.ProductMapper;
import co.com.marimaro.store.usecase.product.ProductUseCase;
import co.com.marimaro.store.web.dto.response.product.SummarizedProductDTO;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.function.Predicate;

@RequiredArgsConstructor
@RestController
@RequestMapping("/products")
public class ProductController {
    public final ProductUseCase productService;
    public final ProductMapper productMapper;

    @GetMapping("")
    public ResponseEntity<List<SummarizedProductDTO>> getAll() {
        return ResponseEntity.ok(productService.getAll().stream().map(product -> productMapper.toSummarizedProductDTO(product)).toList());
    }

    @GetMapping("/{id}")
    public ResponseEntity<Product> getById(@PathVariable Long id) {
        return productService.getProductById(id)
                .map(ResponseEntity::ok)
                .orElse(new ResponseEntity<>(HttpStatus.NO_CONTENT));
    }

    @GetMapping("/category/{categoryId}")
    public ResponseEntity<List<Product>> getByCategory(@PathVariable Long categoryId) {
        return productService.getProductsByCategory(categoryId)
                .filter(Predicate.not(List::isEmpty)) //-> evita que se retorne un 200 OK, ya que como tal el Optinal retorna una Lista vacía y no un Empty
                .map(ResponseEntity::ok)
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
