package com.c5.enumeration;

public enum emballage {
	liquide(" "),
	embalee(" ");
	
	 private String name = "";
	   
	  emballage(String name){
	    this.name = name;
	  }
	   
	  public String toString(){
	    return name;
	  }

}
