package co.com.marimaro.store.persistance.mapper;

import co.com.marimaro.store.domain.Category;
import co.com.marimaro.store.persistance.entity.Categoria;
import org.mapstruct.InheritInverseConfiguration;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.Mappings;

@Mapper(componentModel = "spring")
public interface CategoryMapper {
    @Mappings({
            @Mapping(source = "id", target = "id"),
            @Mapping(source = "descripcion", target = "name"),
            @Mapping(source = "estado", target = "active")
    })
    Category toCategory(Categoria categoria);

    @InheritInverseConfiguration
    // -> usa la conversión inversa del método anterior.
    @Mapping(target = "productos", ignore = true)
    Categoria toCategoria(Category category);
}
