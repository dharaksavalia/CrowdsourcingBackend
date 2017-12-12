package neu.edu.controller.creator;

public class CreatorCreation {
	String name;
	Integer creatorId;
	Long LastDate;
	String Reason;
	public String getReason() {
		return Reason;
	}
	public String getStatus() {
		return Status;
	}
	public void setReason(String reason) {
		Reason = reason;
	}
	public void setStatus(String status) {
		Status = status;
	}
	String Status;
	public String getName() {
		return name;
	}
	public Integer getCreatorId() {
		return creatorId;
	}
	
	
	public void setName(String name) {
		this.name = name;
	}
	public void setCreatorId(Integer creatorId) {
		this.creatorId = creatorId;
	}
	public void setLastDate(Long lastIdeaDate) {
		// TODO Auto-generated method stub
		this.LastDate=lastIdeaDate;
	}
	
}
