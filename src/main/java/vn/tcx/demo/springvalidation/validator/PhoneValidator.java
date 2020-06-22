package vn.tcx.demo.springvalidation.validator;

import javax.validation.ConstraintValidator;
import javax.validation.ConstraintValidatorContext;

import vn.tcx.demo.springvalidation.constant.ValidatorConstant;
import vn.tcx.demo.springvalidation.validator.annotation.Phone;

public class PhoneValidator implements ConstraintValidator<Phone, String> {

    @Override
    public boolean isValid(String value, ConstraintValidatorContext context) {
        return value.matches(ValidatorConstant.SODIENTHOAI_PATTERN);
    }

}
