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

    @GetMapping(path = "/all")
    public List<Fotocamera.FotocameraConIdEPosizione> getAll(){
        return fotocameraService.findAllFotocamere();
    }

    @GetMapping(path = "/today")
    public List<Fotocamera.FotocameraSenzaMedie> getFotocamereToday() {
        return fotocameraService.getFotocamereToday();
    }

    @GetMapping(path = "/medie")
    public List<Fotocamera> getFotocamereTodayMedie(){
        return fotocameraService.getFotocamereTodayMedie();
    }

    @PostMapping(path = "/filtrato")
    public List<Fotocamera> getFotocamereFiltrate(@RequestBody List<PostBody> body){
        return fotocameraService.getFotocamereFiltrate(body);
    }
}
