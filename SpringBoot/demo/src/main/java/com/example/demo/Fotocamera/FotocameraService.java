package com.example.demo.Fotocamera;

import java.util.Optional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.util.List;

@Service
public class FotocameraService {

    private final FotocameraRepository fotocameraRepository;

    @Autowired
    public FotocameraService(FotocameraRepository fotocameraRepository) {
        this.fotocameraRepository = fotocameraRepository;
    }

    public List<Fotocamera> findByToday() {
        return fotocameraRepository.findByToday();
    }

    public List<Fotocamera> getFotocamere() {
        return fotocameraRepository.findAll();
    }
}
