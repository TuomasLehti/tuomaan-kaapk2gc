package fi.tuomaan.joukkoliikenne.sovellukset.kaapk2gc.icskirjoittaja;

import static org.junit.Assert.assertEquals;

import java.util.List;

import org.junit.Test;

import biweekly.component.VEvent;
import fi.tuomaan.joukkoliikenne.koivistonauto.ajopaivakirja.Ajopäiväkirja;

public class TestIcsAjopäiväkirjaMuuttaja 
extends IcsTestienPohja
{

    @Test
    public void lataaOikeanMääränTyöpäiviä()
    {
        Ajopäiväkirja ajopäiväkirja = lataaAjopäiväkirja("fi/tuomaan/joukkoliikenne/sovellukset/kaapk2gc/icskirjoittaja/2024-05-20.pdf");
        List<VEvent> eventList = IcsAjopäiväkirjaMuuttaja.muuta(ajopäiväkirja);

        /* Ajopäiväkirjassa on 5 työpäivää, jokaisessa 2 rupeamaa, joista 
         * kummastakin tulee 3 ajopalaa. */
        assertEquals(30, eventList.size());
    }
    
}
