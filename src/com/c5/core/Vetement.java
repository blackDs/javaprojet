package com.c5.core;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

import com.c5.database.ConnectionDB;


public class Vetement extends Article {
	
	
	//private int idVetement;
	public String marque;
	public String tissu;
	public String sexe;
	public String couleur;
	public int promotion;
	Article a;
	
	
	public Vetement(int idArticle, String nomArticle, double prixArticle, String typeArticle,
			String fournisseur,String marque,String tissu,String sexe,String couleur,int promotion) {
		
		super(idArticle, nomArticle, prixArticle, typeArticle, fournisseur);
		this.setMarque(marque);
		this.setTissu(tissu);
		this.setSexe(sexe);
		this.couleur=couleur;
		this.promotion=promotion;
	}

	public Vetement() {
		
		
	}

	public String getCouleur() {
		return couleur;
	}

	public void setCouleur(String couleur) {
		this.couleur = couleur;
	}

	public String getMarque() {
		return marque;
	}

	public void setMarque(String marque) {
		this.marque = marque;
	}

	public String getTissu() {
		return tissu;
	}

	public void setTissu(String tissu) {
		this.tissu = tissu;
	}

	public String getSexe() {
		return sexe;
	}

	public void setSexe(String sexe) {
		this.sexe = sexe;
	}

	public int getPromotion() {
		return promotion;
	}

	public void setPromotion(int promotion) {
		this.promotion = promotion;
	}

}
