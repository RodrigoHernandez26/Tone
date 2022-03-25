package br.com.gj.tone.configuration;

import br.com.gj.tone.enumeration.ToneEnumeration;
import br.com.gj.tone.event.DiscordEvent;
import lombok.extern.slf4j.Slf4j;
import net.dv8tion.jda.api.JDA;
import net.dv8tion.jda.api.JDABuilder;
import net.dv8tion.jda.api.entities.Activity;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import javax.security.auth.login.LoginException;

@Configuration
@Slf4j
public class BotApplication {

    private final DiscordEvent events;
    public static JDA jda;

    public BotApplication(DiscordEvent events) {
        this.events = events;
    }

    @Bean
    public void initialize() throws LoginException {
        jda = JDABuilder.createLight(ToneEnumeration.TOKEN.getValue())
                .setRawEventsEnabled(true)
                .addEventListeners(events)
                .setActivity(Activity.playing("good music"))
                .build();
    }

}
