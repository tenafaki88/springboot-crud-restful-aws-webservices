package net.javaguides.springboot.aws;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication // @SpringBootApplication = @SpringBootConfiguration + @EnableAutoConfiguration + @ComponentScan
public class SpringbootCrudRestfulAwsWebservicesApplication {

	public static void main(String[] args) {
		SpringApplication.run(SpringbootCrudRestfulAwsWebservicesApplication.class, args);
	}

}
