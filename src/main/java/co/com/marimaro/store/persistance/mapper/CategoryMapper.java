package co.com.marimaro.store.persistance.mapper;

import co.com.marimaro.store.domain.model.product.Category;
import co.com.marimaro.store.external.web.dto.response.category.CategoryDTO;
import co.com.marimaro.store.persistance.entity.product.Categoria;

import org.mapstruct.InheritInverseConfiguration;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.Mappings;

@Mapper(componentModel = "spring")
public interface CategoryMapper {
    @Mappings({
            @Mapping(source = "nombre", target = "name"),
            @Mapping(source = "activo", target = "isActive"),
            @Mapping(source = "productos", target = "products")
    })
    Category toDomain(Categoria entity);

    @InheritInverseConfiguration
    Categoria toEntity(Category domain);

    CategoryDTO toDto(Category domain);

    @Mappings({
            @Mapping(target = "id", source = "id"),
            @Mapping(target = "name", ignore = true),
            @Mapping(target = "isActive", ignore = true),
            @Mapping(target = "products", ignore = true)
    })
    Category toDomain(Long id);
}
