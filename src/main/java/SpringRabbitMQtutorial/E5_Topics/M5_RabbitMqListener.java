package SpringRabbitMQtutorial.E5_Topics;

import org.apache.log4j.Logger;
import org.springframework.amqp.rabbit.annotation.RabbitListener;
import org.springframework.stereotype.Component;

@Component
public class M5_RabbitMqListener {
    Logger logger = Logger.getLogger(M5_RabbitMqListener.class);

    @RabbitListener(queues = E5_RabbitConfiguration.queueName1)
    public void workerE51(String message) {
        logger.info("accepted on worker 5.1 : " + message);
    }

    @RabbitListener(queues = E5_RabbitConfiguration.queueName2)
    public void workerE52(String message) {
        logger.info("accepted on worker 5.2 : " + message);
    }

}
