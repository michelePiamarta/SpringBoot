package com.example.demo.Fotocamera;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import java.util.Optional;
import java.util.List;

@RestController
@RequestMapping(path = "/fotocamera")
public class FotocameraController {

    private final FotocameraService fotocameraService;

    public FotocameraController(FotocameraService fotocameraService) {
        this.fotocameraService = fotocameraService;
    }

    @GetMapping(path = "/oggi")
    public List<Fotocamera> getFotocamera() {
        return fotocameraService.findByToday();
    }

    @GetMapping(path = "/all")
    public List<Fotocamera> getFotocamere() {
        return fotocameraService.getFotocamere();
    }
}
