package com.c5.core;

import java.util.Date;

import com.c5.enumeration.Sexe;
import com.c5.enumeration.emballage;

public class Conserver extends Alimentaire {
	private double stock;	
	private Date dateFabrication;
	//private enum emballage{liquide,embalee}
	private String emballage;
	//String dateFormat = "dd/MM/yyyy";
		
	public Conserver(int idArticle, String nomArticle, double prixArticle, String typeArticle, String fournisseur,
			Date dateExpiration,double stock,Date dateFabrication,String emballage) {
		
		super(idArticle, nomArticle, prixArticle, typeArticle, fournisseur, dateExpiration);
		this.stock=stock;
		this.dateFabrication=dateFabrication;
		this.setEmballage(emballage);
	}

	public Date getDateFabrication() {
		return dateFabrication;
	}

	public void setDateFabrication(Date dateFabrication) {
		this.dateFabrication = dateFabrication;
	}

	public double getStock() {
		return stock;
	}

	public void setStock(double stock) {
		this.stock = stock;
	}

	public String getEmballage() {
		return emballage;
	}

	public void setEmballage(String emballage) {
		this.emballage = emballage;
	}

	@Override
	public String toString() {
		return super.toString()+"Conserver [stock=" + stock + ", dateFabrication=" + dateFabrication + ", emballage=" + emballage;
	}
	
	
 
  
}
