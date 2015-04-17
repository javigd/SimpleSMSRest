package controller;

import models.DeliveryReceipt;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

@Controller
@RequestMapping("receipts")
public class DeliveryReceiptController {

	// private final receiptDao receiptRepository;

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
		// receiptDao.add(new DeliveryReceipt(destination, networkCode,
		// messageId, msisdn, status, errorCode, price, scts,
		// messageTimestamp, clientRef));
		return new ResponseEntity<String>(HttpStatus.OK);
	}

	@RequestMapping(method = RequestMethod.GET, value = "/get")
	public DeliveryReceipt getReceipt(@RequestParam String messageId) {
		return null;
		// return receiptDao.findByMessageId(messageId);
	}
}