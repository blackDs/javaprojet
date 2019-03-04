package com.c5.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import com.c5.core.Chaussette;
import com.c5.core.Chemise;
import com.c5.dao.interfaces.IDao;
import com.c5.database.ConnectionDB;

public class ChausseteDAO implements IDao<Chaussette>{
	private static Connection connect = ConnectionDB.getInstance();
	String query;
	VetementDAO vetdao;
	
	public ChausseteDAO(){
		vetdao = new VetementDAO();
		
	}

	@Override
	public void add(Chaussette ch) {
		vetdao.add(ch);
		query="INSERT INTO Chaussette (idChaussette,TailleChaussette) VALUES (?,?)";
		PreparedStatement stm;
		try{
			stm = connect.prepareStatement(query);
			stm.setInt(1, ch.getIdArticle());
			stm.setInt(2, ch.getTailleChaussette());
			if(stm.executeUpdate()>0)
			{
				System.out.println("A new Chaussette is added");
			}
		}
		catch (SQLException e){
			e.printStackTrace();
		}
	}

	@Override
	public void delete(Chaussette ch) {
		query="DELETE from Chaussette WHERE idChaussette="+ch.getIdArticle();
		PreparedStatement stm; 
		try{
			stm = connect.prepareStatement(query);
			if(stm.executeUpdate()>0)
			{
				System.out.println("Chaussette deleted");
			}
		}
		catch(SQLException e){
			e.printStackTrace();
		}
		vetdao.delete(ch);
		
	}

	@Override
	public void update(Chaussette t) {
		vetdao.update(t);
		query="Update Chaussette set tailleChaussette='"+t.getTailleChaussette()+"' where idChaussette="+t.getIdArticle();
		PreparedStatement stm;
		 try {
				stm = connect.prepareStatement(query);
				if(stm.executeUpdate()>0)
				{
					System.out.println("column updated");
				}
			} catch (SQLException e) {
				e.printStackTrace();
			}
		 /*vd.update(c);
		query="Update Chaussure set pointure='"+c.getPointure()+"' where idChaussure="+c.getIdArticle();
		PreparedStatement stmt;
		 try {
				stmt = connect.prepareStatement(query);
				stmt.executeUpdate();
			} catch (SQLException e) {
				e.printStackTrace();
			}*/
	}

	@Override
	public ArrayList<Chaussette> getAll() {
		ArrayList<Chaussette> listChaussettes = new ArrayList<>();
		query ="SELECT idArticle,nomArticle,prixArticle,typeArticle,fournisseur,marque,tissu,sexe,couleur,promotion,taille "
				+ "from Article a,Vetement v,Chemise c "
				 + "where a.idArticle=v.idVetement AND a.idArticle=c.idChemise";
		PreparedStatement stm;
		try {
			stm = connect.prepareStatement(query);
			ResultSet rs = stm.executeQuery(query);
			while(rs.next())
			{
				listChaussettes.add(new Chaussette(rs.getInt("idArticle"),rs.getString("nomArticle"),rs.getDouble("prixArticle")
						,rs.getString("typeArticle"),rs.getString("fournisseur"),rs.getString("marque"),rs.getString("tissu")
						,rs.getString("sexe"),rs.getString("couleur"),rs.getInt("promotion"),rs.getInt("tailleChaussette")));
			}
		} catch(SQLException e){
			e.printStackTrace();
		}
	
		return listChaussettes;
	}

}
