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
@Table(name="USER_ORDER_DETAILS")
public class UserOrderDetails implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 3047065892744549368L;

	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	@Column(name = "USER_ORDER_ID")
	private long userCartId;
	
	@OneToOne(optional =false)
	@JoinColumn(name = "PRODUCT_ID")
	private ProductDetails productDetails;
	
	@Column(name = "NO_OF_PRODUCT")
	private long noOfProduct;
	
	@Column(name = "PRICE")
	private float price;
	
	@Column(name = "ADDED_DATE")
	@CreationTimestamp
	private java.sql.Timestamp orderedDate;
	
	@Column(name = "MODE_OF_PAYMENT")
	private String modeOfPayment;
	
	@Column(name = "DELEVIRED_OR_NOT")
	private String deleviredOrNot;
	
	@Column(name="ACCESS")
	private String access;
	
	@OneToOne(optional =false)
	@JoinColumn(name = "CATEGORY_ID")
	private CategoryDetails categoryDetails;
	
	
	@ManyToOne(optional =false)
	@JoinColumn(name="USER_ID")
	private UserDetails userDetails;

	public UserOrderDetails() {}

	public UserOrderDetails(long noOfProduct, float price, Timestamp orderedDate,
			String modeOfPayment, String deleviredOrNot, String access) {
		super();
		this.noOfProduct = noOfProduct;
		this.price = price;
		this.orderedDate = orderedDate;
		this.modeOfPayment = modeOfPayment;
		this.deleviredOrNot = deleviredOrNot;
		this.access = access;
	}

	public long getUserCartId() {
		return userCartId;
	}

	public void setUserCartId(long userCartId) {
		this.userCartId = userCartId;
	}

	public ProductDetails getProductDetails() {
		return productDetails;
	}

	public void setProductDetails(ProductDetails productDetails) {
		this.productDetails = productDetails;
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

	public java.sql.Timestamp getOrderedDate() {
		return orderedDate;
	}

	public void setOrderedDate(java.sql.Timestamp orderedDate) {
		this.orderedDate = orderedDate;
	}

	public String getModeOfPayment() {
		return modeOfPayment;
	}

	public void setModeOfPayment(String modeOfPayment) {
		this.modeOfPayment = modeOfPayment;
	}

	public String getDeleviredOrNot() {
		return deleviredOrNot;
	}

	public void setDeleviredOrNot(String deleviredOrNot) {
		this.deleviredOrNot = deleviredOrNot;
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

	public UserDetails getUserDetails() {
		return userDetails;
	}

	public void setUserDetails(UserDetails userDetails) {
		this.userDetails = userDetails;
	}

	
	
	
}
