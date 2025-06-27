package link.honeycombpizza.stomptester;


import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class StompTesterConfig {

    @Bean
    public StompTester stompTester(){
        return new StompTester();
    }
}
