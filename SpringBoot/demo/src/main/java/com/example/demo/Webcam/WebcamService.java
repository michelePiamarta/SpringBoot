package com.example.demo.Webcam;

import java.util.Optional;
import org.springframework.stereotype.Service;
import java.util.List;
import java.util.ArrayList;

@Service
public class WebcamService {

    private final WebcamRepository fotocameraRepository;

    public WebcamService(WebcamRepository fotocameraRepository) {
        this.fotocameraRepository = fotocameraRepository;
    }

    public List<Webcam.WebcamConIdEPosizione> findAllWebcam() {
        return fotocameraRepository.findAllWebcam();
    }

    public Optional<Webcam> getWebcamById(Long id) {
        return fotocameraRepository.findById(id);
    }

    public List<Webcam.WebcamSenzaMedie> getWebcamToday(){
        return fotocameraRepository.findWebcamToday();
    }

    public List<Webcam> getWebcamTodayMedie(){
        return fotocameraRepository.findWebcamTodayMedie();
    }

    public List<Webcam> getWebcamFiltrate(List<PostBody> body){
        List<Long> ids = new ArrayList<Long>();
        for(PostBody id : body)
            ids.add(id.id);
        return fotocameraRepository.findWebcamFiltrate(ids);
    }

    public Optional<WebcamMedie> getMedieGenerali(){
        return fotocameraRepository.findMedieGenerali();
    }
}
