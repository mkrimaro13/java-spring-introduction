package co.com.marimaro.store.domain.model.product;

import lombok.*;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class Attribute {
    private Long id;
    private String name;
    private String value;
}
