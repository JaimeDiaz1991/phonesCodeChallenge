package org.jaimediaz1991.phonechallenge.orders.validator;

import static org.hamcrest.CoreMatchers.is;
import static org.junit.Assert.assertThat;
import static org.mockito.Mockito.when;

import java.util.Arrays;
import java.util.List;
import javax.validation.ConstraintValidatorContext;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.MockitoJUnitRunner;

@RunWith(MockitoJUnitRunner.class)
public class PhonesValidatorTest {
  @Mock
  ConstraintValidatorContext constraintValidatorContext;
  @Mock
  ValidatorService validatorService;
  @InjectMocks
  PhonesValidator phonesValidator;
  @Test
  public void shouldReturnValidateOK(){
    List<String> phoneIds = Arrays.asList("1","2","3");
    when(validatorService.validatePhoneList(phoneIds)).thenReturn(true);
    assertThat(phonesValidator.isValid(phoneIds, constraintValidatorContext),is(true));
  }
  @Test
  public void shouldReturnValidateKO(){
    List<String> phoneIds = Arrays.asList("1","2","3");
    when(validatorService.validatePhoneList(phoneIds)).thenReturn(false);
    assertThat(phonesValidator.isValid(phoneIds, constraintValidatorContext),is(false));
  }

}
