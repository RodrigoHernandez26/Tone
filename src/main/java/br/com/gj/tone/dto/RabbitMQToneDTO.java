package br.com.gj.tone.dto;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import lombok.*;
import net.dv8tion.jda.api.entities.User;

import java.io.Serializable;
import java.util.Date;
import java.util.List;
import java.util.Map;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@JsonIgnoreProperties(ignoreUnknown = true)
@Builder
@ToString
public class RabbitMQToneDTO implements Serializable {

    private String command;
    private List<String> message;
    private String author;
    private Date date = new Date();

}
