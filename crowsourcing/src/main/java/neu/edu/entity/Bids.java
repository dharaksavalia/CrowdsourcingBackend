package neu.edu.entity;
// Generated Dec 10, 2017 2:05:26 PM by Hibernate Tools 5.2.6.Final

import java.util.Date;
import java.util.HashSet;
import java.util.Set;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import static javax.persistence.GenerationType.IDENTITY;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

/**
 * Bids generated by hbm2java
 */
@Entity
@Table(name = "bids", catalog = "crowdsourcing")
public class Bids implements java.io.Serializable {

	private Integer bidId;
	private ServiceDetail serviceDetail;
	private Startup startup;
	private int bidAmount;
	private String description;
	private Date timeRequired;
	private String status;
	private Set<WorkTable> workTables = new HashSet<WorkTable>(0);

	public Bids() {
	}

	public Bids(ServiceDetail serviceDetail, Startup startup, int bidAmount, String description, Date timeRequired,
			String status) {
		this.serviceDetail = serviceDetail;
		this.startup = startup;
		this.bidAmount = bidAmount;
		this.description = description;
		this.timeRequired = timeRequired;
		this.status = status;
	}

	public Bids(ServiceDetail serviceDetail, Startup startup, int bidAmount, String description, Date timeRequired,
			String status, Set<WorkTable> workTables) {
		this.serviceDetail = serviceDetail;
		this.startup = startup;
		this.bidAmount = bidAmount;
		this.description = description;
		this.timeRequired = timeRequired;
		this.status = status;
		this.workTables = workTables;
	}

	@Id
	@GeneratedValue(strategy = IDENTITY)

	@Column(name = "bid_id", unique = true, nullable = false)
	public Integer getBidId() {
		return this.bidId;
	}

	public void setBidId(Integer bidId) {
		this.bidId = bidId;
	}

	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "service_id", nullable = false)
	public ServiceDetail getServiceDetail() {
		return this.serviceDetail;
	}

	public void setServiceDetail(ServiceDetail serviceDetail) {
		this.serviceDetail = serviceDetail;
	}

	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "startup_id", nullable = false)
	public Startup getStartup() {
		return this.startup;
	}

	public void setStartup(Startup startup) {
		this.startup = startup;
	}

	@Column(name = "bid_amount", nullable = false)
	public int getBidAmount() {
		return this.bidAmount;
	}

	public void setBidAmount(int bidAmount) {
		this.bidAmount = bidAmount;
	}

	@Column(name = "description", nullable = false, length = 50)
	public String getDescription() {
		return this.description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	@Temporal(TemporalType.TIMESTAMP)
	@Column(name = "time_required", nullable = false, length = 19)
	public Date getTimeRequired() {
		return this.timeRequired;
	}

	public void setTimeRequired(Date timeRequired) {
		this.timeRequired = timeRequired;
	}

	@Column(name = "status", nullable = false, length = 50)
	public String getStatus() {
		return this.status;
	}

	public void setStatus(String status) {
		this.status = status;
	}

	@OneToMany(fetch = FetchType.LAZY, mappedBy = "bids")
	public Set<WorkTable> getWorkTables() {
		return this.workTables;
	}

	public void setWorkTables(Set<WorkTable> workTables) {
		this.workTables = workTables;
	}

}
