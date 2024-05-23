package com.example.demo.Fotocamera;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.OneToMany;
import jakarta.persistence.Table;
import java.util.List;
import com.example.demo.Traffico.Traffico;

@Entity
@Table
public class Fotocamera {
    @Id
    private Long id;
    private String posizione;
    @OneToMany(mappedBy = "fotocamera")
    private List<Traffico> traffici;


    public Fotocamera() {
    
    }

    public Fotocamera(Long id, String posizione) {
        this.id = id;
        this.posizione = posizione;
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

    @Override
    public String toString() {
        return "Fotocamera{" +
                "id=" + id +
                '}';
    }
}
