package co.com.marimaro.store.persistance.mapper;

import co.com.marimaro.store.domain.PurchaseItem;
import co.com.marimaro.store.persistance.entity.ComprasProducto;
import org.mapstruct.InheritInverseConfiguration;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.Mappings;

@Mapper(componentModel = "spring", uses = {ProductMapper.class})
public interface PurchaseItemMapper {
    @Mappings({
            @Mapping(source = "id.idProducto", target = "productId"), //-> se usa el punto para indicar que un atributo dentro de una clase, ya que no se requiere la clase complemta, solamente un atributo de la clase
            @Mapping(source = "cantidad", target = "quantity"),
            @Mapping(source = "total", target = "total"),
            @Mapping(source = "estado", target = "active")
    })
    PurchaseItem toPurchaseItem(ComprasProducto comprasProducto);

    @InheritInverseConfiguration
    @Mappings({
            @Mapping(target = "id.idCompra", ignore = true),// -> se ignora el id de compra porque no se requiere en la entidad de dominio
            @Mapping(target = "compra", ignore = true),
            @Mapping(target = "producto", ignore = true),
    })
    ComprasProducto toComprasProducto(PurchaseItem purchaseItem);
}
