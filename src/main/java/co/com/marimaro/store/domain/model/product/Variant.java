package co.com.marimaro.store.domain.model.product;

import lombok.Builder;
import lombok.Data;

import java.util.List;

@Data
@Builder(toBuilder = true)
public class Variant {
    private Long id;
    private Product product;
    private Double price;
    private Integer discount;
    private String sku;
    private Integer stock;
    private String imageUrl;
    private List<Attribute> attributes;
}
