package cn.ekgc.itrip;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.server.EnableEurekaServer;

@EnableEurekaServer
@SpringBootApplication
public class itripEurekaServerStarter {
	public static void main(String[] args) {
		SpringApplication.run(itripEurekaServerStarter.class, args);
	}
}