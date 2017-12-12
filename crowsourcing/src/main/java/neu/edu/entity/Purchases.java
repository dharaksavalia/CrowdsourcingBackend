package neu.edu.entity;
// Generated Dec 12, 2017 2:07:28 AM by Hibernate Tools 5.2.6.Final

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import static javax.persistence.GenerationType.IDENTITY;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

/**
 * Purchases generated by hbm2java
 */
@Entity
@Table(name = "purchases", catalog = "crowdsourcing")
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

	@Id
	@GeneratedValue(strategy = IDENTITY)

	@Column(name = "purchase_id", unique = true, nullable = false)
	public Integer getPurchaseId() {
		return this.purchaseId;
	}

	public void setPurchaseId(Integer purchaseId) {
		this.purchaseId = purchaseId;
	}

	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "funder_id", nullable = false)
	public Funders getFunders() {
		return this.funders;
	}

	public void setFunders(Funders funders) {
		this.funders = funders;
	}

	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "funding_id", nullable = false)
	public Funding getFunding() {
		return this.funding;
	}

	public void setFunding(Funding funding) {
		this.funding = funding;
	}

}
