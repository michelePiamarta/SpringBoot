package com.example.demo.ControlloImmagini;

import java.io.File;
import java.time.LocalDateTime;
import java.time.Year;
import java.time.MonthDay;
import java.time.format.DateTimeFormatter;
import org.springframework.stereotype.Service;
import com.example.demo.Immagine.ImmagineRepository;
import java.time.YearMonth;
import java.util.concurrent.LinkedBlockingQueue;

@Service
/**
 * classe che serve per controllare le immagini in modo che se ne arriva una nuova allora viene 
 * aggiunta alla coda
 */
public class ControlloreImmagini extends Thread{
    
    //leggo le date del database, se la loro data è uguale allora non faccio niente, se invece è diversa allora faccio partire python
    private String basePath = new File("").getAbsolutePath();
    private String immaginiPath = basePath+"\\demo\\src\\main\\java\\com\\example\\demo\\ControlloImmagini\\immagini";
    private final String oldFormat = "yyyyMMddHHmmss";
    Long idCartellaInizio;
    Long idCartellaFine;
    // una queue thread safe, se non ce un elemento o vuole aggiungerne uno quando la coda è piena
    // allora aspetterà fino a quando non ce un elemento o la coda non si svuota
    private LinkedBlockingQueue<String> codaImmagini;
    //aggiungo una dependency injection per fare query al db
    private final ImmagineRepository immagineRepository;

    public ControlloreImmagini(ImmagineRepository immagineRepository){
        this.immagineRepository = immagineRepository;
    }
    
    public void setCodaImmagini(LinkedBlockingQueue<String> codaImmagini){
        this.codaImmagini = codaImmagini;
    }

    @Override
    public void run() {
        while(true){
            //cerco una nuova immagine/ delle nuove immagini e le aggiungo alla coda
            //(non puoi usare addAll perchè non è un operazione thread safe visto che viene inheritata da abstract queue)
            if(idCartellaInizio!=null && idCartellaFine!=null){
                File folder = new File(immaginiPath);
                File[] listOfFolders = folder.listFiles();
                for (File webcam : listOfFolders) {
                    Long webcamId = getCamId(webcam);
                    if(webcamId >= idCartellaInizio && webcamId <= idCartellaFine){
                        for(File immagine : webcam.listFiles()){
                            if(needsToBeProcessed(immagine)){
                                codaImmagini.add(immagine.getAbsolutePath());
                            }
                        }
                    }
                }
            }
        }
    }

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
        String tmp = folder.getName().split("cam")[1];
        return Long.parseLong(tmp.split(".jpg")[0]);
    }

    /**
     * ritorna un oggetto LocalDateTime a partire da una stringa
     * @param date la stringa da convertire
     * @return un oggetto LocalDateTime a partire da una stringa
     */
    private java.time.LocalDateTime getLocalDateTimeFromString(String date, String format){
        return java.time.LocalDateTime.parse(date, DateTimeFormatter.ofPattern(format));
    } 

    public boolean needsToBeProcessed(File file){
        //controllo se l'immagine è di oggi
        //if(!isDateToday(getLocalDateTimeFromString(getDateTime(file),oldFormat))){
        //    //System.out.println("l'immagine "+file.getName()+" non è di oggi");
        //    return false;
        //}

        //controllo se è nella coda
        if(codaImmagini.contains(file.getAbsolutePath())){
            //System.out.println("è già presente all'interno della coda l'immagine "+file.getName());
            return false;
        }
        //controllo se è nel database, gli passo come parametri data e cam id
        //controllo se la lista che mi ritorna la query del db non è vuota
        if(!(this.immagineRepository.hasBeenSaved(getLocalDateTimeFromString(getDateTime(file), oldFormat),getCamId(file)).isEmpty())){
            //System.out.println("è già presente del db l'immagine "+file.getName());
            return false;
        }
        System.out.println("aggiungo l'immagine "+file.getName()+" alla coda");
        return true;
    }

    private boolean isDateToday(LocalDateTime time){
        if(time.getDayOfMonth() == MonthDay.now().getDayOfMonth() && time.getMonth() == YearMonth.now().getMonth() && time.getYear() == Year.now().getValue()){
            return true;
        }
        return false;
    }

    public void setCartellaInizio(Long cartellaInizio){
        this.idCartellaInizio = cartellaInizio;
    }

    public void setCartellaFine(Long cartellaFine){
        this.idCartellaFine= cartellaFine;
    }
}
