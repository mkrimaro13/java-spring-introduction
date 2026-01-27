package co.com.marimaro.store.web.dto.response.product;

import java.util.List;

public class DetailedProductDTO {
    private Long id;
    private String name;
    private String description;
    private List<VariantDTO> variants;
}
