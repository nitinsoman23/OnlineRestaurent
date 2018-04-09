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
import javax.validation.constraints.NotNull;

import org.hibernate.annotations.CreationTimestamp;
import org.hibernate.annotations.UpdateTimestamp;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

@Entity
@Table(name="CATEGORY_DETAILS")
public class CategoryDetails implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = -6456752160339475114L;
	
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	@Column(name="CATEGORY_ID")
	private long categoryId;
	
	@NotNull
	@Column(name="CATEGORY_NAME")
	private String categoryName;
	
	@NotNull
	@Column(name="VEG_OR_NON")
	private String vegOrNon;
	
	
	@Column(name="CREATION_DATE")
	@CreationTimestamp
	private java.sql.Timestamp creationDate;
	
	@Column(name="UPDATION_DATE")
	@UpdateTimestamp
	private java.sql.Timestamp updationDate;
	
	@NotNull
	@Column(name="ACCESS")
	private String access;  //A for Admin and U for User
	
	@OneToMany(mappedBy = "categorydetails")
	@JsonIgnoreProperties("categorydetails")
	private List<ProductDetails> productDetails;

	public CategoryDetails() {}


	public CategoryDetails(String categoryName, String vegOrNon, Timestamp creationDate, Timestamp updationDate,
			String access) {
		super();
		this.categoryName = categoryName;
		this.vegOrNon = vegOrNon;
		this.creationDate = creationDate;
		this.updationDate = updationDate;
		this.access = access;
	}


	public long getCategoryId() {
		return categoryId;
	}


	public void setCategoryId(long categoryId) {
		this.categoryId = categoryId;
	}


	public String getCategoryName() {
		return categoryName;
	}


	public void setCategoryName(String categoryName) {
		this.categoryName = categoryName;
	}


	public String getVegOrNon() {
		return vegOrNon;
	}


	public void setVegOrNon(String vegOrNon) {
		this.vegOrNon = vegOrNon;
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


	public String getAccess() {
		return access;
	}


	public void setAccess(String access) {
		this.access = access;
	}


	public List<ProductDetails> getProductDetails() {
		return productDetails;
	}


	public void setProductDetails(List<ProductDetails> productDetails) {
		this.productDetails = productDetails;
	}


	@Override
	public String toString() {
		return "CategoryDetails [categoryId=" + categoryId + ", categoryName=" + categoryName + ", vegOrNon=" + vegOrNon
				+ ", creationDate=" + creationDate + ", updationDate=" + updationDate + ", access=" + access
				+ ", productDetails=" + productDetails + "]";
	}


	}
