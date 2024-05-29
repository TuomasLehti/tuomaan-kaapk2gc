package fi.tuomaan.joukkoliikenne.sovellukset.kaapk2gc.icskirjoittaja;

import static org.junit.Assert.assertEquals;
import java.time.LocalDateTime;
import java.time.ZoneId;
import org.junit.Test;

import biweekly.component.VEvent;
import fi.tuomaan.joukkoliikenne.koivistonauto.ajopaivakirja.Aika;
import fi.tuomaan.joukkoliikenne.koivistonauto.ajopaivakirja.AikaPaikka;
import fi.tuomaan.joukkoliikenne.koivistonauto.ajopaivakirja.Ajopala;
import fi.tuomaan.joukkoliikenne.koivistonauto.ajopaivakirja.AjopalanTyyppi;

public class TestIcsAjopalaMuuttaja 
{

    @Test
    public void test_Kuvaus_Linjaajo()
    {
        final LocalDateTime ALOITUS_AIKA = LocalDateTime.of(2024,5,29,19,40);
        final LocalDateTime LOPETUS_AIKA = LocalDateTime.of(2024,5,29,21,25);
        final String ALOITUS_PAIKKA = "Porvoon tori";
        final String LOPETUS_PAIKKA = "Porvoon sairaala";
        final String SUUNTA = "s2";
        final String PO_KUVAUS = ALOITUS_PAIKKA + " " + SUUNTA + "–" + LOPETUS_PAIKKA;
        final String PO_OTSIKKO = "Linja-ajoa, vuoro 134, linja 1";

        Ajopala ajopala = new Ajopala(
            AjopalanTyyppi.LINJA_AJOA, 
            new AikaPaikka(
                new Aika(ALOITUS_AIKA),
                ALOITUS_PAIKKA
            ), 
            new AikaPaikka(
                new Aika(LOPETUS_AIKA),
                LOPETUS_PAIKKA
            ),
            "1",
            "134",
            2
        );
        VEvent event = IcsAjopalaMuuttaja.muuta(ajopala);

        assertEquals(ALOITUS_AIKA, LocalDateTime.ofInstant(event.getDateStart().getValue().toInstant(), ZoneId.systemDefault()));
        assertEquals(LOPETUS_AIKA, LocalDateTime.ofInstant(event.getDateEnd().getValue().toInstant(), ZoneId.systemDefault()));
        assertEquals(PO_KUVAUS, event.getDescription().getValue());
        assertEquals(PO_OTSIKKO, event.getSummary().getValue());
    }

    @Test
    public void test_Kuvaus_Linjaajo_Suunnaton()
    {
        final LocalDateTime ALOITUS_AIKA = LocalDateTime.of(2024,5,29,15,20);
        final LocalDateTime LOPETUS_AIKA = LocalDateTime.of(2024,5,29,18,30);
        final String ALOITUS_PAIKKA = "Tolkkinen";
        final String LOPETUS_PAIKKA = "Hamari";
        final String PO_KUVAUS = ALOITUS_PAIKKA + "–" + LOPETUS_PAIKKA;
        final String PO_OTSIKKO = "Linja-ajoa, vuoro 134, linjat 1, 2";

        Ajopala ajopala = new Ajopala(
            AjopalanTyyppi.LINJA_AJOA, 
            new AikaPaikka(
                new Aika(ALOITUS_AIKA),
                ALOITUS_PAIKKA
            ), 
            new AikaPaikka(
                new Aika(LOPETUS_AIKA),
                LOPETUS_PAIKKA
            ),
            "1, 2",
            "134",
            -1
        );
        VEvent event = IcsAjopalaMuuttaja.muuta(ajopala);

        assertEquals(ALOITUS_AIKA, LocalDateTime.ofInstant(event.getDateStart().getValue().toInstant(), ZoneId.systemDefault()));
        assertEquals(LOPETUS_AIKA, LocalDateTime.ofInstant(event.getDateEnd().getValue().toInstant(), ZoneId.systemDefault()));
        assertEquals(PO_KUVAUS, event.getDescription().getValue());
        assertEquals(PO_OTSIKKO, event.getSummary().getValue());
    }
    
    @Test
    public void test_SiirtoajoLinjaautolla()
    {
        final LocalDateTime ALOITUS_AIKA = LocalDateTime.of(2024,5,29,15,8);
        final LocalDateTime LOPETUS_AIKA = LocalDateTime.of(2024,5,29,18,20);
        final String ALOITUS_PAIKKA = "Porvoo";
        final String LOPETUS_PAIKKA = "Tolkkinen";
        final String PO_KUVAUS = ALOITUS_PAIKKA + "–" + LOPETUS_PAIKKA;
        final String PO_OTSIKKO = "Siirtoajo linja-autolla";

        Ajopala ajopala = new Ajopala(
            AjopalanTyyppi.SIIRTOAJO, 
            new AikaPaikka(
                new Aika(ALOITUS_AIKA),
                ALOITUS_PAIKKA
            ), 
            new AikaPaikka(
                new Aika(LOPETUS_AIKA),
                LOPETUS_PAIKKA
            ),
            "1, 2",
            "132",
            -1
        );
        VEvent event = IcsAjopalaMuuttaja.muuta(ajopala);

        assertEquals(ALOITUS_AIKA, LocalDateTime.ofInstant(event.getDateStart().getValue().toInstant(), ZoneId.systemDefault()));
        assertEquals(LOPETUS_AIKA, LocalDateTime.ofInstant(event.getDateEnd().getValue().toInstant(), ZoneId.systemDefault()));
        assertEquals(PO_KUVAUS, event.getDescription().getValue());
        assertEquals(PO_OTSIKKO, event.getSummary().getValue());

    }

}
