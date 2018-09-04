package com.caepia.app.api;

import com.caepia.app.api.model.DatabaseUser;
import com.caepia.app.api.service.UserService;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

@SpringBootApplication
public class ApiApplication implements CommandLineRunner {

	@Autowired
	UserService userService;

	public static void main(String[] args) {
		SpringApplication.run(ApiApplication.class, args);
	}

	@Bean
	public ModelMapper modelMapper() {
		return new ModelMapper();
	}

	@Override
	public void run(String... params) throws Exception {
//		DatabaseUser admin = new DatabaseUser();
//		admin.setId("admin");
//		admin.setUsername("admin");
//		admin.setPassword("admin");
//		admin.setStatus(1);
//		//admin.setRoles(new ArrayList<Role>(Arrays.asList(Role.ROLE_ADMIN)));
//
//		userService.signup(admin);
//
//		DatabaseUser client = new DatabaseUser();
//		client.setUsername("client");
//		client.setPassword("client");
//		client.setStatus(1);
//		//client.setRoles(new ArrayList<Role>(Arrays.asList(Role.ROLE_CLIENT)));
//
//		userService.signup(client);


		final DatabaseUser user = userService.search("Usuari DEMO 1");
		System.out.println("params = [" + user + "]");
	}
}
