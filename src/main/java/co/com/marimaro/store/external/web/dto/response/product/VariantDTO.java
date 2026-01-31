package co.com.marimaro.store.external.web.dto.response.product;

import java.util.List;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
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
