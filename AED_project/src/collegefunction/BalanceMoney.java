/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package collegefunction;

import business.person.Faculty;
import business.person.Person;
import business.person.Student;
import java.util.ArrayList;

/**
 *
 * @author Praneeth, Parth, Aviral
 */
public class BalanceMoney {

    int totalStudents=0;
    double financeExpenditure=0;
    double financeRevenue=0;
    int totalPerson=0;

    double balance=0;
String outputData="";

      public String findBalance(String dataPath)
    {
//Person p=new Person();

        Faculty f = new Faculty("Start");
Student s=new Student(dataPath);

ArrayList<Person> personListTemp=f.getPersonDataList(); //access parent using f

ArrayList<Student> studentListTemp=s.getStudentDataList();

ArrayList<Faculty> facultyListTemp=f.getFacultyData();


totalStudents=studentListTemp.size();
totalPerson=personListTemp.size();

System.out.println(totalPerson+" total persons");

System.out.println(totalStudents+" total students");

financeExpenditure=totalPerson*30000;
financeRevenue=totalStudents*1422*16;

outputData=outputData+" Estimated expenditure in finances are:\n "+ "$"+financeExpenditure;

outputData=outputData+"\n \n Estimated revenue in finances are:\n "+ "$"+financeRevenue;

balance=financeRevenue-financeExpenditure;

outputData=outputData+"\n \n Balance/surplus is :\n "+ "$"+balance;

return outputData;


    }
    
}



