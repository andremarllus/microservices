package br.com.posweb.webservice;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.context.web.SpringBootServletInitializer;


@SpringBootApplication
public class App extends SpringBootServletInitializer {

    public static void main(final String[] args) {
        SpringApplication.run(App.class, args);
    }
}
