/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package collegefunction.department.courseschedule;


import collegefunction.department.StudentDirectory;
import collegefunction.department.departmentstudent.CourseLoad;
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

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author Aviral
 */
public class Semester {
    
    private int uid;
    private String semesterName;

    private ArrayList<Semester> semesterList;
    //------------

    public ArrayList<Semester> getSemesterList() {
        return semesterList;
    }

    public Semester() {

    }

    public Semester(String dummy) {
        semesterList = addSemesterList();

    }

    public ArrayList<Semester> addSemesterList() throws DOMException {
        try {
            File fXmlFile = new File("C:\\Users\\Parth\\Documents\\JSR\\AED\\aviralSemester.xml");
            DocumentBuilderFactory dbFactory = DocumentBuilderFactory.newInstance();
            DocumentBuilder dBuilder = dbFactory.newDocumentBuilder();
            Document doc = (Document) dBuilder.parse(fXmlFile);
            doc.getDocumentElement().normalize();
            //   System.out.println("Root element :" + doc.getDocumentElement().getNodeName());

            ArrayList<Semester> facultydata = new ArrayList<Semester>();

            NodeList nlist = null;
            NodeList nl = doc.getElementsByTagName("semester");

            for (int i = 0; i < nl.getLength(); i++) {
                Semester s=new Semester();
                
                nlist = nl.item(i).getChildNodes();
                s.uid = Integer.parseInt(nlist.item(3).getTextContent());
                s.semesterName = nlist.item(1).getTextContent();

                //    System.out.println("Check"+nlist.item(1).getTextContent());
                facultydata.add(s);

            }

            return facultydata;
        } catch (ParserConfigurationException | SAXException | IOException e) {
            System.out.println("exception" + e.getMessage());
            return null;
        }
    }

    public int getUid() {
        return uid;
    }

    public void setUid(int uid) {
        this.uid = uid;
    }

    public String getSemesterName() {
        return semesterName;
    }

    public void setSemesterName(String semesterName) {
        this.semesterName = semesterName;
    }

    
}



