package com.c5.dao;

import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import com.c5.core.Alimentaire;
import com.c5.core.Conserver;
import com.c5.dao.interfaces.IDao;
import com.c5.database.ConnectionDB;
import com.c5.outils.ConvertDate;

public class AlimentaireDAO implements IDao<Alimentaire>{
	String query;
	private static Connection connect = ConnectionDB.getInstance();
	ArticleDAO adao;
	public AlimentaireDAO(){
		adao = new ArticleDAO();
	}
	
	@Override
	public void add(Alimentaire a) {
		adao.add(a);
		query="INSERT INTO Alimentaire (id_alimentaire,date_expiration) VALUES (?,?)";
		PreparedStatement stm;
		try{
			stm = connect.prepareStatement(query);
			stm.setInt(1, a.getIdArticle());
			stm.setDate(2,ConvertDate.convertUtilToSql(a.getDateExpiration()));
			stm.executeUpdate();
		}
		catch (SQLException e){
			e.printStackTrace();
		}
		
	}
	@Override
	public void delete(Alimentaire a) {
		query="DELETE from Alimentaire WHERE id_alimentaire="+a.getIdArticle();
		PreparedStatement stm; 
		try{
			stm = connect.prepareStatement(query);
			stm.executeUpdate();
		}
		catch(SQLException e){
			e.printStackTrace();
		}
		adao.delete(a);
		
	}
	@Override
	public void update(Alimentaire a) {
		adao.update(a);
		String query="UPDATE Alimentaire SET date_expiration='"+a.getDateExpiration()+"'WHERE ID_alimentaire='"+a.getIdArticle()+"'";
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
	public ArrayList<Alimentaire> getAll() {
		ArrayList<Alimentaire> listAlimentaire = new ArrayList<>();
		query ="SELECT *"
				+ "from Article a,Alimentaire al"
				 + "where a.idArticle=al.id_alimentaire";
		PreparedStatement stm;
		try {
			stm = connect.prepareStatement(query);
			ResultSet rs = stm.executeQuery(query);
			while(rs.next())
			{
				listAlimentaire.add(new Alimentaire(rs.getInt("idArticle"),rs.getString("nomArticle"),rs.getDouble("prixArticle")
						,rs.getString("typeArticle"),rs.getString("fournisseur"),rs.getDate("date_Expiration")));
			}
		} catch(SQLException e){
			e.printStackTrace();
		}
	
		return listAlimentaire;
	}	
}


