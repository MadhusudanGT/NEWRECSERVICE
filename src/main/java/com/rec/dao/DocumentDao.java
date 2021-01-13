package com.rec.dao;

import java.util.HashMap;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import com.rec.exception.ResourceNotFoundException;
import com.rec.model.ApplicantModel;
import com.rec.model.DocumentModel;

import com.rec.repository.DocumentRepository;
import com.rec.util.Validation;
@Service
public class DocumentDao {
	@Autowired
	DocumentRepository docrepo;
    
	@Autowired
	Validation validation;
	public DocumentModel Save(DocumentModel doc) {
		System.out.print("success"+ doc);
		
		return docrepo.save(doc);
	}

	public ResponseEntity<DocumentModel> getDocumentById(Long docid) throws ResourceNotFoundException{
	
		DocumentModel status=docrepo.findById(docid).orElseThrow(() -> new ResourceNotFoundException("document not found"));
		
		
		return ResponseEntity.ok().body(status);
		}
	
	public DocumentModel updatedocument(Long id, DocumentModel doc) throws ResourceNotFoundException {
		DocumentModel DocumentModelOptional = docrepo.findById(id)
		.orElseThrow(() -> new ResourceNotFoundException("document not found for this id :: " + id));
         System.out.print("documentmodeloptional"+DocumentModelOptional);
        DocumentModel updatedDocument;

        try {
	        
	          if( (validation.isFirstName(doc.getDocument())==true &&
	        		  validation.isFirstName(doc.getName())==true)||
	        		  (validation.isEmailId(doc.getUrl())==true &&
	        		   validation.isDOB(doc.getLastUpdate())==true))
	        		
	        		  {
	        	      System.out.println("successful");
		 			DocumentModelOptional.setDocument(doc.getDocument());
		 			DocumentModelOptional.setName(doc.getName());
		 			DocumentModelOptional.setUrl(doc.getUrl());
		 			DocumentModelOptional.setLastUpdate(doc.getLastUpdate());
		 			
		 			
		 			 updatedDocument = this.docrepo.save(doc);
		 			return updatedDocument;
	         }
	       

         else
         {
       	 System.out.print("Insert data properly");
        }
        
        }
        catch(Exception e) {
        	System.out.print("Exception found");
        }
        return null;
    	
	}
	public Map<String, Boolean> deletedocument(Long docid) throws ResourceNotFoundException {
		DocumentModel user = this.docrepo.findById(docid)
		.orElseThrow(() -> new ResourceNotFoundException("document not found for this id :: " + docid));
		
		this.docrepo.delete(user);
		Map<String, Boolean> response = new HashMap<>();
		response.put("deleted", Boolean.TRUE);
		return response;
		}
}
