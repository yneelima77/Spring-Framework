package springBoot.dependencyInjection.autowiring.myServices;

import org.springframework.stereotype.Component;

@Component
public class RestFortuneServices implements FortuneServices{
    @Override
    public String getFortune() {
        return null;
    }

}
