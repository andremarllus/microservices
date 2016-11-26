package br.com.posweb.pos_web_eureka_server;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.server.EnableEurekaServer;

@SpringBootApplication
@EnableEurekaServer
public class AppEureka {
	public static void main(String[] args) throws Exception {
		SpringApplication.run(AppEureka.class, args);
	}
}
