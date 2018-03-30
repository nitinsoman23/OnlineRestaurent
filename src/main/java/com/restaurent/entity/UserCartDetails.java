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
import javax.persistence.OneToOne;
import javax.persistence.Table;

import org.hibernate.annotations.CreationTimestamp;

@Entity
@Table(name="USER_CART_DETAILS")
public class UserCartDetails implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = -2061016090166196600L;
	
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	@Column(name = "USER_CART_ID")
	private long userCartId;
	
	@Column(name = "NO_OF_PRODUCT")
	private long noOfProduct;
	
	@Column(name = "PRICE")
	private float price;
	
	@Column(name = "ADDED_DATE")
	@CreationTimestamp
	private java.sql.Timestamp addedDate;

	
	@Column(name="ACCESS")
	private String access;
	
	@OneToOne(optional = false)
	@JoinColumn(name = "CATEGORY_ID")
	private CategoryDetails categoryDetails;
	
	@OneToOne(optional = false)
	@JoinColumn(name = "PRODUCT_ID")
	private ProductDetails productDetails;
	
	@ManyToOne(optional = false)
	@JoinColumn(name = "USER_ID")
	private UserDetails userDetails;
	
	public UserCartDetails() {}


	public UserCartDetails(long noOfProduct, float price, Timestamp addedDate,
			String access) {
		super();
		this.noOfProduct = noOfProduct;
		this.price = price;
		this.addedDate = addedDate;
		this.access = access;
	}


	public long getUserCartId() {
		return userCartId;
	}


	public void setUserCartId(long userCartId) {
		this.userCartId = userCartId;
	}


	public long getNoOfProduct() {
		return noOfProduct;
	}


	public void setNoOfProduct(long noOfProduct) {
		this.noOfProduct = noOfProduct;
	}


	public float getPrice() {
		return price;
	}


	public void setPrice(float price) {
		this.price = price;
	}


	public java.sql.Timestamp getAddedDate() {
		return addedDate;
	}


	public void setAddedDate(java.sql.Timestamp addedDate) {
		this.addedDate = addedDate;
	}


	public String getAccess() {
		return access;
	}


	public void setAccess(String access) {
		this.access = access;
	}


	public CategoryDetails getCategoryDetails() {
		return categoryDetails;
	}


	public void setCategoryDetails(CategoryDetails categoryDetails) {
		this.categoryDetails = categoryDetails;
	}


	public ProductDetails getProductDetails() {
		return productDetails;
	}


	public void setProductDetails(ProductDetails productDetails) {
		this.productDetails = productDetails;
	}


	public UserDetails getUserDetails() {
		return userDetails;
	}


	public void setUserDetails(UserDetails userDetails) {
		this.userDetails = userDetails;
	}


	
	

}
