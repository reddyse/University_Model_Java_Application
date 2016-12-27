/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package collegefunction.department;

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
public class StudentDirectory {
    private int studentId;
    private String firstName;
  //  private String lastName;
    //private String contact;
    //private String email;

    public int getStudentId() {
        return studentId;
    }

    public void setStudentId(int studentId) {
        this.studentId = studentId;
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public ArrayList<StudentDirectory> getStudentDirectoryList() {
        return studentDirectoryList;
    }

    public void setStudentDirectoryList(ArrayList<StudentDirectory> studentDirectoryList) {
        this.studentDirectoryList = studentDirectoryList;
    }

    private ArrayList<StudentDirectory> studentDirectoryList;
    //------------

   

    public StudentDirectory() {

    }

    public StudentDirectory(String dummy) {
       // studentDirectoryList = addStudentDirectory();

    }

    public ArrayList<StudentDirectory> addStudentDirectory() throws DOMException {
        try {
            File fXmlFile = new File("C:\\Users\\Parth\\Documents\\JSR\\AED\\aviral.xml");
            DocumentBuilderFactory dbFactory = DocumentBuilderFactory.newInstance();
            DocumentBuilder dBuilder = dbFactory.newDocumentBuilder();
            Document doc = (Document) dBuilder.parse(fXmlFile);
            doc.getDocumentElement().normalize();
            //   System.out.println("Root element :" + doc.getDocumentElement().getNodeName());

            ArrayList<StudentDirectory> facultydata = new ArrayList<StudentDirectory>();

            NodeList nlist = null;
            NodeList nl = doc.getElementsByTagName("student");

            for (int i = 0; i < nl.getLength(); i++) {
                StudentDirectory s=new StudentDirectory();
                
                nlist = nl.item(i).getChildNodes();
                s.studentId = Integer.parseInt(nlist.item(3).getTextContent());
                s.firstName = nlist.item(1).getTextContent();

                //    System.out.println("Check"+nlist.item(1).getTextContent());
                facultydata.add(s);

            }

            return facultydata;
        } catch (ParserConfigurationException | SAXException | IOException e) {
            System.out.println("exception" + e.getMessage());
            return null;
        }
    }

  
 
    
}


