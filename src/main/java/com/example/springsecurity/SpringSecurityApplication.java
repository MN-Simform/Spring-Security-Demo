package com.example.springsecurity;

import com.example.springsecurity.entity.Users;
import com.example.springsecurity.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;

@SpringBootApplication
public class SpringSecurityApplication implements CommandLineRunner {

	@Autowired
	UserRepository userRepository;

	@Autowired
	BCryptPasswordEncoder bCryptPasswordEncoder;

	public static void main(String[] args) {
		SpringApplication.run(SpringSecurityApplication.class, args);
	}

	@Override
	public void run(String... args) throws Exception {
		userRepository.save(new Users("nimit",bCryptPasswordEncoder.encode("nimit@123"),"nimit@gmail.com","ROLE_ADMIN"));
		userRepository.save(new Users("smit",bCryptPasswordEncoder.encode("smit@123"),"smit@gmail.com","ROLE_NORMAL"));
	}
}
