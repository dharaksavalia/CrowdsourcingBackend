package neu.edu.entity;
// Generated Dec 10, 2017 12:49:06 PM by Hibernate Tools 5.2.6.Final

import java.util.HashSet;
import java.util.Set;

/**
 * Funding generated by hbm2java
 */
public class Funding implements java.io.Serializable {

	private Integer fundingId;
	private Idea idea;
	private int maxUser;
	private int unit;
	private int amount;
	private Set purchaseses = new HashSet(0);

	public Funding() {
	}

	public Funding(Idea idea, int maxUser, int unit, int amount) {
		this.idea = idea;
		this.maxUser = maxUser;
		this.unit = unit;
		this.amount = amount;
	}

	public Funding(Idea idea, int maxUser, int unit, int amount, Set purchaseses) {
		this.idea = idea;
		this.maxUser = maxUser;
		this.unit = unit;
		this.amount = amount;
		this.purchaseses = purchaseses;
	}

	public Integer getFundingId() {
		return this.fundingId;
	}

	public void setFundingId(Integer fundingId) {
		this.fundingId = fundingId;
	}

	public Idea getIdea() {
		return this.idea;
	}

	public void setIdea(Idea idea) {
		this.idea = idea;
	}

	public int getMaxUser() {
		return this.maxUser;
	}

	public void setMaxUser(int maxUser) {
		this.maxUser = maxUser;
	}

	public int getUnit() {
		return this.unit;
	}

	public void setUnit(int unit) {
		this.unit = unit;
	}

	public int getAmount() {
		return this.amount;
	}

	public void setAmount(int amount) {
		this.amount = amount;
	}

	public Set getPurchaseses() {
		return this.purchaseses;
	}

	public void setPurchaseses(Set purchaseses) {
		this.purchaseses = purchaseses;
	}

}
