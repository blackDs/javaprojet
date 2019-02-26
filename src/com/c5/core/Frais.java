package com.c5.core;

import java.util.Date;

import com.c5.enumeration.Nature;

public class Frais extends Alimentaire {
	private double poidStock;
	//private enum nature{legumes,fruit};
	private Nature nature;

	public Frais(int idArticle, String nomArticle, double prixArticle, String typeArticle, String fournisseur,
			Date dateExpiration,Nature nature) {
		super(idArticle, nomArticle, prixArticle, typeArticle, fournisseur, dateExpiration);
		this.nature=nature;
	}

	public double getPoidStock() {
		return poidStock;
	}

	public void setPoidStock(double poidStock) {
		this.poidStock = poidStock;
	}

}
