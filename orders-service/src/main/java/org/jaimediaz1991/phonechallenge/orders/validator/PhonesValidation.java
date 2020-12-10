package org.jaimediaz1991.phonechallenge.orders.validator;

import java.lang.annotation.Documented;
import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;
import javax.validation.Constraint;
import javax.validation.Payload;

@Documented
@Constraint(validatedBy = PhonesValidator.class)
@Target( { ElementType.METHOD, ElementType.FIELD })
@Retention(RetentionPolicy.RUNTIME)
public @interface PhonesValidation {
  String message() default "Invalid orderPhoneIds, some ids don't exist in db";
  Class<?>[] groups() default {};
  Class<? extends Payload>[] payload() default {};
}
