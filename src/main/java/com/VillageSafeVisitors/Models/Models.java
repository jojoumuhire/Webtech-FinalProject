package com.VillageSafeVisitors.Models;



import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;

@Entity
public class Models {
	@Id
    @GeneratedValue(strategy =  GenerationType.IDENTITY)
	private  int id;
	private String names;
	private String email;
	private String phone;
	private String currentVillage;
	private String newVillage;
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getNames() {
		return names;
	}
	public void setNames(String names) {
		this.names = names;
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	public String getPhone() {
		return phone;
	}
	public void setPhone(String phone) {
		this.phone = phone;
	}
	public String getCurrentVillage() {
		return currentVillage;
	}
	public void setCurrentVillage(String currentVillage) {
		this.currentVillage = currentVillage;
	}
	public String getNewVillage() {
		return newVillage;
	}
	public void setNewVillage(String newVillage) {
		this.newVillage = newVillage;
	}
  
	
	
	
}
