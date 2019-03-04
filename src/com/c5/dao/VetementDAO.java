package com.c5.dao;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;

import com.c5.core.Vetement;
import com.c5.dao.interfaces.IDao;
import com.c5.database.ConnectionDB;

public class VetementDAO implements IDao<Vetement> {
	String query;
	private static Connection connect = ConnectionDB.getInstance();
	ArticleDAO adao;
	public VetementDAO(){
		adao = new ArticleDAO();
	}

	@Override
	public void add(Vetement v) {
		adao.add(v);
		query="INSERT INTO Vetement (idVetement,marque,tissu,sexe,couleur,promotion) VALUES (?,?,?,?,?,?)";
		PreparedStatement stm;
		try{
			stm = connect.prepareStatement(query);
			stm.setInt(1, v.getIdArticle());
			stm.setString(2,v.getMarque());
			stm.setString(3,v.getTissu());
			stm.setString(4, (v.getSexe().equals("H")?"H":"F"));
			stm.setString(5, v.getCouleur());
			stm.setInt(6, v.getPromotion());
			stm.executeUpdate();
		}
		catch (SQLException e){
			e.printStackTrace();
		}
	}

	@Override
	public void delete(Vetement v) {
		
		query="DELETE from Vetement WHERE idVetement="+v.getIdArticle();
		PreparedStatement stm; 
		try{
			stm = connect.prepareStatement(query);
			stm.executeUpdate();
		}
		catch(SQLException e){
			e.printStackTrace();
		}
		adao.delete(v);
	
	}

	@Override
	public void update(Vetement t) {
		adao.update(t);
		String query="UPDATE VETEMENT SET MARQUE='"+t.getMarque()+"',TISSU='"+t.getTissu()
		+"',SEXE='"+t.getSexe()+"',couleur='"+t.getCouleur()+"',promotion='"
		+t.getPromotion()+"'WHERE IDVETEMENT='"+t.getIdArticle()+"'";
		PreparedStatement stmt;
		try {
			stmt=connect.prepareStatement(query);
			if(stmt.executeUpdate()>0)
			{
				
			}
		}
		catch(SQLException e){
			e.printStackTrace();
		}
		
	}

	@Override
	public ArrayList<Vetement> getAll() {
		// TODO Auto-generated method stub
		return null;
	}
	

}
