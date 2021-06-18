package dom;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;
import org.springframework.cloud.openfeign.EnableFeignClients;

@SpringBootApplication
@EnableEurekaClient
@EnableFeignClients("dom")
public class Ld8eMsProductClientFeignRibbonEurekaZuulApplication {

	public static void main(String[] args) {
		SpringApplication.run(Ld8eMsProductClientFeignRibbonEurekaZuulApplication.class, args);
	}

}
