package com.example.demo.Fotocamera;

import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class FotocameraConfig {
    @Bean //per dire a spring di eseguire questo metodo all'avvio dell'applicazione
    CommandLineRunner prova(FotocameraRepository repository){
        return args -> {
            //dati di prova
			repository.save(new Fotocamera(2L, "Galleria Rocchetta SS 43 direzione Trento"));
			repository.save(new Fotocamera(4L, "PMV CARRELLATO 836 Strada non specificata"));
			repository.save(new Fotocamera(5L, "PMV CARRELLATO 897 Strada non specificata"));
			repository.save(new Fotocamera(6L, "Moena nord SS 48 direzione Canazei"));
			repository.save(new Fotocamera(8L, "PMV CARRELLATO 834 Strada non specificata"));
			repository.save(new Fotocamera(10L, "St. Castello innesto / Gal. Brozzin SP 232 direzione Egna"));
			repository.save(new Fotocamera(11L, "Castello Molina di Fiemme, innesto dep. SP 232 direzione Predazzo"));
			repository.save(new Fotocamera(30L, "Mollaro SS 43 direzione Cles"));
			repository.save(new Fotocamera(31L, "Cadino SS 12 direzione Bolzano"));
			repository.save(new Fotocamera(32L, "Mostizzolo SS 42 direzione Malè"));
			repository.save(new Fotocamera(34L, "Trento Commerciale (U8) SS 12 direzione Bolzano"));
			repository.save(new Fotocamera(35L, "Piedicastello SUD (U4-U5) SS 12 direzione Verona"));
			repository.save(new Fotocamera(37L, "Borgo Valsugana SS 47 direzione Trento"));
			repository.save(new Fotocamera(39L, "San Cristoforo SS 47 direzione Borgo Valsugana"));
			repository.save(new Fotocamera(40L, "Mezzolombardo Sud SP 235 direzione Trento"));
			repository.save(new Fotocamera(41L, "Mezzolombardo Nord SS 43 direzione Val di Non"));
			repository.save(new Fotocamera(42L, "Mattarello Sud SS 12 direzione Rovereto"));
			repository.save(new Fotocamera(43L, "Campiello SS 47 direzione Padova"));
			repository.save(new Fotocamera(44L, "Totoga SS 50 direzione Imer"));
			repository.save(new Fotocamera(45L, "Predazzo SS 48 direzione Predazzo"));
			repository.save(new Fotocamera(46L, "Trento Est (U10) SS 47 direzione Trento"));
			repository.save(new Fotocamera(47L, "Trento Centro (U6) SS 12 direzione Rovereto"));
			repository.save(new Fotocamera(48L, "Mezzolombardo Campo sportivo SS 43 direzione Val di Non"));
			repository.save(new Fotocamera(49L, "Ravina Cavalcavia SS 12 direzione Rovereto"));
			repository.save(new Fotocamera(50L, "Ravina Cavalcavia SS 12 direzione Bolzano"));
            repository.save(new Fotocamera(51L, "Trento Centro SS 45 bis direzione Cadine"));
            repository.save(new Fotocamera(52L, "Località Martincelli Grigno SS 47 direzione Padova"));
            repository.save(new Fotocamera(53L, "Grigno Ovest SS 47 direzione Padova"));
			repository.save(new Fotocamera(54L, "Trento Commerciale (U7) SS 12 direzione Rovereto"));
			repository.save(new Fotocamera(55L, "Piedicastello SUD (U5) SS 12 direzione Bolzano"));
			repository.save(new Fotocamera(56L, "Cadine SS 45 bis direzione Riva"));
            repository.save(new Fotocamera(60L, "Stazione Castello SS 48 direzione Passo S.Lugano"));
            repository.save(new Fotocamera(61L, "Mori Ovest SS 240 direzione Riva del Garda"));
            repository.save(new Fotocamera(62L, "Mori Est SS 240 direzione Riva del Garda"));
            repository.save(new Fotocamera(63L, "Storo SS 237 direzione direzione Madonna di Campiglio"));
            repository.save(new Fotocamera(64L, "Rotatoria Riva del garda direzione Riva del Garda"));
            repository.save(new Fotocamera(65L, "Tione- Zuclo SS 237 direzione Saone/Ponte Arche/Trento"));
            repository.save(new Fotocamera(66L, "Loppio SS 240 direzione Riva del Garda"));
			repository.save(new Fotocamera(67L, "Passo del Tonale SS 42 direzione Brescia"));
            repository.save(new Fotocamera(68L, "Nago SS 240 direzione Passo San Giovanni/Mori/Rovereto"));
            repository.save(new Fotocamera(69L, "Pergine Centro SS 47 direzione Trento"));
            repository.save(new Fotocamera(70L, "Uscita Lavis SP 235 direzione Bolzano"));
            repository.save(new Fotocamera(71L, "Marter SS 47 direzione Trento"));
			repository.save(new Fotocamera(72L, "Mattarello Sud SS 12 direzione Trento"));
			repository.save(new Fotocamera(73L, "Vason SP 85 direzione Viote"));
			repository.save(new Fotocamera(74L, "Candriai SP 85 direzione Trento"));
			repository.save(new Fotocamera(75L, "Passo Prodoi SS 48 direzione Canazei"));
            repository.save(new Fotocamera(76L, "Passo Sella SS 242 direzione Canazei"));
            repository.save(new Fotocamera(77L, "Passo San Pellegrino SS 346 direzione Moena"));
            repository.save(new Fotocamera(78L, "Passo Lavaze SS 620 direzione Cavalese"));
            repository.save(new Fotocamera(79L, "Lifano SS 240 direzione Riva del Garda"));
            repository.save(new Fotocamera(80L, "Passo Cereda SS 347 direzione Passo Cereda"));
            repository.save(new Fotocamera(81L, "Passo Rolle SS 50 direzione Passo Rolle"));
            repository.save(new Fotocamera(82L, "Cirè-Civezzano SS 47 direzione Pergine"));
            repository.save(new Fotocamera(83L, "Madonna di Campiglio SS 239 direzione Passo C.C. Magno"));
			repository.save(new Fotocamera(84L, "Passo Mendola SS 42 direzione Bolzano"));
			repository.save(new Fotocamera(85L, "Cadine SS 45 bis direzione Riva del Garda"));
			repository.save(new Fotocamera(86L, "Passo Ballino SS 421 direzione Fiavè"));
			repository.save(new Fotocamera(87L, "San Martino di Castrozza SS 50 direzione Fiera di Primiero"));
			repository.save(new Fotocamera(88L, "PMV CARRELLATO 1014 strada non specificata"));
			repository.save(new Fotocamera(89L, "PMV CARRELLATO 948 strada non specificata"));
            repository.save(new Fotocamera(90L, "PMV CARRELLATO 951 strada non specificata"));
            repository.save(new Fotocamera(91L, "PMV CARRELLATO 950 strada non specificata"));
            repository.save(new Fotocamera(92L, "Margone SP 18 direzione Vezzano"));
            repository.save(new Fotocamera(93L, "Passo San Pellegrino SS 346 direzione Passo San Pellegrino"));
            repository.save(new Fotocamera(94L, "Passo Broccon SP 79 direzione Passo Broccon"));
			repository.save(new Fotocamera(95L, "Taio Nord SS 43 direzione Cles"));
			repository.save(new Fotocamera(96L, "Andalo SP 64 direzione Andalo"));
			repository.save(new Fotocamera(97L, "Lagolo SP 85 direzione Lagolo"));
            repository.save(new Fotocamera(98L, "Pian delle Fugazze SS 46 direzione Pian delle Fugazze"));
            repository.save(new Fotocamera(99L, "San Valentino SP 03 direzione San Valentino"));
            repository.save(new Fotocamera(100L, "Passo Coe SP 143 direzione Passo Coe"));
            repository.save(new Fotocamera(101L, "Passo Predaia SP 13 direzione Passo Predaia"));
            repository.save(new Fotocamera(102L, "Sporminore SP 67 direzione Sporminore"));
            repository.save(new Fotocamera(103L, "Passo Gobbera SP 79 direzione Canal San Bovo"));
            repository.save(new Fotocamera(104L, "Sega di Ala SP 211"));
            repository.save(new Fotocamera(105L, "Vigo Cavedine SP 84 direzione Trento"));
            repository.save(new Fotocamera(106L, "Folgaria SS 350 direzione Passo Sommo"));
            repository.save(new Fotocamera(107L, "Bellaria SP 20 direzione Aldeno"));
            repository.save(new Fotocamera(108L, "Casa Cantoniera SS 421 direzione Andalo"));
            repository.save(new Fotocamera(109L, "Pra Alpesina SP 230 direzione Pra Alpesina"));
            repository.save(new Fotocamera(110L, "Passo Fedaia SS 641 direzione Passo Fedaia"));
            repository.save(new Fotocamera(111L, "Passo CostaLunga SP 241 direzione Passo CostaLunga"));
            repository.save(new Fotocamera(112L, "Passo Valles SP 81 direzione Passo Valles"));
            repository.save(new Fotocamera(113L, "Mazzin SS 48 direzione Mazzin"));
            repository.save(new Fotocamera(114L, "Terme di Rabbi SP 86 direzione Terme di Rabbi"));
            repository.save(new Fotocamera(115L, "Marileva 1400 SP 206 direzione Marileva 1400"));
            repository.save(new Fotocamera(116L, "Pejo fonti SP 87 direzione Pejo Fonti"));
            repository.save(new Fotocamera(117L, "Rumo SP 6 direzione Rumo"));
            repository.save(new Fotocamera(118L, "Amola SP 127 direzione Ledro"));
            repository.save(new Fotocamera(119L, "Tremalzo SP 127 direzione Passo Tremalzo"));
            repository.save(new Fotocamera(120L, "Vigolo Vattaro SS 349 direzione Vigolo Vattaro"));
            repository.save(new Fotocamera(121L, "Sant'Antonio di Mavignola SS 239 direzione Madonna di Campiglio"));
            repository.save(new Fotocamera(122L, "Pracul SP 27 direzione Val Daone"));
            repository.save(new Fotocamera(123L, "Bondone SP 69 direzione Bondone"));
            repository.save(new Fotocamera(124L, "Passo Duron SP 222 direzione Zuclo"));
            repository.save(new Fotocamera(125L, "Passo Sommo SS 350 direzione Folgaria"));
            repository.save(new Fotocamera(126L, "Serrada SP 02 direzione Serrada"));
            repository.save(new Fotocamera(127L, "PMV CARRELLATO 1122 strada non specificata"));
            repository.save(new Fotocamera(128L, "PMV CARRELLATO 1123 strada non specificata"));
            repository.save(new Fotocamera(129L, "Passo C.C. Magno SS 239 direzione Madonna di Campiglio"));
            repository.save(new Fotocamera(130L, "Ortisè SP 140 direzione Ortisè"));
            repository.save(new Fotocamera(132L, "Compet SP 12 direzione Panarotta"));
            repository.save(new Fotocamera(133L, "Kamuz SP 135 direzione Frassilongo"));
        };
    }
}
