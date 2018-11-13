package SpringRabbitMQtutorial;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Import;

@EnableAutoConfiguration
@ComponentScan
@Import({RabbitMainConfiguration.class, SpringRabbitMQtutorial.E3_PublishSubscribe.E3_RabbitConfiguration.class})
public class Start {
    public static void main(String[] args) throws Exception {
        SpringApplication.run(Start.class, args);
    }
}
