package site.zhangsun.rabbitmq.configuration;

import org.springframework.amqp.core.Queue;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

/**
 * 配置队列
 */
@Configuration
public class QueueConfig {

    @Bean
    public Queue idQueue() {
        return new Queue("product_id");
    }

    @Bean
    public Queue nameQueue() {
        return new Queue("product_name");
    }

    @Bean
    public Queue priceQueue() {
        return new Queue("product_price");
    }
}
