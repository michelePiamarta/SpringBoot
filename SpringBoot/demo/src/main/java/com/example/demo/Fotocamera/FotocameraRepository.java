package com.example.demo.Fotocamera;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import java.util.List;

public interface FotocameraRepository extends JpaRepository<Fotocamera, Long>{


    @Query("SELECT f FROM Fotocamera f inner join Traffico t on f.id = t.fotocamera.id WHERE day(t.data) = day(CURRENT_DATE)")
    List<Fotocamera> findByToday();

    @Query("SELECT f FROM Fotocamera f")
    List<Fotocamera> findAllFull();

    @Query("SELECT f FROM Fotocamera f WHERE f.id = ?1")
    Fotocamera findByIdFull(Long id);
}
