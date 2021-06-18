package dom;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;
import org.springframework.cloud.openfeign.EnableFeignClients;

@EnableEurekaClient
@EnableFeignClients("dom")
@SpringBootApplication
public class Ld8cMsProductMobileClientFeignApplication {

	public static void main(String[] args) {
		SpringApplication.run(Ld8cMsProductMobileClientFeignApplication.class, args);
	}

}
