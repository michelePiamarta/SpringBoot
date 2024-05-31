import os

def sostituisci_caratteri(nome_file):
    # Divide il nome del file in due parti separate dal carattere "_"
    prima_parte, seconda_parte, terza_parte = nome_file.split("_")

    # Sostituisci il sesto carattere con "5" e l'ottavo carattere con "9" nella seconda parte
    seconda_parte = seconda_parte[:5] + "5" + "27" + seconda_parte[8:]




    # Unisci le due parti per ottenere il nuovo nome del file
    nuovo_nome_file = prima_parte + "_" + seconda_parte + "_" + terza_parte

    return nuovo_nome_file

cartella = "D:\\Studenti\\PIAMARTA.Michele\\Git\\SpringBoot\\SpringBoot\\SpringBoot\\demo\\src\\main\\java\\com\\example\\demo\\ControlloImmagini\\immagini"
# Esempio di utilizzo
for cart in os.listdir(cartella):
    for nome_file in os.listdir(os.path.join(cartella,cart)):
        
            # Ottieni il nuovo nome del file
            print(nome_file)
            nuovo_nome = sostituisci_caratteri(nome_file)

            # Rinomina il file
            vecchio_percorso = os.path.join(os.path.join(cartella,cart), nome_file)
            nuovo_percorso = os.path.join(os.path.join(cartella,cart), nuovo_nome)
            os.rename(vecchio_percorso, nuovo_percorso)
            print(f"File rinominato: {nome_file} -> {nuovo_nome}")

print("Operazione completata!")