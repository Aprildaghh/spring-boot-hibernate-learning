package com.spring.util;

import jakarta.annotation.PostConstruct;
import jakarta.annotation.PreDestroy;
import org.springframework.beans.factory.config.ConfigurableBeanFactory;
import org.springframework.context.annotation.Lazy;
import org.springframework.context.annotation.Primary;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Component;

@Component
@Primary
@Lazy
@Scope(ConfigurableBeanFactory.SCOPE_SINGLETON)
public class CricketCoach implements Coach{

    @Override
    public String getDailyWorkout()
    {
        return "Practice fast bowling for 15 minutes!";
    }

    @PostConstruct
    public void doMyStartupStuff()
    {
        System.out.println("In doMyStartupStuff(): " + getClass().getSimpleName());
    }

    @PreDestroy
    public void doMyCleanupStuff()
    {
        System.out.println("In doMyCleanupStuff(): " + getClass().getSimpleName());
    }


}
