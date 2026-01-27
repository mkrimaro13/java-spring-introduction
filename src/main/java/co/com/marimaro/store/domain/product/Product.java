package co.com.marimaro.store.domain.product;

import lombok.Builder;
import lombok.Data;

import java.util.List;

@Data
@Builder(toBuilder = true)
public class Product {
    private Long id;
    private String name;
    private String description;
    private Boolean isActive;
    private List<Variant> variants;
    private List<Category> categories;
}
