package org.lut.week9;

import org.w3c.dom.Document;
import org.w3c.dom.Node;
import org.w3c.dom.NodeList;
import org.w3c.dom.Element;

import org.xml.sax.SAXException;

import java.io.IOException;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Collections;
import java.util.Date;
import java.util.HashSet;
import java.util.Locale;
import java.util.Set;

import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.ParserConfigurationException;

public class XmlHandling {

    TheaterController theaterController;
    public XmlHandling() {
        theaterController = new TheaterController();
    }

    public static String THEATRE_AREAS = "https://www.finnkino.fi/xml/TheatreAreas";
    public static String SCHEDULE_DATES = "https://www.finnkino.fi/xml/ScheduleDates";
    public static String FINNKINO = "https://www.finnkino.fi/xml/Schedule";

    public ArrayList<Theater> getTheatersList() {
        return theaterController.getTheaters();
    }

    public static String[] AREAS = {"1014", "1015", "1016", "1017", "1041", "1018", "1019", "1021", "1022"};

    public String getXmlUrlString(String location) {
        Date currentDay = Calendar.getInstance().getTime();
        SimpleDateFormat df = new SimpleDateFormat("dd.MM.yyyy", Locale.getDefault());

        return "https://www.finnkino.fi/xml/Schedule/?area=" +
                theaterController.getTheaterID(location) + "&dt=" + df.format(currentDay);
    }
    
    public String getXmlUrlString(String location, String date) {
        return FINNKINO +"/?area=" + theaterController.getTheaterID(location) + "&dt=" + parseDateFromString(date);
    }

    public String getUrl(String id, String date) {
        return FINNKINO +"/?area=" + id + "&dt=" + parseDateFromString(date);
    }

    public String getCurrentDay() {
        Date currentDay = Calendar.getInstance().getTime();
        SimpleDateFormat df = new SimpleDateFormat("dd.MM.yyyy", Locale.getDefault());
        return df.format(currentDay);
    }

    public String parseDateFromString(String dateInString){
        try {
            Date newDate = new SimpleDateFormat("yyyy-MM-dd", Locale.getDefault()).parse(dateInString);

            SimpleDateFormat formatter = new SimpleDateFormat("dd.MM.yyyy", Locale.getDefault());
            if (newDate != null)
                return formatter.format(newDate);
            else {
                return getCurrentDay();
            }
        } catch (ParseException e) {
            e.getStackTrace();
            return getCurrentDay();
        }
    }

    public ArrayList<String> getAllMovies(){
        ArrayList<String> movies = new ArrayList<>();
        movies.add("SELECT MOVIE");

        Set<String> hs = new HashSet<>();
        String url = "https://www.finnkino.fi/xml/Schedule/?area=1014";

        try {
            DocumentBuilder db = DocumentBuilderFactory.newInstance().newDocumentBuilder();
            Document xmlDoc = db.parse(url);

            xmlDoc.getDocumentElement().normalize();

            NodeList nList = xmlDoc.getDocumentElement().getElementsByTagName("Show");

            for (int i=0; i< nList.getLength(); i++) {
                Node node = nList.item(i);
                node.getAttributes();

                if (node.getNodeType() == Node.ELEMENT_NODE) {
                    Element el = (Element) node;
                    String showTitle = el.getElementsByTagName("Title").item(0).getTextContent();
                    hs.add(showTitle);
                }
            }
        } catch (ParserConfigurationException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        } catch (SAXException e) {
            e.printStackTrace();
        }
        ArrayList<String> sortedHashset = new ArrayList<>(hs);
        Collections.sort(sortedHashset);
        movies.addAll(sortedHashset);

        return movies;
    }

    public ArrayList<String> getMoviesInAllAreas(String date, int ta, int tb, String movie){
        ArrayList<String> movies = new ArrayList<>();
        for (String area : AREAS) {
            ArrayList<String> tmp = getMovies(getUrl(area, date), ta, tb, movie);
            movies.addAll(tmp);
        }
        return movies;
    }

    public ArrayList<String> getMoviesInArea(String location, String date, int ta, int tb, String movie) {
        return getMovies(getXmlUrlString(location, date), ta, tb, movie);
    }

