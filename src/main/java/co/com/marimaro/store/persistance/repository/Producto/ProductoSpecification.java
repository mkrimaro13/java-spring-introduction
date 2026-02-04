package co.com.marimaro.store.persistance.repository.Producto;

import java.util.ArrayList;
import java.util.List;

import org.springframework.data.jpa.domain.Specification;
import jakarta.persistence.criteria.Predicate;

import co.com.marimaro.store.persistance.entity.product.Producto;

public class ProductoSpecification {

  public static Specification<Producto> filterBy(ProductoFilters filters) {
    return (root, query, cb) -> {
      List<Predicate> predicates = new ArrayList<>();
      if (filters.nombre() != null) {
        predicates.add(cb.like(cb.lower(root.get("nombre")),
            "%" + filters.nombre().toLowerCase() + "%"));
      }
      if (filters.sku() != null) {
        predicates.add(cb.like(cb.upper(root.get("sku")),
            "%" + filters.sku().toLowerCase() + "%"));
      }
      if (filters.idCategoria() != null) {
        predicates.add(cb.equal(root.join("categorias").get("id"),
            filters.idCategoria()));
      }
      if (filters.talla() != null) {
        predicates.add(cb.like(cb.lower(root.join("variantes").join("ValoresAtributos").get("talla")),
            "%" + filters.talla().toLowerCase() + "%"));
      }
      if (filters.material() != null) {
        predicates.add(cb.like(cb.lower(root.join("variantes").join("ValoresAtributos").get("material")),
            "%" + filters.material().toLowerCase() + "%"));
      }
      if (filters.color() != null) {
        predicates.add(cb.like(cb.lower(root.join("variantes").join("ValoresAtributos").get("valor")),
            "%" + filters.color().toLowerCase() + "%"));
      }

      query.distinct(true).orderBy(cb.asc(root.get("id")));
      return cb.and(predicates.toArray(new Predicate[0]));
    };
  }
}