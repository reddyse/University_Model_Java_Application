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
public class Student extends Person {

    private int studentResearchPapers = 0;
    private int testScore = 0;
    private String collegeName;

    public String getCollegeName() {
        return collegeName;
    }

    public void setCollegeName(String collegeName) {
        this.collegeName = collegeName;
    }

    private ArrayList<Student> studentDataList;
    //------------

    public ArrayList<Student> getStudentDataList() {
        return studentDataList;
    }

    public Student() {

    }

    public Student(String dataPath) {
        studentDataList = addStudentList(dataPath);

    }

    public ArrayList<Student> addStudentList(String dataPath) throws DOMException {
        try {
            File fXmlFile = new File(dataPath);
            DocumentBuilderFactory dbFactory = DocumentBuilderFactory.newInstance();
            DocumentBuilder dBuilder = dbFactory.newDocumentBuilder();
            Document doc = (Document) dBuilder.parse(fXmlFile);
            doc.getDocumentElement().normalize();
            //  System.out.println("Root element :" + doc.getDocumentElement().getNodeName());

            ArrayList<Student> studentdata = new ArrayList<Student>();

            NodeList nlist = null;
            NodeList nl = doc.getElementsByTagName("student");

            for (int i = 0; i < nl.getLength(); i++) {
                Student p = new Student();
                nlist = nl.item(i).getChildNodes();

                p.collegeName = doc.getDocumentElement().getNodeName();

                //  System.out.println("Check"+nlist.item(3).getTextContent());
                p.studentResearchPapers = Integer.parseInt(nlist.item(1).getTextContent());

                p.testScore = Integer.parseInt(nlist.item(3).getTextContent());

                studentdata.add(p);
            }

            return studentdata;
        } catch (ParserConfigurationException | SAXException | IOException e) {
            System.out.println("exception" + e.getMessage());
            return null;
        }
    }

    public int getStudentResearchPapers() {
        return studentResearchPapers;
    }

    public void setStudentResearchPapers(int studentResearchPapers) {
        this.studentResearchPapers = studentResearchPapers;
    }

    public int getTestScore() {
        return testScore;
    }

    public void setTestScore(int testScore) {
        this.testScore = testScore;
    }

}


