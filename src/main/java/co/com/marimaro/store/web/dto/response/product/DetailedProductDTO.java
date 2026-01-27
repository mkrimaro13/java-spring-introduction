package co.com.marimaro.store.web.dto.response.product;

import java.util.List;

import com.fasterxml.jackson.annotation.JsonInclude;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class DetailedProductDTO {
    private Long id;
    private String name;
    private String description;
    @JsonInclude(JsonInclude.Include.NON_EMPTY)
    private List<VariantDTO> variants;
}
