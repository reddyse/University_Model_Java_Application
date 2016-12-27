/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package collegefunction.department.departmentstudent;

/**
 *
 * @author prane
 */
import collegefunction.department.coursecatalog.SeatAssignment;
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
public class CourseLoad {
          
            private  ArrayList<SeatAssignment> seatAssignment;
            private double avgGrade;

    public CourseLoad() 
    {
        this.seatAssignment = new ArrayList<>();
        
    }

  

    public ArrayList<SeatAssignment> getSeatAssignment() {
        return seatAssignment;
    }

    public void setSeatAssignment(ArrayList<SeatAssignment> seatAssignment) {
        this.seatAssignment = seatAssignment;
    }

    public double getAvgGrade() {
        return avgGrade;
    }

    public void setAvgGrade(double avgGrade) {
        this.avgGrade = avgGrade;
    }
            
     public double calculateAverageGrade()
    {
        double cgpa = 0;
        double totalgrade = 0;
        for (SeatAssignment s: seatAssignment)
        {
         totalgrade += s.getGrade();
         
        }
        avgGrade = totalgrade/seatAssignment.size();
        return avgGrade;
    }
     public SeatAssignment assignSeat()
    {
        SeatAssignment s = new SeatAssignment();
        seatAssignment.add(s);
        return s;
   
    }
}



