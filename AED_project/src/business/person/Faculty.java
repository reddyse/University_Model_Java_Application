/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package business.person;

import business.*;
import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
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
public class Faculty extends Person {

    private double salary;
    private int yearsOfExperience;
    private int researchPapers;

    private ArrayList<Faculty> facultyData;
    //------------

    public ArrayList<Faculty> getFacultyData() {
        return facultyData;
    }

    public Faculty() {

    }

    public Faculty(String dummy) {
        facultyData = addFacultyList();

    }

    public ArrayList<Faculty> addFacultyList() throws DOMException {
        try {
            File fXmlFile = new File("C:\\Parth\\Project_AED\\gargava_parth_assignment04_ums\\faculty_data.xml");
            DocumentBuilderFactory dbFactory = DocumentBuilderFactory.newInstance();
            DocumentBuilder dBuilder = dbFactory.newDocumentBuilder();
            Document doc = (Document) dBuilder.parse(fXmlFile);
            doc.getDocumentElement().normalize();
            //   System.out.println("Root element :" + doc.getDocumentElement().getNodeName());

            ArrayList<Faculty> facultydata = new ArrayList<Faculty>();

            NodeList nlist = null;
            NodeList nl = doc.getElementsByTagName("professor");

            for (int i = 0; i < nl.getLength(); i++) {
                Faculty p = new Faculty();
                nlist = nl.item(i).getChildNodes();
                p.salary = Double.parseDouble(nlist.item(1).getTextContent());
                p.yearsOfExperience = Integer.parseInt(nlist.item(3).getTextContent());
                p.researchPapers = Integer.parseInt(nlist.item(1).getTextContent());

                //    System.out.println("Check"+nlist.item(1).getTextContent());
                facultydata.add(p);

            }

            return facultydata;
        } catch (ParserConfigurationException | SAXException | IOException e) {
            System.out.println("exception" + e.getMessage());
            return null;
        }
    }

    //-- 
    public double getSalary() {
        return salary;
    }

    public void setSalary(double salary) {
        this.salary = salary;
    }

    public int getYearsOfExperience() {
        return yearsOfExperience;
    }

    public void setYearsOfExperience(int yearsOfExperience) {
        this.yearsOfExperience = yearsOfExperience;
    }

    public int getResearchPapers() {
        return researchPapers;
    }

    public void setResearchPapers(int researchPapers) {
        this.researchPapers = researchPapers;
    }

}



