package com.OMS.model;

import static org.springframework.data.mongodb.core.FindAndModifyOptions.options;
import static org.springframework.data.mongodb.core.query.Criteria.where;
import static org.springframework.data.mongodb.core.query.Query.query;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.mongodb.core.MongoOperations;
import org.springframework.data.mongodb.core.query.Update;
import org.springframework.stereotype.Service;

@Service
public class Sequence {

	@Autowired
	private MongoOperations mongo;

	public Long getNextCustomerSequence(String string) {
		UserSeq counter = mongo.findAndModify(query(where("_id").is(string)), new Update().inc("seq", 1),
				options().returnNew(true).upsert(true), UserSeq.class);
		return counter.getSeq();
	}

	

}
