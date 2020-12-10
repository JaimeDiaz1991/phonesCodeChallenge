package org.jaimediaz1991.phonechallenge.orders.model.dto;

import java.util.List;
import javax.validation.constraints.NotEmpty;
import lombok.AllArgsConstructor;
import lombok.Data;
import org.jaimediaz1991.phonechallenge.orders.validator.PhonesValidation;

@Data
@AllArgsConstructor
public class OrderRequest {

  @NotEmpty
  String costumerName;
  @NotEmpty
  String costumerSurname;
  @NotEmpty
  String costumerEmail;
  @PhonesValidation
  List<String> orderPhoneIds;

}
