package co.com.marimaro.store.persistance.crud;

import co.com.marimaro.store.persistance.entity.Producto;
import org.springframework.data.repository.CrudRepository;

import java.util.List;
import java.util.Optional;

public interface ProductoCrudRepository extends CrudRepository<Producto, Long> {
    List<Producto> findByIdCategoriaOrderByNombreAsc(Long idCategoria);

    List<Producto> findByCategoria_IdOrderByNombreAsc(Long id);

    Optional<List<Producto>> findByStockLessThanAndEstado(int cantidadStock, boolean estado);
}
