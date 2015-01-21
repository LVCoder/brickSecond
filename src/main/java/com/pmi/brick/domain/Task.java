package com.pmi.brick.domain;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name="TASK")
public class Task {
	
	@Id
	@GeneratedValue
	@Column(name = "id")
	private int id;

	@Column(name="name")
	private String name;
	
	@Column(name="category")
	private String category;
	
	@Column(name="postDate")
	private Date postDate;
	
	@Column(name="startDate")
	private Date startDate;
	
	@Column(name="endDate")
	private Date endDate;
	
	
	@Column(name="aboutText")
	private String aboutText;
	
	
	@Column(name="location")
	private String location;
	
	
	
	@Column(name="bossId")
	private int bossId;
	
	
	@Column(name="workerId")
	private int workerId;
	
	@Column(name="status")
	private String status;

	public int getId() {
		return id;
	}

	

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getCategory() {
		return category;
	}

	public void setCategory(String category) {
		this.category = category;
	}

	public Date getPostDate() {
		return postDate;
	}

	public void setPostDate(Date postDate) {
		this.postDate = postDate;
	}
	

	public Date getStartDate() {
		return startDate;
	}
	
	

	public void setStartDate(Date startDate) {
		this.startDate = startDate;
	}
	public void setStartDate(String startDate) throws ParseException {
		Date date;
	    date = new SimpleDateFormat("MM/dd/yy").parse(startDate);
		this.startDate = date;
	}
	
	public Date getEndDate() {
		return endDate;
	}

	public void setEndDate(Date endDate) {
		this.endDate = endDate;
	}

	public String getAboutText() {
		return aboutText;
	}

	public void setAboutText(String aboutText) {
		this.aboutText = aboutText;
	}

	public String getLocation() {
		return location;
	}

	public void setLocation(String location) {
		this.location = location;
	}

	public int getBossId() {
		return bossId;
	}

	public void setBossId(int bossId) {
		this.bossId = bossId;
	}

	public int getWorkerId() {
		return workerId;
	}

	public void setWorkerId(int workerId) {
		this.workerId = workerId;
	}

	public String getStatus() {
		return status;
	}

	public void setStatus(String status) {
		this.status = status;
	}
	
	
	public void setSameProperties(Task task){
		
		this.name = task.getName();
		this.category = task.getCategory();
		this.postDate = task.getPostDate();
		this.startDate = task.getStartDate();
		this.endDate = task.getEndDate();
		this.aboutText = task.getAboutText();
		this.location = task.getLocation();
		
	}



	
		
		
		
		
		
	
}
