package com.example.demo;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import com.example.demo.ControlloImmagini.ManagerImmagini;

@SpringBootApplication
public class BackEndApplication {


	private static ManagerImmagini managerImmagini;

	@SuppressWarnings("static-access") //per toglire il warning di static access a un metodo non statico di controllore immagini
	public BackEndApplication(ManagerImmagini managerImmagini){
		this.managerImmagini = managerImmagini; //funziona ma ogni volta che creo un oggetto di questa classe mi cambia il controllore di tutte le altre classi
	}
	public static void main(String[] args) {
		SpringApplication.run(BackEndApplication.class, args);
		managerImmagini.start(); // fa partire il thread che controlla e processa le immagini
	}
}
