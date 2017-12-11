package neu.edu.controller.bid;

public class BidCreation {
private Integer bidAmount;
private String description;
private Long timeRequired;
private Integer bidId;
public Integer getBidId() {
	return bidId;
}
public void setBidId(Integer bidId) {
	this.bidId = bidId;
}
public Integer getBidAmount() {
	return bidAmount;
}
public String getDescription() {
	return description;
}
public Long getTimeRequired() {
	return timeRequired;
}
public void setBidAmount(Integer bidAmount) {
	this.bidAmount = bidAmount;
}
public void setDescription(String description) {
	this.description = description;
}
public void setTimeRequired(Long timeRequired) {
	this.timeRequired = timeRequired;
}

}
