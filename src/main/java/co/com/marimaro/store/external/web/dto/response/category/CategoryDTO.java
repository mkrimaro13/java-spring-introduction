package co.com.marimaro.store.external.web.dto.response.category;

import java.util.List;

import co.com.marimaro.store.external.web.dto.response.product.SummarizedProductDTO;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class CategoryDTO {
    private Long id;
    private String name;
    private List<SummarizedProductDTO> products;
}
