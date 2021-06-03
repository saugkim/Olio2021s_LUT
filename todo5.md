Viikon 5 harjoitustehtävät / Week 5 exercises  

In Finnish

5.1. Tee luokkakaavio autosta, jossa auto koostuu erilaisista osista. 
Voit käyttää mielikuvitustasi niin paljon kuin haluat, mutta auton tulee koostua 
ainakin korista, alustasta, renkaista ja moottorista.

 

5.2. Mallinna UML-luokkakaavio pankista, joka sisältää erilaisia tilejä. 

Tilit ovat periytetty kantaluokasta ja pankilla on kolme erilaista tiliä: 
markkinointi-, säästö- ja käyttötili. 

Jokaisella tilillä on tieto sisältämästään rahamäärästä ja tilinumerosta, 
mutta säästötilillä on myös tieto korkoprosentista ja metodi koron lisäämiseksi summaan. 

Markkinointitili sisältää tiedon siitä, kuinka paljon palvelumaksu on ja metodin, 
jonka avulla maksu veloitetaan tililtä.

 

5.3.  


![me](https://github.com/saugkim/Olio2021s_LUT/blob/main/Images/Week53.png)  

Edellä on useita erilaisia luokkia, jotka ovat kuitenkin menneet järjestyksessä sekaisin. 
Järjestä luokat takaisin oikeaan järjestykseen niin, että Character-luokasta periytyvät 
kaikki ne luokat, jotka tunnistat hahmoiksi ja WeaponBehaviour-luokasta periytyvät kaikki aseet. 

Huomioi myös, että jokaisella hahmolla tulee olla ase jo silloin, kun hahmo luodaan, 
eli ase luodaan hahmon kanssa samaan aikaan.

 

5.4. Toteuta 1. tehtävässä nähdyt taulut Java-ohjelmana. 
Luokkien ei vielä tässä tehtävässä tarvitse pitää sisällään metodeja eikä niiden 
tarvitse sisältää tulostusta vaativampaa toiminnallisuutta (pl. rakentaja). 

Tee jokainen autoon kuuluva osa osaluokkana (määritä ne samaan tiedostoon auton kanssa) 
ja liitä se autoon, kun autoa luodaan. 

Lisää myös autolle metodi print(), jolla voi kertoa, mitä osia auto pitää sisällään. 
Tulosta myös jokaisen osaolion rakentajassa, mitä osaa rakennetaan.


5.5. Toteuta tehtävän 3. UML-kaavio ohjelmaksi, 
jonka ei tarvitse sisältää tulostuksia mutkikkaampia suorituksia, poislukien tietysti rakentajat. 

Tee pääluokka, jonka kautta voidaan luoda uusia hahmoja ja hahmoille uusia aseita. 
Hahmojen ei ole tarpeen taistella keskenään, pelkkä tulostus riittää. 
Huomaa, että hahmo-luokan ase-luokka on näkyvyydeltään julkinen.





In English:

5.1. Create a class diagram of a car that has different parts. You can use your imagination as much as you want but it should have at least a chassis, body, wheels and engine.




5.2. Create a UML-class diagram of a bank that has different types of accounts. Accounts are inherited from a superclass and bank has three different accounts: marketing-, savings-, and debitaccount. Each account has information on the amount of money and account number, but savings account also has information on the interest rate and a method to add interest. Marketing account has information on how much is the service cost and a method that can take this cost from the account.



5.3.





Above are multiple different classes that are not in order. Organize them back into order in such a way that Character-class is inherited by all the classes that are characters and WeaponBehaviour is inherited by all weapons. Note that all characters should have a weapon when a character is creted meaning a weapon is created at the same time a character is.



5.4. Create 5.1. diagram as a Java program. Classes do not have to have any methods and they don't have to do anything more than print text (excluding constructor). Create each part that belongs to the car as a class part (defined in the same file as Car class) and add them to the car when a car is being created. Add a method print() to the Car that can tell what parts the car has. Also in each constructor, print out which part is being created. 




5.5. Create 5.3. UML diagram as a program that doesn't have to do anything more than print text (excluding constructors). Create a mainclass where you can create new characters and weapons for the characters. They don't have to fight against each other, a print is enough. Note that WeaponBehaviour in Character is public.

![me](https://github.com/saugkim/Olio2021s_LUT/blob/main/Images/Webp.net-gifmaker.gif)  
https://stackoverflow.com/questions/60094768/how-to-display-an-animated-gif-in-a-github-readme-file  
