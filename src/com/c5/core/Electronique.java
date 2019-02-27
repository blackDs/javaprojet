package com.c5.core;

public class Electronique extends Article {
	private String Ecran;

	public Electronique(int idArticle, String nomArticle,
			double prixArticle, String typeArticle, String fournisseur,String Ecran) {
		
		super(idArticle, nomArticle, prixArticle, typeArticle, fournisseur);
		this.setEcran(Ecran);
	}

	public String getEcran() {
		return Ecran;
	}

	public void setEcran(String ecran) {
		Ecran = ecran;
	}

}
