package com.c5.core;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

public class Alimentaire extends Article {
	
	private Date dateExpiration;
		
	public Alimentaire(int idArticle, String nomArticle, double prixArticle,
			String typeArticle, String fournisseur,Date dateExpiration) {
		super(idArticle, nomArticle, prixArticle, typeArticle, fournisseur);
		//setDateExpiration(dateExpiration);
		this.dateExpiration=dateExpiration;
	}

	public Date getDateExpiration() {
		return dateExpiration;
	}

	@Override
	public String toString() {
		return super.toString()+"Alimentaire [dateExpiration=" + dateExpiration + "]";
	}
	
	/*
	public void setDateExpiration(String date)throws ParseException{
       String forma="dd/mm/yyyy";
       SimpleDateFormat simpleDateFormat =new SimpleDateFormat(forma);
       Date dateEx =simpleDateFormat.parse(date);
       this.dateExpiration=dateEx;
		 
	}*/
	
	

}
