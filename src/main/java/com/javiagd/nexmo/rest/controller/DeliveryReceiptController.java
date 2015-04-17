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
			@RequestParam(value = "to") String destination,
			@RequestParam(required = false, value = "network-code", defaultValue="null") String networkCode,
			@RequestParam(value = "messageId") String messageId,
			@RequestParam(value = "msisdn") String msisdn,
			@RequestParam(value = "status") String status,
			@RequestParam(value = "err-code") String errorCode,
			@RequestParam(value = "price") String price,
			@RequestParam(value = "scts") String scts,
			@RequestParam(value = "message-timestamp") String messageTimestamp,
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