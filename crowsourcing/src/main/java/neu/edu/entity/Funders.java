package neu.edu.entity;
// Generated Dec 12, 2017 2:07:28 AM by Hibernate Tools 5.2.6.Final

import java.util.HashSet;
import java.util.Set;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import static javax.persistence.GenerationType.IDENTITY;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;

/**
 * Funders generated by hbm2java
 */
@Entity
@Table(name = "funders", catalog = "crowdsourcing")
public class Funders implements java.io.Serializable {

	private Integer funderId;
	private String funderName;
	private String funderAddress;
	private String cardNo;
	private String expDate;
	private String cvv;
	private Set<User> users = new HashSet<User>(0);
	private Set<Purchases> purchaseses = new HashSet<Purchases>(0);

	public Funders() {
	}

	public Funders(String funderName, String funderAddress, String cardNo, String expDate, String cvv, Set<User> users,
			Set<Purchases> purchaseses) {
		this.funderName = funderName;
		this.funderAddress = funderAddress;
		this.cardNo = cardNo;
		this.expDate = expDate;
		this.cvv = cvv;
		this.users = users;
		this.purchaseses = purchaseses;
	}

	@Id
	@GeneratedValue(strategy = IDENTITY)

	@Column(name = "funder_id", unique = true, nullable = false)
	public Integer getFunderId() {
		return this.funderId;
	}

	public void setFunderId(Integer funderId) {
		this.funderId = funderId;
	}

	@Column(name = "funder_name", length = 50)
	public String getFunderName() {
		return this.funderName;
	}

	public void setFunderName(String funderName) {
		this.funderName = funderName;
	}

	@Column(name = "funder_address", length = 150)
	public String getFunderAddress() {
		return this.funderAddress;
	}

	public void setFunderAddress(String funderAddress) {
		this.funderAddress = funderAddress;
	}

	@Column(name = "card_no", length = 50)
	public String getCardNo() {
		return this.cardNo;
	}

	public void setCardNo(String cardNo) {
		this.cardNo = cardNo;
	}

	@Column(name = "exp_date", length = 50)
	public String getExpDate() {
		return this.expDate;
	}

	public void setExpDate(String expDate) {
		this.expDate = expDate;
	}

	@Column(name = "cvv", length = 50)
	public String getCvv() {
		return this.cvv;
	}

	public void setCvv(String cvv) {
		this.cvv = cvv;
	}

	@OneToMany(fetch = FetchType.LAZY, mappedBy = "funders")
	public Set<User> getUsers() {
		return this.users;
	}

	public void setUsers(Set<User> users) {
		this.users = users;
	}

	@OneToMany(fetch = FetchType.LAZY, mappedBy = "funders")
	public Set<Purchases> getPurchaseses() {
		return this.purchaseses;
	}

	public void setPurchaseses(Set<Purchases> purchaseses) {
		this.purchaseses = purchaseses;
	}

}
