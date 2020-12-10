package org.jaimediaz1991.phonechallenge.orders.service;

import java.util.Map;
import org.jaimediaz1991.phonechallenge.commons.model.dto.PhoneResponse;
import org.jaimediaz1991.phonechallenge.orders.model.domain.Order;
import org.jaimediaz1991.phonechallenge.orders.model.dto.OrderRequest;

public interface OrderService {

  Order createOrder(OrderRequest orderRequest);
  Map<String,PhoneResponse> obtainAvailablePhones();

}
