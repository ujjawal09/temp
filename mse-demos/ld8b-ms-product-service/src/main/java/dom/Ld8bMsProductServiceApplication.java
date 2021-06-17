package dom;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;

@EnableEurekaClient
@SpringBootApplication
public class Ld8bMsProductServiceApplication {

	public static void main(String[] args) {
		SpringApplication.run(Ld8bMsProductServiceApplication.class, args);
	}

}
