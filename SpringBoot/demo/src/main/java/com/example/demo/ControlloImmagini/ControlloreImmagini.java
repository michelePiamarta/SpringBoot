package com.example.demo.ControlloImmagini;

import java.io.File;
import java.util.Optional;
import java.time.format.DateTimeFormatter;
import org.springframework.stereotype.Service;
import java.time.LocalDateTime;
import com.example.demo.Traffico.TrafficoRepository;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.nio.charset.StandardCharsets;
import java.io.BufferedReader;

@Service
public class ControlloreImmagini extends Thread{
    
    //leggo le date del database, se la loro data è uguale allora non faccio niente, se invece è diversa allora faccio partire python
    private String immaginiPath = "D:\\Studenti\\PIAMARTA.Michele\\Git\\SpringBoot\\SpringBoot\\SpringBoot\\demo\\src\\main\\java\\com\\example\\demo\\ControlloImmagini\\immagini";
    private String pythonPath = "D:\\Studenti\\PIAMARTA.Michele\\TornadoMendix\\TornadoMendix\\main.py";
    private final String oldFormat = "yyyyMMddHHmmss";

    //aggiungo una dependency injection per fare query al db
    private final TrafficoRepository trafficoRepository;

    public ControlloreImmagini(TrafficoRepository trafficoRepository){
        this.trafficoRepository = trafficoRepository;
    }
    
    @Override
    public void run() {
        File folder = new File(immaginiPath);
        File[] listOfFolders = folder.listFiles(); // la lista delle cartelle delle fotocamere
        while(true){
            for(File folderCam : listOfFolders){
                //prendo l'id della fotocamera
                Long id = getCamId(folderCam);
                //prendo l'ultimo timestamp registrato nel db dalla fotocamera usando l'id
                Optional<LocalDateTime> lastTimestamp = getLastTimestamp(id);
                //prendo l'ultima immagine scattata
                File[] immagini = folderCam.listFiles();
                File lastImmagine = immagini[immagini.length-1];
                //prendo la data dell'immagine
                LocalDateTime dataLastImmagine = getLocalDateTimeFromString(getDateTime(lastImmagine),oldFormat);
                //confronto le date
                if(lastTimestamp.isPresent()){
                    if(lastTimestamp.get().equals(dataLastImmagine)){
                        System.out.println("le date sono uguali sulla fotocamera "+id+" non faccio niente");
                    }
                    else{
                        System.out.println("le date sono diverse sulla fotocamera "+id+" faccio partire python");
                        pythonStart(pythonPath,id.toString(),lastImmagine.getName());
                    }
                }
                else{
                    System.out.println("non ci sono timestamp registrati sulla fotocamera "+id+" faccio partire python");
                    pythonStart(pythonPath,id.toString(),lastImmagine.getName());
                }
            }
        }
    }

    //metodi utili
    //metodo per prendere la data e ora dell'ultimo dato registrato nel db a seconda della fotocamera - fatto
    //metodo per convertire la data dell'immagine in un formato leggibile al db - fatto
    //metodo per prendere l'id della fotocamera dalla cartella - fatto
    //metodo che fa partire python

    /**
     * ritorna la data e l'ora dell'immagine
     * @param file l'immagine di cui si vuole la data e l'ora
     * @return la data e l'ora dell'immagine
     */
    private String getDateTime(File file){
        String data = file.getName().split("_")[1];
        return data;
    }
    
    /**
     * ritorna l'id della fotocamera a partire dalla cartella
     * @param folder la cartella da cui prendere l'id
     * @return l'id della fotocamera a partire dalla cartella
     */
    private Long getCamId(File folder){
        return Long.parseLong(folder.getName().split("cam")[1]);
    }

    /**
     * ritorna l'ultimo timestamp registrato nel db a seconda della fotocamera
     * @param fotocamera l'id della fotocamera di cui si vuole il timestamp
     * @return l'ultimo timestamp registrato nel db a seconda della fotocamera
     */
    private Optional<java.time.LocalDateTime> getLastTimestamp(Long fotocamera){
        return trafficoRepository.getLastTimestamp(fotocamera);
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
     * fa partire lo script python
     * @param path il path dello script python
     */
    private void pythonStart(String path, String fotocamera, String data){
        ProcessBuilder processBuilder = new ProcessBuilder("python", path, fotocamera, data);
        processBuilder.redirectErrorStream(true);
        try{
            Process process = processBuilder.start();
            //per leggere i print del processo python
            InputStream inputStream = process.getInputStream();
            BufferedReader reader = new BufferedReader(new InputStreamReader(inputStream, StandardCharsets.UTF_8));
            StringBuilder result = new StringBuilder();
            String line;
            while((line = reader.readLine()) != null){
                //ci va un controllo se la line può essere convertita in json allora la salvo altrimenti la ignoro
                result.append(line);
            }
            String output = result.toString(); // output del processo python in String formato json
            System.out.println(output);

            int exitCode = process.waitFor(); //aspetta che il processo finisca così da non far partire più processi contemporaneamente della stessa immagine
            System.out.println("exit code: "+exitCode);
            if(exitCode == 0)
                System.out.println("successo");
            else
                System.out.println("errore");
        }
        catch(Exception e){
            e.printStackTrace();
        }
    }

    private void newEntry(Long fotocameraId, Integer macchine, Integer camion, Integer moto, LocalDateTime data){
        trafficoRepository.insertTraffico(macchine, camion, moto, fotocameraId, data);
    }
}
