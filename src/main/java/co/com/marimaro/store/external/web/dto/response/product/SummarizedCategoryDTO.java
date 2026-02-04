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
public class SummarizedCategoryDTO {
    private Long id;
    private String name;
    private String description;
    private List<VariantDTO> variants;
}
