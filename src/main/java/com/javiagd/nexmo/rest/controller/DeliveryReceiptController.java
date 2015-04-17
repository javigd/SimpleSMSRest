package com.javiagd.nexmo.rest.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import com.javiagd.nexmo.rest.models.DeliveryReceipt;
import com.javiagd.nexmo.rest.persistence.DeliveryReceiptDAO;

@Controller
@RequestMapping("receipts")
public class DeliveryReceiptController {

	@Autowired
	private DeliveryReceiptDAO deliveryReceiptService;

	@RequestMapping(method = RequestMethod.GET, value = "/receipt")
	public ResponseEntity<String> receipt(
			@RequestParam(value = "to") String destination,
			@RequestParam(required = false, value = "network-code") String networkCode,
			@RequestParam(value = "messageId") String messageId,
			@RequestParam(value = "msisdn") String msisdn,
			@RequestParam(value = "status") String status,
			@RequestParam(value = "err-code") String errorCode,
			@RequestParam(value = "price") String price,
			@RequestParam(value = "scts") String scts,
			@RequestParam(value = "message-timestamp") String messageTimestamp,
			@RequestParam(required = false, value = "client-ref") String clientRef) {
		deliveryReceiptService.add(new DeliveryReceipt(destination, networkCode,
				messageId, msisdn, status, errorCode, price, scts,
				messageTimestamp, clientRef));
		return new ResponseEntity<String>(HttpStatus.OK);
	}

	@RequestMapping(method = RequestMethod.GET, value = "/get")
	public @ResponseBody DeliveryReceipt getReceipt(@RequestParam String messageId) {
		return deliveryReceiptService.getByMessageId(messageId);
	}
}