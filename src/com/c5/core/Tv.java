package com.c5.core;

public class Tv extends Electronique{
	String Résolution ;
	

	public Tv(int idArticle, String nomArticle, double prixArticle, String typeArticle, String fournisseur,
			String Résolution, String Ecran) {
		super(idArticle, nomArticle, prixArticle, typeArticle, fournisseur,Ecran);
		this.Résolution=Résolution;
	}
	
	

}
