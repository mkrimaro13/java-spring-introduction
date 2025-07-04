package co.com.marimaro.store.persistance;

import co.com.marimaro.store.domain.Purchase;
import co.com.marimaro.store.domain.repository.PurchaseRepository;
import co.com.marimaro.store.persistance.crud.CompraCrudRepository;
import co.com.marimaro.store.persistance.entity.Compra;
import co.com.marimaro.store.persistance.mapper.PurchaseMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public class CompraRepository implements PurchaseRepository {
    @Autowired
    private CompraCrudRepository compraCrudRepository;

    @Autowired
    private PurchaseMapper mapper;

    @Override
    public List<Purchase> getAll() {
        return mapper.toPurchases((List<Compra>) compraCrudRepository.findAll());
    }

    @Override
    public Optional<List<Purchase>> getByClientDocument(String clientDocument) {
        return compraCrudRepository.findByIdCliente(clientDocument)
                .map(mapper::toPurchases);
    }

    @Override
    public Purchase save(Purchase purchase) {
        Compra compra = mapper.toCompra(purchase);
        compra.getProductos()
                .forEach(comprasProducto -> comprasProducto.setCompra(compra));
        return mapper.toPurchase(compraCrudRepository.save(compra));
    }
}
