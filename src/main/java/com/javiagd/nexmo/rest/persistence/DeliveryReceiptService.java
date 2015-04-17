package com.javiagd.nexmo.rest.persistence;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.javiagd.nexmo.rest.models.DeliveryReceipt;

@Service
public class DeliveryReceiptService implements PersistenceService {
	
	@Autowired
	private DeliveryReceiptRepository deliveryReceiptRepository;
	
	@Override
	public DeliveryReceipt add(DeliveryReceipt deliveryReceipt) {
		return deliveryReceiptRepository.save(deliveryReceipt);
	}

	@Override
	public DeliveryReceipt getByMessageId(String messageId) {
		return deliveryReceiptRepository.findByMessageId(messageId);
	}
	
}
