package fi.tuomaan.joukkoliikenne.sovellukset.kaapk2gc.icskirjoittaja;

import static org.junit.Assert.assertNotNull;
import static org.junit.Assert.fail;

import java.net.URL;

import fi.tuomaan.joukkoliikenne.koivistonauto.ajopaivakirja.Ajopäiväkirja;
import fi.tuomaan.joukkoliikenne.koivistonauto.ajopaivakirja.PDFLukija.PDFAjopäiväkirjanLukija;

/**
 * Pohjaluokka kaikille Ics-kirjoittajaa testaaville luokille.
 */
public class IcsTestienPohja 
{
    
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
