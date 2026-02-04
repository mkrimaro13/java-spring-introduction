package co.com.marimaro.store.domain.model.product.gateway;

import lombok.Builder;

@Builder(toBuilder = true)
public record ProductSearchCriteria(
    int page_number,
    int page_size,
    String name,
    Long categoryId,
    String sku,
    String size,
    String material,
    String color) {
}
