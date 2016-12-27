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
import java.util.ListIterator;

/**
 *
 * @author Parth
 */
public class Report_DepartmentRank {

    double totalRankPoints;
    double totalStudents;
    double internationalStudents = 0;
    double ratioInternationalToTotal;
    int facultyTotal;
    double ratioFacultyToStudent;
    int facultyYearsTotal = 0;
    int researchPaperSum = 0;
    int testScoreSum = 0;
    double totalFinancial;
    double maxsalary = 0;
    double grandTotal = 52000;
    double percentScore = 0;
    String outputReport="";

    public String rankDept(String dataPath) {
//Person p=new Person();
        Faculty f = new Faculty("Start");
        Student s = new Student(dataPath);

        ArrayList<Person> personListTemp = f.getPersonDataList(); //access parent using f

        ArrayList<Student> studentListTemp = s.getStudentDataList();

        ArrayList<Faculty> facultyListTemp = f.getFacultyData();

        totalStudents = studentListTemp.size();

//        System.out.println(totalStudents + " total students");

        outputReport="Total students in " + s.getStudentDataList().get(1).getCollegeName() + " are \n" + totalStudents+"\n";
        for (int i = 0; i < totalStudents; i++) {
            if (personListTemp.get(i).getNationality().equals("0")) {
//System.out.println(personListTemp.get(i).getFirstName()+" "+ personListTemp.get(i).getLastName()+" is international ");
                internationalStudents++;
            } else {
            }

        }

   //     System.out.println(internationalStudents + " international students");

        outputReport=outputReport+ " \n \n Number of international students are : \n " + internationalStudents;
        
//        System.out.println(facultyListTemp.get(0).getSalary() + " is 1st faculty salary");
  //      System.out.println(studentListTemp.get(1).getCollegeName());

        for (int i = 0; i < facultyListTemp.size() - 1; i++) {
            if (facultyListTemp.get(i).getSalary() > facultyListTemp.get(i + 1).getSalary()) {
                maxsalary = facultyListTemp.get(i).getSalary();
            }
        }

     //   System.out.println("Max fac salary is " + maxsalary);

        outputReport=outputReport+"\n \n The maximum salary offered to a Professor is : \n"+" $"+maxsalary; 
//--------------------------------
        ratioInternationalToTotal = internationalStudents / totalStudents;

       // System.out.println("Ratio of international students to total " + ratioInternationalToTotal);

        outputReport=outputReport+"\n \n The ratio of international students:total are : \n"+ratioInternationalToTotal;
        
        facultyTotal = facultyListTemp.size();

        ratioFacultyToStudent = facultyTotal / totalStudents;
outputReport=outputReport+"\n \n The ratio of faculty:students is : \n"+ratioFacultyToStudent;
        
        for (int i = 0; i < facultyListTemp.size(); i++) {
            facultyYearsTotal++;
        }

        //System.out.println(facultyYearsTotal + " faculty years total!");
outputReport=outputReport+"\n \n The combined experience of all faculty members in college is : \n"+facultyYearsTotal+" years";
//for(int i=0;i<totalStudents;i++) //research paper count for students
//{
//if(personListTemp.get(i).getResearchPaper()>=1)
//{
//researchPaperSum++;
//}
//else{}
//}
        for (int i = 0; i < facultyTotal; i++) //research paper count for faculty
        {
            if (facultyListTemp.get(i).getResearchPapers() >= 1) {
                researchPaperSum = researchPaperSum + facultyListTemp.get(i).getResearchPapers();
            } else {
            }
        }

//        System.out.println(researchPaperSum + "is the total sum of research papers!");
outputReport=outputReport+"\n \n The total amount of research papers published by faculty are: \n"+researchPaperSum+" papers";
        for (int i = 0; i < totalStudents; i++) //research paper
        {
            testScoreSum = testScoreSum + studentListTemp.get(i).getTestScore();
        }

  //      System.out.println(testScoreSum + " is the test score sum");
outputReport=outputReport+"\n \n The average test score of a student is:  \n"+testScoreSum/100+" marks";
       
totalRankPoints = ratioInternationalToTotal * 0.3 + ratioFacultyToStudent * 0.7 + maxsalary * 0.01 + facultyYearsTotal * 0.15
                + researchPaperSum * 0.01 + testScoreSum * 0.25;

        percentScore = totalRankPoints / grandTotal * 100;

    //    System.out.println(percentScore + "% is the percent score of the college " + s.getStudentDataList().get(1).getCollegeName());
outputReport=outputReport+"\n \n Based on these values, and our algorithm the percent score of this department is \n"+percentScore;
        
        return outputReport;
    }

}



