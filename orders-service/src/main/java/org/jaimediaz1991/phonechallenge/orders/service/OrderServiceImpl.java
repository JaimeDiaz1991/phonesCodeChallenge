package org.jaimediaz1991.phonechallenge.orders.service;

import java.math.BigDecimal;
import java.util.List;
import java.util.Map;
import java.util.Optional;
import java.util.stream.Collectors;
import org.jaimediaz1991.phonechallenge.commons.model.dto.PhoneResponse;
import org.jaimediaz1991.phonechallenge.orders.client.PhoneClientRest;
import org.jaimediaz1991.phonechallenge.orders.model.domain.Order;
import org.jaimediaz1991.phonechallenge.orders.model.dto.OrderRequest;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.stereotype.Service;

@Service
public class OrderServiceImpl implements OrderService{

  @Autowired
  private PhoneClientRest phoneClientRest;

  public Order createOrder(OrderRequest orderRequest) {
    Map<String,PhoneResponse> phonesAvailables = obtainAvailablePhones();
    Order order = new Order();
    order.setCostumerName(orderRequest.getCostumerName());
    order.setCostumerSurname(orderRequest.getCostumerSurname());
    order.setCostumerEmail(orderRequest.getCostumerEmail());
    Optional<BigDecimal> total = orderRequest.getOrderPhoneIds().stream().map(x->phonesAvailables.get(x).getPrice()).reduce(BigDecimal::add);
    order.setOrderPhones(orderRequest.getOrderPhoneIds().stream()
        .map(phonesAvailables::get).collect(Collectors.toList()));
    order.setTotal(total.orElse(BigDecimal.ZERO));
    return order;
  }

  @Cacheable("phones")
  public Map<String,PhoneResponse> obtainAvailablePhones (){
    return phoneClientRest.findAll().stream().collect(Collectors.toMap(PhoneResponse::getId,phoneResponse->phoneResponse));
  }

}
