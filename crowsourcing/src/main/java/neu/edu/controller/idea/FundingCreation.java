package neu.edu.controller.idea;

import javax.validation.constraints.NotNull;

public class FundingCreation {
	@NotNull
	Integer maxUsers;
	@NotNull
	Integer unit;
	@NotNull
	Integer amount;
	Integer FundingId;
	public Integer getFundingId() {
		return FundingId;
	}
	public void setFundingId(Integer fundingId) {
		FundingId = fundingId;
	}
	public Integer getMaxUsers() {
		return maxUsers;
	}
	public Integer getUnit() {
		return unit;
	}
	public Integer getAmount() {
		return amount;
	}
	public void setMaxUsers(Integer maxUsers) {
		this.maxUsers = maxUsers;
	}
	public void setUnit(Integer unit) {
		this.unit = unit;
	}
	public void setAmount(Integer amount) {
		this.amount = amount;
	}

}
