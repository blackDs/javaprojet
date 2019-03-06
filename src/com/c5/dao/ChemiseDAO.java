package com.c5.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import com.c5.core.Chemise;
import com.c5.dao.interfaces.IDao;
import com.c5.database.ConnectionDB;

public class ChemiseDAO implements IDao<Chemise> {
	private static Connection connect = ConnectionDB.getInstance();
	String query;
	VetementDAO vetdao;
	
	public ChemiseDAO(){
		vetdao = new VetementDAO();
		
	}
	@Override
	public void add(Chemise ch) {
		vetdao.add(ch);
		query="INSERT INTO Chemise (idChemise,Taille) VALUES (?,?)";
		PreparedStatement stm;
		try{
			stm = connect.prepareStatement(query);
			stm.setInt(1, ch.getIdArticle());
			stm.setString(2, ch.getTaille());
			if(stm.executeUpdate()>0)
			{
				System.out.println("A new Chemise is added");
			}
		}
		catch (SQLException e){
			e.printStackTrace();
		}
		
	}

	@Override
	public void delete(Chemise ch) {
		
		query="DELETE from Chemise WHERE idChemise="+ch.getIdArticle();
		PreparedStatement stm; 
		try{
			stm = connect.prepareStatement(query);
			if(stm.executeUpdate()>0)
			{
				System.out.println("Chemise deleted");
			}
		}
		catch(SQLException e){
			e.printStackTrace();
		}
		
		vetdao.delete(ch);
	
		
		
	}

	@Override
	public void update(Chemise t) {
		vetdao.update(t);
		query="Update Chemise set taille='"+t.getTaille()+"' where idChemise="+t.getIdArticle();
		PreparedStatement stmt;
		 try {
				stmt = connect.prepareStatement(query);
				stmt.executeUpdate();
			} catch (SQLException e) {
				e.printStackTrace();
			}
	}

	@Override
	public ArrayList<Chemise> getAll() {
		ArrayList<Chemise> listChemises = new ArrayList<>();
		query ="SELECT idArticle,nomArticle,prixArticle,typeArticle,fournisseur,marque,tissu,sexe,couleur,promotion,taille "
				+ "from Article a,Vetement v,Chemise c "
				 + "where a.idArticle=v.idVetement AND a.idArticle=c.idChemise";
		PreparedStatement stm;
		try {
			stm = connect.prepareStatement(query);
			ResultSet rs = stm.executeQuery(query);
			while(rs.next())
			{/*
				listChemises.add(new Chemise(rs.getInt("idArticle"),rs.getString("nomArticle"),rs.getDouble("prixArticle")
						,rs.getString("typeArticle"),rs.getString("fournisseur"),rs.getString("marque"),rs.getString("tissu")
						,rs.getString("Sexe"),rs.getString("couleur"),rs.getInt("promotion"),setTaille(rs.getString("taille"))));
			*/
				Chemise ch= new Chemise();
				ch.setIdArticle(rs.getInt("idArticle"));
				ch.setTaille(rs.getString("taille"));
				listChemises.add(ch);
				
			}
		} catch(SQLException e){
			e.printStackTrace();
		}
		return listChemises;
	}
}
