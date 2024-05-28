package com.example.demo.Webcam;

public class WebcamMedie {
    private Double mediaGeneraleMacchine;
    private Double mediaGeneraleCamion;
    private Double mediaGeneraleMoto;

    public WebcamMedie(Double mediaGeneraleMacchine, Double mediaGeneraleCamion, Double mediaGeneraleMoto) {
        this.mediaGeneraleCamion = mediaGeneraleCamion;
        this.mediaGeneraleMacchine = mediaGeneraleMacchine;
        this.mediaGeneraleMoto = mediaGeneraleMoto;
    }

    public Double getMediaGeneraleVeicoli() {
        Double veicoli = 0d;
        if(this.mediaGeneraleCamion != null){
            veicoli+=this.mediaGeneraleCamion;
        }
        if(this.mediaGeneraleMacchine != null){
            veicoli+=this.mediaGeneraleMacchine;
        }
        if(this.mediaGeneraleMoto != null){
            veicoli+=this.mediaGeneraleMoto;
        }
        return veicoli==0 ? null : veicoli;
    }

    public Double getMediaGeneraleMacchine() {
        return this.mediaGeneraleMacchine;
    }

    public Double getMediaGeneraleCamion() {
        return this.mediaGeneraleCamion;
    }

    public Double getMediaGeneraleMoto() {
        return this.mediaGeneraleMoto;
    }

    public void setMediaGeneraleMacchine(Double mediaGeneraleMacchine) {
        this.mediaGeneraleMacchine = mediaGeneraleMacchine;
    }

    public void setMediaGeneraleMoto(Double mediaGeneraleMoto) {
        this.mediaGeneraleMoto = mediaGeneraleMoto;
    }

    public void setMediaGeneraleCamion(Double mediaGeneraleCamion) {
        this.mediaGeneraleCamion = mediaGeneraleCamion;
    }
}
