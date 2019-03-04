package com.c5.core;

import com.c5.enumeration.Processeur;

public class Pc extends Electronique{
	
	private int Ram;
	private String processeur;
	private int disqueDur;

	public Pc(int idArticle, String nomArticle, double prixArticle, String typeArticle, String fournisseur,
			String Ecran,int Ram,String processeur,int disqueDur) {
		super(idArticle, nomArticle, prixArticle, typeArticle, fournisseur,Ecran);
		this.Ram=Ram;
		this.setProcesseur(processeur);
		this.setDisqueDur(disqueDur);
		// TODO Auto-generated constructor stub
	}

	public int getRam() {
		return Ram;
	}

	public void setRam(int ram) {
		Ram = ram;
	}

	public String getProcesseur() {
		return processeur;
	}

	public void setProcesseur(String processeur) {
		this.processeur = processeur;
	}

	public int getDisqueDur() {
		return disqueDur;
	}

	public void setDisqueDur(int disqueDur) {
		this.disqueDur = disqueDur;
	}

}
