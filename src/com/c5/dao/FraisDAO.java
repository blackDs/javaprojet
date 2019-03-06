package com.c5.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import com.c5.core.Frais;
import com.c5.dao.interfaces.IDao;
import com.c5.database.ConnectionDB;

public class FraisDAO implements IDao<Frais>{
	
	private static Connection connect = ConnectionDB.getInstance();
	String query;
	AlimentaireDAO aldao;
	
	public FraisDAO(){
		aldao = new AlimentaireDAO();
		
	}

	@Override
	public void add(Frais f) {
		aldao.add(f);
		query="INSERT INTO Frais (id_frais,poids,poidstock,nature) VALUES (?,?,?,?)";
		PreparedStatement stm;
		try{
			stm = connect.prepareStatement(query);
			stm.setInt(1, f.getIdArticle());
			stm.setDouble(2, f.getPoids());
			stm.setDouble(3, f.getPoidStock());
			stm.setString(4, f.getNature());
			if(stm.executeUpdate()>0)
			{
				System.out.println("A new Frais is added");
			}
		}
		catch (SQLException e){
			e.printStackTrace();
		}
		
	}

	@Override
	public void delete(Frais f) {
		query="DELETE from Frais WHERE id_frais="+f.getIdArticle();
		PreparedStatement stm; 
		try{
			stm = connect.prepareStatement(query);
			
			if(stm.executeUpdate()>0)
				System.out.println("Frais deleted");
		}
		catch(SQLException e){
			e.printStackTrace();
		}
		aldao.delete(f);
	}

	@Override
	public void update(Frais f) {
		aldao.update(f);
		String query="UPDATE Frais SET poids='"+f.getPoids()+"',poid_stock='"+f.getPoidStock()+"',nautre='"+f.getNature()
        +"'WHERE ID_frais='"+f.getIdArticle()+"'";
		PreparedStatement stmt;
		try {
			stmt=connect.prepareStatement(query);
			if(stmt.executeUpdate()>0)
			{
				System.out.println("Chemise updated");
			}
		}
		catch(SQLException e){
			e.printStackTrace();
		}
	}

	@Override
	public ArrayList<Frais> getAll() {
		ArrayList<Frais> listFrais = new ArrayList<>();
		query ="SELECT idArticle,nomArticle,prixArticle,typeArticle,fournisseur,dateExpiration,nature,poids,poidstock"
				+ "from Article a,Alimentaire al,Frais f "
				 + "where a.idArticle=f.id_frais AND a.idArticle=al.id_alimentaire";
		PreparedStatement stm;
		try {
			stm = connect.prepareStatement(query);
			ResultSet rs = stm.executeQuery(query);
			while(rs.next())
			{
				listFrais.add(new Frais(rs.getInt("idArticle"),rs.getString("nomArticle"),rs.getDouble("prixArticle")
						,rs.getString("typeArticle"),rs.getString("fournisseur"),rs.getDate("dateExpiration"),rs.getString("nature")
						,rs.getDouble("poids"),rs.getDouble("poidStock")));
			}
		} catch(SQLException e){
			e.printStackTrace();
		}
	
		return listFrais;
	}

}
