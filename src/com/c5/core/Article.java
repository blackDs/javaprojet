package com.c5.core;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

import com.c5.database.ConnectionDB;

public class Article {
	
		public int 	idArticle  ;
		public String 	nomArticle ;
		public double 	prixArticle;
		public String 	typeArticle;
		public String  fournisseur;
		
		
		public Article(int idArticle, String nomArticle,
					   double prixArticle, String typeArticle, String fournisseur) {
			this.idArticle = idArticle;
			this.nomArticle = nomArticle;
			this.prixArticle = prixArticle;
			this.typeArticle = typeArticle;
			this.fournisseur = fournisseur;
		}


		public Article() {
			// TODO Auto-generated constructor stub
		}


		public int getIdArticle() {
			return idArticle;
		}


		public void setIdArticle(int idArticle) {
			this.idArticle = idArticle;
		}


		public String getNomArticle() {
			return nomArticle;
		}


		public void setNomArticle(String nomArticle) {
			this.nomArticle = nomArticle;
		}


		public double getPrixArticle() {
			return prixArticle;
		}


		public void setPrixArticle(double prixArticle) {
			this.prixArticle = prixArticle;
		}


		public String getTypeArticle() {
			return typeArticle;
		}


		public void setTypeArticle(String typeArticle) {
			this.typeArticle = typeArticle;
		}


		public String getFournisseur() {
			return fournisseur;
		}


		public void setFournisseur(String fournisseur) {
			this.fournisseur = fournisseur;
		}


		@Override
		public String toString() {
			return "Article ID = " + idArticle + ", nom = " + nomArticle + ", prix = " + prixArticle
					+ ", type = " + typeArticle + ", fournisseur = " + fournisseur ;
		}
		
		}
