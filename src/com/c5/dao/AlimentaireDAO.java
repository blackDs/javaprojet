package com.c5.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.ArrayList;

import com.c5.core.Alimentaire;
import com.c5.dao.interfaces.IDao;
import com.c5.database.ConnectionDB;

public class AlimentaireDAO implements IDao<Alimentaire>{
	String query;
	private static Connection connect = ConnectionDB.getInstance();
	ArticleDAO adao;
	public AlimentaireDAO(){
		adao = new ArticleDAO();
	}
	
	@Override
	public void add(Alimentaire t) {
		adao.add(v);
		query="INSERT INTO Alimentaire (idVetement,marque,tissu,sexe,couleur,promotion) VALUES (?,?,?,?,?,?)";
		PreparedStatement stm;
		try{
			stm = connect.prepareStatement(query);
			stm.setInt(1, v.getIdArticle());
			stm.setString(2,v.getMarque());
		
			stm.executeUpdate();
		}
		catch (SQLException e){
			e.printStackTrace();
		}
		
	}
	@Override
	public void delete(Alimentaire t) {
		// TODO Auto-generated method stub
		
	}
	@Override
	public void update(Alimentaire t) {
		// TODO Auto-generated method stub
		
	}
	
	@Override
	public ArrayList getAll() {
		// TODO Auto-generated method stub
		return null;
	}

}
