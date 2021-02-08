package com.rec.repository;

import java.sql.Timestamp;
import java.time.LocalDateTime;
import java.util.Date;
import java.util.List;
import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import com.rec.model.RoleModel;
import com.rec.model.UserModel;
@Repository
public interface UserRepository extends JpaRepository<UserModel, Long>{

Optional<UserModel> findById(Long id);



@Query("select u from UserModel u where u.status='Active' and u.firstName LIKE ?1% or u.lastName LIKE ?1%")
public List<UserModel> search(@Param("keyword")String keyword);

@Query("select u from UserModel u where u.id=:i")
public List<UserModel> searchnumbers(Long i);

@Query("select u from UserModel u join ContactModel cm on (u.id=cm.id) where cm.PhoneNo1=:keyword or cm.PhoneNo2=:keyword")
List<UserModel> findbyphoneno(@Param("keyword")String keyword);


@Query("select u from UserModel u where u.id=:id")
public UserModel findUserID(Long id);

@Query("select u from UserModel u where u.email=:keyword")
List<UserModel> findByEmailid(String keyword);

@Query("select u from UserModel u where createdAt>=?1")
List<UserModel> finduserbydate(@Param ("keyword") Date date);



List<UserModel> findBystatus(String string);


Optional<UserModel> findByEmail(String email);








}