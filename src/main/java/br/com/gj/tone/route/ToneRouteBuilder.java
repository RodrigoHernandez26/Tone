package br.com.gj.tone.route;

import br.com.gj.tone.dto.RabbitMQToneDTO;
import org.apache.camel.CamelContext;
import org.apache.camel.LoggingLevel;
import org.apache.camel.builder.RouteBuilder;
import org.apache.camel.model.dataformat.JsonLibrary;
import org.springframework.stereotype.Component;

import static br.com.gj.tone.configuration.RabbitMQConfiguration.RABBIT_URI;

@Component
public class ToneRouteBuilder extends RouteBuilder {

    @Override
    public void configure() throws Exception {

        errorHandler(deadLetterChannel("direct:errorHandlerToneRouteBuilder"));

        fromF(RABBIT_URI, "test", "test")
                .log("Message received: ${body}")
                .unmarshal().json(JsonLibrary.Jackson, RabbitMQToneDTO.class)
                .log("Object: ${body}");

        from("direct:MQSender")
                .log("${body}")
                .marshal().json(JsonLibrary.Jackson, RabbitMQToneDTO.class)
                .toF(RABBIT_URI, "test", "test");

        from("direct:errorHandlerToneRouteBuilder").log(LoggingLevel.ERROR, "${exception.message}");

    }


}
