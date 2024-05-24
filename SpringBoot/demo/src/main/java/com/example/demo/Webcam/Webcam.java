package com.example.demo.Webcam;

import java.util.List;
import java.util.ArrayList;
import org.springframework.data.annotation.Transient;
import com.example.demo.Immagine.Immagine;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.OneToMany;
import jakarta.persistence.Table;

@Entity
@Table
public class Webcam {
    @Id
    private Long id;
    private String posizione;
    @Transient
    private Float mediaMacchine;
    @Transient
    private Float mediaCamion;
    @Transient
    private Float mediaMoto;
    @Transient
    private Float mediaVeicoli;
    @OneToMany
    @JoinColumn(name = "webcam_id")
    private List<Immagine> immagini;
    public Webcam() {
    
    }

    public Webcam(Long id, String posizione) {
        this.id = id;
        this.posizione = posizione;
    }

    public Webcam(Long id, String posizione, List<Immagine> immagini){
        this.id = id;
        this.posizione = posizione;
        this.immagini = immagini;
    }

    public Webcam(Long id, String posizione, Immagine immagine){
        this.id = id;
        this.posizione = posizione;
        this.immagini = new ArrayList<Immagine>();
        this.immagini.add(immagine);
    }

    public Webcam(Long id, String posizione, Float mediaMacchine, Float mediaCamion, Float mediaMoto){
        this.id = id;
        this.posizione = posizione;
        this.mediaMacchine = mediaMacchine;
        this.mediaCamion = mediaCamion;
        this.mediaMoto = mediaMoto;
    }

    //setter and gettes
    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getPosizione() {
        return posizione;
    }

    public void setPosizione(String posizione) {
        this.posizione = posizione;
    }

    //getter for list

    @Override
    public String toString() {
        return "Fotocamera{" +
                "id=" + id +
                '}';
    }

    public List<Immagine> getImmagini() {
        return immagini;
    }

    public void setImmagini(List<Immagine> immagini) {
        this.immagini = immagini;
    }

    //public Float getMediaVeicoli(){
    //    return this.mediaVeicoli;
    //}
//
    //public void setMediaVeicoli(Float mediaVeicoli){
    //    this.mediaVeicoli = mediaVeicoli;
    //}

    public Float getMediaMacchine(){
        Float mediaMacchine = 0f;
        for(Immagine immagine :immagini){
            mediaMacchine += immagine.getMacchine();
        }
        return mediaMacchine/this.immagini.size();
    }

    public void setMediaMacchine(Float mediaMacchine){
        this.mediaMacchine = mediaMacchine;
    }

    public Float getMediaCamion(){
        Float mediaCamion = 0f;
        for(Immagine immagine :immagini){
            mediaCamion += immagine.getCamion();
        }
        return mediaCamion/this.immagini.size();
    }

    public void setMediaCamion(Float mediaCamion){
        this.mediaCamion = mediaCamion;
    }

    public Float getMediaMoto(){
        Float mediaMoto = 0f;
        for(Immagine immagine :immagini){
            mediaMoto += immagine.getMoto();
        }
        return mediaMoto/this.immagini.size();
    }

    public void setMediaMoto(Float mediaMoto){
        this.mediaMoto = mediaMoto;
    }

    public Float getMediaVeicoli(){
        Float mediaVeicoli = 0f;
        for(Immagine immagine :immagini){
            mediaVeicoli += immagine.getMoto();
            mediaVeicoli += immagine.getMacchine();
            mediaVeicoli += immagine.getCamion();
        }
        return mediaVeicoli/this.immagini.size();
    }

    public void setMediaVeicoli(Float mediaVeicoli){
        this.mediaVeicoli = mediaVeicoli;
    }
    /**
     * per ogni json devo avere una struttura dati diversa, quindi visto che in java non ci sono object facili da usare 
     * si crea una classe aggiuntiva anche se può portare boilerplate
     */
    interface WebcamSenzaMedie{
        Long getId();
        String getPosizione();
        List<Immagine> getImmagini();
        void setId(Long id);
        void setPosizione(String posizione);
        void setImmagini(List<Immagine> immagini);
    }

    interface WebcamConIdEPosizione{
        Long getId();
        String getPosizione();
        void setId(Long id);
        void setPosizione(String posizione);
    }
}
