package com.c5.main;

import java.util.ArrayList;

import com.c5.core.Chaussette;
import com.c5.core.Chemise;
import com.c5.core.Conserver;
import com.c5.core.Pantalon;
import com.c5.core.Tv;
import com.c5.dao.ChausseteDAO;
import com.c5.dao.ChemiseDAO;
import com.c5.dao.PantalonDAO;
import com.c5.dao.TvDAO;
import com.c5.dao.ConserverDAO;

public class main {

	public static void main(String[] args) throws Exception {
		Chemise ch = new Chemise(10,"nom",999,"type","celio","celioo","coton","H","rouge",45,25);
		ChemiseDAO chd = new ChemiseDAO();
		chd.update(ch);
		
		/*Chemise ch1 = new Chemise(11,"name",9999,"typee","ccelio","ccelioo","ccoton","hhomme","rouuge",46,26);
		ChemiseDAO chd1 = new ChemiseDAO();
		chd1.add(ch1);
		*/
		//chd.delete(ch);
		System.out.println("****");
		/*ArrayList<Chemise> chemises = new ArrayList<>();
		chemises.addAll(chd.getAll());
		System.out.println(chemises.isEmpty());
		for (Chemise chem:chemises)
		{
			System.out.println(chem);
		}*/
		
		Pantalon P = new Pantalon(50,"name",50.5,"Pantal","zaraaa","zaraaa","slim","H","rouge",45,35);
		PantalonDAO pd=new PantalonDAO();
		//pd.add(P);
		//pd.update(P);
		
		Chaussette ch1 = new Chaussette(5000,"nom",50,"chauss","nike","nike","sport","H","blanc",40,3);
		ChausseteDAO chdao=new ChausseteDAO();
		//chdao.update(ch1);
	/*	ArrayList<Pantalon> pantalons=new ArrayList<>();
		pantalons.addAll(pd.getAll());
		for (Pantalon p:pantalons)
		{
			System.out.println(p);
		}
		
		Tv tv=new Tv(1010,"Nokia",50,"television","Nokia","30pouce","1982-1024");
		TvDAO tdao=new TvDAO();
		tdao.update(tv);
		ArrayList<Tv> Tvs=new ArrayList<>();
		Tvs.addAll(tdao.getAll());
		for (Tv t:Tvs)
		{
			System.out.println(tv);
		}*/
		
		//Conserver con=new Conserver(3, "nom",1.1 , "xx",null, 10-03-03, 1.1,null, "xxxx");
		java.util.Date uDate = new java.util.Date();
		Conserver con = new Conserver(7, "nom", 0, "type", "fournis",uDate, 0, uDate, "emb");
		ConserverDAO conDAO=new ConserverDAO();
		//conDAO.add(con);
		ArrayList<Conserver> Conservers=new ArrayList<>();
		Conservers.addAll(conDAO.getAll());
		for (Conserver c:Conservers)
		{
			System.out.println(c);
		}
	}
}
