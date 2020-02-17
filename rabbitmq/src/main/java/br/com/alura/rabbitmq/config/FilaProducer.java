package br.com.alura.rabbitmq.config;

import java.io.IOException;
import java.io.Serializable;
import java.util.concurrent.TimeoutException;

import org.springframework.util.SerializationUtils;

public class FilaProducer extends ConnectionRabbit {

	public FilaProducer(String nomefila) throws IOException, TimeoutException {
		super(nomefila);
	}

	/**
	 * 
	 * Publica Mensagens
	 * 
	 * @param object
	 * @throws IOException
	 */
	public void sendMessage(Serializable object) throws IOException {
		channel.basicPublish("", nomefila, null, SerializationUtils.serialize(object));
	}

}
