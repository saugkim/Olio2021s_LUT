Viikon 10 harjoitukset / Week 10 exercises
Suomeksi:

10.1 Tee verkkoselain, jonka avulla on mahdollista käyttää verkkoa sekä syöttää haluamiaan osoitteita osoitepalkkiin. Tee ohjelma niin, että käyttäjän ei tarvitse itse syöttää osoitteen alkuosaa http://.
 
10.2. Luo selaimeesi myös päivitys-painike (Refresh), jonka avulla voit ladata verkkosivun uudelleen. Painike siis etsii senhetkisen verkkosivun ja lataa sen uudelleen. 

10.3. Ota käyttöön tiedosto “index.html” ja lisää se Androidin assets-kansioon. Luo painike, joka suorittaa JavaScript-rajapintakutsun, jossa halutaan käyttää metodia “shoutOut()”. Luo myös toinen painike, jonka avulla on mahdollista muuttaa teksti takaisin alkuperäiseksi JavaScript-metodin initialize() avulla.

 

Jotta saat index.html-tiedoston käyttöösi, tee lisäys osoitepalkin toiminnallisuuteen, jolloin käyttäjän kirjoittaessa “index.html” ladataankin resursseissa oleva tiedosto. 

 

index.html -tiedoston sisältö löytyy alapuolelta. Voitte luoda Android Studiossa uuden tiedoston ja nimetä sen "index.html".

<html>
<head>
<script type="text/javascript">
  function initialize() {
    document.getElementById("random").innerHTML = "Moi Maailma!";
  }

  function shoutOut() {
    document.getElementById("random").innerHTML = "Hello World!";
  } 
</script>
</head>
<body onload="initialize()">
  <p id="random"></p>
</body>
</html>


10.4. Luo verkkoselaimeesi painikkeet, joista on mahdollista päästä edelliselle ja seuraavalle verkkosivulle. Tarvitset siis tallennuspaikan sekä edelliselle että seuraavalle osoitteelle ja lataa ne painikkeita painettaessa.

10.5. Laajenna verkkoselaimen edellinen- ja seuraava-toimintoja niin, että välimuistia on mahdollista matkustaa kauemmas eteen- tai taaksepäin 10 askeleen päähän. Tarvitset muuttujien sijasta siis tietorakenteen, johon tallennat osoitteita talteen, jos niille on tarvetta. Tämän lisäksi, muokkaa historiaa niin, että jos käyttäjä syöttää uuden osoitteen sen jälkeen, kun on mennyt taaksepäin, "seuraavat" sivut nollaantuvat ja käyttäjä on jälleen uusimmassa sivussa (kuten oikeassa selainhistoriassa).





In English:



10.1. Create a web browser application that can access internet and user can input the address manually. Make it so that the user doesn't have to input the "http://"





10.2. Create a refresh-button that can be user the refresh the website. This means the button reloads the current website.



10.3. Make an "index.html" file to Android assets-folder. After this, create a button that makes a JavaScript interface call that calls the shoutOut()-function in the file. Create another button that calls the initialize()-function. Modify the application so that when user writes "index.html" as the address, it will read the .html file.



index.html file is below. You can create a new file in Android studio and name it as "index.html"




<html>
<head>
<script type="text/javascript">
  function initialize() {
    document.getElementById("random").innerHTML = "Moi Maailma!";
  }

  function shoutOut() {
    document.getElementById("random").innerHTML = "Hello World!";
  } 
</script>
</head>
<body onload="initialize()">
  <p id="random"></p>
</body>
</html>


10.4. Create previous / next buttons that enables the user to go back to the previous website or to the next (if in a previous one). You will need a place to store the previous and next websites the user has accessed.



10.5. Extend the previous / next functionalities so that user can go back and forth 10 steps. You will need some data structure to store more than one website and a way to check you are in the correct place. Modify the history functionality in such a way that when a user enter a new website after going back in the history list, the rest of the list will clear and user is back in the "newest" site (just like a real browser history works).
