/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package business.facilities;
import business.person.Person;
import business.person.Student;
import java.io.File;
import java.io.IOException;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.ParserConfigurationException;
import org.w3c.dom.DOMException;
import org.w3c.dom.Document;
import org.w3c.dom.NodeList;
import org.xml.sax.SAXException;
import userview.MainJFrame;

/**
 *
 * @author Parth
 */
public class LibraryServices extends Facilities 
{

    
    private String id;
    private String name;
    private String date;
    private String in_time;
    private String out_time;
    private String is_ruby;
    private String is_group_study;
    private ArrayList <LibraryServices> libstudata;
    


    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getDate() {
        return date;
    }

    public void setDate(String date) {
        this.date = date;
    }

    public String getIn_time() {
        return in_time;
    }

    public void setIn_time(String in_time) {
        this.in_time = in_time;
    }

    public String getOut_time() {
        return out_time;
    }

    public void setOut_time(String out_time) {
        this.out_time = out_time;
    }

    public String getIs_ruby() {
        return is_ruby;
    }

    public void setIs_ruby(String is_ruby) {
        this.is_ruby = is_ruby;
    }

    public String getIs_group_study() {
        return is_group_study;
    }

    public void setIs_group_study(String is_group_study) {
        this.is_group_study = is_group_study;
    }
  

    public ArrayList<LibraryServices> getLibstudata() {
        return libstudata;
    }

    public void setLibstudata(ArrayList<LibraryServices> libstudata) {
        this.libstudata = libstudata;
    }
    
    public String getLibraryServicesReport(Student stuobj) 
    {
        String report;
        ArrayList<Student> stulist;
        ArrayList<Person> perslist;
        Student stuobj2 = new Student();
        stulist=stuobj2.getStudentDataList();
        perslist = stuobj2.getPersonDataList();
        libstudata=getlibstudentdata();
        
        report=getLibraryReport(libstudata, stulist,perslist);
        return report;
    }
            
    public LibraryServices() 
    {
        
    }

    public ArrayList <LibraryServices> getlibstudentdata() throws DOMException {
        try {
            File fXmlFile = new File("D:\\NEU\\AED\\Code_AED\\Project\\university-management-system\\AED_project\\resources\\Praneeth\\lib_usage_data.xml");
            DocumentBuilderFactory dbFactory = DocumentBuilderFactory.newInstance();
            DocumentBuilder dBuilder = dbFactory.newDocumentBuilder();
            Document doc = (Document) dBuilder.parse(fXmlFile);
            doc.getDocumentElement().normalize();
            ArrayList <LibraryServices> libstudentdata = new ArrayList<LibraryServices>();
            NodeList nlist= null;
            NodeList nl=doc.getElementsByTagName("Student");
            for(int i=0; i<nl.getLength();i++)
            {
                LibraryServices s = new LibraryServices();
                nlist=nl.item(i).getChildNodes();
                
                s.id = nlist.item(1).getTextContent();
                s.name = nlist.item(3).getTextContent();
                s.date = nlist.item(5).getTextContent();
                s.in_time=nlist.item(7).getTextContent();
                s.out_time=nlist.item(9).getTextContent();
                s.is_group_study=nlist.item(11).getTextContent();
                s.is_ruby=nlist.item(13).getTextContent();
                libstudentdata.add(s);
            }
            return libstudentdata ;
        }catch (ParserConfigurationException | SAXException | IOException e)
        {
            System.out.println("exception" + e.getMessage());
            return null;
        }
    }

    private static String getVisits(ArrayList<LibraryServices> libstuobj)
    {
        System.out.println("Total Visits-->" + libstuobj.size());
        return "Total Visits-->"+String.valueOf(libstuobj.size())+"\n";
    }
    
    private static String getStudiedCount(ArrayList<LibraryServices> libstudetail)
    {
       NodeList nl=null;
       long diff;
       int count=0;
       String report="";
        for(int i=0; i<libstudetail.size();i++)
        {
         try
         { 
           Date stdt = new Date();
           Date endt = new Date();
           Date temp = new Date();
           DateFormat df = new SimpleDateFormat("mm/dd/yyhhmm");
           stdt=df.parse(libstudetail.get(i).getDate()+libstudetail.get(i).getIn_time());
           endt=df.parse(libstudetail.get(i).getDate()+libstudetail.get(i).getOut_time());
           long difference = stdt.getTime()-endt.getTime();
           if(difference>60000)
           {
               count=count+1;
           } 
         }
         catch (Exception e)
            {
                System.out.println("Exception-->"+ e.getMessage());
            }
              
        }
        System.out.println("Total students studied in Library--->" + count);
        report = String.valueOf(count);
        return "Total students studied in Library--->"+report+"\n";
    }
    
    private static String getLibraryStudyRoomUsedCount(ArrayList<LibraryServices> libstudetail)
    {
       NodeList nl=null;
       String flag;
       String report="";
       int count =0;
        for(int i=0; i<libstudetail.size();i++)
        {
         try
         {  
           flag =libstudetail.get(i).getIs_group_study();
           if("1".equals(flag))
           {
               count=count+1;
           } 
           report = String.valueOf(count);
            
         }
            catch (Exception e)
            {
                System.out.println("Exception-->"+ e.getMessage());
                return "";
            } 
        }
        
        System.out.println("Total students who used Library Study Room--->" + count);
        return "Total students who used Library Study Room--->" + report+"\n";
    }
    
    private static String getAvgPatronVisitsPerDay(ArrayList<LibraryServices> libstudetail, ArrayList<Student> stulist, ArrayList<Person> perslist)
    {
       int val=0;
       int flag=0;
       String report="\n";
   
       for(int i=0; i<libstudetail.size();i++)
       { 
           for(int j=i; j<libstudetail.size();j++)
            { 
                if( libstudetail.get(i).getId().equals(libstudetail.get(j).getId()))
                {
                    if(libstudetail.get(i).getDate()!= libstudetail.get(j).getDate() )
                    {
                        if(j>i)
                        {
                            flag = flag +1;
                            if(flag>4)
                            {
                                val = val+1;
                                flag=0;
                                report = report + "Patron Name-->"+ perslist.get(i).getFirstName()+"\n";
                                report = report + "Patron ID--->"+ perslist.get(i).getCampusID()+"\n";
                                report = report + "Patron Email-->"+perslist.get(i).getEmail()+"\n\n";
                                
                                System.out.println(" ");
                                System.out.println("Patron Name-->"+perslist.get(i).getFirstName());
                                System.out.println("Patron ID--->"+perslist.get(i).getCampusID());
                                System.out.println("Patron Email-->"+perslist.get(i).getEmail());
                                System.out.println(" ");
                            }
                        }
                    }
                }
            }
       }
       System.out.println("Total Number of patrons -->"+ val); 
       report = report +"Total Number of patrons -->" + val;
       return report+"\n";
    }
    
    private static String getLibraryReport(ArrayList<LibraryServices> libstuobj, ArrayList<Student> stulist, ArrayList<Person> perslist) 
    {
        try 
        {
            String report="";
            report=getVisits(libstuobj);
            report = report + getStudiedCount(libstuobj);
            report = report + getLibraryStudyRoomUsedCount(libstuobj);
            report = report + getAvgPatronVisitsPerDay(libstuobj, stulist, perslist);
            return report;
       }
        catch (Exception e)
        {
            System.out.println("exception" + e.getMessage());
            return "report did not generate";
        }
        
    }
    
}

