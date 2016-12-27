/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package collegefunction.department.departmentstudent;

/**
 *
 * @author Parth
 */

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
public class TranscriptCatalog {
    
    private ArrayList <Transcript> transcriptCatalog;
    
    public TranscriptCatalog()
    {
        this.transcriptCatalog = new ArrayList<>();
        
                
    }

    public ArrayList<Transcript> getTranscriptCatalog() {
        return transcriptCatalog;
    }

    public void setTranscriptCatalog(ArrayList<Transcript> transcriptCatalog) {
        this.transcriptCatalog = transcriptCatalog;
    }
    
    public Transcript addTranscript()
    {
        Transcript transcript = new Transcript();
        transcriptCatalog.add(transcript);
        return transcript;
        
    }
}



