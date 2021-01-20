package com.rec.repository;

import java.sql.Timestamp;
import java.time.LocalDateTime;
import java.util.Date;
import java.util.List;
import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import com.rec.model.RoleModel;
import com.rec.model.UserModel;

public interface UserRepository extends JpaRepository<UserModel, Long>{


Optional<UserModel> findById(Long id);

//	select * from rec.user u inner JOIN rec.contact_model cm ON(u.id=cm.id)
//	where phone_no1 ='1234567896' or pincode =543201 or u.id =1 and u.status ='Active';


@Query("select u from UserModel u where u.Status='Active' and u.FirstName LIKE ?1% or u.LastName LIKE ?1%")
public List<UserModel> search(@Param("keyword")String keyword);


// select * from rec.user u inner JOIN rec.contact_model cm ON(u.id=cm.id)
// where phone_no1 ='1234567896' or pincode =543201 or u.id =1 and u.status ='Active';
@Query("select u from UserModel u where u.id=:i")
public List<UserModel> searchnumbers(Long i);

@Query("select u from UserModel u join ContactModel cm on (u.id=cm.id) where cm.PhoneNo1=:keyword or cm.PhoneNo2=:keyword")
List<UserModel> findbyphoneno(@Param("keyword")String keyword);

//	@Query("select u from UserModel u where u.UpdatedAt<=:currentdate")
//	public List<UserModel> finduserbydate(@Param("keyword")String currentdate);
	//select * from rec.user u where u.updated_at between '2018-01-04' and '2020-05-04';
	//select * from rec.user u join rec.role r on (u.id=r.id) where r.title !='manger' and u.updated_at ='2019-01-04 09:14:53';
	


@Query("select r from RoleModel r where r.id=:id")
public RoleModel findRoleID(Long id);

@Query("select u from UserModel u where u.Email=:keyword")
List<UserModel> findByEmailid(String keyword);

@Query("select u from UserModel u where CreatedAt>=?1")
List<UserModel> finduserbydate(@Param ("keyword") Date date);

// @Query("select u from UserModel u where u.UpdatedAt<=:currentdate")
// public List<UserModel> finduserbydate(@Param("keyword")String currentdate);
//select * from rec.user u where u.updated_at between '2018-01-04' and '2020-05-04';
//select * from rec.user u join rec.role r on (u.id=r.id) where r.title !='manger' and u.updated_at ='2019-01-04 09:14:53';
@Query("select u from UserModel u where u.CreatedAt between 'fdt' and 'currentdate'")
public List<UserModel> finduserbydate(Timestamp fdt,LocalDateTime currentdate);

}