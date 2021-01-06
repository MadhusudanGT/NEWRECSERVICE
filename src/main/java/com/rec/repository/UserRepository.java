package com.rec.repository;

import java.util.List;
import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import com.rec.model.RoleModel;
import com.rec.model.UserModel;

public interface UserRepository extends JpaRepository<UserModel, Long>{
	
	Optional<UserModel> findById(Long id);
	
	
	@Query("select u from UserModel u where u.Status='Active' and u.FirstName LIKE ?1% or u.LastName LIKE ?1%")   
	public List<UserModel> search(@Param("keyword")String keyword);

	//@Query("select r from RoleModel r where r.roleID LIKE ?1%")
	@Query("select u from UserModel u where u.id=:i")
	public List<UserModel> searchnumbers(Long i);


	@Query("select r from RoleModel r where r.id=:id")
	public RoleModel findRoleID(Long id);

//	@Query("select u from UserModel u where u.UpdatedAt<=:currentdate")
//	public List<UserModel> finduserbydate(@Param("keyword")String currentdate);

}
