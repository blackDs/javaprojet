package com.c5.core;

public class Vetement extends Article {
	
	private String marque;
	private String tissu;
	private enum sexe{homme,femme};
	
	public Vetement(int idArticle, String nomArticle,
			double prixArticle, String typeArticle, String fournisseur,String marque,String tissu,sexe sexe) {
		
		super(idArticle, nomArticle, prixArticle, typeArticle, fournisseur);
		this.setMarque(marque);
		this.setTissu(tissu);
		sexe=sexe;
		
	}

	public String getTissu() {
		return tissu;
	}

	public void setTissu(String tissu) {
		this.tissu = tissu;
	}

	public String getMarque() {
		return marque;
	}

	public void setMarque(String marque) {
		this.marque = marque;
	}

}
