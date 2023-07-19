package springBoot.dependencyInjection.autowiring.myServices;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Component;

@Component
public class TennisCoach implements Coach{

    /*Applying @Autowired directly field level*/
    @Autowired
    @Qualifier("databaseFortuneService")
    private FortuneServices fortuneService;

    public TennisCoach(){}
    public TennisCoach(FortuneServices theFortuneService) {
        fortuneService = theFortuneService;
    }
   /* //Applying @Autowired at constructor level
    @Autowired
    public TennisCoach(FortuneServices theFortuneService){
        fortuneService = theFortuneService;
    }*/
    @Override
    public String getDailyWorkout() {
        return "Practice your backhand volley";
    }

    @Override
    public String getDailyFortune() {
        return fortuneService.getFortune();
    }
}
