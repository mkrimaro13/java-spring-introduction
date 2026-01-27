package co.com.marimaro.store.usecase.purchase;

import co.com.marimaro.store.domain.purchase.Purchase;
import co.com.marimaro.store.domain.purchase.gateway.PurchaseRepository;
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
