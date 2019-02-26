package com.c5.core;

import com.c5.enumeration.Couleur;
import com.c5.enumeration.Sexe;

public class Pantalon extends Vetement {
	private int taillePantalon;

	public Pantalon(int idArticle, String nomArticle, double prixArticle, String typeArticle, String fournisseur,
		
		String marque, String tissu, Sexe sexe, Couleur couleur, int tailleP, int taillePantalon, int promotion)
	{
		super(idArticle, nomArticle, prixArticle, typeArticle, fournisseur, marque, tissu, sexe, couleur, promotion);
	
		this.taillePantalon = taillePantalon;
	}

	public int getTaillePantalon() {
		return taillePantalon;
	}

	public void setTaillePantalon(int taillePantalon) {
		this.taillePantalon = taillePantalon;
	}
	
	
	

}
