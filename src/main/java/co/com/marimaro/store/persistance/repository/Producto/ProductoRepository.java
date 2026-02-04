package co.com.marimaro.store.persistance.repository.Producto;

import co.com.marimaro.store.persistance.entity.product.Producto;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;

public interface ProductoRepository extends JpaRepository<Producto, Long>, JpaSpecificationExecutor<Producto>{
}