    public ArrayList<String> getMovies(String url, int ta, int tb, String movie) {
        ArrayList<String> movies = new ArrayList<>();

        try {
            DocumentBuilder db = DocumentBuilderFactory.newInstance().newDocumentBuilder();
            Document xmlDoc = db.parse(url);

            xmlDoc.getDocumentElement().normalize();

            NodeList nList = xmlDoc.getDocumentElement().getElementsByTagName("Show");

            for (int i=0; i< nList.getLength(); i++) {
                Node node = nList.item(i);
                node.getAttributes();

                if (node.getNodeType() == Node.ELEMENT_NODE) {
                    Element el = (Element) node;
                    String showStartTime = el.getElementsByTagName("dttmShowStart").item(0).getTextContent();
                    String showTitle = el.getElementsByTagName("Title").item(0).getTextContent();
                    String theatre = el.getElementsByTagName("Theatre").item(0).getTextContent();

                    String format = String.format("%s  at %s\n%s\n%s", showStartTime.substring(0, 10), showStartTime.substring(11), theatre, showTitle);

                    if (movie.equals("SELECT MOVIE")) {
                        if (ta == 0 && tb == 0) {
                            movies.add(format);
                        } else {
                            int temp = Integer.parseInt(showStartTime.substring(11, 13));
                            if (temp >= ta && temp < tb)
                                movies.add(format);
                        }
                    } else {
                        if (showTitle.equals(movie)) {
                            if (ta == 0 && tb == 0) {
                                movies.add(format);
                            } else {
                                int temp = Integer.parseInt(showStartTime.substring(11, 13));
                                if (temp >= ta && temp < tb)
                                    movies.add(format);
                            }
                        }
                    }
                }
            }
        } catch (ParserConfigurationException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        } catch (SAXException e) {
            e.printStackTrace();
        }
        return movies;
    }

    public ArrayList<String> getMoviesInSelectedAreaToday(String location) {
        //https://www.finnkino.fi/xml/Schedule/?area=1016&dt=24.07.2021
        ArrayList<String> movies = new ArrayList<>();
        String url = getXmlUrlString(location);

        try {
            DocumentBuilder db = DocumentBuilderFactory.newInstance().newDocumentBuilder();
            Document xmlDoc = db.parse(url);

            xmlDoc.getDocumentElement().normalize();

            NodeList nList = xmlDoc.getDocumentElement().getElementsByTagName("Show");

            for (int i=0; i< nList.getLength(); i++) {
                Node node = nList.item(i);
                node.getAttributes();

                if (node.getNodeType() == Node.ELEMENT_NODE) {
                    Element el = (Element) node;
                    String showStartTime = el.getElementsByTagName("dttmShowStart").item(0).getTextContent();
                    String showTitle = el.getElementsByTagName("Title").item(0).getTextContent();
                    String theatre = el.getElementsByTagName("Theatre").item(0).getTextContent();

                    movies.add(String.format("%s Start at %s\n%s\n%s", showStartTime.substring(0,10), showStartTime.substring(11), theatre, showTitle));
                }
            }
        } catch (ParserConfigurationException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        } catch (SAXException e) {
            e.printStackTrace();
        }
        return movies;
    }

    public ArrayList<String> readScheduleFromXML() {
        ArrayList<String> ret = new ArrayList<>();
        ret.add("SELECT DATE");

        try {
            DocumentBuilder db = DocumentBuilderFactory.newInstance().newDocumentBuilder();
            Document xmlDoc = db.parse(SCHEDULE_DATES);

            xmlDoc.getDocumentElement().normalize();

            NodeList nList = xmlDoc.getDocumentElement().getElementsByTagName("dateTime");

            for (int i=0; i< nList.getLength(); i++) {
                String date = nList.item(i).getTextContent();
                ret.add(date.substring(0,10));
            }
        } catch (ParserConfigurationException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        } catch (SAXException e) {
            e.printStackTrace();
        }
        return ret;
    }

    public ArrayList<String> readTheatersFromXML() {
        ArrayList<String> ret = new ArrayList<>();
        try {
            DocumentBuilder db = DocumentBuilderFactory.newInstance().newDocumentBuilder();
            Document xmlDoc = db.parse(THEATRE_AREAS);

            xmlDoc.getDocumentElement().normalize();

            NodeList nList = xmlDoc.getDocumentElement().getElementsByTagName("TheatreArea");

            for (int i=0; i< nList.getLength(); i++) {
                Node node = nList.item(i);
                node.getAttributes();

                if (node.getNodeType() == Node.ELEMENT_NODE) {
                    Element el = (Element) node;
                    String loc = el.getElementsByTagName("Name").item(0).getTextContent();
                    int id = Integer.parseInt(el.getElementsByTagName("ID").item(0).getTextContent());

                    ret.add(loc);
                    theaterController.add(new Theater(loc, id));
                }
            }
        } catch (ParserConfigurationException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        } catch (SAXException e) {
            e.printStackTrace();
        }
        return ret;
    }

}
