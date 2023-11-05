package hom.login.RegisandLogin;

import javax.persistence.Entity;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.domain.EntityScan;
import org.springframework.boot.autoconfigure.security.servlet.SecurityAutoConfiguration;



@SpringBootApplication(exclude = SecurityAutoConfiguration.class)
@EntityScan(basePackages = {"freelance/service/freelanceservice"})
public class RegisandLoginApplication {

	public static void main(String[] args) {
		SpringApplication.run(RegisandLoginApplication.class, args);
	}

}
