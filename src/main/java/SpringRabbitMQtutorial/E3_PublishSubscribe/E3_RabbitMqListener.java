package SpringRabbitMQtutorial.E3_PublishSubscribe;

import org.apache.log4j.Logger;
import org.springframework.amqp.rabbit.annotation.RabbitListener;
import org.springframework.stereotype.Component;

@Component
public class E3_RabbitMqListener {
    Logger logger = Logger.getLogger(E3_RabbitMqListener.class);

    @RabbitListener(queues = E3_RabbitConfiguration.queueName1)
    public void workerE1(String message) {
        logger.info("accepted on worker 3.1 : " + message);
    }

    @RabbitListener(queues = E3_RabbitConfiguration.queueName2)
    public void workerE2(String message) {
        logger.info("accepted on worker 3.2 : " + message);
    }

}
