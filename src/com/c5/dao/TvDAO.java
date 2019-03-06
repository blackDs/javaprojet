package com.c5.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import com.c5.core.Chemise;
import com.c5.core.Tv;
import com.c5.dao.interfaces.IDao;
import com.c5.database.ConnectionDB;

public class TvDAO implements IDao<Tv>{

	private static Connection connect = ConnectionDB.getInstance();
	String query;
	ElectroniqueDAO eldao;
	
	public TvDAO(){
		eldao = new ElectroniqueDAO();
		
	}

	@Override
	public void add(Tv t) {
		eldao.add(t);
		query="INSERT INTO Tv (id_tv,resolution) VALUES (?,?)";
		PreparedStatement stm;
		try{
			stm = connect.prepareStatement(query);
			stm.setInt(1, t.getIdArticle());
			stm.setString(2, t.getResolution());
			if(stm.executeUpdate()>0)
			{
				System.out.println("A new Tv is added");
			}
		}
		catch (SQLException e){
			e.printStackTrace();
		}
		
	}

	@Override
	public void delete(Tv t) {
		query="DELETE from Tv WHERE id_tv="+t.getIdArticle();
		PreparedStatement stm; 
		try{
			stm = connect.prepareStatement(query);
			stm.executeUpdate();
		}
		catch(SQLException e){
			e.printStackTrace();
		}
		eldao.delete(t);
		
	}

	@Override
	public void update(Tv t) {
		eldao.update(t);
		String query="UPDATE TV SET Resolution='"+t.getResolution()+"'WHERE ID_tv='"+t.getIdArticle()+"'";
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
	public ArrayList<Tv> getAll() {
		ArrayList<Tv> listTv = new ArrayList<>();
		query ="SELECT idArticle,nomArticle,prixArticle,typeArticle,fournisseur,Ecran,resolution "
				+ "from Article a,Electronique e,Tv t "
				 + "where a.idArticle=e.id_electronique AND a.idArticle=t.id_tv";
		PreparedStatement stm;
		try {
			stm = connect.prepareStatement(query);
			ResultSet rs = stm.executeQuery(query);
			while(rs.next())
			{
				listTv.add(new Tv(rs.getInt("idArticle"),rs.getString("nomArticle"),rs.getDouble("prixArticle")
						,rs.getString("typeArticle"),rs.getString("fournisseur"),rs.getString("Ecran"),rs.getString("Resolution")));
			}
		} catch(SQLException e){
			e.printStackTrace();
		}
	
		return listTv;
	}

}
