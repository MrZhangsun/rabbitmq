package site.zhangsun.rabbitmq.controller;


import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.ResponseBody;
import site.zhangsun.rabbitmq.domain.dto.ResultDTO;
import site.zhangsun.rabbitmq.service.api.ProductService;

import javax.websocket.server.PathParam;

@Controller
public class ProductController {

    private static Logger logger = LoggerFactory.getLogger(ProductController.class);

    private final ProductService productServiceImpl;

    @Autowired
    public ProductController(ProductService productServiceImpl) {
        this.productServiceImpl = productServiceImpl;
    }

    @GetMapping("/")
    @ResponseBody
    public String hello() {
        logger.info("visit index successfully!");
        return "hello rabbitmq";
    }

    @GetMapping("/product")
    @ResponseBody
    public ResultDTO<Boolean> getProduct(String id) {

        ResultDTO<Boolean> resultDTO = new ResultDTO<>();

        if(id == null || "".equals(id)) {
            resultDTO.setCode("ERROR_01");
            resultDTO.setData(null);
            resultDTO.setMessage("invalidate id!");
            resultDTO.setStatus(false);
            return resultDTO;
        }
        ResultDTO<Boolean> messageResult = productServiceImpl.sendMessage(id);
        resultDTO.setStatus(true);
        resultDTO.setCode("SUCCESS_NORMAL");
        resultDTO.setMessage("success");
        resultDTO.setData(messageResult.getStatus());
        return resultDTO;
    }
}
