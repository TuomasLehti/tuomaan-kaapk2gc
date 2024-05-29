package fi.tuomaan.joukkoliikenne.sovellukset.kaapk2gc.icskirjoittaja;

import static org.junit.Assert.assertEquals;
import java.time.LocalDate;
import java.util.List;

import org.junit.Test;

import biweekly.component.VEvent;
import fi.tuomaan.joukkoliikenne.koivistonauto.ajopaivakirja.Ajopäiväkirja;

public class TestIcsTyöpäiväMuuttaja 
extends IcsTestienPohja
{

    @Test
    public void testPorvoo()
    {
        Ajopäiväkirja ajopäiväkirja = loadResource("fi/tuomaan/joukkoliikenne/sovellukset/kaapk2gc/icskirjoittaja/2024-05-29.pdf");
        List<VEvent> events = IcsTyöpäiväMuuttaja.muuta(ajopäiväkirja.työpäivä(LocalDate.of(2024, 5, 29)));
        assertEquals(6, events.size());
    }


    
}
