package com.spring.course_2.rest;

import com.spring.util.Coach;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class DemoController {

    private Coach myCoach;
    private Coach anotherCoach;

    // Construction injection
    @Autowired
    DemoController(Coach c1, @Qualifier("cricketCoach") Coach c2)
    {
        myCoach = c1;
        anotherCoach = c2;
    }


    /*
    // setter injection with qualifier
    @Autowired
    private void setCoach(@Qualifier("cricketCoach") Coach c)
    {
        myCoach = c;
    }
     */
    @GetMapping("/dailyWorkout")
    public String getDailyWorkout()
    {
        return myCoach.getDailyWorkout();
    }

    // if singleton return true if prototype return false
    @GetMapping("/check")
    public String check()
    {
        return "Comparing beans: myCoach == anotherCoach, " + (myCoach == anotherCoach);
    }

}
