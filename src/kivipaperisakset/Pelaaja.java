package kivipaperisakset;

/**
 * Luokka edustaa yksittäistä pelaajaa kivi-paperi-sakset -pelissä.
 * Pelaajalla on voittojen lukumäärä ja kyky tehdä valintoja pelissä.
 */
public class Pelaaja {

    private int voitot;

    /**
     * Luo uuden pelaajan alustamalla voittojen määrän nollaksi.
     */
    public Pelaaja() {
        this.voitot = 0;
    }

    /**
     * Arpoo ja palauttaa pelaajan valinnan pelissä.
     * Valinnat ovat "kivi", "paperi" tai "sakset".
     *
     * @return Arvottu valinta merkkijonona.
     */
    public String pelaajanValinta() {
        String[] vaihtoehdot = { "kivi", "paperi", "sakset" };
        int indeksi = (int) (Math.random() * 3);
        return vaihtoehdot[indeksi];
    }

    /**
     * Lisää pelaajalle yhden voiton.
     *
     * @return Pelaajan uusi voittojen kokonaismäärä.
     */
    public int lisaaVoitto() {
        voitot++;
        return voitot;
    }

    /**
     * Palauttaa pelaajan voittojen kokonaismäärän.
     *
     * @return Pelaajan voittojen määrä.
     */
    public int getVoitot() {
        return voitot;
    }
}