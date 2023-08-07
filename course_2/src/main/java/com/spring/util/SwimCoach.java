package com.spring.util;

public class SwimCoach implements Coach{

    public SwimCoach()
    {
        System.out.println("In constructor: " + getClass().getSimpleName());
    }

    @Override
    public String getDailyWorkout() {
        return "Do swimming stuff.";
    }
}
