package com.javiagd.nexmo.rest.models;

import javax.persistence.*;

@Entity
@Table(name = "receipt")
public class DeliveryReceipt {
    
    @Id
    private String messageId;
    
    @Column(name = "destination")
    private String destination;
    
    @Column(name = "network_code")
    private String networkCode;
    
    @Column(name = "msisdn")
    private String msisdn;
    
    @Column(name = "status")
    private String status;
    
    @Column(name = "err_code")
    private String errorCode;
    
    @Column(name = "price")
    private String price;
    
    @Column(name = "scts")
    private String scts;
    
    @Column(name = "message_timestamp")
    private String messageTimestamp;
    
    @Column(name = "message_timestamp")
    private String clientRef;

    public DeliveryReceipt() {

    }

    public DeliveryReceipt(String destination, String networkCode, String messageId, String msisdn,
            String status, String errorCode, String price, String scts,
            String messageTimestamp, String clientRef) {
        this.destination = destination;

        this.networkCode = networkCode;
        this.messageId = messageId;
        this.msisdn = msisdn;
        this.status = status;
        this.errorCode = errorCode;
        this.price = price;
        this.scts = scts;
        this.messageTimestamp = messageTimestamp;
        this.clientRef = clientRef;
    }

    public String getDestination() {
        return destination;
    }

    public void setDestination(String destination) {
        this.destination = destination;
    }

    public String getNetworkCode() {
        return networkCode;
    }

    public void setNetworkCode(String networkCode) {
        this.networkCode = networkCode;
    }

    public String getMessageId() {
        return messageId;
    }

    public void setMessageId(String messageId) {
        this.messageId = messageId;
    }

    public String getMsisdn() {
        return msisdn;
    }

    public void setMsisdn(String msisdn) {
        this.msisdn = msisdn;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public String getErrorCode() {
        return errorCode;
    }

    public void setErrorCode(String errorCode) {
        this.errorCode = errorCode;
    }

    public String getPrice() {
        return price;
    }

    public void setPrice(String price) {
        this.price = price;
    }

    public String getScts() {
        return scts;
    }

    public void setScts(String scts) {
        this.scts = scts;
    }

    public String getMessageTimestamp() {
        return messageTimestamp;
    }

    public void setMessageTimestamp(String messageTimestamp) {
        this.messageTimestamp = messageTimestamp;
    }

    public String getClientRef() {
        return clientRef;
    }

    public void setClientRef(String clientRef) {
        this.clientRef = clientRef;
    }
}
