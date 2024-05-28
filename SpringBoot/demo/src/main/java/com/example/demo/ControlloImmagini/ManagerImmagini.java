package com.example.demo.ControlloImmagini;

import java.util.concurrent.LinkedBlockingQueue;

import org.springframework.stereotype.Service;

import com.example.demo.Immagine.ImmagineRepository;
import com.example.demo.Webcam.WebcamRepository;

@Service
public class ManagerImmagini extends Thread{

    private ControlloreImmagini controlloreImmagini;
    private ElaboratoreImmagini elaboratoreImmagini;
    private LinkedBlockingQueue<String> codaImmagini;

    public ManagerImmagini(WebcamRepository webcamRepository, ImmagineRepository immagineRepository){
        this.codaImmagini = new LinkedBlockingQueue<String>();
        this.controlloreImmagini = new ControlloreImmagini(immagineRepository);
        this.elaboratoreImmagini = new ElaboratoreImmagini(webcamRepository,immagineRepository);
        this.controlloreImmagini.setCodaImmagini(codaImmagini);
        this.elaboratoreImmagini.setCodaImmagini(codaImmagini);
    }

    @Override
    public void run() {
        controlloreImmagini.start();
        elaboratoreImmagini.start();
    }
}
