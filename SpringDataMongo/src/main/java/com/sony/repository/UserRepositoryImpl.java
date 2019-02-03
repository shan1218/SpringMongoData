package com.sony.repository;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.mongodb.core.MongoTemplate;
import org.springframework.data.mongodb.core.query.Criteria;
import org.springframework.data.mongodb.core.query.Query;
import org.springframework.data.mongodb.core.query.Update;
import org.springframework.stereotype.Component;

import com.mongodb.client.result.UpdateResult;
import com.sony.collection.User;

@Component
public class UserRepositoryImpl {

	@Autowired
	private MongoTemplate mongoTemplate;

	public List<User> find(Query query){
		return mongoTemplate.find(query, User.class);
	}
	
	public long count(Query countQuery){
		return mongoTemplate.count(countQuery, User.class);
	}

	public long updateSiteAccouncementReviewed(boolean flag){
		UpdateResult wr = mongoTemplate.updateMulti(new Query(Criteria.where("isDeleted").is(false)),
				  new Update().set("isDeleted", flag), User.class);
		return wr.getModifiedCount();
	}

	public long updateSiteAccouncementReviewed(List<String> firstName, boolean flag){
		UpdateResult wr = mongoTemplate.updateMulti(new Query(Criteria.where("isDeleted").is(false).and("firstName").in(firstName)),
				  new Update().set("isDeleted", flag), User.class);
		return wr.getModifiedCount();
	}
}
