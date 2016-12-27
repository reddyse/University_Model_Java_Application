/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package collegefunction.department;

import business.person.Faculty;
import business.person.Person;
import business.person.Student;
import java.util.ArrayList;

/**
 *
 * @author Parth
 */
public class StudentDetails {
    int totalPersons=0;
    String outputData="";
    
        public String viewStudentDetails(String dataPath, String input) {
//Person p=new Person();
        Faculty f = new Faculty("Start");
        Student s = new Student(dataPath);

        ArrayList<Person> personListTemp = f.getPersonDataList(); //access parent using f

        ArrayList<Student> studentListTemp = s.getStudentDataList();

        ArrayList<Faculty> facultyListTemp = f.getFacultyData();

        totalPersons = personListTemp.size();
        
        for(int i=0;i<totalPersons;i++)
        {
        if(input.equals(personListTemp.get(i).getCampusID()))
        {
    outputData=    "First Name: \n"+personListTemp.get(i).getFirstName()+"\n \n Last name: \n"+personListTemp.get(i).getLastName() + "\n \n Email ID  \n"+personListTemp.get(i).getEmail()+"\n \n Mobile Number \n"+personListTemp.get(i).getContactNumber();
        }
        }
        
        


        
        
        return outputData;
        
        }
}
