package co.com.marimaro.store.persistance.crud;

import co.com.marimaro.store.persistance.entity.Compra;
import org.springframework.data.repository.CrudRepository;

import java.util.List;
import java.util.Optional;

public interface CompraCrudRepository extends CrudRepository<Compra, Long> {
    Optional<List<Compra>> findByIdCliente(String idCliente);
}
