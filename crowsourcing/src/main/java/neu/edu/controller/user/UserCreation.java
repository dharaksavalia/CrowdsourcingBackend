package neu.edu.controller.user;

import javax.validation.constraints.NotNull;

public class UserCreation {
@NotNull	
private String emailId;
@NotNull
private String password;
private String firstName;
private String lastName;
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
