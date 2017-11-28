package com.exos.beans;

import java.sql.Timestamp;

public class Utilisateur{

	private Integer id;
	private String email;
	private String pass;
	private String nom;
	private String photo;
	private Timestamp date_inscription;
	
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	public String getPass() {
		return pass;
	}
	public void setPass(String pass) {
		this.pass = pass;
	}
	public String getNom() {
		return nom;
	}
	public void setNom(String nom) {
		this.nom = nom;
	}
	public String getPhoto() {
		return photo;
	}
	public void setPhoto(String photo) {
		this.photo = photo;
	}
	public Integer getId() {
		return id;
	}
	public void setId(Integer id) {
		this.id = id;
	}
	public Timestamp getDate_inscription() {
		return date_inscription;
	}
	public void setDate_inscription(Timestamp date_inscription) {
		this.date_inscription = date_inscription;
	}

}
