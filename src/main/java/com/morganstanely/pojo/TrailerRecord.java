package com.morganstanely.pojo;

import javax.xml.bind.annotation.XmlRootElement;

public class TrailerRecord extends Records {
	private String recordType;
	private String productCode;
	private String detailsRecordCount;
	private String totalPremiumAmount;

	public String getRecordType() {
		return recordType;
	}

	public void setRecordType(String recordType) {
		this.recordType = recordType;
	}

	public String getProductCode() {
		return productCode;
	}

	public void setProductCode(String productCode) {
		this.productCode = productCode;
	}

	public String getDetailsRecordCount() {
		return detailsRecordCount;
	}

	public void setDetailsRecordCount(String detailsRecordCount) {
		this.detailsRecordCount = detailsRecordCount;
	}

	public String getTotalPremiumAmount() {
		return totalPremiumAmount;
	}

	public void setTotalPremiumAmount(String totalPremiumAmount) {
		this.totalPremiumAmount = totalPremiumAmount;
	}

}
