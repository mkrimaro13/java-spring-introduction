package co.com.marimaro.store.domain.repository;

import co.com.marimaro.store.domain.Purchase;

import java.util.List;
import java.util.Optional;

public interface PurchaseRepository {
    List<Purchase> getAll();
    Optional<List<Purchase>> getByClientDocument(String clientDocument);
    Purchase save(Purchase purchase);
}
