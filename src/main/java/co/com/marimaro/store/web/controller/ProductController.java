package co.com.marimaro.store.web.controller;

import co.com.marimaro.store.domain.Product;
import co.com.marimaro.store.domain.service.ProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;
import java.util.function.Predicate;

@RestController
@RequestMapping("/products")
public class ProductController {
    @Autowired
    public ProductService productService;

    @GetMapping("")
    public ResponseEntity<List<Product>> getAll() {
        return ResponseEntity.ok(productService.getAll());
    }

    @GetMapping("/{id}")
    public ResponseEntity<Product> getById(@PathVariable("id") Long id) {
        return productService.getProductById(id)
                .map(ResponseEntity::ok)
                .orElse(new ResponseEntity<>(HttpStatus.NOT_FOUND));
    }

    @GetMapping("/category/{categoryId}")
    public ResponseEntity<List<Product>> getByCategory(@PathVariable("categoryId") Long categoryId) {
        return productService.getProductsByCategory(categoryId)
                .filter(Predicate.not(List::isEmpty)) //-> evita que se retorne un 200 OK, ya que como tal el Optinal retorna una Lista vacía y no un Empty
                .map(ResponseEntity::ok)
                .orElse(new ResponseEntity<>(HttpStatus.NOT_FOUND));
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
