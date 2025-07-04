package co.com.marimaro.store.domain;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class PurchaseItem {
    private Long productId;
    private Integer quantity;
    private Double total;
    private Boolean active;
}
