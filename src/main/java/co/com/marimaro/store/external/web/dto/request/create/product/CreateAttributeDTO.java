package co.com.marimaro.store.external.web.dto.request.create.product;

import lombok.Getter;
import lombok.RequiredArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@RequiredArgsConstructor
public class CreateAttributeDTO {
  private final String name;
  private final String value;
}
