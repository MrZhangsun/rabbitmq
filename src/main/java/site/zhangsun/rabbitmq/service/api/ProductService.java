package site.zhangsun.rabbitmq.service.api;


import site.zhangsun.rabbitmq.domain.dto.ResultDTO;

public interface ProductService {

    ResultDTO<Boolean> sendMessage(String id);
}
