package com.rec.dao.service;

import java.util.List;
import java.util.Map;
import java.util.Optional;

import org.springframework.http.ResponseEntity;

import com.rec.exception.ResourceNotFoundException;
import com.rec.model.RoleModel;

public interface RoleService {

List<RoleModel> getAllRoles();

Optional<RoleModel> getRole(long id);

RoleModel saveRole(RoleModel role);

Map<String, Boolean> deleteRole(long id) throws ResourceNotFoundException;

RoleModel updateRole(long id,RoleModel role) throws ResourceNotFoundException;

ResponseEntity<Object> addRole(RoleModel role);

}