package com.example.demo.Fotocamera;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
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

    @PostMapping(path = "/id")
    public void getFotocameraById(@RequestBody Prova[] id) {
        System.out.println(id[0].toString());
    }
}
