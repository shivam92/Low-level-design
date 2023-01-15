package com.parkinglot.model.payment;

import java.util.Date;

import com.parkinglot.adapter.PaymentAdapter;
import com.parkinglot.model.parkinglot.Base;
import com.parkinglot.model.ticket.Ticket;

public class Payment extends Base{

	private double amount;
	private String referenceNumber;
	private PaymentMode paymentMode;
	private PaymentStatus paymentStatus;
	 private Date timeOfPayment;
	    private Invoice invoice;
	   private PaymentAdapter adapetr;
	 public Payment(PaymentAdapter adapetr) {
		 this.adapetr=adapetr;
	 }
	public Date getTimeOfPayment() {
			return timeOfPayment;
		}
		public void setTimeOfPayment(Date timeOfPayment) {
			this.timeOfPayment = timeOfPayment;
		}
		public Invoice getInvoice() {
			return invoice;
		}
		public void setInvoice(Invoice invoice) {
			this.invoice = invoice;
		}
	public double getAmount() {
		return amount;
	}
	public void setAmount(double amount) {
		this.amount = amount;
	}
	public String getReferenceNumber() {
		return referenceNumber;
	}
	public void setReferenceNumber(String referenceNumber) {
		this.referenceNumber = referenceNumber;
	}
	public PaymentMode getPaymentMode() {
		return paymentMode;
	}
	public void setPaymentMode(PaymentMode paymentMode) {
		this.paymentMode = paymentMode;
	}
	public PaymentStatus getPaymentStatus() {
		return paymentStatus;
	}
	public void setPaymentStatus(PaymentStatus paymentStatus) {
		this.paymentStatus = paymentStatus;
	}
	
	public Payment makePayment(Ticket ticket) {
		this.adapetr.makePayment();
		this.paymentStatus=PaymentStatus.SUCCESS;
		this.invoice=new Invoice();
		invoice.setAmount(ticket.getCharge());
		invoice.setTicket(ticket);
		invoice.setInvoicePaidStatus(InvoicePaidStatus.PAID);
		
		return this;
	}
	
}
