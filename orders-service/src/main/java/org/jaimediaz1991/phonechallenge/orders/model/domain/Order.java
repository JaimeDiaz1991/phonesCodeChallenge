package org.jaimediaz1991.phonechallenge.orders.model.domain;

import java.math.BigDecimal;
import java.util.List;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.jaimediaz1991.phonechallenge.commons.model.dto.PhoneResponse;
import org.jaimediaz1991.phonechallenge.commons.model.entity.Phone;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class Order {

  private String costumerName;
  private String costumerSurname;
  private String costumerEmail;
  private List<PhoneResponse> orderPhones;
  private BigDecimal total;
}
