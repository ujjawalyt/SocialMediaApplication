package com.socialmedia;

import java.util.List;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

import com.socialmedia.constant.AppConstant;
import com.socialmedia.entity.Role;
import com.socialmedia.repository.RoleRepo;



@SpringBootApplication
public class SocalMediaApplication  implements CommandLineRunner{

	@Autowired
	private RoleRepo roleRepo;
	
	
	
	public static void main(String[] args) {
		SpringApplication.run(SocalMediaApplication.class, args);
		System.out.println("Social Media Appliction is Start Running..!!");
	}

	
	
	  @Bean
	    public ModelMapper modelMapper() {
		return new ModelMapper();
		
	}



	@Override
	public void run(String... args) throws Exception {
		
		Role role = new Role();
		role.setRoleId(AppConstant.ADMIN_USER);
		role.setName("ROLE_ADMIN");
		
		Role role1 = new Role();
		role1.setRoleId(AppConstant.NORMAL_USER);
		role1.setName("ROLE_NORMAL");
		
		List<Role> roles = List.of(role,role1);
		
		List<Role> result =  roleRepo.saveAll(roles);
		result.forEach(r->System.out.println(r.getName()));
		
	}
	  
	  
}
