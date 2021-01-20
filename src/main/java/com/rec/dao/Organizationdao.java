package com.rec.dao;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import com.rec.exception.ResourceNotFoundException;
import com.rec.model.JobPosition;
import com.rec.model.OrganizationModel;
import com.rec.repository.OrganizationRepository;
@Service
public class Organizationdao {
@Autowired OrganizationRepository orgrepo;

	public Map<String, Boolean> deleteuser(Long uid) throws ResourceNotFoundException {
		OrganizationModel user = this.orgrepo.findById(uid)
				.orElseThrow(() -> new ResourceNotFoundException("user not found for this id :: " + uid));

		this.orgrepo.delete(user);
		Map<String, Boolean> response = new HashMap<>();
		response.put("deleted", Boolean.TRUE);
		return response;
	}
	public ResponseEntity<OrganizationModel> finduserbyid(Long uid) throws com.rec.exception.ResourceNotFoundException {
		OrganizationModel user = this.orgrepo.findById(uid)
				.orElseThrow(() -> new com.rec.exception.ResourceNotFoundException("User not found for this id :: " + uid));
		return ResponseEntity.ok().body(user);
	}

	public OrganizationModel updateemp(Long id, OrganizationModel emp) throws com.rec.exception.ResourceNotFoundException {
		OrganizationModel user = this.orgrepo.findById(id)
				.orElseThrow(() -> new com.rec.exception.ResourceNotFoundException("User not found for this id :: " + id));

		user.setOrgName(emp.getOrgName());
		user.setOrgDescription(emp.getOrgDescription());
		user.setId(user.getId());
		user.setJobmodel(emp.getJobmodel());
		return orgrepo.save(user);
		
	}



	public OrganizationModel saveposition(OrganizationModel org) {
		System.out.print(org);
		OrganizationModel result=orgrepo.save(org);
		return result;
	}

	public List<OrganizationModel> getAllposition() {
		return orgrepo.findAll();
	}

}