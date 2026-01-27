package co.com.marimaro.store.persistance.mapper;

import co.com.marimaro.store.domain.product.Variant;
import co.com.marimaro.store.persistance.entity.product.Variante;
import co.com.marimaro.store.web.dto.response.product.VariantDTO;
import org.mapstruct.InheritInverseConfiguration;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.Mappings;

@Mapper(componentModel = "spring", uses = {AttributeMapper.class})
public interface VariantMapper {
    default Double calculateFinalPrice(Variante entity) {
        if (entity.getDescuento() == null || entity.getDescuento() <= 0) {
            return entity.getPrecio();
        }
        double descuentoDecimal = entity.getDescuento() / 100.0;
        double valorFinal = entity.getPrecio() * (1 - descuentoDecimal);
        return Math.round(valorFinal * 100.0) / 100.0;
    }

    @Mappings({
            @Mapping(source = "precio", target = "basePrice"),
            @Mapping(source = "descuento", target = "discount"),
            @Mapping(target = "finalPrice", expression = "java(calculateFinalPrice(entity))"),
            @Mapping(source = "imagenUrl", target = "imageUrl"),
            @Mapping(source = "valoresAtributos", target = "attributes")
    })
    VariantDTO toDTO(Variante entity);

    @InheritInverseConfiguration
    Variant toDomain(VariantDTO dto);
}
