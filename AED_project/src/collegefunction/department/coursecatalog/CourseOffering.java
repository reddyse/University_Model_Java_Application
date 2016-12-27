/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package collegefunction.department.coursecatalog;

import collegefunction.department.FacultyDirectory;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author Aviral
 */
public class CourseOffering {
    private int courseOfferingId = 0 ;
    private Course course;
    private FacultyDirectory faculty;

    public Course getCourse() {
        return course;
    }

    public void setCourse(Course course) {
        this.course = course;
    }

    public FacultyDirectory getFaculty() {
        return faculty;
    }

    public void setFaculty(FacultyDirectory faculty) {
        this.faculty = faculty;
    }

    public CourseOffering() {
    
        course = new Course();
        faculty = new FacultyDirectory();
        
        
    }
   
    public int getCourseOfferingId() {
        return courseOfferingId;
    }

    public void setCourseOfferingId(int courseOfferingId) {
        this.courseOfferingId = courseOfferingId;
    }



    
    
    
    
}



