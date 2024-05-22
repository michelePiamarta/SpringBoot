package com.example.demo;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import com.example.demo.ControlloImmagini.ControlloreImmagini;

@SpringBootApplication
public class BackEndApplication {


	private static ControlloreImmagini controlloreImmagini;

	public BackEndApplication(ControlloreImmagini controlloreImmagini){
		this.controlloreImmagini = controlloreImmagini; //funziona ma ogni volta che creo un oggetto di questa classe mi cambia il controllore di tutte le altre classi
	}
	public static void main(String[] args) {
		SpringApplication.run(BackEndApplication.class, args);
		controlloreImmagini.start(); // fa partire il thread che controlla le immagini
	}

}
