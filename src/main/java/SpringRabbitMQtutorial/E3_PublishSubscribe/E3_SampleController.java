package SpringRabbitMQtutorial.E3_PublishSubscribe;

import org.apache.log4j.Logger;
import org.springframework.amqp.rabbit.core.RabbitTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;


@Controller
public class E3_SampleController {
    Logger logger = Logger.getLogger(E3_SampleController.class);

    @Autowired
    RabbitTemplate template;


    @RequestMapping("/e3")
    @ResponseBody
    String emitE3() {
        logger.info("Emit to " + E3_RabbitConfiguration.exchangeName);
        template.setExchange(E3_RabbitConfiguration.exchangeName);
        template.convertAndSend("Fanout message");
//        template.convertAndSend(E3_RabbitConfiguration.exchangeName, "Fanout message");
        return "Emit to " + E3_RabbitConfiguration.exchangeName;
    }
}