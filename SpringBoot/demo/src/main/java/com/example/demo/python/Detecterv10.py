from ultralytics import YOLO
import os
from pathlib import Path

class Detector:

    def __init__(self, cam=69, immagine="D:\\Studenti\\PIAMARTA.Michele\\Git\\SpringBoot\\SpringBoot\\SpringBoot\\demo\\src\\main\\java\\com\\example\\demo\\ControlloImmagini\\immagini\\cam69\\2024428000_20240529083302_cam69.jpg"):
        self.model_path = f'{os.path.dirname(__file__)}\\yolov10n.pt'  # Updated model path
        self.dir_path = f'{os.path.dirname(__file__)}\\..\\ControlloImmagini\\immagini\\cam{cam}'
        self.model = YOLO(self.model_path)  # Using YOLOv10n
        self.idCam = cam
        self.threshold = 0.5
        self.immagine = immagine

    def detect(self):
        try:
            # Initialize necessary variables
            auto = 0
            camion = 0
            moto = 0
            print(self.model.names)
            # Get the most recent image
            print(self.immagine)
            # Perform vehicle detection
            # Add 1 to traffic level for cars and 2 for trucks
            results = self.model(self.immagine, conf=self.threshold)
            for result in results:
                for detection in result:
                    classId = detection.boxes.data[0][5]
                    # If it's a car
                    if classId == 2.0:
                        auto += 1
                    # If it's a truck
                    elif classId == 3.0:
                        moto += 1
                    elif classId == 7.0 or classId == 5.0:
                        camion += 1

            print("Detection completed successfully!")
            print(f'{auto} {camion} {moto}')
        except Exception as e:
            print(e)
