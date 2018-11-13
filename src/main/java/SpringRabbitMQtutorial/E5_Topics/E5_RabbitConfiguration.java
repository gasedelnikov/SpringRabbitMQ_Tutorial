package SpringRabbitMQtutorial.E5_Topics;

import org.apache.log4j.Logger;
import org.springframework.amqp.core.*;
import org.springframework.amqp.rabbit.annotation.EnableRabbit;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@EnableRabbit
@Configuration
public class E5_RabbitConfiguration {
    public final static String queueName1 = "E5.1_queue";  
    public final static String queueName2 = "E5.2_queue";  
    public final static String exchangeName = "E5_exchange";      
            
    Logger logger = Logger.getLogger(E5_RabbitConfiguration.class);

    @Bean
    public Queue myQueueE51() {
        return new Queue(E5_RabbitConfiguration.queueName1);
    }

    @Bean
    public Queue myQueueE52() {
        return new Queue(E5_RabbitConfiguration.queueName2);
    }

    @Bean
    public TopicExchange topicExchangeE5(){
        return new TopicExchange(E5_RabbitConfiguration.exchangeName);
    }

    @Bean
    public Binding bindingE51(){
        return BindingBuilder.bind(myQueueE51()).to(topicExchangeE5()).with("*.orange.*");
    }

    @Bean
    public Binding bindingE52(){
        return BindingBuilder.bind(myQueueE52()).to(topicExchangeE5()).with("*.*.rabbit");
    }

    @Bean
    public Binding bindingE53(){
        return BindingBuilder.bind(myQueueE52()).to(topicExchangeE5()).with("lazy.#");
    }
}
