package org.jaimediaz1991.phonechallenge.orders.service;

import static org.junit.Assert.assertThat;

import com.fasterxml.jackson.databind.ObjectMapper;
import java.math.BigDecimal;
import java.util.Collections;
import org.hamcrest.CoreMatchers;
import org.jaimediaz1991.phonechallenge.orders.model.domain.Order;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

@RunWith(SpringRunner.class)
@SpringBootTest
public class JsonConverterTest {

  @Autowired
  ObjectMapper objectMapper;
  @Autowired
  JsonConverter jsonConverter;

  @Test
  public void mapObjectShouldReturnStringInJsonFormat(){
    String jsonResult = jsonConverter.convertToJson(Order.builder().costumerName("jaime").costumerSurname("diaz").costumerEmail("jaime@correo.es").orderPhones(
        Collections.emptyList()).total(BigDecimal.ZERO).build());
    String expectedString = "{\"costumerName\":\"jaime\",\"costumerSurname\":\"diaz\",\"costumerEmail\":\"jaime@correo.es\",\"orderPhones\":[],\"total\":0}";
    assertThat(jsonResult, CoreMatchers.is(expectedString));
  }

}
