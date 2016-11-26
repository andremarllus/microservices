package br.com.posweb.pos_web_hystrix_dashboard;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.hystrix.dashboard.EnableHystrixDashboard;

@SpringBootApplication
@EnableHystrixDashboard
public class AppHystrix {
	public static void main(String[] args) {
		SpringApplication.run(AppHystrix.class, args);
	}
}
