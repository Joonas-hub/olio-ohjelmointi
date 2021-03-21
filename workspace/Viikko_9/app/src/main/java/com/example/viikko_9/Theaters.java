package com.example.viikko_9;

import org.w3c.dom.Document;
import org.w3c.dom.Element;
import org.w3c.dom.Node;
import org.w3c.dom.NodeList;
import org.xml.sax.SAXException;

import java.io.IOException;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.time.format.DateTimeParseException;
import java.util.ArrayList;
import java.util.Date;

import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.ParserConfigurationException;

public class Theaters {

    private ArrayList<Theater> theaterList = new ArrayList<>();
    private ArrayList<String> theaterNames = new ArrayList<>();
    private NodeList nodeList = null;


    public Theaters(String url) {
        try {
            DocumentBuilder builder = DocumentBuilderFactory.newInstance().newDocumentBuilder();
            Document doc = builder.parse(url);
            doc.getDocumentElement().normalize();

            nodeList = doc.getElementsByTagName("TheatreArea");
            for (int i = 0; i < nodeList.getLength(); i++) {
                Node node = nodeList.item(i);
                if (node.getNodeType() == Node.ELEMENT_NODE) {
                    Element element = (Element) node;
                    int id = Integer.parseInt(element.getElementsByTagName("ID").item(0).getTextContent());
                    String name = element.getElementsByTagName("Name").item(0).getTextContent();
                    theaterList.add(new Theater(id, name));
                }

            }
        } catch (IOException e) {
            e.printStackTrace();
        } catch (SAXException e) {
            e.printStackTrace();
        } catch (ParserConfigurationException e) {
            e.printStackTrace();
        }

    }

    public ArrayList<Theater> getTheaterList() {
        return theaterList;
    }

    public ArrayList<String> getTheaterNames() {
        for (Theater i : theaterList) {
            theaterNames.add(i.getName());
        }
        return theaterNames;
    }

