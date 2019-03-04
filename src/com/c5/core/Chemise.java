package com.c5.core;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

import com.c5.database.ConnectionDB;
import com.c5.enumeration.Couleur;
import com.c5.enumeration.Sexe;

public class Chemise extends Vetement{
	private int taille;

	public Chemise(int idArticle, String nomArticle, double prixArticle, String typeArticle, String fournisseur,
			String marque, String tissu, String sexe,String couleur,int promotion,int taille) {
		super(idArticle, nomArticle, prixArticle, typeArticle, fournisseur, marque, tissu, sexe, couleur,promotion);
		this.taille=taille;
	}

	public int getTaille() {
		return taille;
	}

	public void setTaille(int taille) {
		this.taille = taille;
	}

	@Override
	public String toString() {
		return "Chemise " +super.toString()+"[taille=" + taille + "]";
	}
	
	
	
	

}
