package com.c5.dao;

import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import com.c5.core.Conserver;
import com.c5.dao.interfaces.IDao;
import com.c5.database.ConnectionDB;
import com.c5.outils.*;


public class ConserverDAO implements IDao<Conserver>{
	
	private static Connection connect = ConnectionDB.getInstance();
	String query;
	AlimentaireDAO aldao;
	
	public ConserverDAO(){
		aldao = new AlimentaireDAO();
		
	}

	@Override
	public void add(Conserver C) {
		aldao.add(C);
		query="INSERT INTO conserver (id_conserver,stock,date_fabrication,emballage) VALUES (?,?,?,?)";
		PreparedStatement stm;
		try{
			stm = connect.prepareStatement(query);
			stm.setInt(1, C.getIdArticle());
			stm.setDouble(2, C.getStock());
			stm.setDate(3, ConvertDate.convertUtilToSql(C.getDateExpiration()));
			stm.setString(4, C.getEmballage());
			if(stm.executeUpdate()>0)
			{
				System.out.println("A new Emballage is added");
			}
		}
		catch (SQLException e){
			e.printStackTrace();
		}
		
		
	}

	@Override
	public void delete(Conserver C) {
		query="DELETE from CONSERVER WHERE id_conserver="+C.getIdArticle();
		PreparedStatement stm; 
		try{
			stm = connect.prepareStatement(query);
			stm.executeUpdate();
		}
		catch(SQLException e){
			e.printStackTrace();
		}
		aldao.delete(C);
	}
		
	

	@Override
	public void update(Conserver C) {
		aldao.update(C);
		String query="UPDATE Conserver SET Stock='"+C.getStock()+"',date_fabrication='"+ConvertDate.convertUtilToSql(C.getDateExpiration())+"',emballage='"+C.getEmballage()
        +"'WHERE ID_conserver='"+C.getIdArticle()+"'";
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
	public ArrayList<Conserver> getAll() {
		ArrayList<Conserver> listConserver = new ArrayList<>();
		query ="SELECT *"
				+ "from Article a,Alimentaire al,Conserver C "
				 + "where a.idArticle=C.id_conserver AND a.idArticle=al.id_alimentaire";
		PreparedStatement stm;
		try {
			stm = connect.prepareStatement(query);
			ResultSet rs = stm.executeQuery(query);
			while(rs.next())
			{
				listConserver.add(new Conserver(rs.getInt("idArticle"),rs.getString("nomArticle"),rs.getDouble("prixArticle")
						,rs.getString("typeArticle"),rs.getString("fournisseur"),rs.getDate("date_Expiration"),rs.getDouble("Stock")
						,rs.getDate("date_fabrication"),rs.getString("emballage")));
			}
		} catch(SQLException e){
			e.printStackTrace();
		}
	
		return listConserver;
	}
}
