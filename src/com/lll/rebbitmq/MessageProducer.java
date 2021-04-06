package com.lll.rebbitmq;


import javax.annotation.Resource;
import com.lll.utils.JacksonUtil;
import org.apache.log4j.Logger;
import org.springframework.amqp.core.AmqpTemplate;
import org.springframework.stereotype.Service;


/**
 * 通过调用rabbitmq AmqpTemplate对象发送消息
 * @author lll
 *
 */
@Service("messageProducer")
public class MessageProducer {

    private Logger log = Logger.getLogger(MessageProducer.class);

    @Resource
    private AmqpTemplate amqpTemplate;

    public void send(Object message) {
        log.info("消息队列--发送消息为 : " + JacksonUtil.toJsonString(message));
        amqpTemplate.convertAndSend("com.lll.employee", JacksonUtil.toJsonString(message));
    }
}