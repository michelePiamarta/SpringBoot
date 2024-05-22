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
			repository.save(new Traffico(1L,3,2,5,69L,LocalDateTime.of(2024,3,21,12,0,13)));
            repository.save(new Traffico(2L,7,3,1,69L,LocalDateTime.of(2024,4,28,12,40,03)));
            repository.save(new Traffico(3L,6,8,3,34L,LocalDateTime.of(2024,3,22,13,0,27)));
        };
    }
}
