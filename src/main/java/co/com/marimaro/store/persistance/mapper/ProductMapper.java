package co.com.marimaro.store.persistance.mapper;

import co.com.marimaro.store.domain.product.Product;
import co.com.marimaro.store.persistance.entity.product.Producto;
import co.com.marimaro.store.web.dto.response.product.DetailedProductDTO;
import co.com.marimaro.store.web.dto.response.product.SummarizedProductDTO;
import org.mapstruct.InheritInverseConfiguration;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.Mappings;

import java.util.List;

@Mapper(componentModel = "spring", uses = {CategoryMapper.class, VariantMapper.class})
public interface ProductMapper {
    @Mappings({
            @Mapping(source = "nombre", target = "name")
    })
    SummarizedProductDTO toSummarizedProductDTO(Product product);

    @Mappings({
            @Mapping(source = "nombre", target = "name"),
            @Mapping(source = "descripcion", target = "description"),
            @Mapping(source = "variantes", target = "variants"),
    })
    DetailedProductDTO toDetailedProductDTO(Product product);
    @Mappings({
            @Mapping(source = "id", target = "id"),
            @Mapping(source = "nombre", target = "name"),
            @Mapping(source = "idCategoria", target = "categoryId"),
            @Mapping(source = "precio", target = "price"),
            @Mapping(source = "stock", target = "stock"),
            @Mapping(source = "estado", target = "active"),
            @Mapping(source = "categoria", target = "category"),
    })
    Product toProduct(Producto producto);

    List<Product> toProducts(List<Producto> productos);

    @InheritInverseConfiguration
    @Mapping(target = "codigoBarras", ignore = true)
    Producto toProducto(Product product);
}
