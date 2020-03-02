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
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

@Entity
@Table(name = "types")
public class TypesDTO implements Serializable {

	private static final long serialVersionUID = 385431435882712664L;

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private int type_id;

	@Column(name = "NAME")
	private String name;

	@Column(name = "DESCRIPTION")
	private String description;
	
	@OneToMany(mappedBy = "type", targetEntity = ProductsDTO.class)
	@JsonBackReference(value = "type_products")
    private Set<ProductsDTO> type_products;
	
	@OneToMany(mappedBy = "type_products", targetEntity = ProductsDTO.class)
	@JsonIgnoreProperties(value = "type")
	private Set<ProductsDTO> products;

	public TypesDTO() {
		super();
	}

	public TypesDTO(String name, String description) {
		super();
		this.name = name;
		this.description = description;
	}
	
	public TypesDTO(int type_id, String name, String description) {
		super();
		this.type_id = type_id;
		this.name = name;
		this.description = description;
	}

	public int getType_id() {
		return type_id;
	}

	public void setType_id(int type_id) {
		this.type_id = type_id;
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
		return "TypeDTO [type_id=" + type_id + ", name=" + name + ", description=" + description + "]";
	}

	public Set<ProductsDTO> getProducts() {
		return products;
	}

	public void setProducts(Set<ProductsDTO> products) {
		this.products = products;
	}
	
	

}
