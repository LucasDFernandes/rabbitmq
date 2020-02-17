package br.com.alura.rabbitmq.api;

import java.io.IOException;
import java.util.concurrent.TimeoutException;

import javax.websocket.server.PathParam;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import br.com.alura.rabbitmq.config.FilaProducer;

@RestController
@RequestMapping("/")
public class ApiRabbitMQ {

	@GetMapping("/publicar/{mensagem}")
	public ResponseEntity<String> publishMessage(@PathParam("mensagem") String mensagem) {
		try {
			var producer = new FilaProducer("filaApiRabbitMQ");
			producer.sendMessage(mensagem);
		} catch (IOException | TimeoutException e) {
			e.printStackTrace();
		}
		
		return ResponseEntity.ok().build();
	}

}
