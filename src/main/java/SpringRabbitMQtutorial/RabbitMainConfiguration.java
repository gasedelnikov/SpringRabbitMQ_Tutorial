package SpringRabbitMQtutorial;

import SpringRabbitMQtutorial.E1_HelloWorld.E1_RabbitConfiguration;
import SpringRabbitMQtutorial.E1a_HW.E1a_RabbitConfiguration;
import SpringRabbitMQtutorial.E2_WorkTwoQueues.E2_RabbitConfiguration;
import SpringRabbitMQtutorial.E3_PublishSubscribe.E3_RabbitConfiguration;
import SpringRabbitMQtutorial.E4_Routing.E4_RabbitConfiguration;
import SpringRabbitMQtutorial.E5_Topics.E5_RabbitConfiguration;
import SpringRabbitMQtutorial.E6_RPC.E6_RabbitConfiguration;
import org.apache.log4j.Logger;
import org.springframework.amqp.core.AmqpAdmin;
import org.springframework.amqp.rabbit.annotation.EnableRabbit;
import org.springframework.amqp.rabbit.connection.CachingConnectionFactory;
import org.springframework.amqp.rabbit.connection.ConnectionFactory;
import org.springframework.amqp.rabbit.core.RabbitAdmin;
import org.springframework.amqp.rabbit.core.RabbitTemplate;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@EnableRabbit
@Configuration
public class RabbitMainConfiguration {
    Logger logger = Logger.getLogger(RabbitMainConfiguration.class);

    @Bean
    public ConnectionFactory connectionFactory() {
        return new CachingConnectionFactory("localhost");
    }

    @Bean
    public AmqpAdmin amqpAdmin() {
        RabbitAdmin rabbitAdmin = new RabbitAdmin(connectionFactory());
        rabbitAdmin.setAutoStartup(true);
//        rabbitAdmin.deleteQueue(E1_RabbitConfiguration.queueName);
//        rabbitAdmin.deleteQueue(E1a_RabbitConfiguration.queueName);
//        rabbitAdmin.deleteQueue(E2_RabbitConfiguration.queueName);
//        rabbitAdmin.deleteQueue(E3_RabbitConfiguration.queueName1);
//        rabbitAdmin.deleteQueue(E3_RabbitConfiguration.queueName2);
//        rabbitAdmin.deleteQueue(E4_RabbitConfiguration.queueName1);
//        rabbitAdmin.deleteQueue(E4_RabbitConfiguration.queueName2);
//        rabbitAdmin.deleteQueue(E5_RabbitConfiguration.queueName1);
//        rabbitAdmin.deleteQueue(E5_RabbitConfiguration.queueName2);
//        rabbitAdmin.deleteQueue(E6_RabbitConfiguration.queueName);        
//        rabbitAdmin.deleteExchange(E3_RabbitConfiguration.exchangeName);
//        rabbitAdmin.deleteExchange(E4_RabbitConfiguration.exchangeName);
//        rabbitAdmin.deleteExchange(E5_RabbitConfiguration.exchangeName);
        return rabbitAdmin;
    }

    @Bean
    public RabbitTemplate rabbitTemplate() {
        return new RabbitTemplate(connectionFactory());
    }
  

   
    
  
    
  
    
}