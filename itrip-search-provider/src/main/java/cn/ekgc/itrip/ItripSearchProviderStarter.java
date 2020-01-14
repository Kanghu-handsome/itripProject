package cn.ekgc.itrip;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;

@SpringBootApplication
@EnableEurekaClient
public class ItripSearchProviderStarter {
	public static void main(String[] args) {
		SpringApplication.run(ItripSearchProviderStarter.class, args);
	}
}
