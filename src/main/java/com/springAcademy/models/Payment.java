package com.springAcademy.models;

import java.util.Date;

public class Payment extends BaseModel {

    private int amount;
    private PaymentMode paymentMode;
    private PaymentStatus paymentSTatus;
    private Date time;
    private String referenceNumber;

    public PaymentStatus getPaymentSTatus() {
        return paymentSTatus;
    }

    public void setPaymentSTatus(PaymentStatus paymentSTatus) {
        this.paymentSTatus = paymentSTatus;
    }

    public int getAmount() {
        return amount;
    }

    public void setAmount(int amount) {
        this.amount = amount;
    }

    public PaymentMode getPaymentMode() {
        return paymentMode;
    }

    public void setPaymentMode(PaymentMode paymentMode) {
        this.paymentMode = paymentMode;
    }


    public Date getTime() {
        return time;
    }

    public void setTime(Date time) {
        this.time = time;
    }

    public String getReferenceNumber() {
        return referenceNumber;
    }

    public void setReferenceNumber(String referenceNumber) {
        this.referenceNumber = referenceNumber;
    }
}
