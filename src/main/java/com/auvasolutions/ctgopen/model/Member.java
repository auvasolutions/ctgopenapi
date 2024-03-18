package com.auvasolutions.ctgopen.model;

import java.util.Date;

import org.hibernate.annotations.CreationTimestamp;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import jakarta.persistence.Temporal;
import jakarta.persistence.TemporalType;


@Entity
@Table(name = "MEMBER")
public class Member {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;
	@Column(nullable = false)
    private String firstName;
	@Column(nullable = false)
    private String lastName;
	@Column(unique = true, nullable = false)
    private String email;
	@Column(nullable = false)
    private String phoneNumber;
	@Column(nullable = false)
    private String password;
	
	@Column (nullable = true)
	private String selfRating;
	
	@Column (nullable = true)
	private String ctgRating;
	
	@CreationTimestamp
	@Temporal(TemporalType.TIMESTAMP)
    private Date createdDate;
	@CreationTimestamp
    @Temporal(TemporalType.TIMESTAMP)
    private Date modifiedDate;

	public Member() {
		
	}

    public Member(String firstName, String lastName, String email, String phoneNumber, String password, String selfRating) {
    	super();
        this.firstName = firstName;
        this.lastName = lastName;
        this.email = email;
        this.phoneNumber = phoneNumber;
        this.password = password;
        this.selfRating = selfRating;
    }

    // Getters and Setters for all fields

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getPhoneNumber() {
        return phoneNumber;
    }

    public void setPhoneNumber(String phoneNumber) {
        this.phoneNumber = phoneNumber;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

	public String getSelfRating() {
		return selfRating;
	}

	public void setSelfRating(String selfRating) {
		this.selfRating = selfRating;
	}

	public String getCtgRating() {
		return ctgRating;
	}

	public void setCtgRating(String ctgRating) {
		this.ctgRating = ctgRating;
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

	@Override
	public String toString() {
		return "Member [id=" + id + ", firstName=" + firstName + ", lastName=" + lastName + ", email=" + email
				+ ", phoneNumber=" + phoneNumber + ", password=" + password + ", selfRating=" + selfRating
				+ ", ctgRating=" + ctgRating + ", createdDate=" + createdDate + ", modifiedDate=" + modifiedDate + "]";
	}

    // Other methods if needed

    
}
