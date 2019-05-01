/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Functions;

import Model.Personne;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

/**
 *
 * @author lenovo
 */
public class LoginFunction {
    public static Personne Authentifier(Personne p) throws SQLException, ClassNotFoundException{
        Personne personne = null;
        //String SQL ="SELECT * FROM \"Personne\" WHERE Personne.Email = ? AND Personne.Password = ?";
        String SQL = "SELECT *FROM public.personne WHERE personne.email= ? AND personne.password= ? ;";
        Connection cnx = DBConnect.ConnectDB();
        if(cnx == null){
            //resultResponse = "Erreur d'accés au serveur";
            return personne;
        }else{
            String Email = p.getEmail();
            String Password = p.getPassword();
            try{
                PreparedStatement stat = cnx.prepareStatement(SQL);
                stat.setString(1,Email);
                stat.setString(2,Password);
                ResultSet result = stat.executeQuery();
                while(result.next()){
                    String EmailVerif = result.getString("Email");
                    String PasswordVerif = result.getString("Password");
                    if(EmailVerif.equalsIgnoreCase(Email)&&PasswordVerif.equalsIgnoreCase(Password)){
                        String NOM = result.getString("nom");
                        String PRENOM = result.getString("prenom");
                        personne = new Personne(NOM, PRENOM, EmailVerif);
                    }else{
                        return personne;
                    }
                }
            }catch(Exception ex){
                ex.printStackTrace();
            }
            
        }
        return personne
                ;
    }
    
    
    public static int getIdPersonFromEmail(Personne personne) throws ClassNotFoundException, SQLException{
    	int idPersonReturn =0;
    	String email = personne.getEmail();
    	String SQL = "SELECT \"idPersonne\" FROM public.personne WHERE email = ?";
    	Connection cnx = DBConnect.ConnectDB();
    	PreparedStatement stat = cnx.prepareStatement(SQL);
    	stat.setString(1,email);
    	ResultSet result = stat.executeQuery();
    	while(result.next()){
    		idPersonReturn = result.getInt("idPersonne");
    	}
    	return idPersonReturn;
    }

}
