package br.com.gj.tone.configuration;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ComponentScan;

@SpringBootApplication
@ComponentScan("br.com.gj.tone")
public class ToneApplication {

	public static void main(String[] args) {
		SpringApplication.run(ToneApplication.class, args);
	}

}
