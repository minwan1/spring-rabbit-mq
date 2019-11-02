package com.wan.example.user;

import lombok.AllArgsConstructor;
import org.springframework.amqp.rabbit.core.RabbitTemplate;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.ApplicationEventPublisher;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
@Transactional
@AllArgsConstructor
public class UserService {

    private final ApplicationEventPublisher applicationEventPublisher;
    private final UserRepository userRepository;
    private final RabbitTemplate rabbitTemplate;


    public User createUser(final User user){
//        applicationEventPublisher.publishEvent(new UserRegistrationEvent("jinminwan"));



        rabbitTemplate.convertAndSend("spring-boot", user.getEmail());
//        if(true) throw new RuntimeException();
        final User save = userRepository.save(user);
        return save;
    }

    public User findById(final long id){
        return userRepository.findOne(id);
    }


}
