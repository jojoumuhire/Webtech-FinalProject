package com.VillageSafeVisitors.Models;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;


@Entity
public class SignUp {
	@Id
    @GeneratedValue(strategy =  GenerationType.IDENTITY)
	private  int id;
	private String email;
	private String passowrd;
	private String ConfirmPassowrd;
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	public String getPassowrd() {
		return passowrd;
	}
	public void setPassowrd(String passowrd) {
		this.passowrd = passowrd;
	}
	public String getConfirmPassowrd() {
		return ConfirmPassowrd;
	}
	public void setConfirmPassowrd(String confirmPassowrd) {
		ConfirmPassowrd = confirmPassowrd;
	}
	
}
