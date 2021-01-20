package com.rec.dao;

import java.util.HashMap;
import java.util.Map;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import com.rec.exception.ResourceNotFoundException;
import com.rec.model.ApplicationDocumentModel;
import com.rec.repository.ApplicationDocumentRepository;

@Service
public class ApplicationDocumentDao {
	@Autowired
	ApplicationDocumentRepository appdocrepo;

	public ApplicationDocumentModel Save(ApplicationDocumentModel appdoc) {
		System.out.print("success"+ appdoc);
		return appdocrepo.save(appdoc);
	}
	

	public ResponseEntity<ApplicationDocumentModel> getApplicationDocumentById(Long appdocid) throws ResourceNotFoundException{
	
		ApplicationDocumentModel status=appdocrepo.findById(appdocid).orElseThrow(() -> new ResourceNotFoundException("application document not found"));
		
		
		return ResponseEntity.ok().body(status);
		}
	
	
	public ApplicationDocumentModel updateapplicationdocument(Long id, ApplicationDocumentModel appdoc) throws ResourceNotFoundException {
		ApplicationDocumentModel ApplicationDocumentModelOptional = appdocrepo.findById(id)
		.orElseThrow(() -> new ResourceNotFoundException("application document not found for this id :: " + id));
         System.out.print("applicationdocumentmodeloptional"+ApplicationDocumentModelOptional);
         ApplicationDocumentModel updatedApplicationDocument;

        try {    
		 			 updatedApplicationDocument = this.appdocrepo.save(appdoc);
		 			return appdoc;
	         }
	       
        catch(Exception e) {
        	System.out.print("Exception found");
        }
        return null;
    	
	}
	
	public Map<String, Boolean> deleteapplicationdocument(Long appdocid) throws ResourceNotFoundException {
		ApplicationDocumentModel user = this.appdocrepo.findById(appdocid)
		.orElseThrow(() -> new ResourceNotFoundException("application document not found for this id :: " + appdocid));
		
		this.appdocrepo.delete(user);
		Map<String, Boolean> response = new HashMap<>();
		response.put("deleted", Boolean.TRUE);
		return response;
		}
}
