package com.example.demo.Traffico;

import java.util.List;
import java.util.Optional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
/*
 * in questa classe definisco i metodi che gestiranno la business logic, service layer
 */
@Service //più specifico di @Component, indica che questa classe è un service
public class TrafficoService {
    
	
	private final TrafficoRepository trafficoRepository; //dichiaro un'istanza di TrafficoRepository
	@Autowired //per fare dependency injection
	public TrafficoService(TrafficoRepository trafficoRepository) { //costruttore
		this.trafficoRepository = trafficoRepository;
	}

    public List<Traffico> getTrafficos(){ // facendo una classe posso usarla per rispondere alle richieste
		return trafficoRepository.findAll(); //ritorna tutti i traffici
	}

	public Optional<Traffico> getTrafficoFromFotocameraId(Long idFotocamera){ 
		return trafficoRepository.findById_fotocamera(idFotocamera); //ritorna tutti i traffici con idFotocamera uguale a quello passato
	}

}
