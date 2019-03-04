package com.c5.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;

import com.c5.core.Article;
import com.c5.dao.interfaces.IDao;
import com.c5.database.ConnectionDB;

public class ArticleDAO implements IDao<Article>{
	String query;
	private static Connection connect = ConnectionDB.getInstance();
	

	@Override
	public void add(Article a){
		query="INSERT INTO Article (idArticle,nomArticle,prixArticle,typeArticle,fournisseur) VALUES (?,?,?,?,?)";
		PreparedStatement stm;
		try{
			stm = connect.prepareStatement(query);
			stm.setInt(1, a.getIdArticle());
			stm.setString(2, a.getNomArticle());
			stm.setDouble(3, a.getPrixArticle());
			stm.setString(4, a.getTypeArticle());
			stm.setString(5, a.getFournisseur());
			stm.executeUpdate();
		}
		catch (SQLException e){
			e.printStackTrace();
		}

	}

	@Override
	public void delete(Article a) {
		query="DELETE from Article WHERE idArticle="+a.getIdArticle();
		PreparedStatement stm; 
		try{
			stm = connect.prepareStatement(query);
		    //stm.executeQuery(query);
			stm.executeUpdate();
		}
		catch(SQLException e){
			e.printStackTrace();
		}
	}

	@Override
	public void update(Article a) {
		String query="UPDATE ARTICLE SET nomArticle='"+a.getNomArticle()+"',prixArticle='"+a.getPrixArticle()
		+"',typeArticle='"+a.getTypeArticle()+"',fournisseur='"+a.getFournisseur()+"' WHERE idArticle='"+a.getIdArticle()+"'";
		PreparedStatement stmt;
		try {
			stmt=connect.prepareStatement(query);
			stmt.executeUpdate();
		}
		catch(SQLException e){
			e.printStackTrace();
		}
		
		
	}

	@Override
	public ArrayList<Article> getAll() {
		// TODO Auto-generated method stub
		return null;
	}

}
