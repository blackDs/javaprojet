package com.c5.core;

public class Tv extends Electronique{
	String R�solution ;
	

	public Tv(int idArticle, String nomArticle, double prixArticle, String typeArticle, String fournisseur,
			String R�solution, String Ecran) {
		super(idArticle, nomArticle, prixArticle, typeArticle, fournisseur,Ecran);
		this.R�solution=R�solution;
	}
	
	

}
