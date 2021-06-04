Viikon 6 harjoitustehtävät / Week 6 exercises
In Finnish:

6.1. Tässä harjoituksessa tavoitteena on tehdä yksinkertainen kassajärjestelmä talletuspankkiin. Tilejä on kahdenlaisia: tavallisia ja luotollisia. Luotollisilla tileillä on luottovara, jonka verran tili saa olla miinuksella. Tavallinen tili ei voi mennä miinukselle. Tileille voi tallettaa rahaa ja niistä voi tehdä nostoja. Yksittäisen tilin tiedot voi tulostaa. Tilit ovat numeroituja ja tilin tapahtumat kohdistetaan tiliin numeron avulla. Sekä yksittäisen että kaikkien tilien tiedot voi tulostaa. Tilejä on myös mahdollista poistaa. Tee tältä pohjalta tekstipohjainen käyttöliittymä ohjelmaa varten. Tämä ensimmäinen tehtävä on siis pelkän valikon (käyttöliittymän) rakentaminen. Muut toiminnot tulevat myöhemmissä tehtävissä. Käytä kuitenkin tässä tehtävässä apumuuttujia (esim. int amount, credit) matkimaan pankin laajempaa toiminnallisuutta (luokkia).

6.2. Piirrä pankki ja sen tilit UML-luokkakaaviona. Harkitse, tulisiko tilit tehdä abstraktion avulla vaiko erillisinä toiminnallisuuksina. (Tehtävää ei voi palauttaa Viopeen.)

6.3. Toteuta ensin pankki-luokan toiminta. Pankilla on tieto useista erilaisista tileistä, joita se sisältää sekä sillä on metodeja tilien lisäämiseksi ja poistamiseksi. Tämän lisäksi pankilla on metodi, jolla sen tilejä voidaan etsiä. Metodi ottaa sisäänsä etsittävän tilinumeron ja palauttaa tiliolion tai tyhjän. Integroi tämä luokka mukaan aikasemmin tekemääsi käyttöliittymään.

6.4. Toteuta tavallisten tilien toiminta. Tarvitset tavallisen tililuokan, joka voisi vaikka periä ominaisuuksia abstraktilta tililuokalta. Päävalikko pyörii jo ohjelman pääluokassa ja tilit tulevat toimimaan suoraan pankin rajapinnan kautta. Eli pääluokka ei tiedä tileistä mitään, pankki ainoastaan hallinnoi niitä.

6.5. Toteuta lopuksi luotolliset tilit. Luotollinen tili on erikoistapaus tilistä. Nostovaran tutkiminen, uuden tilin luonti sekä tulostus ovat erilaisia kuin tavallisella tilillä. Tarvitaan siis uusi luokka, luotollinen tili, joka periytetään tililuokasta. Muista, että luotolliselta tililtä voi nostaa rahaa luottorajaan asti vaikka tili näyttäisi miinusta. Luo Account.java-tiedostoon abstrakti tililuokka sekä tavallinen tili ja luotollinen tili.





In English:

6.1. In this exercise you are to make a simple banking system. There are two types of accounts: normal and credit. Credit accounts have a credit limit and the account can go to negative by that amount. A normal account cannot go negative. You can deposit and withdraw money from the accounts. You can print individual account information. Accounts are numbered and all transactions / events require the number. Finally, you can print out all accounts and you can also remove accounts. Note! This first exercise is just to create a menu for the system, all other functionalities are to be done in the later parts. Use variables (e.g. int amount, credit) to mimic additional features (classes) developed later.



6.2. Draw bank and its accounts as UML file. Think if the accounts should be done using abstraction or as separate functionalities (Cannot be turned in to Viope).



6.3. Create the functionality for Bank-class. Bank as information on different accounts it contains and there are methods to add or remove accounts. There should also be a method to search for accounts. This methods takes the account number as parameter and returns an account object or nothing. Integrate this to the system menu you did.



6.4. Create the functionalities for normal account. You need a regular account class that can inherit features from an abstract account class. Main menu runs in the mainclass and accounts work through the Bank. Mainclass should have no connection to accounts, only Bank controls them.




6.5. Finally create the credit accounts. Credit account is a special case of an account. Checking the amount of money you can withdraw, creating a new account and printing are different compared to a regular account. You will need a new class, credit account, that is inherited from an account class. Remember that the credit account can withdraw money up to the credit limit even if it goes to negative. Create an abstract account, regular account and credit account to Account.java file.

