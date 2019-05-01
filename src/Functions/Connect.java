package Functions;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class Connect {
	public static void main(String[]args) throws ClassNotFoundException, SQLException{
		float ResultMoy = 0.0f;
		String SQL ="SELECT AVG(Notetp)FROM etudiant";
		String url ="jdbc:mysql://localhost/simpledata";
		String username ="root";
		String password="";
		Class.forName("com.mysql.jdbc.Driver");
		Connection cnx = DriverManager.getConnection(url,username,password);
		PreparedStatement stat = cnx.prepareStatement(SQL);
		ResultSet result = stat.executeQuery();
		while(result.next()){
			ResultMoy = result.getFloat(1);
		}
		System.out.println("La moyenne est : "+ResultMoy);
	}
}
