package com.example.demo.ControlloImmagini;

import java.io.BufferedReader;
import java.io.File;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.nio.charset.StandardCharsets;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.concurrent.LinkedBlockingQueue;

import com.example.demo.Immagine.Immagine;
import com.example.demo.Immagine.ImmagineRepository;
import com.example.demo.Webcam.WebcamRepository;

/**
 * classe che serve per elaborare le immagini presenti nella coda
 */
public class ElaboratoreImmagini extends Thread{

    private LinkedBlockingQueue<String> codaImmagini;
    private WebcamRepository webcamRepository;
    private ImmagineRepository immagineRepository;
    private String basePath = new File("").getAbsolutePath();
    private String pathPython = basePath+"\\demo\\src\\main\\java\\com\\example\\demo\\python\\main.py";
    private final String oldFormat = "yyyyMMddHHmmss";

    public ElaboratoreImmagini(WebcamRepository webcamRepository, ImmagineRepository immagineRepository){
        this.webcamRepository = webcamRepository;
        this.immagineRepository = immagineRepository;

    }

    public void setCodaImmagini(LinkedBlockingQueue<String> codaImmagini){
        this.codaImmagini = codaImmagini;
    }

    @Override
    public void run() {
        while(true){
            elabora();
        }
    }

    public void elabora(){
        try {
            String immagineCorrente = codaImmagini.peek();
            if(immagineCorrente != null){
                System.out.println("elaborando immagine "+immagineCorrente);
                pythonStart(pathPython,immagineCorrente, getCamId(immagineCorrente),getLocalDateTimeFromString(getDateTime(immagineCorrente),oldFormat));
                codaImmagini.take();
            }
            else{
                //System.out.println("la coda è vuota");
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    /**
     * fa partire lo script python
     * @param pathPython il path dello script python
     */
    private void pythonStart(String pathPython,String pathImmagine, String webcam, LocalDateTime data){
        ProcessBuilder processBuilder = new ProcessBuilder("python", pathPython,pathImmagine, webcam);
        processBuilder.redirectErrorStream(true);
        try{
            Process process = processBuilder.start();
            //per leggere i print del processo python
            InputStream inputStream = process.getInputStream();
            BufferedReader reader = new BufferedReader(new InputStreamReader(inputStream, StandardCharsets.UTF_8));
            StringBuilder result = new StringBuilder();
            String line;
            boolean rilevamento = false; //controllo se mi è arrivato "Rilevamento effettuato con successo!"
            Integer macchine = 0;
            Integer camion = 0;
            Integer moto = 0;
            while((line = reader.readLine()) != null){
                //se gli arriva la stringa del rilevamento allora seleziona i dati e li inserisce nel db
                if(rilevamento){
                    result.append(line);
                    System.out.println(line);
                    String[] tmpArray = line.split(" ");
                    macchine = Integer.parseInt(tmpArray[0]);
                    System.out.println("macchine: " + macchine);
                    camion = Integer.parseInt(tmpArray[1]);
                    System.out.println("camion: " + camion);
                    moto = Integer.parseInt(tmpArray[2]);
                    System.out.println("moto: " + moto);
                    newEntry(Long.parseLong(webcam), macchine, camion, moto, data);
                    rilevamento = false;
                }
                if(line.contains("Rilevamento effettuato con successo!")){
                    rilevamento = true;
                }
            }

            int exitCode = process.waitFor(); //aspetta che il processo finisca così da non far partire più processi contemporaneamente della stessa immagine
            System.out.println("exit code: " + exitCode);
            if(exitCode == 0)
                System.out.println("successo");
            else
                System.out.println("errore");
        }
        catch(Exception e){
            e.printStackTrace();
        }
    }

    private void newEntry(Long webcamId, Integer macchine, Integer camion, Integer moto, LocalDateTime data){
        immagineRepository.save(new Immagine(macchine, camion, moto, data, webcamRepository.findById(webcamId).get()));
    }

    /**
     * ritorna la data e l'ora dell'immagine
     * @param file l'immagine di cui si vuole la data e l'ora
     * @return la data e l'ora dell'immagine
     */
    private String getDateTime(String file){
        return file.split("_")[1];
    }

    /**
     * ritorna un oggetto LocalDateTime a partire da una stringa
     * @param date la stringa da convertire
     * @return un oggetto LocalDateTime a partire da una stringa
     */
    private java.time.LocalDateTime getLocalDateTimeFromString(String date, String format){
        return java.time.LocalDateTime.parse(date, DateTimeFormatter.ofPattern(format));
    } 

    /**
     * ritorna l'id della fotocamera a partire dalla cartella
     * @param folder la cartella da cui prendere l'id
     * @return l'id della fotocamera a partire dalla cartella
     */
    private String getCamId(String file){
        return file.split("cam")[2].split(".jpg")[0];
    }
}
