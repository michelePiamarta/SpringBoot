package com.example.demo.Immagine;

import java.util.Optional;
import java.util.List;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

/*
 * in questa interfaccia si effettuano le query al db, data layer
 */
@Repository //per dire a spring che questa interfaccia è un repository
/*
 * la usiamo come dependency injection per fare query al db dove sviluppiamo la business logic
 */
public interface ImmagineRepository extends JpaRepository<Immagine, Long>{ //specifichiamo il tipo di oggetto e il tipo di chiave primaria
    
    /**
     * ritorna il immagine della data odierna
     * @return il immagine della data odierna
     */
    @Query("SELECT t FROM Immagine t join Webcam w on t.webcam.id = w.id WHERE day(t.data) = day(CURRENT_DATE) and month(t.data) = month(CURRENT_DATE) and year(t.data) = year(CURRENT_DATE) order by t.data asc") //query per trovare un traffico tramite data
    List<Immagine> findByToday();

    /**
     * ritorna il immagine di una data specifica
     * @param giorno il giorno di cui si vuole il immagine
     * @param mese il mese di cui si vuole il immagine
     * @param anno l'anno di cui si vuole il immagine
     * @return il immagine di una data specifica
     */
    @Query("SELECT t FROM Immagine t WHERE day(t.data) = ?1 AND month(t.data) = ?2 AND year(t.data) = ?3") 
    Optional<Immagine> findByData(String giorno, String mese, String anno); 

    ///**
    // * ritorna il traffico di una fotocamera specifica del giorno corrente
    // * @param id l'id della fotocamera di cui si vuole il traffico
    // * @return il traffico della fotocamera specificata del giorno corrente
    // */
    //@Query("SELECT t FROM Traffico t WHERE t.idFotocamera = ?1 AND day(t.data) = day(CURRENT_DATE) and month(t.data) = month(CURRENT_DATE) and year(t.data) = year(CURRENT_DATE) order by t.data asc")
    //List<Traffico> findByFotocamera(Long id);

    /**
     * ritorna tutto il traffico di una data precedente
     * @param data la data di cui si vuole il traffico
     * @return tutto il traffico di una data precedente
     */
    @Query("SELECT t FROM Immagine t WHERE t.data < ?1")
    Optional<Immagine> findByDataBefore(String data);

    /**
     * ritorna il traffico di tutte le moto della data odierna
     * @return il traffico di tutte le moto della data odierna
     */
    @Query("SELECT t.moto FROM Immagine t WHERE day(t.data) = day(CURRENT_DATE)")
    List<Immagine> findByMoto();

    /**
     * ritorna il traffico di tutte le auto della data odierna
     * @return il traffico di tutte le auto della data odierna
     */
    @Query("SELECT t.macchine FROM Immagine t WHERE day(t.data) = day(CURRENT_DATE)")
    List<Immagine> findByAuto();

    /**
     * ritorna il traffico di tutti i camion della data odierna
     * @return il traffico di tutti i camion della data odierna
     */
    @Query("SELECT t.camion FROM Immagine t WHERE day(t.data) = day(CURRENT_DATE)")
    List<Immagine> findByCamion();

    //metodi per controllore immagini
    /**
     * ritorna l'ultimo timestamp registrato nel db data una fotocamera
     * @param id l'id della fotocamera
     * @return l'ultimo timestamp registrato nel db data una fotocamera
     */
    @Query("SELECT max(t.data) FROM Immagine t join webcam w on t.webcam.id = w.id WHERE w.id = ?1")
    Optional<java.time.LocalDateTime> getLastTimestamp(Long id);

    /**
     * inserisce un traffico nel db
     * @param macchine le macchine da inserire
     * @param camion i camion da inserire
     * @param moto le moto da inserire
     * @param idFotocamera l'id della fotocamera da inserire
     * @param data la data da inserire
     */
    @Query("INSERT INTO Immagine (macchine, camion, moto, data) VALUES (?1, ?2, ?3, ?4)")
    void insertTraffico(Integer macchine, Integer camion, Integer moto, java.time.LocalDateTime data);

    @Query("select i from Immagine i where i.data = ?1 AND i.webcam.id = ?2")
    List<Immagine> hasBeenSaved(java.time.LocalDateTime data,Long webcamId);
}
