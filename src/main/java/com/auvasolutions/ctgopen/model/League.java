package com.auvasolutions.ctgopen.model;
import jakarta.persistence.*;
import java.util.Date;

@Entity
@Table(name = "LEAGUE")
public class League {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private Long id;

    @Column(name = "name")
    private String name;

    @Column(name = "type")
    private String type;

    @Column(name = "start_date")
    @Temporal(TemporalType.DATE)
    private Date startDate;

    @Column(name = "end_date")
    @Temporal(TemporalType.DATE)
    private Date endDate;

    @Column(name = "registration_start_date")
    @Temporal(TemporalType.DATE)
    private Date registrationStartDate;

    @Column(name = "registration_end_date")
    @Temporal(TemporalType.DATE)
    private Date registrationEndDate;

    @Column(name = "registration_fee")
    private double registrationFee;

    @Column(name = "created_date")
    @Temporal(TemporalType.TIMESTAMP)
    private Date createdDate;

    @Column(name = "modified_date")
    @Temporal(TemporalType.TIMESTAMP)
    private Date modifiedDate;

    // Constructors, getters, setters, and other methods

    public League() {
        // Default constructor required by Hibernate
    }

    // Constructor with necessary fields
    public League(String name, String type, Date startDate, Date endDate,
                  Date registrationStartDate, Date registrationEndDate,
                  double registrationFee) {
        this.name = name;
        this.type = type;
        this.startDate = startDate;
        this.endDate = endDate;
        this.registrationStartDate = registrationStartDate;
        this.registrationEndDate = registrationEndDate;
        this.registrationFee = registrationFee;
    }

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getType() {
		return type;
	}

	public void setType(String type) {
		this.type = type;
	}

	public Date getStartDate() {
		return startDate;
	}

	public void setStartDate(Date startDate) {
		this.startDate = startDate;
	}

	public Date getEndDate() {
		return endDate;
	}

	public void setEndDate(Date endDate) {
		this.endDate = endDate;
	}

	public Date getRegistrationStartDate() {
		return registrationStartDate;
	}

	public void setRegistrationStartDate(Date registrationStartDate) {
		this.registrationStartDate = registrationStartDate;
	}

	public Date getRegistrationEndDate() {
		return registrationEndDate;
	}

	public void setRegistrationEndDate(Date registrationEndDate) {
		this.registrationEndDate = registrationEndDate;
	}

	public double getRegistrationFee() {
		return registrationFee;
	}

	public void setRegistrationFee(double registrationFee) {
		this.registrationFee = registrationFee;
	}

	public Date getCreatedDate() {
		return createdDate;
	}

	public void setCreatedDate(Date createdDate) {
		this.createdDate = createdDate;
	}

	public Date getModifiedDate() {
		return modifiedDate;
	}

	public void setModifiedDate(Date modifiedDate) {
		this.modifiedDate = modifiedDate;
	}

    
}
