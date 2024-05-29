package fi.tuomaan.joukkoliikenne.sovellukset.kaapk2gc.icskirjoittaja;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;
import static org.junit.Assert.fail;

import java.net.URL;
import java.time.LocalDate;
import java.util.List;

import org.junit.Test;

import biweekly.component.VEvent;
import fi.tuomaan.joukkoliikenne.koivistonauto.ajopaivakirja.Ajopäiväkirja;
import fi.tuomaan.joukkoliikenne.koivistonauto.ajopaivakirja.PDFLukija.PDFAjopäiväkirjanLukija;

public class TestIcsTyöpäiväMuuttaja {

    @Test
    public void testPorvoo()
    {
        Ajopäiväkirja ajopäiväkirja = loadResource("fi/tuomaan/joukkoliikenne/sovellukset/kaapk2gc/icskirjoittaja/2024-05-29.pdf");
        List<VEvent> events = IcsTyöpäiväMuuttaja.muuta(ajopäiväkirja.työpäivä(LocalDate.of(2024, 5, 29)));
        assertEquals(6, events.size());
    }

    protected Ajopäiväkirja loadResource(String name) {
    	ClassLoader classLoader = getClass().getClassLoader();
    	URL url = classLoader.getResource(name);
    	assertNotNull("URL is null", url);
		// alussa ylimääräinen kauttaviiva
    	try {
            PDFAjopäiväkirjanLukija pdf = new PDFAjopäiväkirjanLukija(url.getPath().substring(1));
            return pdf.lue();
		} catch (Exception e) {
			fail(e.getMessage());
		}
		return null;
	}

    
}
