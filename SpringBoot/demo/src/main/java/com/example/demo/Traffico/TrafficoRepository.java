package com.example.demo.Traffico;

import java.util.Optional;
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
    
    @Query("SELECT t FROM Traffico t WHERE t.idFotocamera = ?1") //query per trovare un traffico tramite id della fotocamera
    Optional<Traffico> findById_fotocamera(Long id); //query per trovare un traffico tramite id
}
