package org.openlab.openlabcustomerservie;

import org.openlab.entities.Customer;
import org.openlab.repositories.CustomerRepository;
import org.openlab.web.CustomerRestController;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.domain.EntityScan;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;

@SpringBootApplication
@EnableJpaRepositories("org.openlab.repositories")
@ComponentScan({"org.openlab.services"})
@ComponentScan({"org.openlab.mapper"})
@EntityScan("org.openlab.entities")
@ComponentScan(basePackageClasses = CustomerRestController.class)
public class CustomerServiceApplication {

	public static void main(String[] args) {
		SpringApplication.run(CustomerServiceApplication.class, args);
	}

	   @Bean
	    CommandLineRunner  start(CustomerRepository customerRepository){
	        return args -> {
	            customerRepository.save(new Customer("001","Adria","med@adria.com"));
	            customerRepository.save(new Customer("002","LinkedIn","linked@adria.com"));
	        };
	    }
	
	
}
