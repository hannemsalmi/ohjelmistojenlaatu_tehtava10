package kivipaperisakset;

/**
 * Luokka sisältää logiikan kivi-paperi-sakset -pelin pelaamiseen.
 * Peli koostuu kahdesta pelaajasta ja pelikierroksista, joita pelataan, kunnes yksi pelaajista voittaa.
 */
public class Peli {

    public static Pelaaja p1 = new Pelaaja();
    public static Pelaaja p2 = new Pelaaja();
    private static int pelatutPelit = 0;
    public static int tasapelit = 0;

    /**
     * Päämetodi, joka käynnistää pelin ja suorittaa pelikierroksia, kunnes peli päättyy.
     */
    public static void main(String args[]) {
        while (!onkoPeliLoppunut()) {
            pelaaKierros();
        }

        System.out.println("KOLME VOITTOA - PELI PÄÄTTYY");
    }

    /**
     * Suorittaa yhden pelikierroksen, jossa molemmat pelaajat tekevät valinnan.
     * Tarkistaa kierroksen voittajan ja päivittää voittojen ja tasapelien määrää.
     */
    public static void pelaaKierros() {
        System.out.println("Erä: " + pelatutPelit + " =====================\n");
        System.out.println("Tasapelien lukumäärä: " + tasapelit + "\n");

        String p1Valinta = p1.pelaajanValinta();
        String p2Valinta = p2.pelaajanValinta();

        tulostaValinnatJaVoitot(p1Valinta, p2Valinta);

        String voittaja = tarkistaVoittaja(p1Valinta, p2Valinta);

        //Päivitetään voittojen ja tasapelien määrä
        if (voittaja.equals("p1")) {
            p1.lisaaVoitto();
        } else if (voittaja.equals("p2")) {
            p2.lisaaVoitto();
        } else {
            tasapelit++;
        }

        pelatutPelit++;
    }

    /**
     * Tarkistaa kierroksen voittajan vertaamalla pelaajien valintoja.
     * 
     * @param p1Valinta Ensimmäisen pelaajan valinta.
     * @param p2Valinta Toisen pelaajan valinta.
     * @return Voittajan tunnus ("p1" tai "p2") tai "tasapeli".
     */
    public static String tarkistaVoittaja(String p1Valinta, String p2Valinta) {
        if (p1Valinta.equals(p2Valinta)) {
            return "tasapeli";
        } else if ((p1Valinta.equals("kivi") && p2Valinta.equals("sakset")) ||
                   (p1Valinta.equals("paperi") && p2Valinta.equals("kivi")) ||
                   (p1Valinta.equals("sakset") && p2Valinta.equals("paperi"))) {
            return "p1";
        } else {
            return "p2";
        }
    }

    /**
     * Tulostaa kummankin pelaajan valinnan ja voittojen määrän.
     *
     * @param p1Valinta Ensimmäisen pelaajan valinta.
     * @param p2Valinta Toisen pelaajan valinta.
     */
    public static void tulostaValinnatJaVoitot(String p1Valinta, String p2Valinta) {
        System.out.println("Pelaaja 1: " + p1Valinta + "\n\tPelaaja 1:llä koossa " + p1.getVoitot() + " voittoa.");
        System.out.println("Pelaaja 2: " + p2Valinta + "\n\tPelaaja 2:lla koossa " + p2.getVoitot() + " voittoa.");
    }

    /**
     * Tarkistaa, onko peli loppunut katsomalla, onko jommalla kummalla pelaajista 3 voittoa.
     * 
     * @return Tosi, jos peli on loppunut; muuten epätosi.
     */
    public static boolean onkoPeliLoppunut() {
        return p1.getVoitot() >= 3 || p2.getVoitot() >= 3;
    }
}