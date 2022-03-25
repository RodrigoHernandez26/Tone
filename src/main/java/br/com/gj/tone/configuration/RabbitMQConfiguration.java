package br.com.gj.tone.configuration;

import br.com.gj.tone.enumeration.ToneEnumeration;
import com.rabbitmq.client.ConnectionFactory;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class RabbitMQConfiguration {

    public static final String RABBIT_URI = "rabbitmq:amq.direct?queue=%s&routingKey=%s&autoDelete=false";

    @Bean
    public ConnectionFactory rabbitConnectionFactory() {
        ConnectionFactory connectionFactory = new ConnectionFactory();
        connectionFactory.setHost(ToneEnumeration.RABBITMQ_HOST.getValue());
        connectionFactory.setVirtualHost(ToneEnumeration.RABBITMQ_VIRTUAL_HOST.getValue());
        connectionFactory.setUsername(ToneEnumeration.RABBITMQ_USERNAME.getValue());
        connectionFactory.setPassword(ToneEnumeration.RABBITMQ_PASSWORD.getValue());

        return connectionFactory;
    }

}
