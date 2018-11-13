package SpringRabbitMQtutorial.E4_Routing;

import org.apache.log4j.Logger;
import org.springframework.amqp.rabbit.annotation.RabbitListener;
import org.springframework.stereotype.Component;


@Component
public class E4_RabbitMqListener {
    Logger logger = Logger.getLogger(E4_RabbitMqListener.class);

    @RabbitListener(queues = E4_RabbitConfiguration.queueName1)
    public void workerE41(String message) {
        logger.info("accepted on worker 4.1 : " + message);
    }

    @RabbitListener(queues = E4_RabbitConfiguration.queueName2)
    public void workerE42(String message) {
        logger.info("accepted on worker 4.2 : " + message);
    }

}
