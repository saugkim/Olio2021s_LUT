Viikon 9 harjoitustehtävät / Week 9 exercises
9.1. Tee käyttöliittymä, jossa on mahdollista listata kaikki Finnkinon teatterit pudotusvalikossa. Pudotusvalikosta voi siis valita teatterin ja teatterin valinnan jälkeen ohjelmaan listataan kyseisessä teatterissa näytettävät elokuvat. Toiminnallisuuksia ei tarvitse vielä toteuttaa, tärkeintä on saada komponentit paikalleen. Mukana pitäiis olla erilaiseet hakukriteerit kuten päivämäärä, kellonaika, elokuvan nimi, ja paikka. 

 9.2. Lähde etsimään Finnkinon elokuvatarjontaa osoitteesta http://www.finnkino.fi/xml. Tee käyttöliittymän taustalle ohjelma, jonka avulla on mahdollista ladata XML-tiedosto, missä käsitellään toimipaikkoja (areas XML). Luo myös erillinen luokka, jonka sisälle säilöt jokaisen elokuvateatterin tiedot. 

 
Tarvitset siis luokan, joka pitää kirjaa kaikista elokuvateattereista tietorakenteen avulla, sekä luokan, joka sisältää elokuvateatterin tiedot (Paikka ja ID). Pääluokan voit sitten integroida käyttöliittymään. Käyttöliittymään päivitetään aluksi pudotusvalikko niin, että käyttäjä voi valita haluamansa elokuvateatterin listasta. 

9.3. Lähdetään seuraavaksi hakemaan tietoa päivän näytöksistä teatterikohtaisesti. Tiedon hakemiseen tarvitaan haluttu päivämäärä (tämä päivä) sekä teatterin ID-numero. Näistä tiedoista muodostuu haluttu URL muotoon 


https://www.finnkino.fi/xml/Schedule/?area=<teatterinID>&dt=<päivämäärä pp.kk.vvvv>
http://www.finnkino.fi/xml/Schedule/?area=<teatterinID>&dt=<päivämäärä pp.kk.vvvv>    
 <- ja >-merkit eivät kuulu urliin, vaan kuvastavat parametriä! Yllä kaksi vaihtoehtoa, https ja http. Kokeilkaa ensin https ja jos ei toimi, niin http.

 
Parsi saadut esitystiedot aina, kun teatteri on valittu ja esitykset halutaan katsoa. Käytä esittämiseen jotain lista-komponenttia (esim. RecyclerView, ScrollView tai ListView), johon lisäät elokuvat omille rivilleen. Kuten edellisessä tehtävässä, käyttöliittymä vain esittää tiedot, mutta ei itse sisällä mitään parsimiseen tai tiedon säilömiseen liittyvää dataa. Hetkellinen tietorakenteen käyttö on kuitenkin sallittua, jos on mahdollista osoittaa sen olevan tarpeellista. 


9.4. Lisää ohjelmaan toiminnallisuus, jonka avulla käyttäjä voi syöttää päivämäärän sekä kellonaikavälin, jolta haluaa katsella elokuvatarjontaa. Päivämäärä vaikuttaa suoraan datan hakemiseen ja kellonaika vaikuttaa siihen, mitä dataa valitaan näytettäväksi. Tee siis vapaavalintaisia kenttiä, joihin käyttäjä voi syöttää päivämäärän ja aloita jälkeen sekä aloita ennen, miltä väliltä elokuvia haetaan (väli, josta elokuvat alkavat). Jos kaikki kentät jätetään tyhjiksi, haetaan päivän kaikki elokuvat valitussa teatterissa.  (yksi piste puolikkaan sijaan)


9.5. Lisää hakutoiminto, jolla voidaan hakea elokuvan nimen avulla kaikki ne paikat ja ajat, jolloin elokuvaa näytetään. Hakutulosten pitäisi listata elokuvan nimi otsikkona ja sen jälkeen kaikkien esittävien teatterien nimet ja esitysajat käyttäjän syötteen mukaan (eli hakutoiminto etsii edellisten tehtävien mukaisten rajoitusten mukaan JA jos teatteria ei ole annettu, haku etsii kaikista teattereista. Huom: Eri teatterialueita on 9 kun huomioit, että osa id-numeroista käy useamman teatterin läpi. ID 1029 ei näytä kaikkia. ).  (yksi piste puolikkaan sijaan)


In English:
9.1. Create a graphical user interface where it is possible to list all Finnkino theaters in a drop-down list. User can choose a theater from the list and afterwards the application lists movies shown in that specific theater. You don't have to implement the functionalities yet, more important is to get the components in place. There should be different search criteria like date, time, name of the movie and place.

9.2. Try using the Finnkino XML service through a web browser (clicking the links or modifying the url) at https://www.finnkino.fi/xml/. Create software that makes it possible to read XML files that handles Theaters (areas XML). Create a class that stores the information of all Theaters.

You will need a class that stores Theaters in a data structure, another class that has the Theater information (location and ID). Integrate this software to your graphical user interface so that sets the Theaters to the drop-down list and user can choose a Theater from the list.

9.3. Start searching for movies in a specific theater by current date. You will need current date and the theater ID. With these, the URL should be in a following form:


http://www.finnkino.fi/xml/Schedule/?area=<theaterID>&dt=<date in dd.MM.yyyy format>
http://www.finnkino.fi/xml/Schedule/?area=<theaterID>&dt=<date in dd.MM.yyyy format>     
<- and >-character do not belong to the URL, they represent the parameters! Two options above, https and http. Try the https first and if it does not work, use http.

Parse the movie information every time a theater has been chosen and a user wants to see results. You should use a list component to present the results (e.g. RecyclerView, ScrollView, ListView or something else) that lists every result in their own row. Like in the previous exercise, user interface only presents information but it does not contain any information to parsing or storing data. Temporary data structures are allowed if necessary.

9.4. Add a functionality where a user can input date and time interval that are used to search for movies. Date directly affects the data you are searching for and time interval affects what will finally be shown. So create fields for date input and time interval input (start after, start before). If all fields are left empty, show all movies that run in the selected theater on that date. (one point instead of half a point)

9.5. Make a search functionality that searches all theaters for movies with the name. The application should show the results so that it shows the name of the movie, place and time it is shown. The search functionality should work together with the earlier search functionalities AND if no theater is given, it will search through all theaters. Note: There are 9 different areas for theaters if you exclude the more specific ones. ID 1029 does not show all. (one point instead of half a point)



