package fi.tuomaan.joukkoliikenne.sovellukset.kaapk2gc;

import java.io.FileNotFoundException;
import java.io.IOException;

import fi.tuomaan.joukkoliikenne.koivistonauto.ajopaivakirja.Ajopäiväkirja;
import fi.tuomaan.joukkoliikenne.koivistonauto.ajopaivakirja.PDFLukija.PDFAjopäiväkirjanLukija;
import fi.tuomaan.joukkoliikenne.sovellukset.kaapk2gc.icskirjoittaja.IcsKirjoittaja;
import fi.tuomaan.utilities.pdf.InvalidPDFStructure;

/**
 * Pääohjelma.
 */
public class KaAjopaivakirjaGoogleKalenteriin 
{

    public static void main(String[] args) 
    {
        System.out.println("KAH:n ta KAP:n ajopäiväkirja ICS-tiedostoon.");
        System.out.println();
        if (args.length == 0) {
            System.out.println("Ei tiedostoa.");
            return;
        }

        try {
            PDFAjopäiväkirjanLukija lukija = new PDFAjopäiväkirjanLukija(args[0]);
            Ajopäiväkirja ajopäiväkirja = lukija.lue();
            IcsKirjoittaja.kirjoita(ajopäiväkirja, args[0] + ".ics");
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        } catch (InvalidPDFStructure e) {
            e.printStackTrace();
        }

    }
    
}
