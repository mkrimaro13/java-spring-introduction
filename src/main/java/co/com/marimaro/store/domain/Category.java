package co.com.marimaro.store.domain;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class Category {
    private Long id;
    private String name;
    private Boolean active;

}
