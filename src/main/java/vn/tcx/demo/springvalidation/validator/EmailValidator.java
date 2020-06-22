package vn.tcx.demo.springvalidation.validator;

import javax.validation.ConstraintValidator;
import javax.validation.ConstraintValidatorContext;

import vn.tcx.demo.springvalidation.constant.ValidatorConstant;
import vn.tcx.demo.springvalidation.validator.annotation.Email;

public class EmailValidator implements ConstraintValidator<Email, String>{

    @Override
    public boolean isValid(String value, ConstraintValidatorContext context) {
        return value.matches(ValidatorConstant.EMAIL_PATTERN);
    }

}
