package neu.edu.controller.idea;

import java.util.Date;
import java.util.List;

import javax.validation.constraints.NotNull;

public class IdeaCreation {
	@NotNull
	String name;
	@Override
	public String toString() {
		return "IdeaCreation [Name=" + name + ", description=" + description + ", totalFunds=" + totalFunds
				+ ", endDate=" + endDate + ", serviceCreations=" + serviceCreations + ", fundingCreations="
				+ fundingCreations + ", category=" + category + "]";
	}
	@NotNull
	String description;
	@NotNull
	Integer totalFunds;
	@NotNull
	Long endDate;
	@NotNull
	List<ServiceCreation>serviceCreations;
	@NotNull
	List<FundingCreation>fundingCreations;
	@NotNull
	String category;
	Integer IdeaId;
	public Integer getIdeaId() {
		return IdeaId;
	}
	public void setIdeaId(Integer ideaId) {
		IdeaId = ideaId;
	}
	public String getName() {
		return name;
	}
	public String getDescription() {
		return description;
	}
	public Integer getTotalFunds() {
		return totalFunds;
	}
	public Long getEndDate() {
		return endDate;
	}
	public List<ServiceCreation> getServiceCreations() {
		return serviceCreations;
	}
	public List<FundingCreation> getFundingCreations() {
		return fundingCreations;
	}
	public void setName(String name) {
		this.name = name;
	}
	public void setCategory(String category) {
		this.category = category;
	}
	public String getCategory() {
		return category;
	}
	public void setDescription(String description) {
		this.description = description;
	}
	public void setTotalFunds(Integer totalFunds) {
		this.totalFunds = totalFunds;
	}
	public void setEndDate(Long endDate) {
		this.endDate = endDate;
	}
	public void setServiceCreations(List<ServiceCreation> serviceCreations) {
		this.serviceCreations = serviceCreations;
	}
	public void setFundingCreations(List<FundingCreation> fundingCreations) {
		this.fundingCreations = fundingCreations;
	}
	
}
