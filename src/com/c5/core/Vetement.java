package com.c5.core;

import com.c5.enumeration.Couleur;
import com.c5.enumeration.Sexe;

public class Vetement extends Article {
	private String marque;
	private String tissu;
	private Sexe sexe;
	private Couleur couleur;
	
	public Vetement(int idArticle, String nomArticle, double prixArticle, String typeArticle,
			String fournisseur,String marque,String tissu,Sexe sexe,Couleur couleur) {
		
		super(idArticle, nomArticle, prixArticle, typeArticle, fournisseur);
		this.setMarque(marque);
		this.setTissu(tissu);
		this.setSexe(sexe);
		this.couleur=couleur;
		
	}

	public Couleur getCouleur() {
		return couleur;
	}

	public void setCouleur(Couleur couleur) {
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

	public Sexe getSexe() {
		return sexe;
	}

	public void setSexe(Sexe sexe) {
		this.sexe = sexe;
	}
	

}
