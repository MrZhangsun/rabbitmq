package site.zhangsun.rabbitmq.producer;

import org.apache.commons.lang3.StringUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.amqp.core.AmqpTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class ProductProducer {

    private static Logger logger = LoggerFactory.getLogger(ProductProducer.class);
    private final AmqpTemplate amqpTemplate;

    @Autowired
    public ProductProducer(AmqpTemplate amqpTemplate) {
        this.amqpTemplate = amqpTemplate;
    }

    public void send(String message, String queue) {
        if(StringUtils.isBlank(message)) {
            logger.warn("please input validate message!");
            return;
        }

        if(StringUtils.isBlank(queue)) {
            logger.warn("please input validate queue!");
        }

        amqpTemplate.convertAndSend(queue, message);
        logger.info("send message successfully!");
    }

}
