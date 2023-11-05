package enterprise.service.enterservice;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.domain.EntityScan;

@SpringBootApplication
@EntityScan(basePackages = {"freelance/service/freelanceservice"})
public class EnterServiceApplication {

	public static void main(String[] args) {
		SpringApplication.run(EnterServiceApplication.class, args);
	}

}
