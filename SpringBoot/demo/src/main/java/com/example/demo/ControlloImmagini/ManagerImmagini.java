package com.example.demo.ControlloImmagini;

import java.util.concurrent.LinkedBlockingQueue;
import org.springframework.stereotype.Service;
import com.example.demo.Immagine.ImmagineRepository;
import com.example.demo.Webcam.WebcamRepository;

@Service
/**
 * classe che controlla le classi controllore e elaboratore, per avere un codice più ordinato
 */
public class ManagerImmagini extends Thread{

    private ControlloreImmagini[] controlloriImmagini;
    private ElaboratoreImmagini[] elaboratoriImmagini;

    public ManagerImmagini(WebcamRepository webcamRepository, ImmagineRepository immagineRepository){
        this.elaboratoriImmagini = new ElaboratoreImmagini[13];
        this.controlloriImmagini = new ControlloreImmagini[13];

        for(int i = 0;i<13;i++){
            if(i!=2){
                LinkedBlockingQueue<String> codaImmagini = new LinkedBlockingQueue<String>();
                ControlloreImmagini controlloreImmagini = new ControlloreImmagini(immagineRepository);
                ElaboratoreImmagini elaboratoreImmagini = new ElaboratoreImmagini(webcamRepository,immagineRepository);
                controlloreImmagini.setCodaImmagini(codaImmagini);
                elaboratoreImmagini.setCodaImmagini(codaImmagini);
                controlloreImmagini.setCartellaInizio(i*10l);
                controlloreImmagini.setCartellaFine(i*10l+9l);
                controlloriImmagini[i] = controlloreImmagini;
                elaboratoriImmagini[i] = elaboratoreImmagini;
            }
        }
        
    }
 
    @Override
    public void run() {
        for (int i = 0; i < 13; i++) {
            if(i!=2){
                controlloriImmagini[i].start();
                elaboratoriImmagini[i].start();
            }
        }
    }
}