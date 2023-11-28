package test;

import kivipaperisakset.Pelaaja;
import static org.junit.jupiter.api.Assertions.*;
import org.junit.jupiter.api.Test;

public class PelaajaTest {

    @Test
    public void testLisaaVoitto() {
        Pelaaja pelaaja = new Pelaaja();
        pelaaja.lisaaVoitto();
        assertEquals(1, pelaaja.getVoitot(), "Pelaajan voittojen määrän pitäisi kasvaa yhdellä.");
    }

    @Test
    public void testGetVoitot() {
        Pelaaja pelaaja = new Pelaaja();
        assertEquals(0, pelaaja.getVoitot(), "Uuden pelaajan voittojen määrän pitäisi olla 0.");
    }

    @Test
    public void testPelaajanValinta() {
        Pelaaja pelaaja = new Pelaaja();
        String valinta = pelaaja.pelaajanValinta();
        assertTrue(valinta.equals("kivi") || valinta.equals("paperi") || valinta.equals("sakset"),
                   "Pelaajan valinnan pitäisi olla joko 'kivi', 'paperi', tai 'sakset'.");
    }

    @Test
    public void testPelaajanValinnanSatunnaisuus() {
        Pelaaja pelaaja = new Pelaaja();
        int kivi = 0, paperi = 0, sakset = 0;

        for (int i = 0; i < 1000; i++) {
            String valinta = pelaaja.pelaajanValinta();
            switch (valinta) {
                case "kivi":
                    kivi++;
                    break;
                case "paperi":
                    paperi++;
                    break;
                case "sakset":
                    sakset++;
                    break;
            }
        }

        assertTrue(kivi > 0 && paperi > 0 && sakset > 0,
                   "Valintojen 'kivi', 'paperi', ja 'sakset' pitäisi kaikkien esiintyä useita kertoja.");
    }
}
