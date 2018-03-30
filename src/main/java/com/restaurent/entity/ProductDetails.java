package com.restaurent.entity;

import java.io.Serializable;
import java.sql.Timestamp;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

import org.hibernate.annotations.CreationTimestamp;
import org.hibernate.annotations.UpdateTimestamp;

@Entity
@Table(name="PRODUCT_DETAILS")
public class ProductDetails implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1579321213369213722L;
	
	
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	@Column(name="PRODUCT_ID")
	private long productId;
	
	@Column(name="PRODUCT_NAME")
	private String productName;
	
	@Column(name="PRODUCT_DETAIL")
	private String productDetail;

	@Column(name="PRODUCT_PRICE")
	private int productPrice;
	
	@Column(name="CREATION_DATE")
	@CreationTimestamp
	private java.sql.Timestamp creationDate;
	
	@Column(name="UPDATION_DATE")
	@UpdateTimestamp
	private java.sql.Timestamp updationDate;
	
	@Column(name="ACCESS")
	private String access;   //A for Admin and U for User
	
	@ManyToOne(optional = false)
	@JoinColumn(name = "CATEGORY_ID")
	private CategoryDetails categorydetails;
	
	
	public ProductDetails() {}

	public ProductDetails(String productName, String productDetail, int productPrice, Timestamp creationDate,
			Timestamp updationDate, String access) {
		super();
		this.productName = productName;
		this.productDetail = productDetail;
		this.productPrice = productPrice;
		this.creationDate = creationDate;
		this.updationDate = updationDate;
		this.access = access;
	}

	public long getProductId() {
		return productId;
	}

	public void setProductId(long productId) {
		this.productId = productId;
	}

	public String getProductName() {
		return productName;
	}

	public void setProductName(String productName) {
		this.productName = productName;
	}

	public String getProductDetail() {
		return productDetail;
	}

	public void setProductDetail(String productDetail) {
		this.productDetail = productDetail;
	}

	public int getProductPrice() {
		return productPrice;
	}

	public void setProductPrice(int productPrice) {
		this.productPrice = productPrice;
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

	public CategoryDetails getCategorydetails() {
		return categorydetails;
	}

	public void setCategorydetails(CategoryDetails categorydetails) {
		this.categorydetails = categorydetails;
	}

	
}
