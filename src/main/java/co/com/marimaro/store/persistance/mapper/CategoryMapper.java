package co.com.marimaro.store.persistance.mapper;

import co.com.marimaro.store.domain.product.Category;
import co.com.marimaro.store.persistance.entity.product.Categoria;
import co.com.marimaro.store.web.dto.response.product.CategoryDTO;

import org.mapstruct.InheritInverseConfiguration;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.Mappings;

@Mapper(componentModel = "spring", uses = { ProductMapper.class })
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
}
