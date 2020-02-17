package br.com.alura.rabbitmq;

import java.io.IOException;
import java.util.concurrent.TimeoutException;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class RabbitmqApplication {

	public static void main(String[] args) throws IOException, TimeoutException {
		SpringApplication.run(RabbitmqApplication.class, args);
	}

}
