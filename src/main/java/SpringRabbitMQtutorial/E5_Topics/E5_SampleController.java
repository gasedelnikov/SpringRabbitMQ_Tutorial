package SpringRabbitMQtutorial.E5_Topics;

import org.apache.log4j.Logger;
import org.springframework.amqp.rabbit.core.RabbitTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;


@Controller
public class E5_SampleController {
    Logger logger = Logger.getLogger(E5_SampleController.class);

    @Autowired
    RabbitTemplate template;

    @RequestMapping("/e5/{key}/{message}")
    @ResponseBody
    String error(@PathVariable("key") String key, @PathVariable("message") String message) {
        logger.info(String.format("Emit '%s' to '%s'",message,key));
        template.setExchange(E5_RabbitConfiguration.exchangeName);          
        template.convertAndSend(key, message);
        return String.format("Emit '%s' to '%s'",message,key);
    }
}