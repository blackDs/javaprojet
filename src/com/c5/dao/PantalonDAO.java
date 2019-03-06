package com.c5.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import com.c5.core.Chaussette;
import com.c5.core.Chemise;
import com.c5.core.Pantalon;
import com.c5.dao.interfaces.IDao;
import com.c5.database.ConnectionDB;

public class PantalonDAO implements IDao<Pantalon>{
	private static Connection connect = ConnectionDB.getInstance();
	String query;
	VetementDAO vetdao;
	
	public PantalonDAO(){
		vetdao = new VetementDAO();
		
	}

	@Override
	public void add(Pantalon P) {
		vetdao.add(P);
		query="INSERT INTO Pantalon (idPantalon,TaillePantalon) VALUES (?,?)";
		PreparedStatement stm;
		try{
			stm = connect.prepareStatement(query);
			stm.setInt(1, P.getIdArticle());
			stm.setInt(2, P.getTaillePantalon());
			if(stm.executeUpdate()>0)
			{
				System.out.println("A new Pantalon is Added");
			}
		}
		catch (SQLException e){
			e.printStackTrace();
		}
	}

	@Override
	public void delete(Pantalon P) {
		
		query="DELETE from Pantalon WHERE idPantalon="+P.getIdArticle();
		PreparedStatement stm; 
		try{
			stm = connect.prepareStatement(query);
			if(stm.executeUpdate()>0)
			{
				System.out.println("Pantalon deleted");
			}
		}
		catch(SQLException e){
			e.printStackTrace();
		}
		vetdao.delete(P);
	
		
	}

	@Override
	public void update(Pantalon p) {
		vetdao.update(p);
		query="Update Pantalon set taillePantalon='"+p.getTaillePantalon()+"' where idpantalon="+p.getIdArticle();
		PreparedStatement stmt;
		 try {
				stmt = connect.prepareStatement(query);
				if(stmt.executeUpdate()>0)
					System.out.println("Pantalon Updated");
			} catch (SQLException e) {
				e.printStackTrace();
			}
		
	}

	@Override
	public ArrayList<Pantalon> getAll() {
		ArrayList<Pantalon> listPantalon = new ArrayList<>();
		query ="SELECT idArticle,nomArticle,prixArticle,typeArticle,fournisseur,marque,tissu,sexe,couleur,promotion,taillePantalon "
				+ "from Article a,Vetement v,Pantalon p "
				 + "where a.idArticle=v.idVetement AND a.idArticle=p.idPantalon";
		PreparedStatement stm;
		try {
			stm = connect.prepareStatement(query);
			ResultSet rs = stm.executeQuery(query);
			while(rs.next())
			{
				listPantalon.add(new Pantalon(rs.getInt("idArticle"),rs.getString("nomArticle"),rs.getDouble("prixArticle")
						,rs.getString("typeArticle"),rs.getString("fournisseur"),rs.getString("marque"),rs.getString("tissu")
						,rs.getString("sexe"),rs.getString("couleur"),rs.getInt("promotion"),rs.getInt("taillePantalon")));
			}
		} catch(SQLException e){
			e.printStackTrace();
		}
	
		return listPantalon;
	}

}
