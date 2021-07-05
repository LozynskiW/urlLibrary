package com.example.urllibrary.validation;

import com.example.urllibrary.model.pojo.Url;

import javax.validation.ConstraintValidator;
import javax.validation.ConstraintValidatorContext;

public class RequiredNumberOfPoolsValidator implements ConstraintValidator<RequiredNumberOfPools, Url> {

    @Override
    public boolean isValid(Url url, ConstraintValidatorContext constraintValidatorContext) {

        return url.getLink() != null || url.getAdditionalInfo() != null;
    }
}
