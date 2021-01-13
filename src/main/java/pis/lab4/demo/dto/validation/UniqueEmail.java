package pis.lab4.demo.dto.validation;

import lombok.RequiredArgsConstructor;
import pis.lab4.demo.dto.validation.UniqueEmail.UniqueEmailValidator;
import pis.lab4.demo.service.UserService;

import javax.validation.Constraint;
import javax.validation.ConstraintValidator;
import javax.validation.ConstraintValidatorContext;
import javax.validation.Payload;
import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

@Target(ElementType.FIELD)
@Retention(RetentionPolicy.RUNTIME)
@Constraint(validatedBy = UniqueEmailValidator.class)
public @interface UniqueEmail {

  String message() default "{email.not.unique}";

  Class<?>[] groups() default {};

  Class<? extends Payload>[] payload() default {};

  @RequiredArgsConstructor
  class UniqueEmailValidator implements ConstraintValidator<UniqueEmail, String> {

    private final UserService userService;

    @Override
    public boolean isValid(String email, ConstraintValidatorContext constraintValidatorContext) {
      return !userService.isUserExistsWithEmail(email);
    }
  }

}
