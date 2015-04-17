package com.javiagd.nexmo.rest.persistence;

import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

import com.javiagd.nexmo.rest.models.DeliveryReceipt;

@Repository
public interface DeliveryReceiptRepository extends MongoRepository<DeliveryReceipt, String>{
	DeliveryReceipt findByMessageId(String messageId);
}
