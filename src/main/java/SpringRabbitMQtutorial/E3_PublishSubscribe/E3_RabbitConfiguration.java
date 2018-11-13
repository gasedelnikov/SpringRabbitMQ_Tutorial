package SpringRabbitMQtutorial.E3_PublishSubscribe;

import org.apache.log4j.Logger;
import org.springframework.amqp.core.*;
import org.springframework.amqp.rabbit.annotation.EnableRabbit;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@EnableRabbit
@Configuration
public class E3_RabbitConfiguration {
    public final static String queueName1 = "E3.1_queue";  
    public final static String queueName2 = "E3.2_queue";  
    public final static String exchangeName = "E3_exchange";      
    
    Logger logger = Logger.getLogger(E3_RabbitConfiguration.class);

    @Bean
    public Queue myQueueE31() {
        return new Queue(E3_RabbitConfiguration.queueName1);
    }

    @Bean
    public Queue myQueueE32() {
        return new Queue(E3_RabbitConfiguration.queueName2);
    }

    @Bean
    public FanoutExchange fanoutExchangeE3(){
        return new FanoutExchange(E3_RabbitConfiguration.exchangeName);
    }

    @Bean
    public Binding bindingE31(){
        return BindingBuilder.bind(myQueueE31()).to(fanoutExchangeE3());
    }

    @Bean
    public Binding bindingE32(){
        return BindingBuilder.bind(myQueueE32()).to(fanoutExchangeE3());
    }
}
