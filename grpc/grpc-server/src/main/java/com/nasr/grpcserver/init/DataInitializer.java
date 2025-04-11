package com.nasr.grpcserver.init;

import com.nasr.grpcserver.domain.User;
import com.nasr.grpcserver.repository.UserRepository;
import jakarta.annotation.PostConstruct;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class DataInitializer {

    @Autowired
    private UserRepository userRepository;
    @PostConstruct
    public void init() {

        if (userRepository.count()==0){
            addDefaultUser();
        }
    }

    private void addDefaultUser() {

        User user = new User();
        user.setFirstName("Mohammad");
        user.setLastName("Nasr");
        user.setNationalCode("1272674519");

        userRepository.save(user);
    }
}
