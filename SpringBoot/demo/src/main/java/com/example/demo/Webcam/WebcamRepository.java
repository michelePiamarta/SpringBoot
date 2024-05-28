package com.example.demo.Webcam;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface WebcamRepository extends JpaRepository<Webcam, Long>{


    @Query("SELECT w FROM Webcam w")
    List<Webcam.WebcamConIdEPosizione> findAllWebcam();

    // get generale
    @Query("SELECT w FROM Webcam w join Immagine i on w.id = i.webcam.id where day(i.data) = day(CURRENT_DATE) and month(i.data) = month(CURRENT_DATE) and year(i.data) = year(CURRENT_DATE)")
    List<Webcam.WebcamSenzaMedie> findWebcamToday();
    
    @Query("SELECT max(i.data) FROM Webcam w join Immagine i on w.id = i.webcam.id WHERE w.id = ?1")
    Optional<java.time.LocalDateTime> findLastTimestamp(Long id);

    @Query("SELECT w FROM Webcam w join Immagine i on w.id = i.webcam.id where day(i.data) = day(CURRENT_DATE) and month(i.data) = month(CURRENT_DATE) and year(i.data) = year(CURRENT_DATE)")
    List<Webcam> findWebcamTodayMedie();

    @Query("SELECT w FROM Webcam w join Immagine i on w.id = i.webcam.id where w.id in ?1")
    List<Webcam> findWebcamFiltrate(List<Long> body);
    //macchine camion moto
    @Query("SELECT new com.example.demo.Webcam.WebcamMedie(avg(i.macchine),avg(i.camion),avg(i.moto)) from Webcam w join Immagine i on w.id = i.webcam.id where day(i.data) = day(CURRENT_DATE) and month(i.data) = month(CURRENT_DATE) and year(i.data) = year(CURRENT_DATE)")
    Optional<WebcamMedie> findMedieGenerali();
}
