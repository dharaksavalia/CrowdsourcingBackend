package neu.edu.entity;
// Generated Dec 10, 2017 12:49:06 PM by Hibernate Tools 5.2.6.Final

/**
 * Purchases generated by hbm2java
 */
public class Purchases implements java.io.Serializable {

	private Integer purchaseId;
	private Funders funders;
	private Funding funding;

	public Purchases() {
	}

	public Purchases(Funders funders, Funding funding) {
		this.funders = funders;
		this.funding = funding;
	}

	public Integer getPurchaseId() {
		return this.purchaseId;
	}

	public void setPurchaseId(Integer purchaseId) {
		this.purchaseId = purchaseId;
	}

	public Funders getFunders() {
		return this.funders;
	}

	public void setFunders(Funders funders) {
		this.funders = funders;
	}

	public Funding getFunding() {
		return this.funding;
	}

	public void setFunding(Funding funding) {
		this.funding = funding;
	}

}