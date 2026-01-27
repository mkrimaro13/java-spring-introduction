package co.com.marimaro.store.persistance.mapper;

import co.com.marimaro.store.domain.product.Product;
import co.com.marimaro.store.persistance.entity.product.Producto;
import co.com.marimaro.store.web.dto.response.product.DetailedProductDTO;
import co.com.marimaro.store.web.dto.response.product.SummarizedProductDTO;

import org.mapstruct.CollectionMappingStrategy;
import org.mapstruct.InheritInverseConfiguration;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.Mappings;

@Mapper(componentModel = "spring", uses = {
        VariantMapper.class }, collectionMappingStrategy = CollectionMappingStrategy.TARGET_IMMUTABLE)
public interface ProductMapper {

    // Domain -> DTO
    SummarizedProductDTO toSummarizedProductDTO(Product product);

    DetailedProductDTO toDetailedProductDTO(Product product);

    // Persistencia -> Dominio
    @Mappings({
            @Mapping(source = "id", target = "id"),
            @Mapping(source = "nombre", target = "name"),
            @Mapping(source = "activo", target = "isActive"),
            @Mapping(source = "categorias", target = "categories"),
            @Mapping(source = "variantes", target = "variants"),
            @Mapping(source = "descripcion", target = "description"),
    })
    Product toDomain(Producto producto);

    // Dominio -> Persistencia
    @InheritInverseConfiguration
    Producto toEntity(Product product);
}
