package com.javiagd.nexmo.rest.persistence;

import com.javiagd.nexmo.rest.models.DeliveryReceipt;

public interface PersistenceDAO {

	public void add(DeliveryReceipt deliveryReceipt);
	
	public DeliveryReceipt getByMessageId(String messageId);
	
}
