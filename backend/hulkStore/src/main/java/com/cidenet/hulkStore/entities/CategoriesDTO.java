package com.cidenet.hulkStore.entities;

import java.io.Serializable;
import java.util.Set;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;

import com.fasterxml.jackson.annotation.JsonBackReference;


@Entity
@Table(name = "categories")
public class CategoriesDTO implements Serializable {

	private static final long serialVersionUID = 3303515864574868787L;
	
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	@Column(name = "CATEGORY_ID")
	private int category_id;
	
	@Column(name = "NAME")
	private String name;
	
	@Column(name = "DESCRIPTION")
	private String description;
	
	@OneToMany(mappedBy = "category", targetEntity = ProductsDTO.class)
	@JsonBackReference(value = "category_products")
    private Set<ProductsDTO> category_products;
	
//	@OneToMany(mappedBy = "category_products", targetEntity = ProductsDTO.class)
//	@JsonIgnoreProperties(value = "category")
//  private Set<ProductsDTO> products;

	public CategoriesDTO() {
		super();
	}

	public CategoriesDTO(String name, String description) {
		super();
		this.name = name;
		this.description = description;
	}
	
	public CategoriesDTO(int category_id, String name, String description) {
		super();
		this.category_id = category_id;
		this.name = name;
		this.description = description;
	}

	public int getCategory_id() {
		return category_id;
	}

	public void setCategory_id(int category_id) {
		this.category_id = category_id;
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

	public static long getSerialversionuid() {
		return serialVersionUID;
	}

	@Override
	public String toString() {
		return "CategoriesDTO [category_id=" + category_id + ", name=" + name + ", description=" + description + "]";
	}

//	public Set<ProductsDTO> getProducts() {
//		return products;
//	}
//
//	public void setProducts(Set<ProductsDTO> products) {
//		this.products = products;
//	}
	
	

}
