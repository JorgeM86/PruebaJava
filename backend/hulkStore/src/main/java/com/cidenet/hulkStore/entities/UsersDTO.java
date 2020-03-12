package com.cidenet.hulkStore.entities;

import java.io.Serializable;
import java.util.Date;
import java.util.Set;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;

import org.springframework.format.annotation.DateTimeFormat;


@Entity
@Table(name="users")
public class UsersDTO implements Serializable {

	private static final long serialVersionUID = -4798135721458176107L;

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	@Column(name = "USER_ID")
	private int user_id;
	
	@Column(name = "USER_TYPE")
	private int user_type;
	
	@Column(name = "NAME")
	private String name;
	
	@Column(name = "LAST_NAME")
	private String last_name;
	
	@Column(name = "GENDER")
	private String gender;
	
	@DateTimeFormat(pattern = "yyyy-MM-dd")
	@Column(name="BIRTH_DATE")
    private Date birth_date;
	
	@Column(name = "EMAIL")
	private String email;
	
	@Column(name = "PASSWORD")
	private String password;
	
	@Column(name = "CELLPHONE")
	private String cellphone;

	@DateTimeFormat(pattern = "yyyy-MM-dd'T'hh:mm")
	@Column(name = "REGISTRATION_DATE")
	private Date registration_date;
	
	@OneToMany(mappedBy = "receipts_userFK", targetEntity = ReceiptsDTO.class)
    private Set<ReceiptsDTO> receipts;
	
	public UsersDTO() {
		
	}
	
	public UsersDTO(int user_type, String name, String last_name, String gender, String email, String password, 
			String cellphone) {
		super();
		this.user_type = user_type;
		this.name = name;
		this.last_name = last_name;
		this.gender = gender;
		this.email = email;
		this.password = password;
		this.cellphone = cellphone;
	}

	public UsersDTO(int user_type, String name, String last_name, String gender, Date birth_date, String email,
			String password, String cellphone, Date registration_date) {
		super();
		this.user_type = user_type;
		this.name = name;
		this.last_name = last_name;
		this.gender = gender;
		this.birth_date = birth_date;
		this.email = email;
		this.password = password;
		this.cellphone = cellphone;
		this.registration_date = registration_date;
	}
	
	public UsersDTO(int user_id, int user_type, String name, String last_name, String gender, Date birth_date,
			String email, String password, String cellphone, Date registration_date) {
		super();
		this.user_id = user_id;
		this.user_type = user_type;
		this.name = name;
		this.last_name = last_name;
		this.gender = gender;
		this.birth_date = birth_date;
		this.email = email;
		this.password = password;
		this.cellphone = cellphone;
		this.registration_date = registration_date;
	}

	public int getUser_id() {
		return user_id;
	}

	public void setUser_id(int user_id) {
		this.user_id = user_id;
	}
	
	public int getUser_type() {
		return user_type;
	}

	public void setUser_type(int user_type) {
		this.user_type = user_type;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getLast_name() {
		return last_name;
	}

	public void setLast_name(String last_name) {
		this.last_name = last_name;
	}
	
	public String getGender() {
		return gender;
	}

	public void setGender(String gender) {
		this.gender = gender;
	}
	
	public Date getBirth_date() {
		return birth_date;
	}

	public void setBirth_date(Date birth_date) {
		this.birth_date = birth_date;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public String getCellphone() {
		return cellphone;
	}

	public void setCellphone(String cellphone) {
		this.cellphone = cellphone;
	}

	public Date getRegistration_date() {
		return registration_date;
	}

	public void setRegistration_date(Date registration_date) {
		this.registration_date = registration_date;
	}

	public static long getSerialversionuid() {
		return serialVersionUID;
	}

	@Override
	public String toString() {
		return "UsersDTO [user_id=" + user_id + ", user_type=" + user_type + ", name=" + name + ", last_name="
				+ last_name + ", gender=" + gender + ", birth_date=" + birth_date + ", email=" + email + ", password="
				+ password + ", cellphone=" + cellphone + ", registration_date=" + registration_date + "]";
	}

	public Set<ReceiptsDTO> getReceipts() {
		return receipts;
	}

	public void setReceipts(Set<ReceiptsDTO> receipts) {
		this.receipts = receipts;
	}
	
}
