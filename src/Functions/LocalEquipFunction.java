package Functions;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import Model.LocalEquip;

public class LocalEquipFunction{
 /*
  * This class is used to add the generated key in the association class
  * */
	
	
	public static void AddKeys(int idLocal,int idEquipement) throws ClassNotFoundException, SQLException{
		String SQL = "INSERT INTO public.localequip(\"idLocal\",\"idEquipement\")VALUES(?,?)";			
		Connection cnx = DBConnect.ConnectDB();
		if(cnx == null){
			
		}else{
			PreparedStatement stat = cnx.prepareStatement(SQL);
			stat.setInt(1,idLocal);
			stat.setInt(2,idEquipement);
			stat.executeUpdate();
		}
	}
	
	/*
	 * Function that allows us to get all the idEquipement in the local
	 * */
	public static ArrayList<Integer> AllIdEquipementFromLocal(int idLocal) throws ClassNotFoundException, SQLException{
		ArrayList<Integer> arrayOfIdEquipement = new ArrayList<Integer>();
		String SQL = "SELECT \"idEquipement\" FROM public.localequip WHERE \"idLocal\" = ?";
		Connection cnx = DBConnect.ConnectDB();
		if(cnx == null){
			
		}else{
			PreparedStatement stat = cnx.prepareStatement(SQL);
			stat.setInt(1,idLocal);
			ResultSet result = stat.executeQuery();
			while(result.next()){
				arrayOfIdEquipement.add(result.getInt("idEquipement"));
			}
		}
		return arrayOfIdEquipement;
	}
	
	/*
	 * 
	 * Method that allows us to confirme if the local containe those equipement or not
	 * */
	
	public static boolean EquipementInLocal(LocalEquip localEquip) throws ClassNotFoundException, SQLException{
		boolean returnResult;
		int idLocal = localEquip.getIdLocal();
		int idEquipement = localEquip.getIdEquipement();
		String SQL ="SELECT * FROM public.localequip WHERE \"idLocal\" = ? AND \"idEquipement\" = ? ";
		Connection cnx = DBConnect.ConnectDB();
		PreparedStatement stat = cnx.prepareStatement(SQL);
		stat.setInt(1,idLocal);
		stat.setInt(2,idEquipement);
		ResultSet resultSet = stat.executeQuery();
		if(!resultSet.next()){
			returnResult = false;
		}else{
			returnResult = true;
		}
		return returnResult;
	}
}
