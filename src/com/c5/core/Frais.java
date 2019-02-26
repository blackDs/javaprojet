package com.c5.core;

import java.util.Date;

public class Frais extends Alimentaire {
	private double poidStock;
	private enum nature{legumes,fruit};

	public Frais(int idArticle, String nomArticle, double prixArticle, String typeArticle, String fournisseur,
			Date dateExpiration,nature nature) {
		super(idArticle, nomArticle, prixArticle, typeArticle, fournisseur, dateExpiration);
		nature=nature;
	}

	public double getPoidStock() {
		return poidStock;
	}

	public void setPoidStock(double poidStock) {
		this.poidStock = poidStock;
	}

}
