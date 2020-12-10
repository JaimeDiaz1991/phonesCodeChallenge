package org.jaimediaz1991.phonechallenge.orders.service;

import static org.hamcrest.CoreMatchers.is;
import static org.hamcrest.CoreMatchers.notNullValue;
import static org.hamcrest.CoreMatchers.nullValue;
import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;
import static org.junit.Assert.assertThat;
import static org.mockito.ArgumentMatchers.isNotNull;
import static org.mockito.Mockito.when;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Map;
import org.jaimediaz1991.phonechallenge.commons.model.dto.PhoneResponse;
import org.jaimediaz1991.phonechallenge.orders.client.PhoneClientRest;
import org.jaimediaz1991.phonechallenge.orders.model.domain.Order;
import org.jaimediaz1991.phonechallenge.orders.model.dto.OrderRequest;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.test.context.junit4.SpringRunner;

@RunWith(SpringRunner.class)
public class OrderServiceTest {

  @Mock
  PhoneClientRest phoneClientRest;
  @InjectMocks
  OrderServiceImpl orderService;

  @Test
  public void shouldReturnAnEmptyList(){
    when(phoneClientRest.findAll()).thenReturn(new ArrayList<>());
    Map<String, PhoneResponse> stringPhoneResponseMap = orderService.obtainAvailablePhones();
    assertNotNull(stringPhoneResponseMap);
    assertThat(stringPhoneResponseMap.size(),is(0));

  }
  @Test
  public void shouldReturnOneListWithOnePhone(){
    when(phoneClientRest.findAll()).thenReturn(Arrays.asList(new PhoneResponse("1","phonenumber1","imageRef1","smartphone 1", BigDecimal
        .valueOf(250.5))));
    Map<String, PhoneResponse> stringPhoneResponseMap = orderService.obtainAvailablePhones();
    assertNotNull(stringPhoneResponseMap);
    assertThat(stringPhoneResponseMap.size(),is(1));
    assertThat(stringPhoneResponseMap.get("1"),notNullValue());
    assertThat(stringPhoneResponseMap.get("1").getId(),is("1"));
    assertThat(stringPhoneResponseMap.get("1").getName(),is("phonenumber1"));
    assertThat(stringPhoneResponseMap.get("1").getImage(),is("imageRef1"));
    assertThat(stringPhoneResponseMap.get("1").getDescription(),is("smartphone 1"));
    assertThat(stringPhoneResponseMap.get("1").getPrice(),is(BigDecimal.valueOf(250.5)));

  }

  @Test
  public void createOrder() {
    when(phoneClientRest.findAll()).thenReturn(Arrays.asList(new PhoneResponse("1","phonenumber1","imageRef1","smartphone 1", BigDecimal
        .valueOf(250.5))));
    OrderRequest orderRequest = new OrderRequest("jaime","diaz","email@correo.com",Arrays.asList("1"));
    Order order = orderService.createOrder(orderRequest);
    assertThat(order,notNullValue());
    assertThat(order.getCostumerName(),is("jaime"));
    assertThat(order.getCostumerSurname(),is("diaz"));
    assertThat(order.getCostumerEmail(),is("email@correo.com"));
    assertThat(order.getOrderPhones().size(),is(1));
  }
}
