package com.cidenet.hulkStore.entities;

import java.io.Serializable;
import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

import org.springframework.format.annotation.DateTimeFormat;

import com.fasterxml.jackson.annotation.JsonBackReference;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

@Entity
@Table(name="receipts")
public class ReceiptsDTO implements Serializable {

	private static final long serialVersionUID = 3321570939831971018L;
	
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	@Column(name = "RECEIPT_ID")
	private int receipt_id;
	
	@Column(name = "TOTAL_PRICE")
	private double total_price;
	
	@Column(name = "TOTAL_QUANTITY")
	private int total_quantity;
	
	@Column(name = "PRODUCT_FK")
	private int product_fk;
	
	@Column(name = "USER_FK")
	private int user_fk;
	
	@DateTimeFormat(pattern = "yyyy-MM-dd'T'hh:mm")
	@Column(name = "DATE")
	private Date date;
	
	@JoinColumn(name="USER_FK", insertable = false, updatable = false)
	@ManyToOne(targetEntity = UsersDTO.class)
	@JsonBackReference(value = "receipts_userFK")
	private UsersDTO receipts_userFK;
	
	@JoinColumn(name="PRODUCT_FK", insertable = false, updatable = false)
	@ManyToOne(targetEntity = ProductsDTO.class)
	@JsonIgnoreProperties(value = "type")
	private ProductsDTO product;


	public ReceiptsDTO() {
		super();
	}
	
	public ReceiptsDTO(double total_price, int total_quantity, int product_fk, int user_fk) {
		super();
		this.total_price = total_price;
		this.total_quantity = total_quantity;
		this.product_fk = product_fk;
		this.user_fk = user_fk;
	}

	public ReceiptsDTO(double total_price, int total_quantity, int product_fk, int user_fk, Date date) {
		super();
		this.total_price = total_price;
		this.total_quantity = total_quantity;
		this.product_fk = product_fk;
		this.user_fk = user_fk;
		this.date = date;
	}
	
	public ReceiptsDTO(int receipt_id, double total_price, int total_quantity, int product_fk, int user_fk, Date date) {
		super();
		this.receipt_id = receipt_id;
		this.total_price = total_price;
		this.total_quantity = total_quantity;
		this.product_fk = product_fk;
		this.user_fk = user_fk;
		this.date = date;
	}

	public int getReceipt_id() {
		return receipt_id;
	}

	public void setReceipt_id(int receipt_id) {
		this.receipt_id = receipt_id;
	}

	public double getTotal_price() {
		return total_price;
	}

	public void setTotal_price(double total_price) {
		this.total_price = total_price;
	}

	public int getTotal_quantity() {
		return total_quantity;
	}

	public void setTotal_quantity(int total_quantity) {
		this.total_quantity = total_quantity;
	}

	public int getProduct_fk() {
		return product_fk;
	}

	public void setProduct_fk(int product_fk) {
		this.product_fk = product_fk;
	}

	public int getUser_fk() {
		return user_fk;
	}

	public void setUser_fk(int user_fk) {
		this.user_fk = user_fk;
	}

	public Date getDate() {
		return date;
	}

	public void setDate(Date date) {
		this.date = date;
	}

	public static long getSerialversionuid() {
		return serialVersionUID;
	}

	@Override
	public String toString() {
		return "ReceiptsDTO [receipt_id=" + receipt_id + ", total_price=" + total_price + ", total_quantity="
				+ total_quantity + ", product_fk=" + product_fk + ", user_fk=" + user_fk + ", date=" + date + "]";
	}

	public ProductsDTO getProduct() {
		return product;
	}

	public void setProduct(ProductsDTO product) {
		this.product = product;
	}

	
	
}
