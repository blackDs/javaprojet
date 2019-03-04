package com.c5.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import com.c5.core.Pc;
import com.c5.core.Tv;
import com.c5.dao.interfaces.IDao;
import com.c5.database.ConnectionDB;

public class PcDAO implements IDao<Pc>{
	private static Connection connect = ConnectionDB.getInstance();
	String query;
	ElectroniqueDAO eldao;
	
	public PcDAO(){
		eldao = new ElectroniqueDAO();
	}

	@Override
	public void add(Pc t) {
		eldao.add(t);
		query="INSERT INTO Pc (id_pc,Processeur,disque_dur) VALUES (?,?,?)";
		PreparedStatement stm;
		try{
			stm = connect.prepareStatement(query);
			stm.setInt(1, t.getIdArticle());
			stm.setString(2, t.getProcesseur());
			stm.setInt(3, t.getDisqueDur());
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
	public void delete(Pc t) {
		query="DELETE from Pc WHERE id_Pc="+t.getIdArticle();
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
	public void update(Pc t) {
		eldao.update(t);
		String query="UPDATE Pc SET Processeur='"+t.getProcesseur()+"'WHERE ID_Pc='"+t.getIdArticle()+"'";
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
	public ArrayList<Pc> getAll() {
		ArrayList<Pc> listPc = new ArrayList<>();
		query ="SELECT idArticle,nomArticle,prixArticle,typeArticle,fournisseur,Ecran,processeur,disque_dur "
				+ "from Article a,Electronique e,Pc p "
				 + "where a.idArticle=e.id_electronique AND a.idArticle=p.id_pc";
		PreparedStatement stm;
		try {
			stm = connect.prepareStatement(query);
			ResultSet rs = stm.executeQuery(query);
			while(rs.next())
			{
				listPc.add(new Pc(rs.getInt("idArticle"),rs.getString("nomArticle"),rs.getDouble("prixArticle")
						,rs.getString("typeArticle"),rs.getString("fournisseur"),rs.getString("Ecran"),rs.getInt("Ram"),rs.getString("Processeur")
						,rs.getInt("disque_dur")));
			}
		} catch(SQLException e){
			e.printStackTrace();
		}
	
		return listTv;
	}

	

}
