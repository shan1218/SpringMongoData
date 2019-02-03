package com.sony.repository;

import java.util.List;
import java.util.Optional;
import java.util.Set;

import org.springframework.data.domain.Sort;
import org.springframework.data.mongodb.repository.Query;

import com.sony.collection.User;

public interface UserRepository extends BaseMongoRepository<User, String> { 
	
	public List<User> findByIdIn(Set<String> ids);
	
	public List<User> findByUserNameAndIsDeleted(String userName, boolean isDeleted);
	
	public List<User> findByUserNameIgnoreCaseAndIsDeleted(String userName, boolean isDeleted);
	
	@Query(value ="{'isDeleted':false}")
	public List<User> findByFirstNameOrLastName(String FirstName,String LastName);
	
	@Query(value ="{'isDeleted':false}")
	public List<User> findByAll(Sort sort);
	
	@Query(value ="{'isDeleted':false ,'userName' : ?0  }")
	public Optional<User> findNonDeletedUserByUserName(String userName);

}
