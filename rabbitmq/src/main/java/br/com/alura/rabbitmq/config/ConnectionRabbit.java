package br.com.alura.rabbitmq.config;

import java.io.IOException;
import java.util.concurrent.TimeoutException;

import com.rabbitmq.client.Channel;
import com.rabbitmq.client.Connection;
import com.rabbitmq.client.ConnectionFactory;

/**
 * 
 * Classe Responsável pela Conexão com servidor RabbitMQ
 * 
 * @author lucasfernandes
 *
 */
public class ConnectionRabbit {

	protected Channel channel;
	protected Connection connection;
	protected String nomefila;

	public ConnectionRabbit(String nomefila) throws IOException, TimeoutException {
		this.nomefila = nomefila;

		// Create a connection factory
		ConnectionFactory factory = new ConnectionFactory();

		// hostname of your rabbitmq server
		factory.setHost("localhost");

		// getting a connection
		connection = factory.newConnection();

		// creating a channel
		channel = connection.createChannel();

		// declaring a queue for this channel. If queue does not exist,
		// it will be created on the server.
		channel.queueDeclare(nomefila, false, false, false, null);
	}

	/**
	 * Fecha canal e conexão caso seja necessário.
	 * 
	 * @throws IOException
	 * @throws TimeoutException 
	 */
	public void close() throws IOException, TimeoutException {
		this.channel.close();
		this.connection.close();
	}

}
