package com.example.demo.Traffico;

import java.time.LocalDateTime;
import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class TrafficoConfig {

    @Bean //per dire a spring di eseguire questo metodo all'avvio dell'applicazione
    CommandLineRunner commandLineRunner(TrafficoRepository repository){
        return args -> {
			repository.save(new Traffico(1L,3,2,5,54L,LocalDateTime.of(2024,5,21,12,0)));
        };
    }
}
