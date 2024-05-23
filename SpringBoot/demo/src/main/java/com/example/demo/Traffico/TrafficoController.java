package com.example.demo.Traffico;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController //mi permette di aggiungere endpoints a questa classe
@RequestMapping(path = "traffico") // diamo un path url di default per le richieste a questa classe
/*
 * in questa classe definisco i metodi che risponderanno alle richieste http, api layer
 */
public class TrafficoController { 

    private final TrafficoService trafficoService; // creo un oggetto di tipo TrafficoService per la business logic
    /*
     * dependency injection, nella classe traffico service ci servse un cosrtuttore senza parametri
     */
    @Autowired
    public TrafficoController(TrafficoService trafficoService) {
        this.trafficoService = trafficoService;
    }

    @GetMapping(path = "/hello") // per la get request
	public List<Traffico> getTrafficos(){ 
        return trafficoService.getTrafficos();
    }

    /**
     * ritorna una lista di traffico della data odierna
     * @return una lista di traffico della data odierna
     */
    @GetMapping(path = "/oggi")
    public List<Traffico> getTrafficoFromToday(){ 
        return trafficoService.getTrafficoFromToday();
    }

    /**
     * ritorna il traffico di una dsata specifica
     * @param giorno il giorno di cui si vuole il traffico
     * @param mese il mese di cui si vuole il traffico
     * @param anno l'anno di cui si vuole il traffico
     * @return
     */
    @GetMapping(path = "/data")
    public Optional<Traffico> getTrafficoFromData(@RequestParam("giorno") String giorno, @RequestParam("mese") String mese, @RequestParam("anno") String anno){ 
        return trafficoService.getTrafficoFromData(giorno, mese, anno);
    }
    /**
     * ritorna il traffico di una fotocamera specifica nel giorno corrente
     * @param idFotocamera l'id della fotocamera di cui si vuole il traffico
     * @return il traffico della fotocamera specificata nel giorno corrente
     */
    @GetMapping(path = "/fotocamera")
    public List<Traffico> getTrafficoFromFotocamera(@RequestParam("fotocamera")Long idFotocamera) {
        return trafficoService.getTrafficoFromFotocamera(idFotocamera);
    }

    @GetMapping(path = "/moto")
    public List<Traffico> getTrafficoMoto(){
        return trafficoService.getTrafficoMoto();
    }

    @GetMapping(path = "/auto")
    public List<Traffico> getTrafficoAuto(){
        return trafficoService.getTrafficoAuto();
    }

    @GetMapping(path = "/camion")
    public List<Traffico> getTrafficoCamion(){
        return trafficoService.getTrafficoCamion();
    }

    //<@GetMapping(path = "/ogniTraffico")
    //<public List<Traffico> getOgniTraffico(){
    //<    return trafficoService.getOgniTraffico();
    //<}
}
