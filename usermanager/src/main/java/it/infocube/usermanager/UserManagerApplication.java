package it.infocube.usermanager;

import lombok.extern.slf4j.Slf4j;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
@Slf4j
public class UserManagerApplication {

	public static void main(String[] args) {
		log.info("Starting user manager...");
		SpringApplication.run(UserManagerApplication.class, args);
	}

}
