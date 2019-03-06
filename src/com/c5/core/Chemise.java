package com.c5.core;

import com.c5.enumeration.Taille;

public class Chemise extends Vetement{
	private Taille taille;

	public Chemise(int idArticle, String nomArticle, double prixArticle, String typeArticle, String fournisseur,
			String marque, String tissu, String sexe,String couleur,int promotion,Taille taille) {
		super(idArticle, nomArticle, prixArticle, typeArticle, fournisseur, marque, tissu, sexe, couleur,promotion);
		this.taille=taille;
	}

	public Chemise() {
		// TODO Auto-generated constructor stub
	}

	public String getTaille() {
		return taille.toString();
	}

	public void setTaille(String taille) {
		switch(taille){
		case "XXS":
			this.taille = Taille.XXS;
			break;
		}
	}

	@Override
	public String toString() {
		return "Chemise " +super.toString()+"[taille=" + taille + "]";
	}
	
	
	
	

}
