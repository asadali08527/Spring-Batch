package com.morganstanely.pojo;

public class DetailRecord extends Records {
	private String recordType;
	private String productCode;
	private String policyContractId;
	private String employeeId;
	private String memberSpouseIndicator;
	private String paidByIndicator;
	private String premiumAmount;
	private String lastName;
	private String firstName;
	private String collectionNumber;

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

	public String getPolicyContractId() {
		return policyContractId;
	}

	public void setPolicyContractId(String policyContractId) {
		this.policyContractId = policyContractId;
	}

	public String getEmployeeId() {
		return employeeId;
	}

	public void setEmployeeId(String employeeId) {
		this.employeeId = employeeId;
	}

	public String getMemberSpouseIndicator() {
		return memberSpouseIndicator;
	}

	public void setMemberSpouseIndicator(String memberSpouseIndicator) {
		this.memberSpouseIndicator = memberSpouseIndicator;
	}

	public String getPaidByIndicator() {
		return paidByIndicator;
	}

	public void setPaidByIndicator(String paidByIndicator) {
		this.paidByIndicator = paidByIndicator;
	}

	public String getPremiumAmount() {
		return premiumAmount;
	}

	public void setPremiumAmount(String premiumAmount) {
		this.premiumAmount = premiumAmount;
	}

	public String getLastName() {
		return lastName;
	}

	public void setLastName(String lastName) {
		this.lastName = lastName;
	}

	public String getFirstName() {
		return firstName;
	}

	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}

	public String getCollectionNumber() {
		return collectionNumber;
	}

	public void setCollectionNumber(String collectionNumber) {
		this.collectionNumber = collectionNumber;
	}

}
