package neu.edu.controller.user;

import javax.validation.constraints.NotNull;

public class UserCreation {
@NotNull	
private String emailId;
@NotNull
private String password;
@NotNull
private String firstName;
@NotNull
private String lastName;
private String funders;
private String startup;
@Override
public String toString() {
	return "UserCreation [emailId=" + emailId + ", password=" + password + ", firstName=" + firstName + ", lastName="
			+ lastName + ", funders=" + funders + ", startup=" + startup + ", creator=" + creator + ", category="
			+ category + "]";
}
private String creator;
private String category;
public String getCategory() {
	return category;
}
public void setCategory(String category) {
	this.category = category;
}
public String getFunders() {
	return funders;
}
public String getStartup() {
	return startup;
}
public String getCreator() {
	return creator;
}
public void setFunders(String funders) {
	this.funders = funders;
}
public void setStartup(String startup) {
	this.startup = startup;
}
public void setCreator(String creator) {
	this.creator = creator;
}
public String getLastName() {
	return lastName;
}
public String getFirstName() {
	return firstName;
}
public void setFirstName(String firstName) {
	this.firstName = firstName;
}
public void setLastName(String lastName) {
	this.lastName = lastName;
}
public String getEmailId() {
	return emailId;
}
public String getPassword() {
	return password;
}

public void setEmailId(String emailId) {
	this.emailId = emailId;
}
public void setPassword(String password) {
	this.password = password;
}


}
