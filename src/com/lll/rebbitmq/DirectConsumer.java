package com.lll.rebbitmq;


import org.apache.log4j.Logger;
import org.springframework.amqp.core.Message;
import org.springframework.amqp.core.MessageListener;
import org.springframework.stereotype.Service;


/**
 * rabbitmq接收推送的数据
 * @author lll
 *
 */
@Service("directConsumer")
public class DirectConsumer implements MessageListener {

    private Logger log = Logger.getLogger(DirectConsumer.class);

    @Override
    public void onMessage(Message message) {
        log.info("------> 消息队列 接收到的消息为 : " + message);
    }

}