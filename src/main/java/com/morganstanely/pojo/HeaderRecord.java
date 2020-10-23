package com.morganstanely.pojo;

public class HeaderRecord extends Records {
	private String recordType;
	private String productCode;
	private String fileCreationDate;
	private String billingDate;

	public String getProductCode() {
		return productCode;
	}

	public void setProductCode(String productCode) {
		this.productCode = productCode;
	}

	public String getFileCreationDate() {
		return fileCreationDate;
	}

	public void setFileCreationDate(String fileCreationDate) {
		this.fileCreationDate = fileCreationDate;
	}

	public String getBillingDate() {
		return billingDate;
	}

	public void setBillingDate(String billingDate) {
		this.billingDate = billingDate;
	}

	public String getRecordType() {
		return recordType;
	}

	public void setRecordType(String recordType) {
		this.recordType = recordType;
	}

}
