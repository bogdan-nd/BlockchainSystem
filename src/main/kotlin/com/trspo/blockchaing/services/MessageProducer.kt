package com.trspo.blockchaing.services

import org.springframework.amqp.rabbit.core.RabbitTemplate
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.beans.factory.annotation.Value
import org.springframework.stereotype.Service

@Service
class MessageProducer {
    @Autowired
    lateinit var rabbitTemplate: RabbitTemplate
    @Value("\${rabbitmq.message-exchange}")
    lateinit var messageExchange:String

    fun sendStartMessage(){
        rabbitTemplate.convertAndSend(messageExchange,"","send-message")
        print("Send message")
    }
}