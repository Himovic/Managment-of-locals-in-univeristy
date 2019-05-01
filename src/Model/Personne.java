/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Model;

/**
 *
 * @author lenovo
 */
public class Personne {
    private String Nom,Prenom,Email,Password;
    private int id;
    public Personne(int id){
    	this.id=id;
    }
    public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public Personne(String Nom,String Prenom,String Email,String Password){
        this.Nom=Nom;
        this.Prenom = Prenom;
        this.Email=Email;
        this.Password=Password;
    }
    public Personne(String Email){
    	this.Email = Email;
    }
    public Personne(String Nom,String Prenom,String Email){
    	this.Nom=Nom;
    	this.Prenom=Prenom;
    	this.Email=Email;
    }
    public Personne(String Email,String Password){
        this.Email=Email;
        this.Password = Password;
    }

    /**
     * @return the Nom
     */
    public String getNom() {
        return Nom;
    }

    /**
     * @param Nom the Nom to set
     */
    public void setNom(String Nom) {
        this.Nom = Nom;
    }

    /**
     * @return the Prenom
     */
    public String getPrenom() {
        return Prenom;
    }

    /**
     * @param Prenom the Prenom to set
     */
    public void setPrenom(String Prenom) {
        this.Prenom = Prenom;
    }

    /**
     * @return the Email
     */
    public String getEmail() {
        return Email;
    }

    /**
     * @param Email the Email to set
     */
    public void setEmail(String Email) {
        this.Email = Email;
    }

    /**
     * @return the Password
     */
    public String getPassword() {
        return Password;
    }

    /**
     * @param Password the Password to set
     */
    public void setPassword(String Password) {
        this.Password = Password;
    }
    
}
