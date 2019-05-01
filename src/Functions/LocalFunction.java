package Functions;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;

import Model.Equipement;
import Model.Local;

public class LocalFunction {
	
	/*
	 * 
	 * Méthods utilisé pour ajouter un Local
	 * **/
	public static int AjouterLocal(Local local) throws ClassNotFoundException, SQLException{
		String SQL ="INSERT INTO public.local(\"prioriteNiv\",nom,etage,nbrtable,numero)VALUES(?,?,?,?,?)";
		int GENERATED_KEY = 0;
		Connection cnx = DBConnect.ConnectDB();
		if(cnx == null){
			
		}else{
			String Nom = local.getNom();
			String Niveau = local.getNiveau();
			int Etage = local.getEtage();
			int NbrTable = local.getNbrtable();
			int Numero = local.getNumero();
			try{
				PreparedStatement stat = cnx.prepareStatement(SQL,Statement.RETURN_GENERATED_KEYS);
				stat.setString(1,Niveau);
				stat.setString(2,Nom);
				stat.setInt(3,Etage);
				stat.setInt(4,NbrTable);
				stat.setInt(5,Numero);
				stat.executeUpdate();
				ResultSet result = stat.getGeneratedKeys();
				while(result.next()){
					GENERATED_KEY = result.getInt(4);
				}
			}catch(Exception ex){
				ex.printStackTrace();
			}
		}
		return GENERATED_KEY;	
		
	}
	
	/**
	 * Méthods utilisée pour récupérer tous les locaux
	 * 
	 * */
	public static ArrayList<Local> AllLocal() throws ClassNotFoundException, SQLException{
		ArrayList<Local> arrayLocal = new ArrayList<Local>();
		String SQL ="SELECT * FROM public.local";
		Connection cnx = DBConnect.ConnectDB();
		if(cnx == null){
			
		}else{
			PreparedStatement stat = cnx.prepareStatement(SQL);
			ResultSet result = stat.executeQuery();
			while(result.next()){
				
				String priorite = result.getString("prioriteNiv");
				String nom = result.getString("nom");
				int etage = result.getInt("etage");
				int nbrtable  = result.getInt("nbrtable");
				int numero = result.getInt("numero");
				Local local = new Local(priorite,nom,etage,nbrtable,numero);
				arrayLocal.add(local);
			}
		}
		return arrayLocal;
	}
	
	/*
	 * Afficher un local spécifier en passant le code
	 * du local en paramétre , 
	 * en retournant le local chercher
	 * **/
	public static Local AfficherUnSeulLocal(Local getlocal) throws ClassNotFoundException, SQLException{
		String getLocalName = getlocal.getNom();
		Local local = null;
		String SQL ="SELECT * FROM public.local WHERE nom = ?";
		Connection cnx = DBConnect.ConnectDB();
		if(cnx == null){
			
		}else{
			PreparedStatement stat = cnx.prepareStatement(SQL);
			stat.setString(1,getLocalName);
			ResultSet result = stat.executeQuery();
			while(result.next()){
				String priorite = result.getString("prioriteNiv");
				String nom = result.getString("nom");
				int etage = result.getInt("etage");
				int nbrtable = result.getInt("nbrtable");
				int numero = result.getInt("numero");
				local = new Local(priorite,nom,etage,nbrtable,numero);
			}
		}
		return local;
	}
	
	/*
	 * Méthode pour récupérer l'id du local a partir du code
	 * */
	public static int GetIDLocal(Local LocalName) throws ClassNotFoundException, SQLException{
		String localName = LocalName.getNom();
		int idLocal = 0;
		String SQL ="SELECT \"idLocal\" FROM public.local WHERE \"nom\" = ?";
		Connection cnx = DBConnect.ConnectDB();
		if(cnx == null){
			
		}else{
			PreparedStatement stat = cnx.prepareStatement(SQL);
			stat.setString(1,localName);
			ResultSet result = stat.executeQuery();
			while(result.next()){;
				idLocal = result.getInt("idLocal");
			}
		}
		return idLocal;
	}
	
