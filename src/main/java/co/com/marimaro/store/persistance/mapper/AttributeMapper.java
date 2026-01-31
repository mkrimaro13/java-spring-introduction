package co.com.marimaro.store.persistance.mapper;

import co.com.marimaro.store.domain.model.product.Attribute;
import co.com.marimaro.store.domain.model.product.Variant;
import co.com.marimaro.store.external.web.dto.request.create.product.CreateVariantDTO;
import co.com.marimaro.store.external.web.dto.response.product.AttributeDTO;
import co.com.marimaro.store.persistance.entity.product.ValoresAtributos;

import org.mapstruct.InheritInverseConfiguration;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.Mappings;

@Mapper(componentModel = "spring")
public interface AttributeMapper {

    // Persistencia -> Dominio
    @Mappings({
            @Mapping(source = "atributo.nombre", target = "name"),
            @Mapping(source = "valor", target = "value")
    })
    Attribute toDomain(ValoresAtributos entity);

    // Dominio -> Persistencia
    @InheritInverseConfiguration
    @Mapping(target = "variantes", ignore = true)
    @Mapping(target = "atributo.id", ignore = true)
    @Mapping(target = "atributo.valoresAtributos", ignore = true)
    ValoresAtributos toEntity(Attribute domain);

    // Sin @Mappings ya que los nombres son iguales
    // DTO -> Dominio
    @Mapping(target = "id", ignore = true)
    Attribute toDomain(AttributeDTO dto);

    @Mappings({
            @Mapping(target = "id", ignore = true),
            @Mapping(target = "product", ignore = true),
            @Mapping(target = "attributes.id", ignore = true),
            @Mapping(source = "price", target = "price"),
            @Mapping(source = "discount", target = "discount"),
            @Mapping(source = "sku", target = "sku"),
            @Mapping(source = "stock", target = "stock"),
            @Mapping(source = "imageUrl", target = "imageUrl"),
            @Mapping(source = "attributes", target = "attributes"),
    })
    Variant toDomain(CreateVariantDTO dto);

    // Dominio -> DTO
    AttributeDTO toDTO(Attribute domain);

}
