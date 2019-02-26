package com.c5.enumeration;

public enum Nature {

	legumes(" "),
	fruit(" ");
	
	 private String name = "";
	   
	  Nature(String name){
	    this.name = name;
	  }
	   
	  public String toString(){
	    return name;
	  }
	
}
