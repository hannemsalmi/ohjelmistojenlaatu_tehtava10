package test;
import kivipaperisakset.Pelaaja;
import kivipaperisakset.Peli;

import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;
import static org.junit.jupiter.api.Assertions.assertEquals;

import java.io.ByteArrayOutputStream;
import java.io.PrintStream;

import org.junit.jupiter.api.Test;

public class PeliTest {

    @Test
    public void testTarkistaVoittajaKiviVsSakset() {
        String voittaja = Peli.tarkistaVoittaja("kivi", "sakset");
        assertEquals("p1", voittaja, "Kiven pitäisi voittaa sakset.");
    }

    @Test
    public void testTarkistaVoittajaPaperiVsKivi() {
        String voittaja = Peli.tarkistaVoittaja("paperi", "kivi");
        assertEquals("p1", voittaja, "Paperin pitäisi voittaa kivi.");
    }

    @Test
    public void testTarkistaVoittajaSaksetVsPaperi() {
        String voittaja = Peli.tarkistaVoittaja("sakset", "paperi");
        assertEquals("p1", voittaja, "Saksien pitäisi voittaa paperi.");
    }

    @Test
    public void testTarkistaVoittajaTasapeli() {
        String voittaja = Peli.tarkistaVoittaja("kivi", "kivi");
        assertEquals("tasapeli", voittaja, "Samankaltaisten valintojen pitäisi johtaa tasapeliin.");
    }
    
    @Test
    public void testTulostaValinnatJaVoitot() {
        Pelaaja p1 = new Pelaaja();
        Pelaaja p2 = new Pelaaja();

        p1.lisaaVoitto();
        String p1Valinta = "kivi";
        String p2Valinta = "paperi";

        ByteArrayOutputStream outContent = new ByteArrayOutputStream();
        System.setOut(new PrintStream(outContent));

        Peli.tulostaValinnatJaVoitot(p1Valinta, p2Valinta);

        String expectedOutput = "Pelaaja 1: kivi\n\tPelaaja 1:llä koossa 0 voittoa.\nPelaaja 2: paperi\n\tPelaaja 2:lla koossa 0 voittoa.";
        
        String actualOutput = outContent.toString().replace("\r\n", "\n").trim();
        
        assertEquals(expectedOutput, actualOutput);

        System.setOut(System.out);
    }


    @Test
    public void testOnkoPeliLoppunut() {
        // Peli ei ole loppunut, jos kummallakaan pelaajalla ei ole kolmea voittoa
        assertFalse(Peli.onkoPeliLoppunut());

        for (int i = 0; i < 3; i++) {
            Peli.p1.lisaaVoitto();
        }

        // Peli on loppunut, kun yhdellä pelaajalla on kolme voittoa
        assertTrue(Peli.onkoPeliLoppunut());
    }
    
    @Test
    public void testPelaaKierros() {
        int alkuTasapelit = Peli.tasapelit;
        int alkuP1Voitot = Peli.p1.getVoitot();
        int alkuP2Voitot = Peli.p2.getVoitot();

        Peli.pelaaKierros();

        boolean muutosTapahtunut = alkuTasapelit != Peli.tasapelit ||
                                  alkuP1Voitot != Peli.p1.getVoitot() ||
                                  alkuP2Voitot != Peli.p2.getVoitot();

        assertTrue("Pelikierroksen jälkeen pelin tilan pitäisi muuttua.", muutosTapahtunut);
    }

}
