package com.c5.main;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.ArrayList;

import com.c5.core.Alimentaire;
import com.c5.dao.interfaces.IDao;
import com.c5.database.ConnectionDB;


public class maindate {

	public static void main(String[] args) {
		
		Connection connect = ConnectionDB.getInstance();
		String query="INSERT INTO test (id,date) VALUES (?,?)";
		PreparedStatement stm;
		 java.util.Date uDate = new java.util.Date();
		try{
			stm = connect.prepareStatement(query);
			stm.setInt(1, 1);
			stm.setDate(2,convertUtilToSql(uDate));
			stm.executeUpdate();
		}
		catch (SQLException e){
			e.printStackTrace();
		}
	}
	
	 private static java.sql.Date convertUtilToSql(java.util.Date uDate) {
	        java.sql.Date sDate = new java.sql.Date(uDate.getTime());
	        return sDate;
	    }
}
