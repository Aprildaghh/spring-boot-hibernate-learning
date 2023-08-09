package com.april.section_6.validation;

import jakarta.validation.ConstraintValidator;
import jakarta.validation.ConstraintValidatorContext;

public class CourseCodeConstraintValidator
        implements ConstraintValidator<CourseCode, String> {

    private String coursePrefix;

    @Override
    public void initialize(CourseCode constraintAnnotation) {
        this.coursePrefix = constraintAnnotation.value();
    }

    @Override
    public boolean isValid(String userCode,
                           ConstraintValidatorContext constraintValidatorContext) {

        boolean result;

        if(userCode != null)
        {
            result = userCode.startsWith(coursePrefix);
        }
        else
        {
            result = false;
        }

        return result;
    }
}
