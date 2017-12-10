package neu.edu.entity;
// Generated Dec 10, 2017 12:49:06 PM by Hibernate Tools 5.2.6.Final

import java.util.HashSet;
import java.util.Set;

/**
 * Funders generated by hbm2java
 */
public class Funders implements java.io.Serializable {

	private Integer funderId;
	private String funderName;
	private String funderAddress;
	private String cardNo;
	private String expDate;
	private String cvv;
	private Set users = new HashSet(0);
	private Set purchaseses = new HashSet(0);

	public Funders() {
	}

	public Funders(String funderName) {
		this.funderName = funderName;
	}

	public Funders(String funderName, String funderAddress, String cardNo, String expDate, String cvv, Set users,
			Set purchaseses) {
		this.funderName = funderName;
		this.funderAddress = funderAddress;
		this.cardNo = cardNo;
		this.expDate = expDate;
		this.cvv = cvv;
		this.users = users;
		this.purchaseses = purchaseses;
	}

	public Integer getFunderId() {
		return this.funderId;
	}

	public void setFunderId(Integer funderId) {
		this.funderId = funderId;
	}

	public String getFunderName() {
		return this.funderName;
	}

	public void setFunderName(String funderName) {
		this.funderName = funderName;
	}

	public String getFunderAddress() {
		return this.funderAddress;
	}

	public void setFunderAddress(String funderAddress) {
		this.funderAddress = funderAddress;
	}

	public String getCardNo() {
		return this.cardNo;
	}

	public void setCardNo(String cardNo) {
		this.cardNo = cardNo;
	}

	public String getExpDate() {
		return this.expDate;
	}

	public void setExpDate(String expDate) {
		this.expDate = expDate;
	}

	public String getCvv() {
		return this.cvv;
	}

	public void setCvv(String cvv) {
		this.cvv = cvv;
	}

	public Set getUsers() {
		return this.users;
	}

	public void setUsers(Set users) {
		this.users = users;
	}

	public Set getPurchaseses() {
		return this.purchaseses;
	}

	public void setPurchaseses(Set purchaseses) {
		this.purchaseses = purchaseses;
	}

}
