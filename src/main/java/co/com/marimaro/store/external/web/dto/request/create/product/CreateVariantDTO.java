package co.com.marimaro.store.external.web.dto.request.create.product;

import java.util.List;

import lombok.Getter;
import lombok.RequiredArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@RequiredArgsConstructor
public class CreateVariantDTO {
  private final Double price;
  private final Integer discount;
  private final String sku;
  private final Integer stock;
  private final String imageUrl;
  private final List<CreateAttributeDTO> attributes;
}
