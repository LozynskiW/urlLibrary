package com.example.urllibrary.validation;

import javax.validation.Constraint;
import javax.validation.Payload;
import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

@Constraint(validatedBy = {RequiredNumberOfPoolsValidator.class})
@Target({ElementType.TYPE})
@Retention(RetentionPolicy.RUNTIME)
public @interface RequiredNumberOfPools {
    String message() default "Zespoly grajace w meczu musza byc rozne";
    Class<?>[] groups() default {};
    Class<? extends Payload>[] payload() default {};
}
