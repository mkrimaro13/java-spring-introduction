package co.com.marimaro.store.web.controller;

import java.util.List;
import java.util.function.Predicate;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import co.com.marimaro.store.domain.Purchase;
import co.com.marimaro.store.domain.service.PurchaseService;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;

@RestController
@RequestMapping("/purchases")
public class PurchaseController {
    @Autowired
    public PurchaseService purchaseService;

    @GetMapping("")
    public ResponseEntity<List<Purchase>> getAll() {
        return ResponseEntity.ok(purchaseService.getAll());
    }

    @GetMapping("/client/clientDocument")
    public ResponseEntity<List<Purchase>> getAllByClientDocument(
            @RequestParam("clientDocument") String clientDocument) {
        return purchaseService.getPurchasesByClientDocument(clientDocument)
                .filter(Predicate.not(List::isEmpty)) // Evita que se retorne un 200 OK si la lista está vacía
                .map(ResponseEntity::ok)
                .orElse(ResponseEntity.notFound().build()); // Es otra forma de retornar un 404 Not Found
    }

    @PostMapping("")
    public ResponseEntity<Purchase> create(@RequestBody Purchase purchase) {
        return ResponseEntity.status(201).body(purchaseService.create(purchase)); // Otra forma de retornar 201 sin pasar por el constructor de ResponseEntity
    }

}
