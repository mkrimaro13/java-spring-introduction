package co.com.marimaro.store.external.web.controller;

import co.com.marimaro.store.domain.model.product.Product;
import co.com.marimaro.store.domain.model.product.gateway.ProductSearchCriteria;
import co.com.marimaro.store.domain.usecase.product.ProductUseCase;
import co.com.marimaro.store.external.web.dto.request.create.product.CreateProductDTO;
import co.com.marimaro.store.external.web.dto.response.product.DetailedProductDTO;
import co.com.marimaro.store.persistance.mapper.ProductMapper;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;

@RequiredArgsConstructor
@RestController
@RequestMapping("/products")
public class ProductController {
        public final ProductUseCase productService;
        public final ProductMapper productMapper;

        @GetMapping("")
        public ResponseEntity<List<DetailedProductDTO>> getAllDetailed(
                        @RequestParam(defaultValue = "0", required = false) int page_number,
                        @RequestParam(defaultValue = "10", required = false) int page_size,
                        @RequestParam(required = false) String name,
                        @RequestParam(required = false) String material,
                        @RequestParam(required = false) String color,
                        @RequestParam(required = false) String size,
                        @RequestParam(required = false) Long category_id

        ) {
                ProductSearchCriteria criteria = ProductSearchCriteria.builder()
                                .page_number(page_number)
                                .page_size(page_size)
                                .categoryId(category_id)
                                .name(name)
                                .color(color)
                                .material(material)
                                .size(size)
                                .build();
                return ResponseEntity
                                .ok(productService.getAllFiltering(criteria).stream()
                                                .map(productMapper::toDetailedProductDTO)
                                                .toList());
        }

        @GetMapping("/{id}")
        public ResponseEntity<DetailedProductDTO> getProduct(@PathVariable Long id) {
                return productService.getProductById(id)
                                .map(product -> ResponseEntity.ok(productMapper.toDetailedProductDTO(product)))
                                .orElse(ResponseEntity.notFound().build());
        }

        @PostMapping("")
        public ResponseEntity<Product> create(@RequestBody CreateProductDTO product) {
                return new ResponseEntity<>(productService.create(productMapper.toDomain(product)), HttpStatus.CREATED);
        }

        @DeleteMapping("")
        public ResponseEntity<?> deactivate(Long id) {
                return productService.delete(id)
                                ? ResponseEntity.ok().build()
                                : ResponseEntity.notFound().build();

        }
}
