package com.c5.enumeration;

public enum Processeur {
	
	Pentuim ("Intel Pentium 4"),
	  DualCore ("Intel Dual Core"),
	  QuadCore ("Intel Quad Core"),
	  AMD("amd de l'atom"),
	  i3("Intel i3"),
	  i5("Intel i5"),
	  i7("Intel i7");
	  
	  private String name = "";
	   
	  Processeur(String name){
	    this.name = name;
	  }
	   
	  public String toString(){
	    return name;
	  }

}
