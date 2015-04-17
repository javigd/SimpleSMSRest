package com.javiagd.nexmo.rest.persistence;

import org.springframework.data.mongodb.core.MongoOperations;
import org.springframework.data.mongodb.core.query.Criteria;
import org.springframework.data.mongodb.core.query.Query;

import com.javiagd.nexmo.rest.models.DeliveryReceipt;
import com.mongodb.MongoException;

public class DeliveryReceiptDAO implements PersistenceDAO {
	
	private MongoOperations mongoOps;
    private static final String RECEIPT_COLLECTION = "DeliveryReceipt";
    
    public DeliveryReceiptDAO(MongoOperations mongoOps){
        this.mongoOps=mongoOps;
    }
    
	@Override
	public void add(DeliveryReceipt deliveryReceipt) throws MongoException {
		mongoOps.insert(deliveryReceipt, RECEIPT_COLLECTION);
	}

	@Override
	public DeliveryReceipt getByMessageId(String messageId) throws MongoException {
        Query query = new Query(Criteria.where("_id").is(messageId));
        return this.mongoOps.findOne(query, DeliveryReceipt.class, RECEIPT_COLLECTION);
	}
	
}
