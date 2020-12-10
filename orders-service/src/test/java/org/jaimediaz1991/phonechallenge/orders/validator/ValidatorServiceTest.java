package org.jaimediaz1991.phonechallenge.orders.validator;

import static org.hamcrest.CoreMatchers.is;
import static org.junit.Assert.assertThat;
import static org.mockito.Mockito.when;

import java.math.BigDecimal;
import java.util.Arrays;
import java.util.Collections;
import java.util.HashMap;
import java.util.Map;
import org.jaimediaz1991.phonechallenge.commons.model.dto.PhoneResponse;
import org.jaimediaz1991.phonechallenge.orders.service.OrderService;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.MockitoJUnitRunner;

@RunWith(MockitoJUnitRunner.class)
public class ValidatorServiceTest {

  @Mock
  OrderService orderService;

  @InjectMocks
  ValidatorServiceImpl validatorService;

  @Test
  public void whenInputPhonesIdsMatchesWithPhonesAvailablesValidateShouldReturnOK() {

    when(orderService.obtainAvailablePhones()).thenReturn(generateMapPhonesAvailables());
    assertThat(validatorService.validatePhoneList(Arrays.asList("1", "2", "3")), is(true));

  }
  @Test
  public void whenEmptyAvailablePhonesValidateShouldReturnKO() {
    when(orderService.obtainAvailablePhones()).thenReturn(new HashMap<>());
    assertThat(validatorService.validatePhoneList(Arrays.asList("1", "2", "3")), is(false));
  }
  @Test
  public void whenPhonesAvailablesNotMatchesWithInputIdsValidateShouldReturnKO() {
    when(orderService.obtainAvailablePhones()).thenReturn(new HashMap<>());
    assertThat(validatorService.validatePhoneList(Arrays.asList("1", "2", "0")), is(false));
  }

  Map<String, PhoneResponse> generateMapPhonesAvailables() {
    Map<String, PhoneResponse> phonesAvailables = new HashMap<>();
    phonesAvailables
        .put("1", new PhoneResponse("1", "phonenumber1", "imageRef1", "smartphone 1", BigDecimal
            .valueOf(250.5)));
    phonesAvailables.put("2", new PhoneResponse("2", "phonenumber2", "imageRef2", "smartphone 2",
        BigDecimal.valueOf(155.5)));
    phonesAvailables.put("3", new PhoneResponse("3", "phonenumber3", "imageRef3", "smartphone 3",
        BigDecimal.valueOf(135.5)));
    phonesAvailables.put("4", new PhoneResponse("4", "phonenumber4", "imageRef4", "smartphone 4",
        BigDecimal.valueOf(295.5)));
    return phonesAvailables;
  }
}
