package com.mykola.spring.web.validation;

import static java.lang.annotation.ElementType.*;
import static java.lang.annotation.RetentionPolicy.*;

import java.lang.annotation.Documented;
import java.lang.annotation.Retention;
import java.lang.annotation.Target;

import javax.validation.Constraint;
import javax.validation.Payload;

@Target( { METHOD, FIELD, ANNOTATION_TYPE })
@Retention(RUNTIME)
@Constraint(validatedBy = {ValidEmailImpl.class})
@Documented
public @interface ValidEmail {

    String message() default "This does not appear to be a valid Email.";

    Class<?>[] groups() default {};

    Class<? extends Payload>[] payload() default {};

    int min() default 5;
}
