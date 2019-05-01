package Functions;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import Model.Creneau;

public class CreneauFunction {
	public static String AjouterCreanu(Creneau creneau) throws ClassNotFoundException, SQLException{
		String SQL = "INSERT INTO public.\"Creneau\"(\"DebutHeure\",\"FinHeure\")VALUES(?,?)";
		String HeureDebut = creneau.getHeureDebut();
		String HeureFin = creneau.getHeureFin();
		Connection cnx = DBConnect.ConnectDB();
		PreparedStatement stat = cnx.prepareStatement(SQL);
		stat.setString(1,HeureDebut);
		stat.setString(2,HeureFin);
		stat.execute();
		return "OK";
	}
	
	public static ArrayList<Creneau> AllCreneau() throws ClassNotFoundException, SQLException{
		String SQL ="SELECT * FROM public.\"Creneau\"";
		ArrayList<Creneau> allCreneau = new ArrayList<Creneau>();
		Connection cnx = DBConnect.ConnectDB();
		PreparedStatement stat = cnx.prepareStatement(SQL);
		ResultSet result = stat.executeQuery();
		while(result.next()){
			String HeureDebut = result.getString("DebutHeure");
			String HeureFin = result.getString("FinHeure");
			int idCreneau = result.getInt("idCreneau");
			Creneau creneau = new Creneau(idCreneau,HeureDebut, HeureFin);
			allCreneau.add(creneau);
		}
		return allCreneau;
	}
	
	public static String deleteCreneau(Creneau creneau) throws ClassNotFoundException, SQLException{
		int idCreneau = creneau.getId();
		String SQL = "DELETE FROM public.\"Creneau\" WHERE \"idCreneau\" = ?";
		Connection cnx = DBConnect.ConnectDB();
		PreparedStatement stat = cnx.prepareStatement(SQL);
		stat.setInt(1,idCreneau);
		stat.executeUpdate();
		return "OK";
	}
	
	public static Creneau oneCreneau(Creneau creneau) throws ClassNotFoundException, SQLException{
		int idCreneau = creneau.getId();
		Creneau creneauRes = null;
		String SQL = "SELECT * FROM public.\"Creneau\" WHERE \"idCreneau\" = ?";
		Connection cnx = DBConnect.ConnectDB();
		PreparedStatement stat = cnx.prepareStatement(SQL);
		stat.setInt(1,idCreneau);
		ResultSet result = stat.executeQuery();
		while(result.next()){
			String HeureDebut = result.getString("DebutHeure");
			String HeureFin = result.getString("FinHeure");
			int id = result.getInt("idCreneau");
			creneauRes = new Creneau(id,HeureDebut, HeureFin);
		}
		return creneauRes;
	}
	
	public static String ModifierCreneau(Creneau creneau) throws ClassNotFoundException, SQLException{
		int idCreneau = creneau.getId();
		String heureDebut = creneau.getHeureDebut();
		String heureFin = creneau.getHeureFin();
		String SQL = "UPDATE public.\"Creneau\" SET \"DebutHeure\"= ? , \"FinHeure\" = ? WHERE \"idCreneau\" = ?";
		Connection cnx = DBConnect.ConnectDB();
		PreparedStatement stat = cnx.prepareStatement(SQL);
		stat.setString(1,heureDebut);
		stat.setString(2,heureFin);
		stat.setInt(3,idCreneau);
		stat.executeUpdate();
		return "OK";
	}
}
