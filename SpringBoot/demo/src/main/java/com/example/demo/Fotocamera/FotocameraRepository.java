package com.example.demo.Fotocamera;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import java.util.Optional;
import java.util.List;

public interface FotocameraRepository extends JpaRepository<Fotocamera, Long>{


    @Query("SELECT f,t FROM Fotocamera f inner join Traffico t on f.id = t.idFotocamera WHERE day(t.data) = day(CURRENT_DATE)")
    List<Fotocamera> findByToday();
}
