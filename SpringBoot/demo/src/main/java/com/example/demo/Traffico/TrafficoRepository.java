package com.example.demo.Traffico;

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
public interface TrafficoRepository extends JpaRepository<Traffico, Long>{ //specifichiamo il tipo di oggetto e il tipo di chiave primaria
    
    /**
     * ritorna il traffico della data odierna
     * @return il traffico della data odierna
     */
    @Query("SELECT t FROM Traffico t WHERE day(t.data) = day(CURRENT_DATE) and month(t.data) = month(CURRENT_DATE) and year(t.data) = year(CURRENT_DATE)") //query per trovare un traffico tramite data
    List<Traffico> findByToday(); //query per trovare un traffico tramite data

    /**
     * ritorna il traffico di una data specifica
     * @param giorno il giorno di cui si vuole il traffico
     * @param mese il mese di cui si vuole il traffico
     * @param anno l'anno di cui si vuole il traffico
     * @return il traffico di una data specifica
     */
    @Query("SELECT t FROM Traffico t WHERE day(t.data) = ?1 AND month(t.data) = ?2 AND year(t.data) = ?3") 
    Optional<Traffico> findByData(String giorno, String mese, String anno); 

    /**
     * ritorna il traffico di una fotocamera specifica del giorno corrente
     * @param id l'id della fotocamera di cui si vuole il traffico
     * @return il traffico della fotocamera specificata del giorno corrente
     */
    @Query("SELECT t FROM Traffico t WHERE t.idFotocamera = ?1 AND day(t.data) = day(CURRENT_DATE) and month(t.data) = month(CURRENT_DATE) and year(t.data) = year(CURRENT_DATE)")
    List<Traffico> findByFotocamera(Long id);

    /**
     * ritorna tutto il traffico di una data precedente
     * @param data la data di cui si vuole il traffico
     * @return tutto il traffico di una data precedente
     */
    @Query("SELECT t FROM Traffico t WHERE t.data < ?1")
    Optional<Traffico> findByDataBefore(String data);

    /**
     * ritorna il traffico di tutte le moto della data odierna
     * @return il traffico di tutte le moto della data odierna
     */
    @Query("SELECT t.moto FROM Traffico t WHERE day(t.data) = day(CURRENT_DATE)")
    List<Traffico> findByMoto();

    /**
     * ritorna il traffico di tutte le auto della data odierna
     * @return il traffico di tutte le auto della data odierna
     */
    @Query("SELECT t.macchine FROM Traffico t WHERE day(t.data) = day(CURRENT_DATE)")
    List<Traffico> findByAuto();

    /**
     * ritorna il traffico di tutti i camion della data odierna
     * @return il traffico di tutti i camion della data odierna
     */
    @Query("SELECT t.camion FROM Traffico t WHERE day(t.data) = day(CURRENT_DATE)")
    List<Traffico> findByCamion();

    //metodi per controllore immagini
    /**
     * ritorna l'ultimo timestamp registrato nel db data una fotocamera
     * @param id l'id della fotocamera
     * @return l'ultimo timestamp registrato nel db data una fotocamera
     */
    @Query("SELECT max(t.data) FROM Traffico t WHERE t.idFotocamera = ?1")
    Optional<java.time.LocalDateTime> getLastTimestamp(Long id);

    /**
     * inserisce un traffico nel db
     * @param macchine le macchine da inserire
     * @param camion i camion da inserire
     * @param moto le moto da inserire
     * @param idFotocamera l'id della fotocamera da inserire
     * @param data la data da inserire
     */
    @Query("INSERT INTO Traffico (macchine, camion, moto, idFotocamera, data) VALUES (?1, ?2, ?3, ?4, ?5)")
    void insertTraffico(Integer macchine, Integer camion, Integer moto, Long idFotocamera, java.time.LocalDateTime data);

    
}
