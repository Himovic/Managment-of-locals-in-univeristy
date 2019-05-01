package Functions;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Arrays;

import Model.Creneau;
import Model.Equipement;
import Model.Local;
import Model.LocalEquip;
import Model.Reservation;

public class ReservationFunction {
	public static String ConfirmeDate(Reservation ReservationDate) throws ClassNotFoundException, SQLException{
		String returnResult ="";
		String getDate = ReservationDate.getDate();
		String SQL = "SELECT * FROM public.\"Reservation\" WHERE \"Date\" = ?";
		Connection cnx = DBConnect.ConnectDB();
		PreparedStatement stat = cnx.prepareStatement(SQL);
		stat.setString(1,getDate);
		ResultSet result = stat.executeQuery();
		if(result == null){
			returnResult = "DATEOK";
		}else{
			returnResult = "DATENOTOK";
		}
		return returnResult;
	}
	
	public static String ConfirmeCreneau(Reservation ReservationTime) throws ClassNotFoundException, SQLException{
		String returnResult="TIMENOTOK";
		int getTime = ReservationTime.getIdCreneau();
		String getDate = ReservationTime.getDate();
		String SQL = "SELECT * FROM public.\"Reservation\" WHERE \"idCreneau\" = ? AND \"Date\" = ?";
		Connection cnx = DBConnect.ConnectDB();
		PreparedStatement stat = cnx.prepareStatement(SQL);
		stat.setInt(1,getTime);
		stat.setString(2,getDate);
		ResultSet result = stat.executeQuery();
		if(!result.next()){
			returnResult = "TIMEOK";
		}
		return returnResult;
	}
	
	public static String ReservationFunction(Reservation reservation) throws ClassNotFoundException, SQLException{
		String returnResult ="NOTOK";
		String SQL_TABLE = "SELECT * FROM public.local WHERE \"nbrtable\" >= ?";
		String SQL_TIME = "SELECT * FROM public.\"Reservation\" WHERE \"idCreneau\" = ? AND \"Date\" = ?";
		String SQL_TIME_LOCAL = "SELECT * FROM public.\"Reservation\" WHERE \"idCreneau\" = ? AND \"Date\" = ? AND \"idLocal\" = ? ";
		String date = reservation.getDate();
		int NbrTable = reservation.getLocal().getNbrtable();
		int Creneau = reservation.getCreneau().getId();
		ArrayList<Integer> equipements = reservation.getEquipements();
		ArrayList<Integer> FinalLocalIdToReserve = new ArrayList<Integer>();
		Connection cnx = DBConnect.ConnectDB();
		PreparedStatement stat = cnx.prepareStatement(SQL_TIME);
		stat.setInt(1,Creneau);
		stat.setString(2,date);
		ResultSet result = stat.executeQuery();
		if(result.next()){
			returnResult = "Créneau complé ! Esseayer un autre créneau.";
			return returnResult;
		}else{
			PreparedStatement stat1 = cnx.prepareStatement(SQL_TABLE);
			stat1.setInt(1,NbrTable);
			ResultSet result1 = stat1.executeQuery();
			if(!result1.next()){
				returnResult = "Il n'y'a pas un local qui corréspond a le nombre de place entrée";
				return returnResult;
			}else{
				boolean confirmeLocal =false;
				while(result1.next()){
					int id_local = result1.getInt("idLocal");
					for(int i=0 ; i<equipements.size();i++){
						int id_equipement = equipements.get(i);
						LocalEquip localEquip = new LocalEquip(id_local,id_equipement);
						boolean confirmeExistantEquipInLocal = LocalEquipFunction.EquipementInLocal(localEquip);
						if(confirmeExistantEquipInLocal){
							confirmeLocal = true;
							FinalLocalIdToReserve.add(id_local);
						}
					}
				}
				if(!confirmeLocal){
					returnResult = "Il n'y'a pas un local qui contien tous les équipements sélectionnés";
					return returnResult;
				}else{
					//test if the local if not occupied in the time & date
					returnResult = FinalLocalIdToReserve.toString().replaceAll("\\[|\\]","").replaceAll("," , ",");
					ArrayList<String> stringAllLocalId = new ArrayList<String>(Arrays.asList(returnResult.split(",")));
					ArrayList<Integer> IdInInteger = new ArrayList<Integer>();
					ArrayList<Integer> FinalLocalId = new ArrayList<Integer>();
					for(String stringValue : stringAllLocalId){
						try{
							IdInInteger.add(Integer.parseInt(stringValue));
							System.out.println("All local IdInInteger : "+IdInInteger.toString());
						}catch(Exception ex){
							
						}
					}
					for(int i=0 ; i<IdInInteger.size() ; i++){
						int ID_LOCAL_VERIF = IdInInteger.get(i);
						PreparedStatement stat2 = cnx.prepareStatement(SQL_TIME_LOCAL);
						stat2.setInt(1,Creneau);
						stat2.setString(2,date);
						stat2.setInt(3,ID_LOCAL_VERIF);
						ResultSet resultTimeLocal = stat2.executeQuery();
						if(!resultTimeLocal.next()){
							FinalLocalId.add(ID_LOCAL_VERIF);
						}
					}
					String finalReturnConfirme = FinalLocalId.toString().replaceAll("\\[|\\]","").replaceAll("," , ",");
					System.out.println("final return confirme id in reservation function "+finalReturnConfirme);
					return finalReturnConfirme;
				}
			}
		}
	}
	
	
	/*
	 * Méthode pour éffectuer la reservation final d'un local
	 * */
	
