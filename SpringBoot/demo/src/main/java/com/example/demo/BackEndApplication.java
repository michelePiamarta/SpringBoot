package com.example.demo;

import java.time.LocalDateTime;
import java.util.List;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.demo.student.Traffico;

@SpringBootApplication
@RestController //mi permette di aggiungere endpoints a questa classe
public class BackEndApplication {

	public static void main(String[] args) {
		SpringApplication.run(BackEndApplication.class, args);
	}

	@GetMapping(path = "/hello") // per la get request
	public List<Traffico> hello(){ // facendo una classe posso usarla per rispondere alle richieste
		return List.of(
			new Traffico(1L,3,2,5,54L,LocalDateTime.of(2024,5,21,12,0)),
			new Traffico()
		);
	}
}
