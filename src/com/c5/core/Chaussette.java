package com.c5.core;

import com.c5.enumeration.Couleur;
import com.c5.enumeration.Sexe;

public class Chaussette extends Vetement{

	private int tailleChaussette;
	public Chaussette(int idArticle, String nomArticle, double prixArticle, String typeArticle, String fournisseur,
			String marque, String tissu, Sexe sexe,Couleur couleur,int tailleChaussette) {
		super(idArticle, nomArticle, prixArticle, typeArticle, fournisseur, marque, tissu, sexe, couleur, tailleChaussette);
		this.setTailleChaussette(tailleChaussette);
	}
	
	public int getTailleChaussette() {
		return tailleChaussette;
	}
	
	public void setTailleChaussette(int tailleChaussette) {
		this.tailleChaussette = tailleChaussette;
	}

}
