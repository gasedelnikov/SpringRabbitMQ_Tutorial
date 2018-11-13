package SpringRabbitMQtutorial.E4_Routing;

import org.apache.log4j.Logger;
import org.springframework.amqp.rabbit.core.RabbitTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
public class E4_SampleController {
    Logger logger = Logger.getLogger(E4_SampleController.class);

    @Autowired
    RabbitTemplate template;

    @RequestMapping("/e4/error")
    @ResponseBody
    String error() {
        logger.info("Emit as error");
        template.setExchange(E4_RabbitConfiguration.exchangeName);        
        template.convertAndSend("error", "Error");
        return "Emit as error";
    }

    @RequestMapping("/e4/info")
    @ResponseBody
    String info() {
        logger.info("Emit as info");
        template.setExchange(E4_RabbitConfiguration.exchangeName);        
        template.convertAndSend("info", "Info");
        return "Emit as info";
    }

    @RequestMapping("/e4/warning")
    @ResponseBody
    String warning() {
        logger.info("Emit as warning");
        template.setExchange(E4_RabbitConfiguration.exchangeName);        
        template.convertAndSend("warning", "Warning");
        return "Emit as warning";
    }
}