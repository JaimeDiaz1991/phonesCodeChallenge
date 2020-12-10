package org.jaimediaz1991.phonechallenge.commons.model.dto;

import java.io.Serializable;
import java.math.BigDecimal;
import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@AllArgsConstructor
public class PhoneResponse implements Serializable {

  private static final long serialVersionUID = 1891606331955156122L;

  private String id;

  private String name;
  private String image;
  private String description;
  private BigDecimal price;


}
