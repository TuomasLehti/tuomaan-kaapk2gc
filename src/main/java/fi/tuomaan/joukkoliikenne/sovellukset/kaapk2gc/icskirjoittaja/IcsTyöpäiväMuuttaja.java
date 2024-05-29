package fi.tuomaan.joukkoliikenne.sovellukset.kaapk2gc.icskirjoittaja;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import biweekly.component.VEvent;
import fi.tuomaan.joukkoliikenne.koivistonauto.ajopaivakirja.Ajopala;
import fi.tuomaan.joukkoliikenne.koivistonauto.ajopaivakirja.AjopalanTyyppi;
import fi.tuomaan.joukkoliikenne.koivistonauto.ajopaivakirja.Työpäivä;

/**
* Muuttaa Koiviston auton ajopäiväkirjan työpäivän iCalendar-muotoon.
  */
public class IcsTyöpäiväMuuttaja 
{

    public static List<VEvent> muuta(Työpäivä työpäivä)
    {
        List<VEvent> listOfEvents = new ArrayList<>();

        for (Ajopala ajopala : työpäivä.ajopalat())
          if (muutetaanko(ajopala))
            listOfEvents.add(IcsAjopalaMuuttaja.muuta(ajopala));

        return listOfEvents;
    }

    private static Boolean muutetaanko(Ajopala ajopala)
    {
        List<AjopalanTyyppi> muutettavat = new ArrayList<>(Arrays.asList(new AjopalanTyyppi[]{
            AjopalanTyyppi.LINJA_AJOA,
            AjopalanTyyppi.SIIRTOAJO,
            AjopalanTyyppi.SIIRTYMÄ_AUTOLLA,
            AjopalanTyyppi.SISÄÄNAJO,
            AjopalanTyyppi.ULOSAJO
        }));
        return muutettavat.contains(ajopala.tyyppi());
    }

    
}
