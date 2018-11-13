package SpringRabbitMQtutorial.E2_WorkTwoQueues;

import org.apache.log4j.Logger;
import org.springframework.amqp.core.Queue;
import org.springframework.amqp.rabbit.annotation.EnableRabbit;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@EnableRabbit
@Configuration
public class E2_RabbitConfiguration {
    public final static String queueName = "E2_queue";  
    Logger logger = Logger.getLogger(E2_RabbitConfiguration.class);

    @Bean
    public Queue myQueueE2() {
        return new Queue(E2_RabbitConfiguration.queueName);
    }

}
