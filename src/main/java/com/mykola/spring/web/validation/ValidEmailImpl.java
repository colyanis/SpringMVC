package com.mykola.spring.web.validation;

import org.apache.commons.validator.routines.EmailValidator;

import javax.validation.ConstraintValidator;
import javax.validation.ConstraintValidatorContext;

/**
 * Created by mtverdok on 4/21/2017.
 */
public class ValidEmailImpl implements ConstraintValidator<ValidEmail, String> {
    private int min;

    @Override
    public void initialize(ValidEmail validEmail) {
        min = validEmail.min();
    }

    @Override
    public boolean isValid(String email, ConstraintValidatorContext constraintValidatorContext) {
        if (email.length() < min) {
            return false;
        }

        if (!EmailValidator.getInstance(false).isValid(email)) {
            return false;
        }

        return true;
    }
}
