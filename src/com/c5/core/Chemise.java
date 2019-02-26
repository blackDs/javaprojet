package com.c5.core;

import com.c5.enumeration.Couleur;
import com.c5.enumeration.Sexe;
import com.c5.enumeration.Taille;

public class Chemise extends Vetement{
	private Taille taille;

	public Chemise(int idArticle, String nomArticle, double prixArticle, String typeArticle, String fournisseur,
			String marque, String tissu, Sexe sexe,Taille taille,Couleur couleur,int promotion) {
		super(idArticle, nomArticle, prixArticle, typeArticle, fournisseur, marque, tissu, sexe, couleur,promotion);
		this.taille=taille;
	}

	public Taille getTaille() {
		return taille;
	}

	public void setTaille(Taille taille) {
		this.taille = taille;
	}
	
	

}
