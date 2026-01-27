package co.com.marimaro.store.domain.purchase.gateway;

import co.com.marimaro.store.domain.purchase.Purchase;

import java.util.List;
import java.util.Optional;

public interface PurchaseRepository {
    List<Purchase> getAll();
    Optional<List<Purchase>> getByClientDocument(String clientDocument);
    Purchase save(Purchase purchase);
}
