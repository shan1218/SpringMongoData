/**
 * 
 */
package com.sony.repository;

import java.io.Serializable;

import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.data.repository.NoRepositoryBean;

/**
 * @author SThangavelu
 *
 */
@NoRepositoryBean
public interface BaseMongoRepository<T, ID extends Serializable> extends MongoRepository<T, ID> {

	/**
	 * @param id
	 * @param domain Class
	 * @return true if deleted
	 */
	public boolean removeById(ID id, Class<T> t);

	/**
	 * @param id
	 * @param domain Class
	 * @return true if deleted
	 */
	public boolean deleteById(ID id, Class<T> t);

}
