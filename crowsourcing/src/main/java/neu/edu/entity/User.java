package neu.edu.entity;
// Generated Dec 10, 2017 2:05:26 PM by Hibernate Tools 5.2.6.Final

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import static javax.persistence.GenerationType.IDENTITY;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
import javax.persistence.UniqueConstraint;

/**
 * User generated by hbm2java
 */
@Entity
@Table(name = "user", catalog = "crowdsourcing", uniqueConstraints = @UniqueConstraint(columnNames = "email_id"))
public class User implements java.io.Serializable {

	private Integer userId;
	private Creator creator;
	private Funders funders;
	private Person person;
	private Startup startup;
	private String emailId;
	private String password;
	private String admin;

	public User() {
	}

	public User(String emailId, String password) {
		this.emailId = emailId;
		this.password = password;
	}

	public User(Creator creator, Funders funders, Person person, Startup startup, String emailId, String password,
			String admin) {
		this.creator = creator;
		this.funders = funders;
		this.person = person;
		this.startup = startup;
		this.emailId = emailId;
		this.password = password;
		this.admin = admin;
	}

	@Id
	@GeneratedValue(strategy = IDENTITY)

	@Column(name = "user_id", unique = true, nullable = false)
	public Integer getUserId() {
		return this.userId;
	}

	public void setUserId(Integer userId) {
		this.userId = userId;
	}

	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "creator_id")
	public Creator getCreator() {
		return this.creator;
	}

	public void setCreator(Creator creator) {
		this.creator = creator;
	}

	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "funder_id")
	public Funders getFunders() {
		return this.funders;
	}

	public void setFunders(Funders funders) {
		this.funders = funders;
	}

	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "person_id")
	public Person getPerson() {
		return this.person;
	}

	public void setPerson(Person person) {
		this.person = person;
	}

	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "startup_id")
	public Startup getStartup() {
		return this.startup;
	}

	public void setStartup(Startup startup) {
		this.startup = startup;
	}

	@Column(name = "email_id", unique = true, nullable = false, length = 50)
	public String getEmailId() {
		return this.emailId;
	}

	public void setEmailId(String emailId) {
		this.emailId = emailId;
	}

	@Column(name = "password", nullable = false, length = 500)
	public String getPassword() {
		return this.password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	@Column(name = "admin", length = 45)
	public String getAdmin() {
		return this.admin;
	}

	public void setAdmin(String admin) {
		this.admin = admin;
	}

}
