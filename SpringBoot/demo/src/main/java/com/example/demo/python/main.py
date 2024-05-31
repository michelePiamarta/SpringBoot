import sys
import Detecter
#import DetecterMultiplo
#import time
if __name__ == "__main__":
    detector = Detecter.Detector(sys.argv[2],sys.argv[1]) #sys.argv[2],sys.argv[1]
    detector.detect()
    #detector = DetecterMultiplo.Detector()
    #detector2 = Detecter.Detector(immagine = "D:\\Studenti\\PIAMARTA.Michele\\Git\\SpringBoot\\SpringBoot\\SpringBoot\\demo\\src\\main\\java\\com\\example\\demo\\ControlloImmagini\\immagini\\cam130\\2024428000_20240530195202_cam130.jpg")
    #detector3 = Detecter.Detector(immagine = "D:\\Studenti\\PIAMARTA.Michele\\Git\\SpringBoot\\SpringBoot\\SpringBoot\\demo\\src\\main\\java\\com\\example\\demo\\ControlloImmagini\\immagini\\cam130\\2024428000_20240530195202_cam130.jpg") 
    #start_time_multiplo = time.time()
    #detector2.detect()
    ##detector3.detect()
    ##detector.detect() # questo printa un json della detection in modo che il server java possa leggerlo
    #end_time_multiplo = time.time()
##
    #print(f'tempo esecuzione: {end_time_multiplo-start_time_multiplo}')