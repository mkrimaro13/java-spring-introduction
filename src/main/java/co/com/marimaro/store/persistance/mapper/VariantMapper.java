package co.com.marimaro.store.persistance.mapper;

import co.com.marimaro.store.domain.product.Variant;
import co.com.marimaro.store.persistance.entity.product.Variante;
import co.com.marimaro.store.web.dto.response.product.VariantDTO;
import org.mapstruct.InheritInverseConfiguration;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.Mappings;

@Mapper(componentModel = "spring", uses = { AttributeMapper.class })
public interface VariantMapper {
    default Double calculateFinalPrice(Variant domain) {
        if (domain.getDiscount() == null || domain.getDiscount() <= 0) {
            return domain.getPrice().doubleValue();
        }
        double descuentoDecimal = domain.getDiscount() / 100.0;
        double valorFinal = domain.getPrice() * (1 - descuentoDecimal);
        return Math.round(valorFinal * 100.0) / 100.0;
    }

    // Persistencia -> Dominio
    @Mappings({
            @Mapping(source = "producto", target = "product"),
            @Mapping(source = "precio", target = "price"),
            @Mapping(source = "descuento", target = "discount"),
            @Mapping(source = "imagenUrl", target = "imageUrl"),
            @Mapping(source = "valoresAtributos", target = "attributes")
    })
    Variant toDomain(Variante entity);

    // Dominio -> Persistencia
    @InheritInverseConfiguration
    @Mapping(target = "producto", ignore = true)
    Variante toEntity(Variant domain);

    // Dominio -> DTO
    @Mappings({
            @Mapping(source = "price", target = "basePrice"),
            @Mapping(target = "finalPrice", expression = "java(calculateFinalPrice(domain))"),
    })
    VariantDTO toDto(Variant domain);
}
