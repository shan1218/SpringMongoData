package com.sony.repository;

import java.io.Serializable;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.mongodb.core.MongoTemplate;
import org.springframework.data.mongodb.repository.query.MongoEntityInformation;
import org.springframework.data.mongodb.repository.support.SimpleMongoRepository;

import com.mongodb.client.result.DeleteResult;

public class BaseMongoRepositoryImpl<T, ID extends Serializable> extends SimpleMongoRepository<T, ID>
		implements BaseMongoRepository<T, ID> {

	@Autowired
	private MongoTemplate mongoTemplate;

	public BaseMongoRepositoryImpl(MongoEntityInformation<T, ID> metadata, MongoTemplate pMongoTemplate) {
		super(metadata, pMongoTemplate);
		this.mongoTemplate = pMongoTemplate;
	}
	
	@Override
	public boolean removeById(ID id, Class<T> t) {
		long deletedCount = checkAndDelete(id, t);
		return deletedCount > 0;
	}

	@Override
	public boolean deleteById(ID id, Class<T> t) {
		long deletedCount = checkAndDelete(id, t);
		return deletedCount > 0;
	}

	private long checkAndDelete(ID id, Class<T> t) {
		long deletedCount = 0;
		T findById = mongoTemplate.findById(id, t);
		if (findById != null) {
			DeleteResult remove = mongoTemplate.remove(findById);
			deletedCount = remove.getDeletedCount();
		}
		return deletedCount;
	}

	public void setMongoTemplate(MongoTemplate mongoTemplate) {
		this.mongoTemplate = mongoTemplate;
	}

	public MongoTemplate getMongoTemplate() {
		return mongoTemplate;
	}

}
