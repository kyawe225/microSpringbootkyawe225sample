package com.example.student.service;

import com.example.student.StudentRepository;


import org.springframework.amqp.core.Queue;
import org.springframework.amqp.rabbit.annotation.RabbitListener;
import org.springframework.amqp.support.converter.Jackson2JsonMessageConverter;
import org.springframework.amqp.support.converter.MessageConverter;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.messaging.handler.annotation.SendTo;

import com.example.student.Student;

@Configuration
public class RabbitMQConfig {

    private final StudentRepository studentRepository;

    public static final String QUEUE_NAME = "getSchoolRelatedStudent";

    RabbitMQConfig(StudentRepository studentRepository) {
        this.studentRepository = studentRepository;
    }

    @Bean
    public Queue exampleQueue() {
        return new Queue(QUEUE_NAME, false);
    }

    @Bean
    public MessageConverter jsonMessageConverter() {
        return new Jackson2JsonMessageConverter();
    }

    @RabbitListener(queues = "getSchoolRelatedStudent")
    @SendTo()
    public Iterable<Student> listen(int schoolId) {
        return studentRepository.findBySchoolId(schoolId);
    }
}
