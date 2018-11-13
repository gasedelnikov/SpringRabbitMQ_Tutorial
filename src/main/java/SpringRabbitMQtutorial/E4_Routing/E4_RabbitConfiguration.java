package SpringRabbitMQtutorial.E4_Routing;

import org.apache.log4j.Logger;
import org.springframework.amqp.core.*;
import org.springframework.amqp.rabbit.annotation.EnableRabbit;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@EnableRabbit
@Configuration
public class E4_RabbitConfiguration {
    public final static String queueName1 = "E4.1_queue";  
    public final static String queueName2 = "E4.2_queue";  
    public final static String exchangeName = "E4_exchange";      
        
    Logger logger = Logger.getLogger(E4_RabbitConfiguration.class);

    @Bean
    public Queue myQueueE41() {
        return new Queue(E4_RabbitConfiguration.queueName1);
    }

    @Bean
    public Queue myQueueE42() {
        return new Queue(E4_RabbitConfiguration.queueName2);
    }

    @Bean
    public DirectExchange directExchangeE4(){
        return new DirectExchange(E4_RabbitConfiguration.exchangeName);
    }

    @Bean
    public Binding errorBinding41(){
        return BindingBuilder.bind(myQueueE41()).to(directExchangeE4()).with("error");
    }

    @Bean
    public Binding errorBinding42(){
        return BindingBuilder.bind(myQueueE42()).to(directExchangeE4()).with("error");
    }

    @Bean
    public Binding infoBinding4(){
        return BindingBuilder.bind(myQueueE42()).to(directExchangeE4()).with("info");
    }

    @Bean
    public Binding warningBinding4(){
        return BindingBuilder.bind(myQueueE42()).to(directExchangeE4()).with("warning");
    }

}
