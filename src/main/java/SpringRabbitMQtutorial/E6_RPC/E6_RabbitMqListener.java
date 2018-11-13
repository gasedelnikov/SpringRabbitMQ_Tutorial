package SpringRabbitMQtutorial.E6_RPC;

import org.apache.log4j.Logger;
import org.springframework.amqp.rabbit.annotation.RabbitListener;
import org.springframework.stereotype.Component;

@Component
public class E6_RabbitMqListener {
    Logger logger = Logger.getLogger(E6_RabbitMqListener.class);

    @RabbitListener(queues = E6_RabbitConfiguration.queueName)
    public String workerE6(String message) throws InterruptedException {
        logger.info("Received on worker E6: " + message);
        Thread.sleep(3000);
        return "Received on worker E6: " + message;
    }
}
