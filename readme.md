# Koiviston auto Helsingin ajopäiväkirja Googlen kalenteriin

Tällä ohjelmalla pystyt siirtämään Koiviston auton Helsingin ja Porvoon 
toimipisteistä saamasi PDF-tiedostot Googlen kalenteriin.

Ohjelman uusin versio on tällä hetkellä 0.0.

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

- Kalenterin luominen vetämällä run.batin päälle.
  - Erikoismerkit ja välilyönnit saattavat sekoittaa.
  - Samaan kansioon ilmestyy ICS-tiedosto.
  - Kannattaa säästää PDF-tiedostot, jotka haluaa säästää.
- Kalenterin vieminen Google calendariin.
  - Asetukset -> Tuo ja vie
  - Kannattaa luoda oma kalenteri työvuoroille ainakin tässä vaiheessa, jotta
    kaikki on tarvittaessa helppo poistaa, mikäli jokin menee pieleen.
- Työpäivien muuttuminen
  - Tee uudesta PDF:stä uusi ICS.
  - Vie kalenteriin samaan tapaan kuin uusi työpäivä.
  - Vanhan työpäivän joudut poistamaan käsityönä.
  - Kannattaa ottaa muutoksista vain yksittäisen päivän PDF, jotta on helpompi
    poistaa vanhat vain yhden päivän kohdalta.

## Tulevaisuudensuunnitelmia

- Tarjolle tullee kolme vaihtoehtoa:
  - Niukka, joka muuttaa vain rupeaman alku- ja loppuajat.
  - Normaali, joka muuttaa kaikki, jossa pitää itse ajaa.
  - Runsas, joka muuttaa myös kaikki, jossa matkustetaan
- Normaaliin ja runsaaseen tulee vaihtoehdoksi linja-ajopalojen muuttaminen
  yksittäisiksi linjasivuiksi.

Kun tämä kaikki perussälä on saatu jotakuinkin toimimaan tällä PC-ohjelmalla,
alan miettiä, kuinka saisin sen pelaamaan ihan Windows-ikkunan kanssa ja
mahdollisesti jopa kännykässä. Ohjelman rakenne on suunniteltu laajennettavuus
mielessä.