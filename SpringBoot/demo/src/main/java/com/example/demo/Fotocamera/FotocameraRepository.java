package com.example.demo.Fotocamera;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import java.util.List;
import java.util.Optional;

public interface FotocameraRepository extends JpaRepository<Fotocamera, Long>{


    @Query("SELECT f FROM Fotocamera f")
    List<Fotocamera.FotocameraConIdEPosizione> findAllFotocamere();

    // get generale
    @Query("SELECT f FROM Fotocamera f join Immagine t on f.id = t.fotocamera.id where day(t.data) = day(CURRENT_DATE) and month(t.data) = month(CURRENT_DATE) and year(t.data) = year(CURRENT_DATE)")
    List<Fotocamera.FotocameraSenzaMedie> findFotocameraToday();
    
    // @Query("SELECT max(t.data) FROM Traffico t join fotocamera f on t.fotocamera.id = f.id WHERE f.id = ?1")
    @Query("SELECT max(t.data) FROM Fotocamera f join Immagine t on f.id = t.fotocamera.id WHERE f.id = ?1")
    Optional<java.time.LocalDateTime> findLastTimestamp(Long id);

    @Query("SELECT f FROM Fotocamera f join Immagine t on f.id = t.fotocamera.id where day(t.data) = day(CURRENT_DATE) and month(t.data) = month(CURRENT_DATE) and year(t.data) = year(CURRENT_DATE)")
    List<Fotocamera> findFotocameraTodayMedie();

    @Query("SELECT f FROM Fotocamera f join Immagine t on f.id = t.fotocamera.id where f.id in ?1")
    List<Fotocamera> findFotocamereFiltrate(List<Long> body);
}
