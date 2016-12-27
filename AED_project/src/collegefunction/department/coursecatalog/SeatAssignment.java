/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package collegefunction.department.coursecatalog;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author Aviral
 */
public class SeatAssignment { // how many seats are assigned to student, one student will get one seat in one course offering, though course offering can  hve many seats)
   
   private CourseOffering courseOffering;
   
   private double grade;

    public SeatAssignment() {
        courseOffering = new CourseOffering();
        
    }
   

    public CourseOffering getCourseOffering() {
        return courseOffering;
    }

    public void setCourseOffering(CourseOffering courseOffering) {
        this.courseOffering = courseOffering;
    }
   


    public double getGrade() {
        return grade;
    }

    public void setGrade(double grade) {
        this.grade = grade;
    }
  
}


