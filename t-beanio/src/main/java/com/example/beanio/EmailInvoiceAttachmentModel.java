package com.example.beanio;

import lombok.Data;

@Data
public class EmailInvoiceAttachmentModel {
	private String buyerCode;
	private String vendorCode;
	private String fiDocNo;
	private String blockchainPaymentRef;
	private String invoiceAmount;
	private String vatAmount;
	private String whtFlag;
	private String whtAmount;
	private String businessPlace;
	private String paymentDate;
	private String netPaymentAmount;
	private String reason;
}
