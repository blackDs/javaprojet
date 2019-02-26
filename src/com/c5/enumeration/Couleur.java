package com.c5.enumeration;

public enum Couleur {
	R ("Rouge"),
	  V ("Vert"),
	  M ("Maron"),
	  Blc("Blanc"),
	  B("Bleu");
	  
	  private String name = "";
	   
	  Couleur(String name){
	    this.name = name;
	  }
	   
	  public String toString(){
	    return name;
	  }

}
