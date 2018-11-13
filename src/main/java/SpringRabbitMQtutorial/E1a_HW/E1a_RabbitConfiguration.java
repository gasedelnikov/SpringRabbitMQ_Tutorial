package SpringRabbitMQtutorial.E1a_HW;

import org.apache.log4j.Logger;
import org.springframework.amqp.core.Queue;
import org.springframework.amqp.rabbit.annotation.EnableRabbit;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@EnableRabbit
@Configuration
public class E1a_RabbitConfiguration {
    public final static String queueName = "E1a_queue";
    Logger logger = Logger.getLogger(E1a_RabbitConfiguration.class);
    
    @Bean
    public Queue myQueueE1a() {
        return new Queue(E1a_RabbitConfiguration.queueName);
    }

}
