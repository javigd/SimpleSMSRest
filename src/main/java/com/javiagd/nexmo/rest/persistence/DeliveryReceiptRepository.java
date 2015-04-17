package com.javiagd.nexmo.rest.persistence;

import org.springframework.data.mongodb.repository.MongoRepository;
import com.javiagd.nexmo.rest.models.DeliveryReceipt;

public interface DeliveryReceiptRepository extends MongoRepository<DeliveryReceipt, String>{
	DeliveryReceipt findByMessageId(String messageId);
}
