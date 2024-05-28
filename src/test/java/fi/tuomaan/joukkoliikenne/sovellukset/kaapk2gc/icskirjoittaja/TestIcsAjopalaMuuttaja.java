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
    public void test_Linjaajo()
    {
        final LocalDateTime ALOITUS_AIKA = LocalDateTime.of(2024,5,29,15,20);
        final LocalDateTime LOPETUS_AIKA = LocalDateTime.of(2024,5,29,18,30);
        final String ALOITUS_PAIKKA = "Tolkkinen";
        final String LOPETUS_PAIKKA = "Hamari";
        final String PO_PAIKAT = ALOITUS_PAIKKA + "–" + LOPETUS_PAIKKA;

        Ajopala ajopala = new Ajopala(
            AjopalanTyyppi.LINJA_AJOA, 
            new AikaPaikka(
                new Aika(ALOITUS_AIKA),
                "Tolkkinen"
            ), 
            new AikaPaikka(
                new Aika(LOPETUS_AIKA),
                "Hamari"
            )
        );
        VEvent event = IcsAjopalaMuuttaja.muuta(ajopala);

        assertEquals(ALOITUS_AIKA, LocalDateTime.ofInstant(event.getDateStart().getValue().toInstant(), ZoneId.systemDefault()));
        assertEquals(LOPETUS_AIKA, LocalDateTime.ofInstant(event.getDateEnd().getValue().toInstant(), ZoneId.systemDefault()));
        assertEquals(PO_PAIKAT, event.getDescription().getValue());
    }
    
}
