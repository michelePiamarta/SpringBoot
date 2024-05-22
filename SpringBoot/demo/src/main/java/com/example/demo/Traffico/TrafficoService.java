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

	/**
	 * ritorna tutti i traffici
	 * @return tutti i traffici
	 */
    public List<Traffico> getTrafficos(){
		return trafficoRepository.findAll(); //ritorna tutti i traffici
	}

	/**
	 * ritorna il traffico della data odierna
	 * @return il traffico della data odierna
	 */
	public List<Traffico> getTrafficoFromToday(){
		return trafficoRepository.findByToday();
	}

	/**
	 * ritorna il traffico di una data specifica
	 * @param giorno il giorno di cui si vuole il traffico
	 * @param mese il mese di cui si vuole il traffico 
	 * @param anno l'anno di cui si vuole il traffico
	 * @return il traffico di una data specifica
	 */
	public Optional<Traffico> getTrafficoFromData(String giorno, String mese, String anno){ 
		return trafficoRepository.findByData(giorno, mese, anno);
	}
	
	/**
	 * ritorna il traffico di una fotocamera specifica nel giorno corrente
	 * @param id l'id della fotocamera di cui si vuole il traffico
	 * @return il traffico della fotocamera specificata nel giorno corrente
	 */
	public List<Traffico> getTrafficoFromFotocamera(Long id){ 
		return trafficoRepository.findByFotocamera(id);
	}

	/**
	 * ritorna il traffico di tutte le moto della data odierna
	 * @return il traffico di tutte le moto della data odierna
	 */
	public List<Traffico> getTrafficoMoto(){
		return trafficoRepository.findByMoto();
	}

	/**
	 * ritorna il traffico di tutte le auto della data odierna
	 * @return il traffico di tutte le auto della data odierna
	 */
	public List<Traffico> getTrafficoAuto(){
		return trafficoRepository.findByAuto();
	}
	/**
	 * ritorna il traffico di tutti i camion della data odierna
	 * @return il traffico di tutti i camion della data odierna
	 */
	public List<Traffico> getTrafficoCamion(){
		return trafficoRepository.findByCamion();
	}

	//public List<Traffico> getOgniTraffico(){
	//	return trafficoRepository.getOgniTraffico();
	//}
}
