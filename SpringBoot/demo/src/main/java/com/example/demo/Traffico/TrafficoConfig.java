package com.example.demo.Traffico;

import java.time.LocalDateTime;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import com.example.demo.Fotocamera.FotocameraRepository;

@Configuration
public class TrafficoConfig {

    private final FotocameraRepository fotocameraRepository;

    @Autowired
    public TrafficoConfig(FotocameraRepository repository) {
        this.fotocameraRepository = repository;
    }

    @Bean //per dire a spring di eseguire questo metodo all'avvio dell'applicazione
    CommandLineRunner commandLineRunner(TrafficoRepository repository){
        return args -> {
            //dati fittizzidi prova
			repository.save(new Traffico(3,2,5,LocalDateTime.of(2024,3,21,12,0,13),fotocameraRepository.findById(69L).get()));
            repository.save(new Traffico(7,3,1,LocalDateTime.of(2024,4,28,12,40,03),fotocameraRepository.findById(69L).get()));
            repository.save(new Traffico(6,8,3,LocalDateTime.of(2024,5,22,13,0,27),fotocameraRepository.findById(34L).get()));
            repository.save(new Traffico(6,8,3,LocalDateTime.of(2024,5,22,13,0,27),fotocameraRepository.findById(97L).get()));
            repository.save(new Traffico(6,8,3,LocalDateTime.of(2024,5,22,13,0,27),fotocameraRepository.findById(88L).get()));
            repository.save(new Traffico(9,3,1,LocalDateTime.of(2024,5,22,15,20,27),fotocameraRepository.findById(88L).get()));
            repository.save(new Traffico(2,4,0,LocalDateTime.of(2024,5,22,15,50,47),fotocameraRepository.findById(88L).get()));
            repository.save(new Traffico(1,7,2,LocalDateTime.of(2024,5,22,15,12,59),fotocameraRepository.findById(88L).get()));
            repository.save(new Traffico(1,7,2,LocalDateTime.of(2024,5,22,15,32,59),fotocameraRepository.findById(98L).get()));
            repository.save(new Traffico(1,7,2,LocalDateTime.of(2024,5,22,19,12,59),fotocameraRepository.findById(108L).get()));
            repository.save(new Traffico(1,7,2,LocalDateTime.of(2024,5,22,15,12,59),fotocameraRepository.findById(78L).get()));
            repository.save(new Traffico(1,7,2,LocalDateTime.of(2024,5,23,15,12,59),fotocameraRepository.findById(2L).get()));
            repository.save(new Traffico(1,7,2,LocalDateTime.of(2024,5,23,15,12,59),fotocameraRepository.findById(2L).get()));
        };
    }
}
