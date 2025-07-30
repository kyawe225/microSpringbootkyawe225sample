package com.example.school.service;

import com.example.school.StudentModel;
import org.springframework.amqp.rabbit.core.RabbitTemplate;

import org.springframework.amqp.support.converter.Jackson2JsonMessageConverter;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class QueueMessageProducer {
    private final RabbitTemplate template;

    public QueueMessageProducer(RabbitTemplate template){
        this.template = template;
        this.template.setMessageConverter(new Jackson2JsonMessageConverter());
    }


    public List<StudentModel> getSchoolRelatedStudents(String queueName, String message){
        var i = template.convertSendAndReceive(queueName,message);
        if (i instanceof List<?>) {
            return (List<StudentModel>) i;
        } else {
            throw new IllegalStateException("Unexpected response: " + i);
        }
    }
}
