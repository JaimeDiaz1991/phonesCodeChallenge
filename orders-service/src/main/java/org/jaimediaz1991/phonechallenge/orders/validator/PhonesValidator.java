package org.jaimediaz1991.phonechallenge.orders.validator;

import java.util.List;
import javax.validation.ConstraintValidator;
import javax.validation.ConstraintValidatorContext;
import org.springframework.beans.factory.annotation.Autowired;

public class PhonesValidator implements ConstraintValidator<PhonesValidation, List<String>> {

  @Autowired
  ValidatorService validatorService;

  @Override
  public void initialize(PhonesValidation phoneList) {
  }

  @Override
  public boolean isValid(List<String> phoneIds,
      ConstraintValidatorContext cxt) {

    return validatorService.validatePhoneList(phoneIds);
  }
}
