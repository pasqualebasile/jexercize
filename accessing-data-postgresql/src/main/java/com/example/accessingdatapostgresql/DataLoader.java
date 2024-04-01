package com.example.accessingdatapostgresql;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.ApplicationArguments;
import org.springframework.boot.ApplicationRunner;
import org.springframework.stereotype.Component;

/**
 * Componente per il data loader. Viene eseguito automaticamente perché implementa `run()`
 */
@Component
public class DataLoader implements ApplicationRunner {
    private UserRepository userRepository;

    @Autowired
    public DataLoader(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    public void run(ApplicationArguments args ) {
        userRepository.save(new User("lala", "lala"));
        userRepository.save(new User("land", "land"));
    }
}
