package co.com.marimaro.store.domain.service;

import co.com.marimaro.store.domain.Purchase;
import co.com.marimaro.store.domain.repository.PurchaseRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class PurchaseService {
    @Autowired
    private PurchaseRepository repository;

    public List<Purchase> getAll() {
        return repository.getAll();
    }

    public Optional<List<Purchase>> getPurchasesByClientDocument(String clientDocument) {
        return repository.getByClientDocument(clientDocument);
    }

    public Purchase create(Purchase purchase) {
        return repository.save(purchase);
    }
}
