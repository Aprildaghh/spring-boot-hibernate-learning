package com.spring.course_2.config;

import com.spring.util.Coach;
import com.spring.util.SwimCoach;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class SportConfig {


    // "aquatic" will be the bean id which we'll use in qualifier
    @Bean("aquatic")
    public Coach swimCoach()
    {
        return new SwimCoach();
    }

}
