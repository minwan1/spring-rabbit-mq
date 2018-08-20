package com.wan.example.user;

import lombok.AllArgsConstructor;
import org.springframework.context.ApplicationEventPublisher;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
@AllArgsConstructor
public class UserService {

    private final ApplicationEventPublisher applicationEventPublisher;
    private final UserRepository userRepository;

    @Transactional
    public User createUser(final User user){
        final User save = userRepository.save(user);
        applicationEventPublisher.publishEvent(new UserRegistrationEvent("jinminwan"));

//        if(true) throw new RuntimeException();
        return save;
    }

    @Transactional
    public User findById(final long id){
        return userRepository.findOne(id);
    }


}
