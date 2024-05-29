package fi.tuomaan.joukkoliikenne.sovellukset.kaapk2gc.icskirjoittaja;

import java.time.ZoneId;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Date;
import java.util.List;

import biweekly.component.VEvent;
import fi.tuomaan.joukkoliikenne.koivistonauto.ajopaivakirja.Ajopala;
import fi.tuomaan.joukkoliikenne.koivistonauto.ajopaivakirja.AjopalanTyyppi;

/**
 * Muuttaa Koiviston auton ajopäiväkirjan ajopalan iCalendar-muotoon.
 */
public class IcsAjopalaMuuttaja 
{

    public static VEvent muuta(Ajopala ajopala)
    {
        if (!muutetaanko(ajopala)) return null;

        VEvent event = new VEvent();
        event = muutaAjat(event, ajopala);

        /* Tapahtuman otsikkoon tulee ajopalan tyyppi, ja linja-ajon
         * tapauksessa myös vuoro ja linjat. */
        if (ajopala.tyyppi() == AjopalanTyyppi.LINJA_AJOA) 
            event = muutaOtsikkoLinjaajo(event, ajopala);
        else    
            event = muutaOtsikko(event, ajopala);

        /* Tapahtuman kuvaukseen tulee aloitus- ja lopetuspaikat, ja 
         * mahdollisesti suunta, jos kyse on linja-ajosta. */
        if ((ajopala.tyyppi() == AjopalanTyyppi.LINJA_AJOA) && ajopala.onkoSuuntaa())
            event = muutaKuvaus(event, ajopala);
        else
            event = muutaKuvausSuunnaton(event, ajopala);

        return event;
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

    private static VEvent muutaAjat(VEvent event, Ajopala ajopala)
    {
        event.setDateStart(Date.from(ajopala.aloitus().aika().aika().atZone(ZoneId.systemDefault()).toInstant()));
        event.setDateEnd(Date.from(ajopala.lopetus().aika().aika().atZone(ZoneId.systemDefault()).toInstant()));
        return event;
    }
    
    private static VEvent muutaOtsikkoLinjaajo(VEvent event, Ajopala ajopala) {
        String fmt = (ajopala.linjat().contains(",")) ? "%s, vuoro %s, linjat %s" : "%s, vuoro %s, linja %s";
        event.setSummary(String.format(
            fmt,
            AjopalanTyyppi.asString(ajopala.tyyppi()),
            ajopala.vuoro(),
            ajopala.linjat()
        ));
        return event;
    }

    private static VEvent muutaOtsikko(VEvent event, Ajopala ajopala) {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'muutaOtsikko'");
    }

    private static VEvent muutaKuvaus(VEvent event, Ajopala ajopala) 
    {
        event.setDescription(String.format(
            "%s s%d–%s", 
            ajopala.aloitus().paikka(),
            ajopala.suunta(),
            ajopala.lopetus().paikka()
        ));
        return event;
    }

    private static VEvent muutaKuvausSuunnaton(VEvent event, Ajopala ajopala) 
    {
        event.setDescription(String.format(
            "%s–%s", 
            ajopala.aloitus().paikka(),
            ajopala.lopetus().paikka()
        ));
        return event;
    }
    
}
