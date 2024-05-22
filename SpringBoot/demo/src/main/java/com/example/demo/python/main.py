import sys
import os
import Detecter

if __name__ == "__main__":
    detector = Detecter.Detector(sys.argv[1])
    detector.detect() # questo printa un json della detection in modo che il server java possa leggerlo