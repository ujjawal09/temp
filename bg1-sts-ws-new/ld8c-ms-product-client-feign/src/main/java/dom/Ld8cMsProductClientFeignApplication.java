package dom;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.openfeign.EnableFeignClients;

@EnableFeignClients("dom")
@SpringBootApplication
public class Ld8cMsProductClientFeignApplication {

	public static void main(String[] args) {
		SpringApplication.run(Ld8cMsProductClientFeignApplication.class, args);
	}

}
