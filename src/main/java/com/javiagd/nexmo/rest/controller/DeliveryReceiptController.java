package com.javiagd.nexmo.rest.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import com.javiagd.nexmo.rest.models.DeliveryReceipt;
import com.javiagd.nexmo.rest.persistence.DeliveryReceiptDAO;
import com.mongodb.MongoException;

@Controller
public class DeliveryReceiptController {

	@Autowired
	private DeliveryReceiptDAO deliveryReceiptService;

	@RequestMapping(method = RequestMethod.GET, value = "/receipt")
	public ResponseEntity<String> receipt(
			@RequestParam(required = false, value = "to", defaultValue="null") String destination,
			@RequestParam(required = false, value = "network-code", defaultValue="null") String networkCode,
			@RequestParam(required = false, value = "messageId", defaultValue="null") String messageId,
			@RequestParam(required = false, value = "msisdn", defaultValue="null") String msisdn,
			@RequestParam(required = false, value = "status", defaultValue="null") String status,
			@RequestParam(required = false, value = "err-code", defaultValue="null") String errorCode,
			@RequestParam(required = false, value = "price", defaultValue="null") String price,
			@RequestParam(required = false, value = "scts", defaultValue="null") String scts,
			@RequestParam(required = false, value = "message-timestamp") String messageTimestamp,
			@RequestParam(required = false, value = "client-ref", defaultValue="null") String clientRef) {
		try {
			deliveryReceiptService.add(new DeliveryReceipt(destination, networkCode,
					messageId, msisdn, status, errorCode, price, scts,
					messageTimestamp, clientRef));
		} catch (MongoException e) {
			return new ResponseEntity<String>(HttpStatus.INTERNAL_SERVER_ERROR);
		}
		return new ResponseEntity<String>(HttpStatus.OK);
	}

	@RequestMapping(method = RequestMethod.GET, value = "/get")
	public @ResponseBody DeliveryReceipt getReceipt(@RequestParam String messageId) {
		DeliveryReceipt deliveryReceipt = null;
		try {
			deliveryReceipt = deliveryReceiptService.getByMessageId(messageId);
		} catch (MongoException e) {
			return null;
		}
		return deliveryReceipt;
	}
}