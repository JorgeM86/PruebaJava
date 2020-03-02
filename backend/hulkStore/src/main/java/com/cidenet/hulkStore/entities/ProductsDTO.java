package com.cidenet.hulkStore.entities;

import java.io.Serializable;
import java.util.Set;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Table;

import com.fasterxml.jackson.annotation.JsonBackReference;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

@Entity
@Table(name = "products")
public class ProductsDTO implements Serializable {

	private static final long serialVersionUID = 755741979229703092L;

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	@Column(name = "PRODUCT_ID")
	private int product_id;
	
	@Column(name = "NAME")
	private String name;
	
	@Column(name = "DESCRIPTION")
	private String description;
	
	@Column(name = "QUANTITY")
	private int quantity;
	
	@Column(name = "PRICE")
	private double price;
	
	@Column(name = "CATEGORY_FK")
	private int category_fk;
	
	@Column(name = "TYPE_FK")
	private int type_fk;
	
	@JoinColumn(name="CATEGORY_FK", insertable = false, updatable = false)
	@ManyToOne(targetEntity = CategoriesDTO.class)
	@JsonIgnoreProperties(value = "products")
	private CategoriesDTO category;
	
	@JoinColumn(name="TYPE_FK", insertable = false, updatable = false)
	@ManyToOne(targetEntity = TypesDTO.class)
	private TypesDTO type;
	
//	@JoinColumn(name="CATEGORY_FK", insertable = false, updatable = false)
//	@ManyToOne(targetEntity = CategoriesDTO.class)
//	@JsonBackReference(value = "category_products1")
//	private CategoriesDTO category_products;
	
	@JoinColumn(name="TYPE_FK", insertable = false, updatable = false)
	@ManyToOne(targetEntity = TypesDTO.class)
	@JsonBackReference(value = "type_products1")
	private TypesDTO type_products;
	
	@OneToMany(mappedBy = "product", targetEntity = ReceiptsDTO.class)
	@JsonBackReference(value = "receipts_productFK32")
    private Set<ReceiptsDTO> receipts;

	public ProductsDTO() {
		super();
	}

	public ProductsDTO(String name, String description, int quantity, double price, int category_fk, int type_fk) {
		super();
		this.name = name;
		this.description = description;
		this.quantity = quantity;
		this.price = price;
		this.category_fk = category_fk;
		this.type_fk = type_fk;
	}
	
	public ProductsDTO(int product_id, String name, String description, int quantity, double price, int category_fk,
			int type_fk) {
		super();
		this.product_id = product_id;
		this.name = name;
		this.description = description;
		this.quantity = quantity;
		this.price = price;
		this.category_fk = category_fk;
		this.type_fk = type_fk;
	}

	public int getProduct_id() {
		return product_id;
	}

	public void setProduct_id(int product_id) {
		this.product_id = product_id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public int getQuantity() {
		return quantity;
	}

	public void setQuantity(int quantity) {
		this.quantity = quantity;
	}

	public double getPrice() {
		return price;
	}

	public void setPrice(double price) {
		this.price = price;
	}

	public int getCategory_fk() {
		return category_fk;
	}

	public void setCategory_fk(int category_fk) {
		this.category_fk = category_fk;
	}

	public int getType_fk() {
		return type_fk;
	}

	public void setType_fk(int type_fk) {
		this.type_fk = type_fk;
	}

	public static long getSerialversionuid() {
		return serialVersionUID;
	}

	@Override
	public String toString() {
		return "ProductsDTO [product_id=" + product_id + ", name=" + name + ", description=" + description + ", quantity=" + quantity
				+ ", price=" + price + ", category_fk=" + category_fk + ", type_fk=" + type_fk + "]";
	}

	public CategoriesDTO getCategory() {
		return category;
	}

	public void setCategory(CategoriesDTO category) {
		this.category = category;
	}

	public TypesDTO getType() {
		return type;
	}

	public void setType(TypesDTO type) {
		this.type = type;
	}
	
}
