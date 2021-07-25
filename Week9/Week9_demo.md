## Demonstration of Week 9 assignments   

Tools used:  
**Android Studio 4.2.1**   



### Assignments  
**Part 1 (9.1-3)**    
[source code here]
(https://github.com/saugkim/Olio2021s_LUT/blob/main/Week9/app/src/main/java/org/lut/week9)  

9.1. Create a graphical user interface where it is possible to list all Finnkino theaters in a drop-down list. User can choose a theater from the list and afterwards the application lists movies shown in that specific theater. You don't have to implement the functionalities yet, more important is to get the components in place. There should be different search criteria like date, time, name of the movie and place.  
--> Implemented, in main view 3 spinner(drop down) objects for search by area, date, and movie  
UI: Select Theater, Select Date, Select Movie spinners and TextView to display selected area.

9.2. Try using the Finnkino XML service through a web browser (clicking the links or modifying the url) at https://www.finnkino.fi/xml/. Create software that makes it possible to read XML files that handles Theaters (areas XML). Create a class that stores the information of all Theaters.  

You will need a class that stores Theaters in a data structure, another class that has the Theater information (location and ID). Integrate this software to your graphical user interface so that sets the Theaters to the drop-down list and user can choose a Theater from the list.  
--> Implemented, Theater which has location and ID and TheaterController for add theater and search theater  
Drop down list for area and date retrieved form https://www.finnkino.fi/xml/TheatreAreas/ and https://www.finnkino.fi/xml/ScheduleDates/ each.  
List for movie not implemented.

9.3. Start searching for movies in a specific theater by current date. You will need current date and the theater ID. With these, the URL should be in a following form:  

--> Implemented, when area(theater) is selected from drop down list (spinner), combined with today(current day), 
url string for finnkino xml query is concatenated as   
**"https://www.finnkino.fi/xml/Schedule/?area=1029&dt=24.07.2021"** and based on the query,
get movies available in selected area today and display them as list View using Fragment in Main.   

<table>
  <tr>
    <th>Demo clip</th>
    <th>Main View</th>
    <th>ListView in Fragment</th>
  </tr>
  <tr>
    <td><img src="https://github.com/saugkim/Olio2021s_LUT/blob/main/Images/week11_1.gif" width="250"/></td>
    <td><img src="https://github.com/saugkim/Olio2021s_LUT/blob/main/Images/week11_navigation_drawer.PNG" width="250"/></td>
    <td><img src="https://github.com/saugkim/Olio2021s_LUT/blob/main/Images/week11_settingFragment.PNG" width="250"/></td>
  </tr>
</table>


