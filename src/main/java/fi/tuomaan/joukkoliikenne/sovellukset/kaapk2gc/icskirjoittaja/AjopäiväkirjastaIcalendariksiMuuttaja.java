package fi.tuomaan.joukkoliikenne.sovellukset.kaapk2gc.icskirjoittaja;

import fi.tuomaan.joukkoliikenne.koivistonauto.ajopaivakirja.Ajopäiväkirja;
import net.fortuna.ical4j.model.Calendar;

/**
 * Muuttaa Koiviston auton ajopäiväkirjan iCalendar-muotoon.
 */
public class AjopäiväkirjastaIcalendariksiMuuttaja 
{

    public static Calendar muuta(Ajopäiväkirja ajopäiväkirja)
    {
        Calendar kalenteri = new Calendar();
        return kalenteri;
    }
    
}
