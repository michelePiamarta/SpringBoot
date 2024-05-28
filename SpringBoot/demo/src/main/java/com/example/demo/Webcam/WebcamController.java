package com.example.demo.Webcam;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.demo.Immagine.Immagine;
import com.example.demo.Webcam.Webcam.WebcamSenzaMedie;
import java.time.LocalDateTime;
import java.time.MonthDay;
import java.time.Year;
import java.time.YearMonth;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping(path = "/webcam")
public class WebcamController {

    private final WebcamService fotocameraService;

    public WebcamController(WebcamService fotocameraService) {
        this.fotocameraService = fotocameraService;
    }

    @GetMapping(path = "/all")
    public List<Webcam.WebcamConIdEPosizione> getAll(){
        return fotocameraService.findAllWebcam();
    }

    @GetMapping(path = "/today")
    public List<Webcam.WebcamSenzaMedie> getWebcamToday() {
        List<Webcam.WebcamSenzaMedie> fotocamere = fotocameraService.getWebcamToday();
        for(WebcamSenzaMedie f : fotocamere){
            List<Immagine> tmp = new ArrayList<Immagine>();
            for(Immagine I: f.getImmagini()){
                if(isDateToday(I.getData())){
                    tmp.add(I);
                }
            }
            f.setImmagini(tmp);
        }

        return fotocamere;
    }

    @GetMapping(path = "/medie")
    public List<Webcam> getWebcamTodayMedie(){
        List<Webcam> fotocamere = fotocameraService.getWebcamTodayMedie();
        for(Webcam f : fotocamere){
            List<Immagine> tmp = new ArrayList<Immagine>();
            for(Immagine I: f.getImmagini()){
                if(isDateToday(I.getData())){
                    tmp.add(I);
                }
            }
            f.setImmagini(tmp);
        }

        return fotocamere;
    }

    @PostMapping(path = "/filtrato")
    public List<Webcam> getWebcamFiltrate(@RequestBody List<PostBody> body){
        List<Webcam> fotocamere = fotocameraService.getWebcamFiltrate(body);
        for(Webcam f : fotocamere){
            List<Immagine> tmp = new ArrayList<Immagine>();
            for(Immagine I: f.getImmagini()){
                if(isDateToday(I.getData())){
                    tmp.add(I);
                }
            }
            f.setImmagini(tmp);
        }

        return fotocamere;
    }

    @GetMapping(path = "medieGenerali")
    public Optional<WebcamMedie> getMedieGenerali(){
        return fotocameraService.getMedieGenerali();
    }

    private boolean isDateToday(LocalDateTime time){
        if(time.getDayOfMonth() == MonthDay.now().getDayOfMonth() && time.getMonth() == YearMonth.now().getMonth() && time.getYear() == Year.now().getValue()){
            return true;
        }
        return false;
    }

}
