package fi.tuomaan.joukkoliikenne.sovellukset.kaapk2gc.icskirjoittaja;

import java.io.IOException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import biweekly.Biweekly;
import biweekly.ICalendar;
import biweekly.component.VEvent;
import fi.tuomaan.joukkoliikenne.koivistonauto.ajopaivakirja.Ajopäiväkirja;
import fi.tuomaan.utilities.tiedostot.TiedostoApurit;

public class IcsKirjoittaja 
{

    public static void kirjoita(Ajopäiväkirja ajopäiväkirja, String tiedostonNimi) throws IOException
    {
        ICalendar calendar = new ICalendar();

        List<VEvent> listOfEvents = IcsAjopäiväkirjaMuuttaja.muuta(ajopäiväkirja);
        for (VEvent event : listOfEvents) calendar.addEvent(event);
        String s = Biweekly.write(calendar).go();

        TiedostoApurit.kirjoitaTiedostoon(tiedostonNimi, new ArrayList<String>(Arrays.asList((new String[]{s}))));

    }
    
}
