package com.c5.enumeration;

public enum Sexe {
	H("Homme"),
	F("Femme");
	
	
	 private String name = "";
	   
	  Sexe(String name){
	    this.name = name;
	  }
	   
	  public String toString(){
	    return name;
	  }

}
