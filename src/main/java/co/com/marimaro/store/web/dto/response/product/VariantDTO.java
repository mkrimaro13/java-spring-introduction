package co.com.marimaro.store.web.dto.response.product;

import java.util.List;

public class VariantDTO {
    private Long id;
    private String sku;
    private Double basePrice;
    private Integer discount;
    private Double finalPrice;
    private Integer stock;
    private String imageUrl;
    private List<AttributeDTO> attributes;
}
