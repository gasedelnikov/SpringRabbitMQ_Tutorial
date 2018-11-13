package SpringRabbitMQtutorial.E6_RPC;

import org.apache.log4j.Logger;
import org.springframework.amqp.rabbit.core.RabbitTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;


@Controller
public class E6_SampleController {
    Logger logger = Logger.getLogger(E6_SampleController.class);

    @Autowired
    RabbitTemplate template;


    @RequestMapping("/e6/{message}")
    @ResponseBody
    String error(@PathVariable("message") String message) {
        logger.info(String.format("Emit '%s'", message));
        String response = (String) template.convertSendAndReceive("",E6_RabbitConfiguration.queueName, message);
        logger.info(String.format("Received on producer '%s'", response));
        return String.valueOf("returned from worker : " + response);
    }
}