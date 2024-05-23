package com.example.demo.Traffico;

import java.time.LocalDateTime;
import com.example.demo.Fotocamera.Fotocamera;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.SequenceGenerator;
import jakarta.persistence.Table;

/*
 * per poter mandare/ricevere oggetti ci serve una classe 
 */
@Entity 
@Table //per dire a hibernate di creare una tabella nel db usando questa classe
public class Traffico {
    @Id //per dire a hibernate che questo è il campo chiave
    @SequenceGenerator( //per dire a hibernate di usare una sequenza per generare l'id
            name = "traffico_sequence", 
            sequenceName = "traffico_sequence", //nome della sequenza
            allocationSize = 1 //incremento di 1
    )
    @GeneratedValue( //per dire a hibernate di generare l'id tramite la sequenza traffico_sequence
            strategy = GenerationType.SEQUENCE,
            generator = "traffico_sequence"
    )
    private Long id;
    private Integer macchine;
    private Integer camion;
    private Integer moto;
    private LocalDateTime data;
    @ManyToOne
    // metti lazy il seguente fetch type
    @JoinColumn(name = "fotocamera_id")
    private Fotocamera fotocamera;


    public Traffico() {

    }

    public Traffico(Long id, Integer macchine, Integer camion, Integer moto, LocalDateTime data) {
        this.id = id;
        this.macchine = macchine;
        this.camion = camion;
        this.moto = moto;
        this.data = data;
    }

    public Traffico(Integer macchine, Integer camion, Integer moto, LocalDateTime data) {
        this.macchine = macchine;
        this.camion = camion;
        this.moto = moto;
        this.data = data;
    }

    public Traffico(Integer macchine, Integer camion, Integer moto, LocalDateTime data, Fotocamera fotocamera) {
        this.macchine = macchine;
        this.camion = camion;
        this.moto = moto;
        this.data = data;
        this.fotocamera = fotocamera;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Integer getMacchine() {
        return macchine;
    }

    public void setMacchine(Integer macchine) {
        this.macchine = macchine;
    }

    public Integer getCamion() {
        return camion;
    }

    public void setCamion(Integer camion) {
        this.camion = camion;
    }

    public Integer getMoto() {
        return moto;
    }

    public void setMoto(Integer moto) {
        this.moto = moto;
    }

    public LocalDateTime getData() {
        return data;
    }

    public void setData(LocalDateTime data) {
        this.data = data;
    }

    public Fotocamera getFotocamera() {
        return fotocamera;
    }

    public void setFotocamera(Fotocamera fotocamera) {
        this.fotocamera = fotocamera;
    }

    //to string
    @Override
    public String toString() {
        return "Traffico{" +
                "id=" + id +
                ", macchine=" + macchine +
                ", camion=" + camion +
                ", moto=" + moto +
                ", data=" + data +
                '}';
    }

}
