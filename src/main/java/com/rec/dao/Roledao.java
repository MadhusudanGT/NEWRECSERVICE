package com.rec.dao;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Optional;
import javax.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.rec.exception.ResourceNotFoundException;

import com.rec.dao.service.RoleService;
import com.rec.model.RoleModel;
import com.rec.repository.RoleRepository;


@Service
public class Roledao implements RoleService {
@Autowired
RoleRepository repo;




@Override
public List<RoleModel> getAllRoles() {
return this.repo.findAll();
}

@Override
public Optional<RoleModel> getRole(long id) {
return this.repo.findById(id);
}

@Override
public RoleModel saveRole(@Valid RoleModel role) {
role.setUpdatedAt(null);
return this.repo.save(role);

}


@Override
public Map<String, Boolean> deleteRole(long id)throws ResourceNotFoundException {
RoleModel rolemodel = this.repo.findById(id)
.orElseThrow(() -> new ResourceNotFoundException("User not found for this id :: " + id));

this.repo.delete(rolemodel);
Map<String, Boolean> response = new HashMap<>();
response.put("deleted", Boolean.TRUE);
return response;
}

@Override
public RoleModel updateRole(long id,RoleModel role) throws ResourceNotFoundException {
RoleModel rolemodel = this.repo.findById(id)
.orElseThrow(() -> new ResourceNotFoundException("User not found for this id :: " + id));
role.setCreatedAt(rolemodel.getCreatedAt());
role.setUpdatedAt(new java.util.Date());
final RoleModel updatedrole = this.repo.save(role);
return updatedrole;
}
}