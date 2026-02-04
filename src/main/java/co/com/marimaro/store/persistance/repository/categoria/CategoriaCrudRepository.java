package co.com.marimaro.store.persistance.repository.categoria;

import org.springframework.data.repository.CrudRepository;

import co.com.marimaro.store.persistance.entity.product.Categoria;

public interface CategoriaCrudRepository extends CrudRepository<Categoria, Long> {

}
