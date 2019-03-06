package com.c5.core;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

import com.c5.enumeration.Nature;

public class Frais extends Alimentaire {
	private double poidStock;
	private double poids;
	private String nature;
	
	public Frais(int idArticle, String nomArticle, double prixArticle, String typeArticle, String fournisseur,
			Date dateExpiration,String nature,double poids,double poidStock) {
		super(idArticle, nomArticle, prixArticle, typeArticle, fournisseur, dateExpiration);
		this.setNature(nature);
		this.poids=poids;
		this.poidStock=poidStock;
	}

	public double getPoidStock() {
		return poidStock;
	}

	public void setPoidStock(double poidStock) {
		this.poidStock = poidStock;
	}

	public double getPoids() {
		return poids;
	}

	public void setPoids(double poids) {
		this.poids = poids;
	}

	public double prixFrais() {
		return getPrixArticle()*poids;
	}

	public String getNature() {
		return nature;
	}

	public void setNature(String nature) {
		this.nature = nature;
	}

}
