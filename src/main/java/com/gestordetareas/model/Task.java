package com.gestordetareas.model;

import javax.persistence.Entity;
import javax.persistence.Id;

@Entity
public class Task {
	@Id
	private int id;
	private String name;
	boolean isDone;
	
	
	public Task() {

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
	public Boolean getIsDone() {
		  return isDone;
		} 
	public void setIsDone(Boolean isDoneArg) {
		  isDone = isDoneArg;
		}

}
