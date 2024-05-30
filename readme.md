# Koiviston auto Helsingin ajopäiväkirja Googlen kalenteriin

Tällä ohjelmalla pystyt siirtämään Koiviston auton Helsingin ja Porvoon 
toimipisteistä saamasi PDF-tiedostot Googlen kalenteriin.

Ohjelman uusin versio on tällä hetkellä 0.1.

## Ohjelman asentaminen

Ohjelma löytyy oikealta, Releases-kohdasta ja edelleen Assets-kohdasta. Lataa
``tuomaan-kaapk2gc.zip`` omalle koneellesi ja pura se haluamaasi kansioon.

Ohjelma vaatii, että tietokoneella on Java asennettuna.

### Java-koe

Voit kokeilla, onko tietokoneellasi Java asennettuna.

Sitä varten kansiossa on tiedosto nimeltä ``java_koe.bat``, jonka voit 
käynnistää kaksoisnapsauttamalla. Jos ruudulle ilmestyvässä ikkunassa lukee
ensimmäisellä rivillä ``java`` ja sen jälkeen numeroita, kaikki on valmista 
ohjelman käyttämistä varten.

Jos ruudulla komeilee virheilmoitus, tietokoneellasi ei luultavasti ole
Javaa. Voit asentaa sen WWW-osoitteesta https://www.java.com/en/download/.

## Ohjelman käyttäminen

**Ohjelman käynnistämiseksi vedä ajopäiväkirja-PDF ``run.bat``-tiedoston 
päälle.** Kansioon, josta vedit PDF:n, muodostuu tiedosto, jonka pääte on ICS.

Ohjelma ei välttämättä löydä PDF-tiedostoa, jos tiedoston tai kansioiden 
nimissä on välilyöntejä, å-, ä, tai ö-kjriamia, tai muita erikoismerkkejä.

Kannattaa säästää PDF-tiedostot, joiden sisältämät työvuorot haluaa varmasti
säästää.

**Kalenteri tuodaan Google-kalenteriin asetusvalikon kautta.** Ylälaidasta 
hammasrattaankuva -> asetukset. Sen jälkeen vasemmasta laidasta tuo ja vie.
Sen jälkeen valitaan tiedosto tietokoneelta ja kalenteri, johon ajopäiväkirja
lisätään. Lopuksi napsautetaan tietenkin Tuo-näppäintä.

Kannattaa luoda oma kalenteri työvuoroille ainakin tässä vaiheessa, jotta
kaikki on tarvittaessa helppo poistaa, mikäli jokin menee pieleen.

**Jos työpäivä muuttuu**, siitä tehdään ICS-tiedosto ja se tuodaan Google-
kalenteriin edellä kuvatulla tavalla, mutta vanha työpäivä pitää poistaa käsin.

Kannattaa ottaa muutoksista vain yksittäisen päivän PDF, jotta on helpompi
poistaa vanhat vain yhden päivän kohdalta.

## Tulevaisuudensuunnitelmia

- Tarjolle tullee neljä vaihtoehtoa:
  - Niukka, joka muuttaa vain rupeaman alku- ja loppuajat.
  - Normaali, joka muuttaa kaikki, jossa pitää itse ajaa.
  - Runsas, joka muuttaa myös kaikki, jossa matkustetaan
  - Ylitsevuotava, joka muuttaa myös kaikki valmistelu- ja lopetteluajat.
- Normaaliin ja runsaaseen tulee vaihtoehdoksi linja-ajopalojen muuttaminen
  yksittäisiksi linjasivuiksi.

Kun tämä kaikki perussälä on saatu jotakuinkin toimimaan tällä PC-ohjelmalla,
alan miettiä, kuinka saisin sen pelaamaan ihan Windows-ikkunan kanssa ja
mahdollisesti jopa kännykässä. Ohjelman rakenne on suunniteltu laajennettavuus
mielessä.