	public static String DeleteLocal(Local localName) throws ClassNotFoundException, SQLException{
		String SQL = "DELETE FROM public.local WHERE \"nom\" = ?";
		String NomLocal = localName.getNom();
		Connection cnx = DBConnect.ConnectDB();
		PreparedStatement stat = cnx.prepareStatement(SQL);
		stat.setString(1,NomLocal);
		stat.execute();
		return "OK";
	}
	
	public static String ConfirmeNbrPlace(Local local) throws ClassNotFoundException, SQLException{
		String SQL = "SELECT * FROM public.local WHERE \"nbrtable\" > ?";
		String returnResult = "LOCALOK";
		int nbrTable = local.getNbrtable();
		Connection cnx = DBConnect.ConnectDB();
		PreparedStatement stat = cnx.prepareStatement(SQL);
		stat.setInt(1,nbrTable);
		ResultSet result = stat.executeQuery();
		if(!result.next()){
			returnResult = "LOCALNOTOK";
		}	
		return returnResult;
	}
	/*
	 * 
	 * Méthode pour récupérer tous les locaux relatives au Equipements choisi
	 * */
	public static ArrayList<Local> getLocalFromEquipement(Equipement equipement) throws ClassNotFoundException, SQLException{
		ArrayList<Local> allLocal = new ArrayList<Local>();
		ArrayList<Integer> AllLocalIDs = new ArrayList<Integer>();
		String SQL = "SELECT \"idLocal\" FROM public.localequip WHERE \"idEquipement\" = ?";
		String SQL_LOCAL = "SELECT * FROM public.local WHERE \"idLocal\" = ?";
		int idEquipement = equipement.getIdEquipement();
		Connection cnx = DBConnect.ConnectDB();
		PreparedStatement stat = cnx.prepareStatement(SQL);
		stat.setInt(1,idEquipement);
		ResultSet idLocalResult = stat.executeQuery();
		while(idLocalResult.next()){
			AllLocalIDs.add(idLocalResult.getInt("idLocal"));
		}
		for(int i=0 ; i<AllLocalIDs.size();i++){
			int getId = AllLocalIDs.get(i);
			PreparedStatement statLocal = cnx.prepareStatement(SQL_LOCAL);
			statLocal.setInt(1,getId);
			ResultSet result1 = statLocal.executeQuery();
			while(result1.next()){
				String nom = result1.getString("nom");
				int numero = result1.getInt("numero");
				int nbrtable = result1.getInt("nbrtable");
				int etage = result1.getInt("etage");
				Local local = new Local(nom,numero,nbrtable,etage,getId);
				allLocal.add(local);
			}
		}
		return allLocal;
	}
	
	
	/*
	 * Méthode qui nous permet de récupérer le local a partir de son identifiant
	 * */
	public static Local showOneLocal(Local local) throws ClassNotFoundException, SQLException{
		Local returnLocal = null;
		String SQL  = "SELECT * FROM public.local WHERE \"idLocal\" = ?";
		int idLocal = local.getNbrtable();
		Connection cnx = DBConnect.ConnectDB();
		PreparedStatement stat = cnx.prepareStatement(SQL);
		stat.setInt(1,idLocal);
		ResultSet result = stat.executeQuery();
		while(result.next()){
			String NOM = result.getString("nom");
			int NBR_TABLE = result.getInt("nbrtable");
			int NUMERO = result.getInt("numero");
			int ETAGE = result.getInt("etage");
			int ID_LOCAL = result.getInt("idLocal");
			String PRIORITE_NIV = result.getString("prioriteNiv");
			returnLocal = new Local(PRIORITE_NIV, NOM, ETAGE, NBR_TABLE, NUMERO,ID_LOCAL);
		}
		return returnLocal;
	}
	
	/*
	 * Methode pour recuperer le nom du local a partir de l'id
	 * */
	public static String getLocalNameFromId(int idLocal) throws ClassNotFoundException, SQLException{
		String NOM = "";
		String SQL = "SELECT nom FROM public.local WHERE \"idLocal\" = ?";
		Connection cnx = DBConnect.ConnectDB();
		PreparedStatement stat = cnx.prepareStatement(SQL);
		stat.setInt(1,idLocal);
		ResultSet result = stat.executeQuery();
		while(result.next()){
			NOM = result.getString("nom");
		}
		return NOM;
	}
}
