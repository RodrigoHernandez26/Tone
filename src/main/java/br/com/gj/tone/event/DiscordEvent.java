package br.com.gj.tone.event;

import br.com.gj.tone.dto.RabbitMQToneDTO;
import br.com.gj.tone.enumeration.ToneEnumeration;
import lombok.extern.slf4j.Slf4j;
import net.dv8tion.jda.api.events.ReadyEvent;
import net.dv8tion.jda.api.events.message.MessageReceivedEvent;
import net.dv8tion.jda.api.hooks.ListenerAdapter;
import org.apache.camel.Produce;
import org.apache.camel.ProducerTemplate;
import org.jetbrains.annotations.NotNull;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

@Component
@Slf4j
public class DiscordEvent extends ListenerAdapter {

    @Produce("direct:MQSender")
    private ProducerTemplate producer;

    @Override
    public void onReady(@NotNull ReadyEvent event) {
        System.out.println("Bot Online!");
    }

    @Override
    public void onMessageReceived(@NotNull MessageReceivedEvent event) {
        if (event.getMessage().getAuthor().isBot()) return;
        if (!event.getMessage().getAttachments().isEmpty()) return;

        String[] args = event.getMessage().getContentRaw().split(" ");
        String firstWord = args[0].substring(1);
        List<String> message = new ArrayList<>(Arrays.asList(args));
        message.remove(0);

        if(args[0].startsWith(ToneEnumeration.PREFIX.getValue())) {

            RabbitMQToneDTO rabbitMQToneDTO = new RabbitMQToneDTO();
            rabbitMQToneDTO.setCommand(firstWord);
            rabbitMQToneDTO.setAuthor(event.getAuthor().toString());
            if (!message.isEmpty()) rabbitMQToneDTO.setMessage(message);
            producer.sendBody(rabbitMQToneDTO);

        }
    }

}
