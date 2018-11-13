package SpringRabbitMQtutorial.E1a_HW;

import org.apache.log4j.Logger;
import org.springframework.amqp.core.AmqpTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
public class E1a_SampleController {
    Logger logger = Logger.getLogger(E1a_SampleController.class);

    @Autowired
    AmqpTemplate template;

    @RequestMapping("/e1a")
    @ResponseBody
    String responseBodyE1a() {
        logger.info("Emit to " + E1a_RabbitConfiguration.queueName);
        template.convertAndSend("", E1a_RabbitConfiguration.queueName, "Message to queue");
        return "Emit to queue:"+E1a_RabbitConfiguration.queueName;
    }
}