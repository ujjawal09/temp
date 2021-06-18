package dom;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;
import org.springframework.cloud.netflix.zuul.EnableZuulProxy;

@EnableZuulProxy
@EnableEurekaClient
@SpringBootApplication
public class Ld8dMsZuulServerApiGatewayApplication {

	public static void main(String[] args) {
		System.out.println("SPINNING UP A ZUUL SERVER");
		SpringApplication.run(Ld8dMsZuulServerApiGatewayApplication.class, args);
	}

}
