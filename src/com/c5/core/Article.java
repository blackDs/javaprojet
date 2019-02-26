package com.c5.core;

public class Article {
	
		private int 	idArticle  ;
		private String 	nomArticle ;
		private double 	prixArticle;
		private String 	typeArticle;
		private String  fournisseur;
		
		
		public Article(int idArticle, String nomArticle,
					   double prixArticle, String typeArticle, String fournisseur) {
			
			this.idArticle = idArticle;
			this.nomArticle = nomArticle;
			this.prixArticle = prixArticle;
			this.typeArticle = typeArticle;
			this.fournisseur = fournisseur;
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
