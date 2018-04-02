package site.zhangsun.rabbitmq.service.impl;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.amqp.core.AmqpTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import site.zhangsun.rabbitmq.domain.dto.ResultDTO;
import site.zhangsun.rabbitmq.service.api.ProductService;

import java.util.Date;

/**
 * 生产消息
 */
@Service
public class ProductServiceImpl implements ProductService {

    private static Logger logger = LoggerFactory.getLogger(ProductServiceImpl.class);

    protected final AmqpTemplate rabbitmqTemplate;

    @Autowired
    public ProductServiceImpl(AmqpTemplate rabbitmqTemplate) {
        this.rabbitmqTemplate = rabbitmqTemplate;
    }

    @Override
    public ResultDTO<Boolean> sendMessage(String id) {
        ResultDTO<Boolean> resultDTO = new ResultDTO<>();

        String message = id + new Date();
        String queue = "product_id";

        rabbitmqTemplate.convertAndSend(message, queue);
        logger.info("the message has been send!");

        resultDTO.setData(true);
        resultDTO.setStatus(true);
        return resultDTO;
    }
}
