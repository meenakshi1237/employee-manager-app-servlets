package com.entity;

import java.time.LocalDateTime;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

import org.hibernate.annotations.CreationTimestamp;
import org.hibernate.annotations.UpdateTimestamp;
@Entity
public class Task {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int id;
	private String description;
	@CreationTimestamp
	private LocalDateTime createddatetime;
	@UpdateTimestamp
	@Column(updatable = false)
	private LocalDateTime completedatetime;
	private String status;
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getDescription() {
		return description;
	}
	public void setDescription(String description) {
		this.description = description;
	}
	public LocalDateTime getCreateddatetime() {
		return createddatetime;
	}
	public void setCreateddatetime(LocalDateTime createddatetime) {
		this.createddatetime = createddatetime;
	}
	public LocalDateTime getCompletedatetime() {
		return completedatetime;
	}
	public void setCompletedatetime(LocalDateTime completedatetime) {
		this.completedatetime = completedatetime;
	}
	public String getStatus() {
		return status;
	}
	public void setStatus(String status) {
		this.status = status;
	}
	
	
}
