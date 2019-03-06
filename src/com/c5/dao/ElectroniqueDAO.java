package com.c5.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import com.c5.core.Electronique;
import com.c5.core.Tv;
import com.c5.dao.interfaces.IDao;
import com.c5.database.ConnectionDB;

public class ElectroniqueDAO implements IDao<Electronique>{
	String query;
	private static Connection connect = ConnectionDB.getInstance();
	ArticleDAO adao;
	public ElectroniqueDAO(){
		adao = new ArticleDAO();
	}


	@Override
	public void add(Electronique E) {
		adao.add(E);
		query="INSERT INTO Electronique (id_Electronique,Ecran) VALUES (?,?)";
		PreparedStatement stm;
		try{
			stm = connect.prepareStatement(query);
			stm.setInt(1, E.getIdArticle());
			stm.setString(2,E.getEcran());
			stm.executeUpdate();
		}
		catch (SQLException e){
			e.printStackTrace();
		}
		
	}

	@Override
	public void delete(Electronique t) {
		query="DELETE from Electronique WHERE id_Electronique="+t.getIdArticle();
		PreparedStatement stm; 
		try{
			stm = connect.prepareStatement(query);
			stm.executeUpdate();
		}
		catch(SQLException e){
			e.printStackTrace();
		}
		adao.delete(t);
		
	}

	@Override
	public void update(Electronique t) {
		adao.update(t);
		String query="UPDATE Electronique SET Ecran='"+t.getEcran()+"'WHERE ID_Electronique='"+t.getIdArticle()+"'";
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
	public ArrayList getAll() {
		ArrayList<Electronique> listElectronique = new ArrayList<>();
		query ="SELECT idArticle,nomArticle,prixArticle,typeArticle,fournisseur,Ecran"
				+ "from Article a,Electronique e "
				 + "where a.idArticle=e.id_electronique";
		PreparedStatement stm;
		try {
			stm = connect.prepareStatement(query);
			ResultSet rs = stm.executeQuery(query);
			while(rs.next())
			{
				listElectronique.add(new Electronique(rs.getInt("idArticle"),rs.getString("nomArticle"),rs.getDouble("prixArticle")
						,rs.getString("typeArticle"),rs.getString("fournisseur"),rs.getString("Ecran")));
			}
		} catch(SQLException e){
			e.printStackTrace();
		}
	
		return listElectronique;
	}
	}

}
