package co.com.marimaro.store.external.web.dto.request.create.product;

import java.util.List;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.RequiredArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@RequiredArgsConstructor
@AllArgsConstructor
@Builder(toBuilder = true)
public class CreateProductDTO {
  private final String name;
  private String description;
  private final List<CreateVariantDTO> variants;
  private final List<Long> categories;
}
