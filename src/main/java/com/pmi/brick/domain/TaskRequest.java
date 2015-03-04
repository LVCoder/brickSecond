package com.pmi.brick.domain;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;

import com.pmi.brick.domain.User.Gender;

@Entity
@Table(name="TASKREQUEST")
public class TaskRequest {
	@Id
	@GeneratedValue
	@Column(name="id")
	private int id;
	
	@Column(name="taskId")
	private int taskId;
	
	@Column(name="workerId")
	private int workerId;
	
	@Column(name="date")
	private Date date;
	
	@Column(name="text")
	private String text;
	
	@Column(name = "status")
	@Enumerated(EnumType.STRING)
	private Status status;

	public Status getStatus() {
		return status;
	}

	public void setStatus(Status status) {
		this.status = status;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public int getTaskId() {
		return taskId;
	}

	public void setTaskId(int taskId) {
		this.taskId = taskId;
	}

	public int getWorkerId() {
		return workerId;
	}

	public void setWorkerId(int workerId) {
		this.workerId = workerId;
	}

	public Date getDate() {
		return date;
	}

	public void setDate(Date date) {
		this.date = date;
	}

	public String getText() {
		return text;
	}

	public void setText(String text) {
		this.text = text;
	}
	
	public enum Status {
	   InProcess,  // запит в≥дправлено
	   Declined ,  // запит в≥дхилено роботодавцем
	   Withdrew,   // запит в≥дкликано виконавцем
	   Terminated,  // час п≥дтвердженн€ вийшов, вибрано ≥ншого роботодавц€. 
	   Submited //запит п≥дверджено
	}

}