	public static String finalReservation(Reservation reservation) throws ClassNotFoundException, SQLException{
		String finalReturn ="";
		Connection cnx = DBConnect.ConnectDB();
		int idLocal = reservation.getLocal().getNbrtable();
		String date = reservation.getDate();
		int creneau = reservation.getCreneau().getId();
		int idPersonne = reservation.getPersonne().getId();
		String SQL ="INSERT INTO public.\"Reservation\" (\"idPersonne\",\"idLocal\",\"idCreneau\",\"Date\") VALUES(?,?,?,?)";
		PreparedStatement stat = cnx.prepareStatement(SQL);
		stat.setInt(1,idPersonne);
		stat.setInt(2,idLocal);
		stat.setInt(3,creneau);
		stat.setString(4,date);
		if(!stat.execute()){
			finalReturn = "La reservation est confirmée";
		}else{
			finalReturn = "La reservation n'est pas confirmée";
		}
		return finalReturn;
	}
	
	/*
	 * Méthode pour afficher tous les réservations
	 * */
	
	public static ArrayList<Reservation> allReservations() throws ClassNotFoundException, SQLException{
		ArrayList<Reservation> allReservation = new ArrayList<Reservation>();
		int idReservation=0;
		String date = "";
		String SQL_RESERVATION = "SELECT * FROM public.\"Reservation\" ";
		Connection cnx = DBConnect.ConnectDB();
		PreparedStatement stat = cnx.prepareStatement(SQL_RESERVATION);
		ResultSet result = stat.executeQuery();
		while(result.next()){
			int idLocal = result.getInt("idLocal");
			int idCreneau = result.getInt("idCreneau");
			Creneau creneau = new Creneau(idCreneau);
			idReservation = result.getInt("idReservation");
			date = result.getString("Date");
			String LocalNom = LocalFunction.getLocalNameFromId(idLocal);
			Creneau getCreneau = CreneauFunction.oneCreneau(creneau);
			Local getLocal = new Local(LocalNom);
			Reservation reservation = new Reservation(idReservation,getCreneau,getLocal,date);
			allReservation.add(reservation);
		}
		return allReservation;
	}
	
	/*
	 * Methode pour libérer une réservation
	 * */
	public static String LibererReservation(Reservation reservation) throws ClassNotFoundException, SQLException{
		String returnResult="";
		String SQL ="DELETE FROM public.\"Reservation\" WHERE \"idReservation\" = ?";
		int idReservation = reservation.getIdCreneau();
		Connection cnx = DBConnect.ConnectDB();
		PreparedStatement stat = cnx.prepareStatement(SQL);
		stat.setInt(1,idReservation);
		if(!stat.execute()){
			returnResult = "Reservation libérer avec succées";
		}else{
			returnResult = "La réservation n'est pas libérée";
		}		
		return returnResult;
	}
}
