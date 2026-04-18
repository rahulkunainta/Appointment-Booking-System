package com.project.model;

public class Doctor {
	
	private int id;
	private String name;
	private String specialization;
	private int experience;
	private double fees;
	private String availableTime;
	
	 public Doctor() {
		 
	  }

	
	public Doctor(int id,String name, String specialization, int experience, double fees, String availableTime ){
		
		this.id=id;
		this.name=name;
		this.specialization=specialization;
		this.experience=experience;
		this.fees=fees;
		this.availableTime=availableTime;
		 
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


	public String getSpecialization() {
		return specialization;
	}


	public void setSpecialization(String specialization) {
		this.specialization = specialization;
	}


	public int getExperience() {
		return experience;
	}


	public void setExperience(int experience) {
		this.experience = experience;
	}


	public double getFees() {
		return fees;
	}


	public void setFees(double fees) {
		this.fees = fees;
	}


	public String getAvailableTime() {
		return availableTime;
	}


	public void setAvailableTime(String availableTime) {
		this.availableTime = availableTime;
	}
	
	
	
	
	
	
	
	
	
	
	
}
