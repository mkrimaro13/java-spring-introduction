package co.com.marimaro.store.persistance.mapper;

import co.com.marimaro.store.domain.product.Attribute;
import co.com.marimaro.store.persistance.entity.product.ValoresAtributos;
import co.com.marimaro.store.web.dto.response.product.AttributeDTO;
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
    ValoresAtributos toEntity(Attribute domain);

    // Sin @Mappings ya que los nombres son iguales
    // DTO -> Dominio
    @Mapping(target = "id", ignore = true)
    Attribute toDomain(AttributeDTO dto);

    // Dominio -> DTO
    AttributeDTO toDTO(Attribute domain);

}
