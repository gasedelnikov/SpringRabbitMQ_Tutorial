package SpringRabbitMQtutorial.E6_RPC;

import org.apache.log4j.Logger;
import org.springframework.amqp.core.Queue;
import org.springframework.amqp.rabbit.annotation.EnableRabbit;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@EnableRabbit
@Configuration
public class E6_RabbitConfiguration {
    public final static String queueName = "E6_queue";  
//    public final static String exchangeName = "E6_exchange";    
    
    Logger logger = Logger.getLogger(E6_RabbitConfiguration.class);

    @Bean
    public Queue myQueueE6() {
        return new Queue(E6_RabbitConfiguration.queueName);
    }
}
