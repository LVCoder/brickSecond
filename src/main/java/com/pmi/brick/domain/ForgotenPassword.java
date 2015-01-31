package com.pmi.brick.domain;

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "forgoten_passwords")
public class ForgotenPassword {
  
  @Id
	@GeneratedValue
	@Column(name = "id")
	private int id;
  @Column(name = "user_id")
	private int user_id;
  @Column(name = "hash_password")
	private String hash_password;
  @Column(name = "date")
	private Date date;
  @Column(name = "is_used")
	private boolean is_used;
  public ForgotenPassword() { }
public boolean getisIs_used() {
	return is_used;
}
public void setIs_used(boolean is_used) {
	this.is_used = is_used;
}
public Date getDate() {
	return date;
}
public void setDate(Date date) {
	this.date = date;
}
public int getId() {
	return id;
}
public void setId(int id) {
	this.id = id;
}
public int getUser_id() {
	return user_id;
}
public void setUser_id(int user_id) {
	this.user_id = user_id;
}
public String getHash_password() {
	return hash_password;
}
public void setHash_password(String hash_password) {
	this.hash_password = hash_password;
}
}
