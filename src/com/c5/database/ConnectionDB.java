package com.c5.database;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class ConnectionDB {

	  private static String url = "jdbc:mysql://localhost:3306/magasin";
	  private static String user = "root";
	  private static String passwd = "";
	  private static Connection connect = null;
	  
	  private ConnectionDB() {    
	  }
	   
	  public static Connection getInstance(){
	   
	   if(connect == null){
	       try {
	      Class.forName("com.mysql.jdbc.Driver");
	         connect = DriverManager.getConnection(url, user, passwd);
	         System.out.println("connexion réussi");
	       } catch (SQLException | ClassNotFoundException e) {
	         e.printStackTrace();
	       }
	     }      
	     return connect;
	      } 
	   
	}