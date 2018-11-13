package SpringRabbitMQtutorial.E1a_HW;

import org.apache.log4j.Logger;
import org.springframework.amqp.rabbit.annotation.RabbitListener;
import org.springframework.stereotype.Component;

@Component
public class E1a_RabbitMqListener {
    Logger logger = Logger.getLogger(E1a_RabbitMqListener.class);
      
    
    @RabbitListener(queues = E1a_RabbitConfiguration.queueName)
    public void processQueueE1a(String message) {
        logger.info("Received from queue " + E1a_RabbitConfiguration.queueName + ": " + message);
    }

}
