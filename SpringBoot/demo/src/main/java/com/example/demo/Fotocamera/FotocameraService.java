package com.example.demo.Fotocamera;

import java.util.Optional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.util.List;
import java.util.ArrayList;

@Service
public class FotocameraService {

    private final FotocameraRepository fotocameraRepository;

    @Autowired
    public FotocameraService(FotocameraRepository fotocameraRepository) {
        this.fotocameraRepository = fotocameraRepository;
    }

    public List<Fotocamera.FotocameraConIdEPosizione> findAllFotocamere() {
        return fotocameraRepository.findAllFotocamere();
    }

    public Optional<Fotocamera> getFotocameraById(Long id) {
        return fotocameraRepository.findById(id);
    }

    public List<Fotocamera.FotocameraSenzaMedie> getFotocamereToday(){
        return fotocameraRepository.findFotocameraToday();
    }

    public List<Fotocamera> getFotocamereTodayMedie(){
        return fotocameraRepository.findFotocameraTodayMedie();
    }

    public List<Fotocamera> getFotocamereFiltrate(List<PostBody> body){
        List<Long> ids = new ArrayList<Long>();
        for(PostBody id : body)
            ids.add(id.id);
        return fotocameraRepository.findFotocamereFiltrate(ids);
    }
}
