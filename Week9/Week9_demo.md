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
--> Implemented, Theater which has location and ID and TheaterController for add theater and search theater.  
Drop down list for area and date retrieved form https://www.finnkino.fi/xml/TheatreAreas/ and https://www.finnkino.fi/xml/ScheduleDates/ each, XmlHandling class handles this.  
 

9.3. Start searching for movies in a specific theater by current date. You will need current date and the theater ID. With these, the URL should be in a following form:  
--> Implemented, when area(theater) is selected from drop down list (spinner), combined with today(current day), 
url string for finnkino xml query is concatenated as   
**"https://www.finnkino.fi/xml/Schedule/?area=1029&dt=24.07.2021"** and based on the query,
get movies available in selected area today and display them as list View using Fragment in Main.   
<br>
<br>
<table>
  <tr>
    <th>Demo clip</th>
    <th>Main View</th>
    <th>ListView in Fragment</th>
  </tr>
  <tr>
    <td><img src="https://github.com/saugkim/Olio2021s_LUT/blob/main/Images/week9.gif" width="250"/></td>
    <td><img src="https://github.com/saugkim/Olio2021s_LUT/blob/main/Images/week9_1.PNG" width="250"/></td>
    <td><img src="https://github.com/saugkim/Olio2021s_LUT/blob/main/Images/week9_2.PNG" width="250"/></td>
  </tr>
</table>


**Part2 (not implemented 9.4-5)**  
9.4. Add a functionality where a user can input date and time interval that are used to search for movies. Date directly affects the data you are searching for and time interval affects what will finally be shown. So create fields for date input and time interval input (start after, start before). If all fields are left empty, show all movies that run in the selected theater on that date. (one point instead of half a point)

9.5. Make a search functionality that searches all theaters for movies with the name. The application should show the results so that it shows the name of the movie, place and time it is shown. The search functionality should work together with the earlier search functionalities AND if no theater is given, it will search through all theaters. Note: There are 9 different areas for theaters if you exclude the more specific ones. ID 1029 does not show all. (one point instead of half a point)



