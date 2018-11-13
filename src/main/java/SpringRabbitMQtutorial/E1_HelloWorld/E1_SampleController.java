package SpringRabbitMQtutorial.E1_HelloWorld;

import org.apache.log4j.Logger;

import org.springframework.amqp.rabbit.core.RabbitTemplate;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
public class E1_SampleController {
    Logger logger = Logger.getLogger(E1_SampleController.class);

    @Autowired
    RabbitTemplate template;

    @RequestMapping("/e1")
    @ResponseBody
    String responseBodyE1() {
        logger.info("Emit to " + E1_RabbitConfiguration.queueName);
//        template.setExchange("");         
        template.convertAndSend("", E1_RabbitConfiguration.queueName, "Message to queue 1");
        return "Emit to queue:"+E1_RabbitConfiguration.queueName;
    }

}