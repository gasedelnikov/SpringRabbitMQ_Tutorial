package SpringRabbitMQtutorial.E2_WorkTwoQueues;

import org.apache.log4j.Logger;
import org.springframework.amqp.rabbit.annotation.RabbitListener;
import org.springframework.stereotype.Component;
import java.util.Random;
import org.springframework.amqp.rabbit.annotation.EnableRabbit;

@EnableRabbit
@Component
public class E2_RabbitMqListener {
    Logger logger = Logger.getLogger(E2_RabbitMqListener.class);
    Random random = new Random();

    @RabbitListener(queues = E2_RabbitConfiguration.queueName, containerFactory = "containerFactory")
    public void workerE21(String message) throws InterruptedException {
        logger.info("worker 2.1 : " + message);
        Thread.sleep(100 * random.nextInt(20));
    }

    @RabbitListener(queues = E2_RabbitConfiguration.queueName, containerFactory = "containerFactory")
    public void workerE22(String message) throws InterruptedException {
        logger.info("worker 2.2 : " + message);
        Thread.sleep(100 * random.nextInt(20));
    }
}
