package co.com.marimaro.store.persistance.mapper;

import co.com.marimaro.store.domain.product.Category;
import co.com.marimaro.store.persistance.entity.product.Categoria;
import co.com.marimaro.store.web.dto.response.product.AttributeDTO;
import co.com.marimaro.store.web.dto.response.product.CategoryDTO;

import org.mapstruct.InheritInverseConfiguration;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.Mappings;

@Mapper(componentModel = "spring")
public interface CategoryMapper {
    @Mappings({
            @Mapping(source = "nombre", target = "name"),
            @Mapping(source = "activo", target = "isActive")
    })
    Category toDomain(Categoria entity);

    @InheritInverseConfiguration
    @Mapping(target = "productos", ignore = true)
    Categoria toEntity(Category domain);

    
    Category toDomain(CategoryDTO dto);
}
