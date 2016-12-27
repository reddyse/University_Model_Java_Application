/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package business.person;

import business.*;
import java.io.File;
import java.io.IOException;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.ParserConfigurationException;
import org.w3c.dom.DOMException;
import org.w3c.dom.Document;
import org.w3c.dom.NodeList;
import org.xml.sax.SAXException;

/**
 *
 * @author Parth
 */
public class Person {

    private String campusID;
    private String firstName;
    private String lastName;

    private String nationality;

    private String contactNumber;
    private String email;
    private String address;
    private String city;
    private String country;
    private ArrayList<Person> personDataList;

    public Person(String dummy) {

    }

    public ArrayList<Person> getPersonDataList() {
        return personDataList;
    }

    public Person() {
        personDataList = addPersonList();

    }

    public ArrayList<Person> addPersonList() throws DOMException {
        try {
            File fXmlFile = new File("D:\\NEU\\AED\\Code_AED\\Project\\university-management-system\\AED_project\\resources\\Praneeth\\person_data.xml");
            DocumentBuilderFactory dbFactory = DocumentBuilderFactory.newInstance();
            DocumentBuilder dBuilder = dbFactory.newDocumentBuilder();
            Document doc = (Document) dBuilder.parse(fXmlFile);
            doc.getDocumentElement().normalize();
            //System.out.println("Root element :" + doc.getDocumentElement().getNodeName());

            ArrayList<Person> persondata = new ArrayList<Person>();
            //Person p = new Person();
            NodeList nlist = null;
            NodeList nl = doc.getElementsByTagName("Person");

            for (int i = 0; i < nl.getLength(); i++) {
                Person p = new Person("dummy");
                nlist = nl.item(i).getChildNodes();
                p.firstName = nlist.item(3).getTextContent();
                p.lastName = nlist.item(5).getTextContent();
                p.email = nlist.item(11).getTextContent();
                p.contactNumber = nlist.item(9).getTextContent();
                p.nationality = nlist.item(7).getTextContent();
                p.address = nlist.item(13).getTextContent();
                p.campusID = nlist.item(1).getTextContent();
                p.city = nlist.item(15).getTextContent();
                p.country = nlist.item(17).getTextContent();

                persondata.add(p);

            }

            return persondata;
        } catch (ParserConfigurationException | SAXException | IOException e) {
            System.out.println("exception" + e.getMessage());
            return null;
        }

    }

    public String getCampusID() {
        return campusID;
    }

    public void setCampusID(String campusID) {
        this.campusID = campusID;
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public String getNationality() {
        return nationality;
    }

    public void setNationality(String nationality) {
        this.nationality = nationality;
    }

    public String getContactNumber() {
        return contactNumber;
    }

    public void setContactNumber(String contactNumber) {
        this.contactNumber = contactNumber;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public String getCity() {
        return city;
    }

    public void setCity(String city) {
        this.city = city;
    }

    public String getCountry() {
        return country;
    }

    public void setCountry(String country) {
        this.country = country;
    }

}



