package fi.tuomaan.joukkoliikenne.sovellukset.kaapk2gc.icskirjoittaja;

import java.time.ZoneId;
import java.util.Date;

import biweekly.component.VEvent;
import fi.tuomaan.joukkoliikenne.koivistonauto.ajopaivakirja.Ajopala;

/**
 * Muuttaa Koiviston auton ajopäiväkirjan ajopalan iCalendar-muotoon.
 */
public class IcsAjopalaMuuttaja 
{

    public static VEvent muuta(Ajopala ajopala)
    {
        VEvent event = new VEvent();
        event.setDateStart(Date.from(ajopala.aloitus().aika().aika().atZone(ZoneId.systemDefault()).toInstant()));
        event.setDateEnd(Date.from(ajopala.lopetus().aika().aika().atZone(ZoneId.systemDefault()).toInstant()));
        event.setDescription(ajopala.aloitus().paikka() + "–" + ajopala.lopetus().paikka());
        return event;
    }
    
}
