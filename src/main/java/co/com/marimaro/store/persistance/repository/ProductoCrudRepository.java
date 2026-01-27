package co.com.marimaro.store.persistance.repository;

import co.com.marimaro.store.persistance.entity.product.Producto;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;

import java.util.List;

public interface ProductoCrudRepository extends CrudRepository<Producto, Long> {
    List<Producto> findByCategorias_Id(Long idCategoria);
    @Query("SELECT DISTINCT p FROM Producto p JOIN p.categorias c WHERE c.id = :categoriaId")
    List<Producto> findProductosByCategorias_Id(@Param("categoriaId") Long categoriaId);
}