    public ArrayList<String> getMovies(int selection, String date, String start, String end) {
        int id = theaterList.get(selection).getId();
        LocalDateTime dateTimeStart = null;
        LocalDateTime dateTimeEnd = null;
        try {
            dateTimeStart = LocalDateTime.parse(date + " " + start, DateTimeFormatter.ofPattern("dd.MM.yyyy HH:mm"));
            dateTimeEnd = LocalDateTime.parse(date + " " + end, DateTimeFormatter.ofPattern("dd.MM.yyyy HH:mm"));
        } catch (DateTimeParseException e) {
            return null;
        }
        String url = "https://www.finnkino.fi/xml/Schedule/?area=" + id + "&dt=" + date;
        NodeList movieList = null;
        ArrayList<String> titleList = new ArrayList<>();

        try {
            DocumentBuilder builderMovies = DocumentBuilderFactory.newInstance().newDocumentBuilder();
            Document docMovie = builderMovies.parse(url);
            docMovie.getDocumentElement().normalize();
            movieList = docMovie.getElementsByTagName("Shows").item(0).getChildNodes();

            for (int i = 0; i < movieList.getLength(); i++) {
                Node node = movieList.item(i);
                if (node.getNodeType() == Node.ELEMENT_NODE) {
                    Element element = (Element) node;
                    String title = element.getElementsByTagName("Title").item(0).getTextContent();
                    String startTime = element.getElementsByTagName("dttmShowStart").item(0).getTextContent();
                    LocalDateTime dateParsed = LocalDateTime.parse(startTime);
                    DateTimeFormatter dateFormat = DateTimeFormatter.ofPattern("HH:mm\t\tdd/MM/yyyy");
                    String dateTime = dateFormat.format(dateParsed);
                    if ((dateParsed.isAfter(dateTimeStart) | dateParsed.isEqual(dateTimeStart)) && (dateParsed.isBefore(dateTimeEnd)) | dateParsed.isEqual(dateTimeEnd)) {
                        titleList.add(title + "\n" + dateTime);
                    }


                }
            }

        } catch (ParserConfigurationException e) {
            e.printStackTrace();
        } catch (SAXException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
        return titleList;
    }

    public ArrayList<String> search(int selection, String s, String date, String start, String end) {
        ArrayList<String> titleList = new ArrayList<>();
        if (selection == 0) {
            for (int j = 0; j < theaterList.size(); j++) {
                int id = theaterList.get(j).getId();
                LocalDateTime dateTimeStart = null;
                LocalDateTime dateTimeEnd = null;
                try {
                    dateTimeStart = LocalDateTime.parse(date + " " + start, DateTimeFormatter.ofPattern("dd.MM.yyyy HH:mm"));
                    dateTimeEnd = LocalDateTime.parse(date + " " + end, DateTimeFormatter.ofPattern("dd.MM.yyyy HH:mm"));
                } catch (DateTimeParseException e) {
                    return null;
                }
                String url = "https://www.finnkino.fi/xml/Schedule/?area=" + id + "&dt=" + date;
                NodeList movieList = null;
                //ArrayList<String> titleList = new ArrayList<>();

                try {
                    DocumentBuilder builderMovies = DocumentBuilderFactory.newInstance().newDocumentBuilder();
                    Document docMovie = builderMovies.parse(url);
                    docMovie.getDocumentElement().normalize();
                    movieList = docMovie.getElementsByTagName("Shows").item(0).getChildNodes();

                    for (int i = 0; i < movieList.getLength(); i++) {
                        Node node = movieList.item(i);
                        if (node.getNodeType() == Node.ELEMENT_NODE) {
                            Element element = (Element) node;
                            String title = element.getElementsByTagName("Title").item(0).getTextContent();
                            String startTime = element.getElementsByTagName("dttmShowStart").item(0).getTextContent();
                            LocalDateTime dateParsed = LocalDateTime.parse(startTime);
                            DateTimeFormatter dateFormat = DateTimeFormatter.ofPattern("HH:mm\t\tdd/MM/yyyy");
                            String dateTime = dateFormat.format(dateParsed);
                            String theaterName = element.getElementsByTagName("Theatre").item(0).getTextContent();

                            if ((dateParsed.isAfter(dateTimeStart) | dateParsed.isEqual(dateTimeStart)) && (dateParsed.isBefore(dateTimeEnd)) | dateParsed.isEqual(dateTimeEnd)) {
                                if (title.contains(s)) {
                                    titleList.add(title + "\n" + dateTime + "\n" + theaterName);
                                }


                            }


                        }
                    }

                } catch (ParserConfigurationException e) {
                    e.printStackTrace();
                } catch (SAXException e) {
                    e.printStackTrace();
                } catch (IOException e) {
                    e.printStackTrace();
                }

            }
            return titleList;
        }
        else {
            int id = theaterList.get(selection).getId();
            LocalDateTime dateTimeStart = null;
            LocalDateTime dateTimeEnd = null;
            try {
                dateTimeStart = LocalDateTime.parse(date + " " + start, DateTimeFormatter.ofPattern("dd.MM.yyyy HH:mm"));
                dateTimeEnd = LocalDateTime.parse(date + " " + end, DateTimeFormatter.ofPattern("dd.MM.yyyy HH:mm"));
            } catch (DateTimeParseException e) {
                return null;
            }
            String url = "https://www.finnkino.fi/xml/Schedule/?area=" + id + "&dt=" + date;
            NodeList movieList = null;


            try {
                DocumentBuilder builderMovies = DocumentBuilderFactory.newInstance().newDocumentBuilder();
                Document docMovie = builderMovies.parse(url);
                docMovie.getDocumentElement().normalize();
                movieList = docMovie.getElementsByTagName("Shows").item(0).getChildNodes();

                for (int i = 0; i < movieList.getLength(); i++) {
                    Node node = movieList.item(i);
                    if (node.getNodeType() == Node.ELEMENT_NODE) {
                        Element element = (Element) node;
                        String title = element.getElementsByTagName("Title").item(0).getTextContent();
                        String startTime = element.getElementsByTagName("dttmShowStart").item(0).getTextContent();
                        LocalDateTime dateParsed = LocalDateTime.parse(startTime);
                        DateTimeFormatter dateFormat = DateTimeFormatter.ofPattern("HH:mm\t\tdd/MM/yyyy");
                        String dateTime = dateFormat.format(dateParsed);
                        String theaterName = element.getElementsByTagName("Theatre").item(0).getTextContent();
                        if ((dateParsed.isAfter(dateTimeStart) | dateParsed.isEqual(dateTimeStart)) && (dateParsed.isBefore(dateTimeEnd)) | dateParsed.isEqual(dateTimeEnd)) {
                            if (title.contains(s)) {
                                titleList.add(title + "\n" + dateTime + "\n" + theaterName);
                            }
                        }


                    }
                }

            } catch (ParserConfigurationException e) {
                e.printStackTrace();
            } catch (SAXException e) {
                e.printStackTrace();
            } catch (IOException e) {
                e.printStackTrace();
            }
            return titleList;
        }
    }
}
