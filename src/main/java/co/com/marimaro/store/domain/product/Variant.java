package co.com.marimaro.store.domain.product;

import lombok.Builder;
import lombok.Data;

import java.util.List;

@Data
@Builder(toBuilder = true)
public class Variant {
    private Integer id;
    private Product product;
    private Integer price;
    private Float discount;
    private String sku;
    private Integer stock;
    private List<Attribute> attributes;
}
