package com.example.demo.student;
import java.time.LocalDateTime;
/*
 * per poter mandare/ricevere oggetti ci serve una classe 
 */
public class Traffico {
    private Long id;
    private Integer macchine;
    private Integer camion;
    private Integer moto;
    private Long idFotocamera;
    private LocalDateTime data;

    public Traffico() {

    }

    public Traffico(Long id, Integer macchine, Integer camion, Integer moto, Long idFotocamera, LocalDateTime data) {
        this.id = id;
        this.macchine = macchine;
        this.camion = camion;
        this.moto = moto;
        this.idFotocamera = idFotocamera;
        this.data = data;
    }

    public Traffico(Integer macchine, Integer camion, Integer moto, Long idFotocamera, LocalDateTime data) {
        this.macchine = macchine;
        this.camion = camion;
        this.moto = moto;
        this.idFotocamera = idFotocamera;
        this.data = data;
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

    public Long getIdFotocamera() {
        return idFotocamera;
    }

    public void setIdFotocamera(Long idFotocamera) {
        this.idFotocamera = idFotocamera;
    }

    public LocalDateTime getData() {
        return data;
    }

    public void setData(LocalDateTime data) {
        this.data = data;
    }

    //to string
    @Override
    public String toString() {
        return "Traffico{" +
                "id=" + id +
                ", macchine=" + macchine +
                ", camion=" + camion +
                ", moto=" + moto +
                ", idFotocamera=" + idFotocamera +
                ", data=" + data +
                '}';
    }

}
