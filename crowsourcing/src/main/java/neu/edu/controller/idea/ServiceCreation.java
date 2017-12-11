package neu.edu.controller.idea;


import javax.validation.constraints.NotNull;

public class ServiceCreation {
	@NotNull
	Integer maxBid;
	@NotNull
	String description;
	public Integer getServiceId() {
		return ServiceId;
	}
	public void setServiceId(Integer serviceId) {
		ServiceId = serviceId;
	}
	@NotNull
Long endDate;
	Integer ServiceId;
public Integer getMaxBid() {
	return maxBid;
}
public String getDescription() {
	return description;
}
public Long getEndDate() {
	return endDate;
}
public void setMaxBid(Integer maxBid) {
	this.maxBid = maxBid;
}
public void setDescription(String description) {
	this.description = description;
}
public void setEndDate(Long endDate) {
	this.endDate = endDate;
}

}
