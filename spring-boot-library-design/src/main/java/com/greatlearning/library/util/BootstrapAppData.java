package com.greatlearning.library.util;

import org.springframework.boot.context.event.ApplicationReadyEvent;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.event.EventListener;

import com.greatlearning.library.model.Role;
import com.greatlearning.library.model.User;
import com.greatlearning.library.repository.UserJPARepository;

@Configuration
public class BootstrapAppData {

	private final UserJPARepository userRepository;
	
	public BootstrapAppData(UserJPARepository userRepository) {
		this.userRepository = userRepository;
	}
	
	@EventListener(ApplicationReadyEvent.class)
	public void insertAppData(ApplicationReadyEvent event) {
		System.out.println("Application is ready :: ");
		System.out.println("Inserting the test data :: ");
		User kiran = new User("kiran", "welcome", "kiran@gmail.com");
		User vinay = new User("vinay", "welcome", "vinay@gmail.com");
		
		Role userRole = new Role("ROLE_USER");
		Role adminRole = new Role("ROLE_ADMIN");
		
		kiran.addRole(userRole);
		
		vinay.addRole(userRole);
		vinay.addRole(adminRole);
		
		this.userRepository.save(vinay);
		this.userRepository.save(kiran);
	}
}
