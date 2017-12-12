package neu.edu.controller.funder;

import java.util.List;

public class FunderCreation {
private String fundName;
private String funderAddress;
private String cardNo;
private String expDate;
private String cvv;
List<Integer>categoryIds;
public String getFundName() {
	return fundName;
}
public String getFunderAddress() {
	return funderAddress;
}
public String getCardNo() {
	return cardNo;
}
public String getExpDate() {
	return expDate;
}
public String getCvv() {
	return cvv;
}
public List<Integer> getCategoryIds() {
	return categoryIds;
}
public void setFundName(String fundName) {
	this.fundName = fundName;
}
public void setFunderAddress(String funderAddress) {
	this.funderAddress = funderAddress;
}
public void setCardNo(String cardNo) {
	this.cardNo = cardNo;
}
public void setExpDate(String expDate) {
	this.expDate = expDate;
}
public void setCvv(String cvv) {
	this.cvv = cvv;
}
public void setCategoryIds(List<Integer> categoryIds) {
	this.categoryIds = categoryIds;
}
}
