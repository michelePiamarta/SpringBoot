package com.example.demo.Immagine;

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
public interface ImmagineRepository extends JpaRepository<Immagine, Long>{

    @Query("select i from Immagine i where i.data = ?1 AND i.webcam.id = ?2")
    List<Immagine> hasSaved(java.time.LocalDateTime data,Long webcamId);
}
