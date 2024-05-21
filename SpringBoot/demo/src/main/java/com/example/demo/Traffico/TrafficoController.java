package com.example.demo.Traffico;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController //mi permette di aggiungere endpoints a questa classe
@RequestMapping(path = "api/v1/traffico") // diamo un path url di default per le richieste a questa classe
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
	public List<Traffico> getTrafficos(){ // facendo una classe posso usarla per rispondere alle richieste
        return trafficoService.getTrafficos();
    }

    @GetMapping(path = "/fotocamera") // per la get request
    public Optional<Traffico> getTrafficoFromFotocameraId(@RequestParam("id") Long idFotocamera){ // facendo una classe posso usarla per rispondere alle richieste
        return trafficoService.getTrafficoFromFotocameraId(idFotocamera);
    }

}
