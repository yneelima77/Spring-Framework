package springBoot.dependencyInjection.autowiring.myServices;

import org.springframework.context.annotation.Bean;

public interface Coach {
    public String getDailyWorkout();
    public String getDailyFortune();
}
