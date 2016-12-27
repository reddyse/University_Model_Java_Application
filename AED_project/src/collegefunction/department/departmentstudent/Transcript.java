/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package collegefunction.department.departmentstudent;


import collegefunction.department.StudentDirectory;
import collegefunction.department.courseschedule.Semester;
import java.util.ArrayList;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author Aviral
 */
public class Transcript {
 private StudentDirectory student;
 private ArrayList<Semester> semesterList;
 private double finalGrade;
 
 public Transcript()
 {
     this.semesterList = new ArrayList<>();
     
 }

    public StudentDirectory getStudent() {
        return student;
    }

    public void setStudent(StudentDirectory student) {
        this.student = student;
    }

    public ArrayList<Semester> getSemesterList() {
        return semesterList;
    }

    public void setSemesterList(ArrayList<Semester> semesterList) {
        this.semesterList = semesterList;
    }

    public double getFinalGrade() {
        return finalGrade;
    }

    public void setFinalGrade(double finalGrade) {
        this.finalGrade = finalGrade;
    }
 
 
 public Semester addSemester()
 {
     Semester semester = new Semester();
        semesterList.add(semester);
        return semester;
 }
  
  
}


