package org.lut.week9;

import org.w3c.dom.Document;
import org.w3c.dom.Node;
import org.w3c.dom.NodeList;
import org.w3c.dom.Element;

import org.xml.sax.SAXException;

import java.io.IOException;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.Locale;

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
    public static String XML_URL = "https://www.hel.fi/palvelukarttaws/rest/v4/department/?format=xml";

    public ArrayList<Theater> getTheatersList() {
        return theaterController.getTheaters();
    }

    public String getXmlUrlString(String location) {
        Date currentDay = Calendar.getInstance().getTime();
        SimpleDateFormat df = new SimpleDateFormat("dd.MM.yyyy", Locale.getDefault());

        return "https://www.finnkino.fi/xml/Schedule/?area=" +
                theaterController.getTheaterID(location) + "&dt=" + df.format(currentDay);
    }
    
    public String getXmlUrlString(String location, String date) {
        //String newDateFormat = date.replaceAll("-", ".");
        return FINNKINO +"/?area=" + theaterController.getTheaterID(location) + "&dt=" + parseDateFromString(date);
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

    public ArrayList<String> getMoviesInSelectedAreaToday(String url, int ta, int tb) {
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

                    int temp = Integer.parseInt(showStartTime.substring(11,13));
                    if (temp >= ta && temp < tb)
                        movies.add(String.format("%s\t%s\n%s", showStartTime.substring(0,10), showStartTime.substring(11), showTitle));
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

    public ArrayList<String> getMoviesInSelectedAreaToday(String url) {
        //https://www.finnkino.fi/xml/Schedule/?area=1016&dt=24.07.2021
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

                    movies.add(String.format("%s\t%s\n%s", showStartTime.substring(0,10), showStartTime.substring(11), showTitle));
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
        ret.add("Select Date");
        StringBuilder tmp = new StringBuilder();
        try {
            DocumentBuilder db = DocumentBuilderFactory.newInstance().newDocumentBuilder();
            Document xmlDoc = db.parse(SCHEDULE_DATES);

            xmlDoc.getDocumentElement().normalize();

            NodeList nList = xmlDoc.getDocumentElement().getElementsByTagName("dateTime");

            for (int i=0; i< nList.getLength(); i++) {
                String date = nList.item(i).getTextContent();
                ret.add(date.substring(0,10));
                tmp.append(date.substring(0,10)).append("\n");
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

    public String read() {
        StringBuilder output = new StringBuilder();
        try {

            DocumentBuilder dBuilder = DocumentBuilderFactory.newInstance().newDocumentBuilder();
            Document xmlDoc = dBuilder.parse(XML_URL);
            xmlDoc.getDocumentElement().normalize();
            //String user = xmlDoc.getElementsByTagName("user").item(0).getTextContent();
            //String pwd = xmlDoc.getElementsByTagName("password").item(0).getTextContent();
            System.out.println("Root element: " + xmlDoc.getDocumentElement().getNodeName());
            NodeList nList = xmlDoc.getDocumentElement().getElementsByTagName("Show");
            //output = "Root element: " + xmlDoc.getDocumentElement().getNodeName();
            for (int i=0; i< nList.getLength(); i++) {
                Node node = nList.item(i);
                node.getAttributes();

                if (node.getNodeType() == Node.ELEMENT_NODE) {
                    Element el = (Element) node;
                    output.append(el.getElementsByTagName("Theatre").item(0).getTextContent()).append(": ");
                }
            }
        } catch (IOException e) {
            e.printStackTrace();
        } catch (ParserConfigurationException e) {
            e.printStackTrace();
        } catch (SAXException e) {
            e.printStackTrace();
        }
        return output.toString();
    }
}
