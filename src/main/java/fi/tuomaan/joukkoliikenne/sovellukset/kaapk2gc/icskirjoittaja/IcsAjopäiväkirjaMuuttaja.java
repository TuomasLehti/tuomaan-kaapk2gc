package fi.tuomaan.joukkoliikenne.sovellukset.kaapk2gc.icskirjoittaja;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

import biweekly.component.VEvent;
import fi.tuomaan.joukkoliikenne.koivistonauto.ajopaivakirja.Ajopäiväkirja;
import fi.tuomaan.joukkoliikenne.koivistonauto.ajopaivakirja.Työpäivä;

public class IcsAjopäiväkirjaMuuttaja 
{
    
    public static List<VEvent> muuta(Ajopäiväkirja ajopäiväkirja)
    {
        List<VEvent> listOfEvents = new ArrayList<>();

        for (LocalDate pvm : ajopäiväkirja.työpäivät()) {
            Työpäivä työpäivä = ajopäiväkirja.työpäivä(pvm);
            if (työpäivä.sisältääAjopaloja())
                listOfEvents.addAll(IcsTyöpäiväMuuttaja.muuta(työpäivä));
        }

        return listOfEvents;

    }

}
