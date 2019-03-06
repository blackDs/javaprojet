package com.c5.enumeration;


public enum Taille {
	  XXS ("Very Small"),
	  S ("Small"),
	  M ("Meduim"),
	  L ("LaRGE"),
	  XXL("Very large");
	  
	  private String name = "";
	   
	  Taille(String name){
	    this.name = name;
	  }
	   /*
	  public String toString(){
	    return name;
	  }*/

}
