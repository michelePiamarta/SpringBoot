package com.example.demo.Webcam;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import com.example.demo.Immagine.Immagine;
import com.example.demo.Immagine.ImmagineRepository;

import java.time.LocalDateTime;

@Configuration
public class WebcamConfig {

    private ImmagineRepository immagineRepository;

    @Autowired
    public WebcamConfig(ImmagineRepository immagineRepository){
        this.immagineRepository = immagineRepository;
    }

    @Bean //per dire a spring di eseguire questo metodo all'avvio dell'applicazione
    CommandLineRunner configurazioneFotocamere(WebcamRepository repository){
        return args -> {
			repository.save(new Webcam(2L, "Galleria Rocchetta SS 43 direzione Trento"));
			repository.save(new Webcam(4L, "PMV CARRELLATO 836 Strada non specificata"));
			repository.save(new Webcam(5L, "PMV CARRELLATO 897 Strada non specificata"));
			repository.save(new Webcam(6L, "Moena nord SS 48 direzione Canazei"));
			repository.save(new Webcam(8L, "PMV CARRELLATO 834 Strada non specificata"));
			repository.save(new Webcam(10L, "St. Castello innesto / Gal. Brozzin SP 232 direzione Egna"));
			repository.save(new Webcam(11L, "Castello Molina di Fiemme, innesto dep. SP 232 direzione Predazzo"));
			repository.save(new Webcam(30L, "Mollaro SS 43 direzione Cles"));
			repository.save(new Webcam(31L, "Cadino SS 12 direzione Bolzano"));
			repository.save(new Webcam(32L, "Mostizzolo SS 42 direzione Malè"));
			repository.save(new Webcam(34L, "Trento Commerciale (U8) SS 12 direzione Bolzano"));
			repository.save(new Webcam(35L, "Piedicastello SUD (U4-U5) SS 12 direzione Verona"));
			repository.save(new Webcam(37L, "Borgo Valsugana SS 47 direzione Trento"));
			repository.save(new Webcam(39L, "San Cristoforo SS 47 direzione Borgo Valsugana"));
			repository.save(new Webcam(40L, "Mezzolombardo Sud SP 235 direzione Trento"));
			repository.save(new Webcam(41L, "Mezzolombardo Nord SS 43 direzione Val di Non"));
			repository.save(new Webcam(42L, "Mattarello Sud SS 12 direzione Rovereto"));
			repository.save(new Webcam(43L, "Campiello SS 47 direzione Padova"));
			repository.save(new Webcam(44L, "Totoga SS 50 direzione Imer"));
			repository.save(new Webcam(45L, "Predazzo SS 48 direzione Predazzo"));
			repository.save(new Webcam(46L, "Trento Est (U10) SS 47 direzione Trento"));
			repository.save(new Webcam(47L, "Trento Centro (U6) SS 12 direzione Rovereto"));
			repository.save(new Webcam(48L, "Mezzolombardo Campo sportivo SS 43 direzione Val di Non"));
			repository.save(new Webcam(49L, "Ravina Cavalcavia SS 12 direzione Rovereto"));
			repository.save(new Webcam(50L, "Ravina Cavalcavia SS 12 direzione Bolzano"));
            repository.save(new Webcam(51L, "Trento Centro SS 45 bis direzione Cadine"));
            repository.save(new Webcam(52L, "Località Martincelli Grigno SS 47 direzione Padova"));
            repository.save(new Webcam(53L, "Grigno Ovest SS 47 direzione Padova"));
			repository.save(new Webcam(54L, "Trento Commerciale (U7) SS 12 direzione Rovereto"));
			repository.save(new Webcam(55L, "Piedicastello SUD (U5) SS 12 direzione Bolzano"));
			repository.save(new Webcam(56L, "Cadine SS 45 bis direzione Riva"));
            repository.save(new Webcam(60L, "Stazione Castello SS 48 direzione Passo S.Lugano"));
            repository.save(new Webcam(61L, "Mori Ovest SS 240 direzione Riva del Garda"));
            repository.save(new Webcam(62L, "Mori Est SS 240 direzione Riva del Garda"));
            repository.save(new Webcam(63L, "Storo SS 237 direzione direzione Madonna di Campiglio"));
            repository.save(new Webcam(64L, "Rotatoria Riva del garda direzione Riva del Garda"));
            repository.save(new Webcam(65L, "Tione- Zuclo SS 237 direzione Saone/Ponte Arche/Trento"));
            repository.save(new Webcam(66L, "Loppio SS 240 direzione Riva del Garda"));
			repository.save(new Webcam(67L, "Passo del Tonale SS 42 direzione Brescia"));
            repository.save(new Webcam(68L, "Nago SS 240 direzione Passo San Giovanni/Mori/Rovereto"));
            repository.save(new Webcam(69L, "Pergine Centro SS 47 direzione Trento"));
            repository.save(new Webcam(70L, "Uscita Lavis SP 235 direzione Bolzano"));
            repository.save(new Webcam(71L, "Marter SS 47 direzione Trento"));
			repository.save(new Webcam(72L, "Mattarello Sud SS 12 direzione Trento"));
			repository.save(new Webcam(73L, "Vason SP 85 direzione Viote"));
			repository.save(new Webcam(74L, "Candriai SP 85 direzione Trento"));
			repository.save(new Webcam(75L, "Passo Prodoi SS 48 direzione Canazei"));
            repository.save(new Webcam(76L, "Passo Sella SS 242 direzione Canazei"));
            repository.save(new Webcam(77L, "Passo San Pellegrino SS 346 direzione Moena"));
            repository.save(new Webcam(78L, "Passo Lavaze SS 620 direzione Cavalese"));
            repository.save(new Webcam(79L, "Lifano SS 240 direzione Riva del Garda"));
            repository.save(new Webcam(80L, "Passo Cereda SS 347 direzione Passo Cereda"));
            repository.save(new Webcam(81L, "Passo Rolle SS 50 direzione Passo Rolle"));
            repository.save(new Webcam(82L, "Cirè-Civezzano SS 47 direzione Pergine"));
            repository.save(new Webcam(83L, "Madonna di Campiglio SS 239 direzione Passo C.C. Magno"));
			repository.save(new Webcam(84L, "Passo Mendola SS 42 direzione Bolzano"));
			repository.save(new Webcam(85L, "Cadine SS 45 bis direzione Riva del Garda"));
			repository.save(new Webcam(86L, "Passo Ballino SS 421 direzione Fiavè"));
			repository.save(new Webcam(87L, "San Martino di Castrozza SS 50 direzione Fiera di Primiero"));
			repository.save(new Webcam(88L, "PMV CARRELLATO 1014 strada non specificata"));
			repository.save(new Webcam(89L, "PMV CARRELLATO 948 strada non specificata"));
            repository.save(new Webcam(90L, "PMV CARRELLATO 951 strada non specificata"));
            repository.save(new Webcam(91L, "PMV CARRELLATO 950 strada non specificata"));
            repository.save(new Webcam(92L, "Margone SP 18 direzione Vezzano"));
            repository.save(new Webcam(93L, "Passo San Pellegrino SS 346 direzione Passo San Pellegrino"));
            repository.save(new Webcam(94L, "Passo Broccon SP 79 direzione Passo Broccon"));
			repository.save(new Webcam(95L, "Taio Nord SS 43 direzione Cles"));
			repository.save(new Webcam(96L, "Andalo SP 64 direzione Andalo"));
			repository.save(new Webcam(97L, "Lagolo SP 85 direzione Lagolo"));
            repository.save(new Webcam(98L, "Pian delle Fugazze SS 46 direzione Pian delle Fugazze"));
            repository.save(new Webcam(99L, "San Valentino SP 03 direzione San Valentino"));
            repository.save(new Webcam(100L, "Passo Coe SP 143 direzione Passo Coe"));
            repository.save(new Webcam(101L, "Passo Predaia SP 13 direzione Passo Predaia"));
            repository.save(new Webcam(102L, "Sporminore SP 67 direzione Sporminore"));
            repository.save(new Webcam(103L, "Passo Gobbera SP 79 direzione Canal San Bovo"));
            repository.save(new Webcam(104L, "Sega di Ala SP 211"));
            repository.save(new Webcam(105L, "Vigo Cavedine SP 84 direzione Trento"));
            repository.save(new Webcam(106L, "Folgaria SS 350 direzione Passo Sommo"));
            repository.save(new Webcam(107L, "Bellaria SP 20 direzione Aldeno"));
            repository.save(new Webcam(108L, "Casa Cantoniera SS 421 direzione Andalo"));
            repository.save(new Webcam(109L, "Pra Alpesina SP 230 direzione Pra Alpesina"));
            repository.save(new Webcam(110L, "Passo Fedaia SS 641 direzione Passo Fedaia"));
            repository.save(new Webcam(111L, "Passo CostaLunga SP 241 direzione Passo CostaLunga"));
            repository.save(new Webcam(112L, "Passo Valles SP 81 direzione Passo Valles"));
            repository.save(new Webcam(113L, "Mazzin SS 48 direzione Mazzin"));
            repository.save(new Webcam(114L, "Terme di Rabbi SP 86 direzione Terme di Rabbi"));
            repository.save(new Webcam(115L, "Marileva 1400 SP 206 direzione Marileva 1400"));
            repository.save(new Webcam(116L, "Pejo fonti SP 87 direzione Pejo Fonti"));
            repository.save(new Webcam(117L, "Rumo SP 6 direzione Rumo"));
            repository.save(new Webcam(118L, "Amola SP 127 direzione Ledro"));
            repository.save(new Webcam(119L, "Tremalzo SP 127 direzione Passo Tremalzo"));
            repository.save(new Webcam(120L, "Vigolo Vattaro SS 349 direzione Vigolo Vattaro"));
            repository.save(new Webcam(121L, "Sant'Antonio di Mavignola SS 239 direzione Madonna di Campiglio"));
            repository.save(new Webcam(122L, "Pracul SP 27 direzione Val Daone"));
            repository.save(new Webcam(123L, "Bondone SP 69 direzione Bondone"));
            repository.save(new Webcam(124L, "Passo Duron SP 222 direzione Zuclo"));
            repository.save(new Webcam(125L, "Passo Sommo SS 350 direzione Folgaria"));
            repository.save(new Webcam(126L, "Serrada SP 02 direzione Serrada"));
            repository.save(new Webcam(127L, "PMV CARRELLATO 1122 strada non specificata"));
            repository.save(new Webcam(128L, "PMV CARRELLATO 1123 strada non specificata"));
            repository.save(new Webcam(129L, "Passo C.C. Magno SS 239 direzione Madonna di Campiglio"));
            repository.save(new Webcam(130L, "Ortisè SP 140 direzione Ortisè"));
            repository.save(new Webcam(132L, "Compet SP 12 direzione Panarotta"));
            repository.save(new Webcam(133L, "Kamuz SP 135 direzione Frassilongo"));

            /// dati fittizi per prove ///
            //immagineRepository.save(new Immagine(3,2,5,LocalDateTime.of(2024,3,21,12,0,13),repository.findById(69L).get()));
            //immagineRepository.save(new Immagine(7,3,1,LocalDateTime.of(2024,4,28,12,40,03),repository.findById(69L).get()));
            //immagineRepository.save(new Immagine(6,8,3,LocalDateTime.of(2024,5,22,13,0,27),repository.findById(34L).get()));
            //immagineRepository.save(new Immagine(6,8,3,LocalDateTime.of(2024,5,22,13,0,27),repository.findById(97L).get()));
            //immagineRepository.save(new Immagine(6,8,3,LocalDateTime.of(2024,5,22,13,0,27),repository.findById(88L).get()));
            //immagineRepository.save(new Immagine(9,3,1,LocalDateTime.of(2024,5,22,15,20,27),repository.findById(88L).get()));
            //immagineRepository.save(new Immagine(2,4,0,LocalDateTime.of(2024,5,22,15,50,47),repository.findById(88L).get()));
            //immagineRepository.save(new Immagine(1,7,2,LocalDateTime.of(2024,5,22,15,12,59),repository.findById(88L).get()));
            //immagineRepository.save(new Immagine(1,7,2,LocalDateTime.of(2024,5,24,15,32,59),repository.findById(98L).get()));
            //immagineRepository.save(new Immagine(1,7,2,LocalDateTime.of(2024,5,24,19,12,59),repository.findById(108L).get()));
            //immagineRepository.save(new Immagine(1,7,2,LocalDateTime.of(2024,5,24,15,12,59),repository.findById(5L).get()));
            //immagineRepository.save(new Immagine(1,7,2,LocalDateTime.of(2024,5,24,15,12,59),repository.findById(2L).get()));
            //immagineRepository.save(new Immagine(1,7,2,LocalDateTime.of(2024,5,24,15,12,59),repository.findById(2L).get()));
        };
    }
}
