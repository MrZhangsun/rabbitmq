package site.zhangsun.rabbitmq;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;
import site.zhangsun.rabbitmq.controller.ProductController;
import site.zhangsun.rabbitmq.domain.dto.ResultDTO;
import site.zhangsun.rabbitmq.producer.ProductProducer;

@RunWith(SpringRunner.class)
@SpringBootTest
public class RabbitmqApplicationTests {

	@Autowired
	private ProductProducer productProducer;

	@Autowired
	private ProductController productController;

	@Test
	public void contextLoads() {
		productProducer.send("this is product id", "product_id");
		productProducer.send("this is product name", "product_name");
		productProducer.send("this is product price", "product_price");
	}

	@Test
	public void produceControllerTest() {
		ResultDTO<Boolean> resultDTO = productController.getProduct("product_001");
		System.out.println(resultDTO.getStatus());
	}


}
