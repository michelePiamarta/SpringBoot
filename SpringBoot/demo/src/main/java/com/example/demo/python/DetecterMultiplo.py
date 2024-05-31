from ultralytics import YOLO
import os
class Detector:

    def __init__(self,cam=69,immagini=["D:\\Studenti\\PIAMARTA.Michele\\Git\\SpringBoot\\SpringBoot\\SpringBoot\\demo\\src\\main\\java\\com\\example\\demo\\ControlloImmagini\\immagini\\cam130\\2024428000_20240530195202_cam130.jpg","D:\\Studenti\\PIAMARTA.Michele\\Git\\SpringBoot\\SpringBoot\\SpringBoot\\demo\\src\\main\\java\\com\\example\\demo\\ControlloImmagini\\immagini\\cam124\\2024428000_20240530093602_cam124.jpg"]):
        self.model_path = f'{os.path.dirname(__file__)}\\yolov8n.pt'
        self.dir_path = f'{os.path.dirname(__file__)}\\..\\ControlloImmagini\\immagini\\cam{cam}'
        self.model = YOLO(self.model_path)
        self.idCam = cam
        self.threshold = 0.5
        self.immagini = immagini

    def detect(self):
        for i in self.immagini:
            try:
                #inizializzo le variabili necessarie
                

                #prendo l'immagine più recente
                #print(self.immagine)
                #effettuo il rilevamento delle auto
                #aggiungo al livello di traffico 1 per le auto e 2 per i camion
                results = self.model(self.immagini,conf=self.threshold)
                for result in results:
                    auto = 0
                    camion = 0
                    moto = 0
                    for detection in result:
                        classId = detection.boxes.data[0][5]
                        #se è un'auto
                        if classId== 2.0:
                            auto +=1
                        #se è un camion
                        elif classId == 3.0:
                            moto +=1
                        elif classId == 7.0 or classId == 5.0:
                            camion +=1

                print("Rilevamento effettuato con successo!")

                print(f'{auto} {camion} {moto}')
            except Exception as e:
                print(e)