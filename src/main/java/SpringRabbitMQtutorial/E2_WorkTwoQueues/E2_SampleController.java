package SpringRabbitMQtutorial.E2_WorkTwoQueues;

import org.apache.log4j.Logger;
import org.springframework.amqp.core.AmqpTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
public class E2_SampleController {
    Logger logger = Logger.getLogger(E2_SampleController.class);

    @Autowired
    AmqpTemplate template;

    @RequestMapping("/e2")
    @ResponseBody
    String responseBodyE2() {
        logger.info("Emit to queue" + E2_RabbitConfiguration.queueName);
        for(int i = 0;i<10;i++){
            template.convertAndSend("", E2_RabbitConfiguration.queueName, "Message " + i);
        }    
        return "Emit to queue " + E2_RabbitConfiguration.queueName;

    }
}