package com.restaurent.entity;

import java.io.Serializable;
import java.sql.Timestamp;
import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;

import org.hibernate.annotations.CreationTimestamp;
import org.hibernate.annotations.UpdateTimestamp;

@Entity
@Table(name="USER_DETAILS")
public class UserDetails implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = -2774632787891766892L;

	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	@Column(name = "USER_ID")
	private long userId;
	
	@Column(name = "FIRSTNAME")
	private String firstName;
	
	@Column(name = "lASTNAME")
	private String lastName;
	
	@Column(name = "EMAIL_ID")
	private String emailId;
	
	@Column(name = "MOBILE_NO", unique=true)
	private String mobileNo;
	
	@Column(name = "PASSWORD")
	private String password;
	
	@Column(name = "ACCESS")
	private String access;
	
	@Column(name = "CREATION_DATE")
	@CreationTimestamp
	private java.sql.Timestamp  creationDate;
	
	@Column(name = "UPDATION_DATE")
	@UpdateTimestamp
	private java.sql.Timestamp  updationDate;
	
	@OneToMany(mappedBy = "userDetails")
	private List<UserCartDetails> userCartDetails;

	@OneToMany(mappedBy = "userDetails")
	private List<UserOrderDetails> userOrderdetails;
	
	
	public UserDetails() {}
	
	public UserDetails(String firstName, String lastName, String emailId, String mobileNo, String password,
			String access, Timestamp creationDate, Timestamp updationDate) {
		super();
		this.firstName = firstName;
		this.lastName = lastName;
		this.emailId = emailId;
		this.mobileNo = mobileNo;
		this.password = password;
		this.access = access;
		this.creationDate = creationDate;
		this.updationDate = updationDate;
	}

	public long getUserId() {
		return userId;
	}

	public void setUserId(long userId) {
		this.userId = userId;
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

	public String getEmailId() {
		return emailId;
	}

	public void setEmailId(String emailId) {
		this.emailId = emailId;
	}

	public String getMobileNo() {
		return mobileNo;
	}

	public void setMobileNo(String mobileNo) {
		this.mobileNo = mobileNo;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public String getAccess() {
		return access;
	}

	public void setAccess(String access) {
		this.access = access;
	}

	public java.sql.Timestamp getCreationDate() {
		return creationDate;
	}

	public void setCreationDate(java.sql.Timestamp creationDate) {
		this.creationDate = creationDate;
	}

	public java.sql.Timestamp getUpdationDate() {
		return updationDate;
	}

	public void setUpdationDate(java.sql.Timestamp updationDate) {
		this.updationDate = updationDate;
	}

	public List<UserCartDetails> getUserCartDetails() {
		return userCartDetails;
	}

	public void setUserCartDetails(List<UserCartDetails> userCartDetails) {
		this.userCartDetails = userCartDetails;
	}

	public List<UserOrderDetails> getUserOrderdetails() {
		return userOrderdetails;
	}

	public void setUserOrderdetails(List<UserOrderDetails> userOrderdetails) {
		this.userOrderdetails = userOrderdetails;
	}

	
	
	
}
