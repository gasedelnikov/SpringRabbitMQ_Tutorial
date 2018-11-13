package SpringRabbitMQtutorial.E1_HelloWorld;

import org.apache.log4j.Logger;
import org.springframework.amqp.core.Message;
import org.springframework.amqp.core.MessageListener;
import org.springframework.amqp.core.Queue;
import org.springframework.amqp.rabbit.annotation.EnableRabbit;
import org.springframework.amqp.rabbit.connection.ConnectionFactory;
import org.springframework.amqp.rabbit.listener.SimpleMessageListenerContainer;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
@EnableRabbit
public class E1_RabbitConfiguration {
    public final static String queueName = "E1_queue";
    Logger logger = Logger.getLogger(E1_RabbitConfiguration.class);

    @Bean
    public Queue myQueueE1() {
        return new Queue(E1_RabbitConfiguration.queueName);
    }

    @Bean
    public SimpleMessageListenerContainer messageListenerContainerE1() {
        ApplicationContext context = new AnnotationConfigApplicationContext(SpringRabbitMQtutorial.RabbitMainConfiguration.class);
        ConnectionFactory connectionFactory = context.getBean(ConnectionFactory.class);        
        
        SimpleMessageListenerContainer container = new SimpleMessageListenerContainer();
        container.setConnectionFactory(connectionFactory);
        container.setQueueNames(E1_RabbitConfiguration.queueName);
        container.setMessageListener(new MessageListener() {
            public void onMessage(Message message) {
                 logger.info("received from queue : " + E1_RabbitConfiguration.queueName + ": " + message);
            }
        });
        return container;
    }   
}