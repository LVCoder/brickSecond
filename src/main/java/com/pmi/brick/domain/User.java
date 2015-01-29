package com.pmi.brick.domain;


import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "USER")
public class User {



	public User(){
		
	}
	
	@Id
	@GeneratedValue
	@Column(name = "id")
	private int id;

	@Column(name = "name")
	private String name;

	@Column(name = "surname")
	private String surname;

	@Column(name = "phone")
	private String phone;

	@Column(name = "email")
	private String email;
	
	@Column(name = "password")
	private String password;

	@Column(name ="dob")
	private Date dob;
	
	@Column(name="aboutUser")
	private String aboutUser;
	
	@Column(name="city")
	private String city;
	
	@Column(name="taskCategories")
	private String taskCategories;
	
	@Column(name="confirmCode")
	private String confirmCode;
	
	
	@Column(name="authority")
	private String authority;
	
	@Column(name = "enabled")
	private boolean enabled;
	
	@Column(name = "isEmailConfirm")
	private boolean isEmailConfirm;
	
	@Column(name = "sex")
	@Enumerated(EnumType.STRING)
	private Gender gender;
	
	public boolean getIsEmailConfirm() {
		return isEmailConfirm;
	}

	public void setIsEmailConfirm(boolean isEmailConfirm) {
		this.isEmailConfirm = isEmailConfirm;
	}
	
	public Gender getGender() {
		return gender;
	}

	public void setGender(Gender gender) {
		this.gender = gender;
	}

	public enum Gender {
	    Male, Female ,Unknown
	}

	public boolean getEnabled() {
		return enabled;
	}

	public void setEnabled(boolean enabled) {
		this.enabled = enabled;
	}

	public String getConfirmCode() {
		return confirmCode;
	}

	public void setConfirmCode(String confirmCode) {
		this.confirmCode = confirmCode;
	}

	
	
		public String getCity() {
		return city;
	}

	public void setCity(String city) {
		this.city = city;
	}

	public String getAuthority() {
		return authority;
	}

	public void setAuthority(String authority) {
		this.authority = authority;
	}

		public Date getDob() {
		return dob;
	}

	public void setDob(Date dob) {
		this.dob = dob;
	}

	public String getTaskCategories() {
		return taskCategories;
	}

	public void setTaskCategories(String taskCategories) {
		this.taskCategories = taskCategories;
	}

		public String getAboutUser() {
		return aboutUser;
	}

	public void setAboutUser(String aboutUser) {
		this.aboutUser = aboutUser;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getSurname() {
		return surname;
	}

	public void setSurname(String surname) {
		this.surname = surname;
	}

	public String getPhone() {
		return phone;
	}

	public void setPhone(String phone) {
		this.phone = phone;
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

	
}

