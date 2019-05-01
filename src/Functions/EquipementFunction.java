package Functions;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;

import Model.Equipement;
import Model.Local;

public class EquipementFunction {
	
	/*
	 * M�thode impl�menter pour ajouter un �quipement au local
	 * le type d'�quipement est stock� en fonction d'un ensemble de
	 * string r�cup�r� avant sous le type d'arraylist
	 * */
	
	public static String AjouterEquipement(Equipement equipement) throws ClassNotFoundException, SQLException{
		String SQL ="INSERT INTO public.equipement(typequip) VALUES(?)";
		Connection cnx = DBConnect.ConnectDB();
		if(cnx == null){
			
		}else{
			PreparedStatement stat = cnx.prepareStatement(SQL);
			String typeEquip = equipement.getTypeEquipement();
			stat.setString(1,typeEquip);
			stat.executeUpdate();
		}
		return "OK";
	}
	
	/*
	 * M�thode pour r�cup�rer l'ID de l'�quipement a partir de l'id du local
	 * */
	
	public static int getIdEquipFromIdLocal(Local local) throws ClassNotFoundException, SQLException{
		int ID=0;
		int idLocal = local.getId();
		String SQL = "SELECT idEquipement FROM public.localequip "
				+ "WHERE localequip.idLocalEquip = ?";
		Connection cnx = DBConnect.ConnectDB();
		if(cnx == null){
			
		}else{
			PreparedStatement stat = cnx.prepareStatement(SQL);
			stat.setInt(1,idLocal);
			ResultSet result = stat.executeQuery();
			while(result.next()){
				ID = result.getInt("idEquipement");
			}
		}
		return ID;
	}
	
	
	/*
	 * M�thode utilis� pour r�cup�rer un �quipement
	 * Pour cela , il faut passer en param�tre : idLocal,idEquip
	 * 
	 * */
	public static Equipement AfficherEquipement(Local local,Equipement equi) throws ClassNotFoundException, SQLException{
		Equipement equipement = null;
		int idLocal = local.getId();
		int idEquipement = equi.getIdEquipement();
		String SQL = "SELECT * FROM public.equipement WHERE "
				+ "equipement.idEquipement = localequip.idEquipement = ? "
				+ "AND local.idLocal = localequip.idLocal = ?";
		Connection cnx = DBConnect.ConnectDB();
		PreparedStatement stat = cnx.prepareStatement(SQL);
		stat.setInt(1,idEquipement);
		stat.setInt(2,idLocal);
		ResultSet result = stat.executeQuery();
		while(result.next()){
			String typeEquip = result.getString("typequip");
			String etatEquip = result.getString("etatequip");
			int nbrTable = result.getInt("nbrtable");
			equipement = new Equipement(idEquipement,typeEquip);
		}
		return equipement;
	}
	
	/*
	 * M�thode pour confirmer la modification de l'�quipement
	 * */
	
	public static String ModifierEquipement(Equipement equipement,Local local) throws ClassNotFoundException, SQLException{
		String RETURN ="NO RETURN VALUES";
		String TypeEquip = equipement.getTypeEquipement();
		int IDEQUIPEMENT = equipement.getIdEquipement();
		int IDLOCAL = local.getId();
		String SQL ="UPDATE public.equipement SET "
				+ "typequip = ?,etatequip = ?,nbrtable = ? "
				+ "WHERE equipement.idEquipement = localequip.idEquipement = ? AND"
				+ "local.idLocal = localequip.idLocal = ?";
		Connection cnx = DBConnect.ConnectDB();
		if(cnx == null){
			
		}else{
			PreparedStatement stat = cnx.prepareStatement(SQL);
			stat.setString(1,TypeEquip);
			stat.setInt(4,IDEQUIPEMENT);
			stat.setInt(5,IDLOCAL);
			stat.executeUpdate();
			RETURN = "Modification de l'�quipement est faite avec succ�es";
		}
		return RETURN;
	}
	
	/*
	 * M�thode utilis� pour supprimer un �quipement a partir de son ID
	 * */
	public static String DeleteEquipement(Equipement equipement) throws ClassNotFoundException, SQLException{
		String CONFIRME ="";
		String SQL ="DELETE FROM public.equipement WHERE equipement.typequip = ?";
		Connection cnx = DBConnect.ConnectDB();
		String nomEquip = equipement.getTypeEquipement();
		PreparedStatement stat = cnx.prepareStatement(SQL);
		stat.setString(1,nomEquip);
		stat.executeUpdate();
		CONFIRME = "OK";
		return CONFIRME;
	}
	
	/*
	 * M�thode pour afficher tous les �quipement
	 * */
	public static ArrayList<Equipement> AllEquipement() throws ClassNotFoundException, SQLException{
		ArrayList<Equipement> listEquip = new ArrayList<Equipement>();
		Connection cnx = DBConnect.ConnectDB();
		String SQL = "SELECT * FROM public.equipement";
		PreparedStatement stat = cnx.prepareStatement(SQL);
		ResultSet result = stat.executeQuery();
		while(result.next()){
			Equipement equip = new Equipement(result.getInt("idEquip"),result.getString("typequip"));
			listEquip.add(equip);
		}
		return listEquip;
	}
	
	/*
	 * M�thode pour afficher le nom de l'�quipement a partir de son id
	 * */
	public static String EquipementName(int idEquipement) throws ClassNotFoundException, SQLException{
		String name ="";
		Connection cnx = DBConnect.ConnectDB();
		String SQL = "SELECT typequip FROM public.equipement WHERE \"idEquip\" = ? ";
		PreparedStatement stat = cnx.prepareStatement(SQL);
		stat.setInt(1,idEquipement);
		ResultSet result = stat.executeQuery();
		while(result.next()){
			name = result.getString("typequip");
		}
		return name;
	}
	
	
	
}
