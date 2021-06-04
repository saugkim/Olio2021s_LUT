Viikon 8 harjoitustehtävät / Week 8 exercises
Suomeksi:

8.1. Muuta limsa-automaatin rakennetta niin, että se noudattaa toiminnassaan Singleton-suunnitteluperiaatetta, eli että on mahdollista luoda vain yksi instanssi oliosta.



8.2. Luo graafinen käyttöliittymä limsa-automaatista. Käytä limsa-automaatin  rakennettua toiminnallisuutta mahdollisimman paljon, eli ainoa muutos tulee olemaan konsolikäyttöliittymästä graafiseksi. Lisäksi muuta pulloja hallinnoiva tietorakenne ArrayListiksi, ellet ole sitä jo aikaisemmin tehnyt. 



Ohjeet:

Tehtävän tarkoituksena on rakentaa käyttöliittymä, jossa on “valuuttakolo”, eli painike, josta on mahdollista lisätä rahaa koneeseen. Tämän lisäksi tarvitaan painike, josta on mahdollista ostaa limsoja sekä palautuspainike, josta saa rahat ulos. Huomaathan, että konsoliin tulostaminen ei ole enää toimiva keino, joten lisää käyttöliittymään myös kenttä, jonne tulosteet ilmestyvät näkyviin. 



 

8.3. Muokkaa käyttöliittymää niin, että automaattiin on mahdollista lisätä erilaisia määriä rahaa. Tähän on suotavaa käyttää SeekBar-komponenttia, jonka avulla voidaan liu’uttamalla määrittää, kuinka paljon rahaa koneeseen laitetaan. Tarvitset silti kuitenkin painikkeen, josta raha syötetään ja SeekBar nollaantuu.



 

8.4. Lisää käyttöliittymään mahdollisuus ostaa erilaisia limsoja eri kokoisina, jolloin hyödyllistä olisi käyttää pudotusvalikoita ostoksen määritykseen. Käyttäjä valitsee siis pudotusvalikosta ostettavan tuotteen ja sen koon, jonka jälkeen kone joko myy tuotteen tai ilmoittaa, ettei sitä ole (voit käyttää esimerkiksi Android Studion Spinner-komponenttia). 



8.5. Lisää ohjelmaan toiminnallisuus, jonka avulla on mahdollista tulostaa käyttäjälle kuitti viimeisimmästä ostoksesta. Kuitin tulee sisältää tieto siitä, että se on kuitti sekä tieto kyseisestä ostoksesta, eli ainakin tuotteen nimi ja hinta. Kuitti ei tulosteta käyttöliittymään vaan se tulostetaan suoraan tiedostoon, joka on erikseen määritelty ohjelman sisällä. 





In English:

8.1. Change the BottleDispenser so taht it uses the Singleton design pattern meaning that you can only create one object at a time.



8.2. Create a graphical user interface for the BottleDispenser. Use the functionality that has already been made so the only change you have to do is change the console prints to a graphical user interface. Additionally, change the Bottle list to an ArrayList if you haven't already done that.



Instructions: 

There should be a button that is used to add money to the machine. Additionally you need a button that buys the bottles and a button that returns money. Note that console prints are not an option so you need a text field where the prints are shown.





8.3. Modify the user interface in such a way that it is possible to change the amount of money you put to the BottleDispenser. It is recommended to use SeekBar-component that works as a slider to change the amount of money given. You will still need a button to that adds the money and resets SeekBar.



8.4. Add a possibility to buy different sodas in different sizes. One possiblity is to use drop-down list for buying the bottles. This means the user chooses from the drop-down list the bottle they want to buy and its size. Afterwards the BottleDispenser either sells the product or says that they are out (you can use Spinner component for example).



8.5. Add a functionality that makes it possible to print receipt of the last purchase for the user. The receipt should contain information that it is a receipt and what was purchased (name and price at least). The receipt is not printed to the user interface but instead, written to a file (that is defined in the program).

