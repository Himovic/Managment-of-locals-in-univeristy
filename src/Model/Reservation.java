package Model;

import java.util.ArrayList;

public class Reservation {
	private int idPersonne,idLocal,idHeure,idCreneau;
	private String Date;
	private Creneau creneau;
	private Local local;
	private Personne personne;
	private ArrayList<Integer> equipements;
	private int idReservation;
	/*
	 * Final constructor reservation
	 * */
	
	public Reservation(Local local,Creneau creneau,Personne personne,String Date){
		this.local = local;
		this.creneau=creneau;
		this.personne=personne;
		this.Date=Date;
	}
	/*
	 * Constructor for all reservation
	 * */
	public Reservation(int idReservation,Creneau creneau,Local local,String Date){
		this.idReservation=idReservation;
		this.creneau=creneau;
		this.local=local;
		this.Date=Date;
	}
	public int getIdReservation() {
		return idReservation;
	}
	public void setIdReservation(int idReservation) {
		this.idReservation = idReservation;
	}
	public Personne getPersonne() {
		return personne;
	}

	public void setPersonne(Personne personne) {
		this.personne = personne;
	}

	public Reservation(Creneau creneau , Local local,ArrayList<Integer> equipements , String Date){
		this.creneau=creneau;
		this.local = local;
		this.equipements=equipements;
		this.Date=Date;
	}
	
	public Local getLocal() {
		return local;
	}

	public void setLocal(Local local) {
		this.local = local;
	}

	public ArrayList<Integer> getEquipements() {
		return equipements;
	}

	public void setEquipements(ArrayList<Integer> equipements) {
		this.equipements = equipements;
	}

	public Reservation(int idPersonne,int idLocal,int idHeure,int idCreneau,String Date){
		this.idPersonne=idPersonne;
		this.idLocal=idLocal;
		this.idHeure=idHeure;
		this.idCreneau=idCreneau;
		this.Date=Date;
	}
	public Reservation(int idCreneau){
		this.idCreneau=idCreneau;
	}
	public Reservation(String Date , int idCreneau){
		this.Date=Date;
		this.idCreneau=idCreneau;
	}
	public Reservation(String Date , Creneau creneau){
		this.Date=Date;
		this.creneau=creneau;
	}
	public Creneau getCreneau() {
		return creneau;
	}
	public void setCreneau(Creneau creneau) {
		this.creneau = creneau;
	}
	public Reservation(String Date){
		this.Date=Date;
	}
	public int getIdCreneau() {
		return idCreneau;
	}
	public void setIdCreneau(int idCreneau) {
		this.idCreneau = idCreneau;
	}
	public int getIdPersonne() {
		return idPersonne;
	}
	public void setIdPersonne(int idPersonne) {
		this.idPersonne = idPersonne;
	}
	public int getIdLocal() {
		return idLocal;
	}
	public void setIdLocal(int idLocal) {
		this.idLocal = idLocal;
	}
	public int getIdHeure() {
		return idHeure;
	}
	public void setIdHeure(int idHeure) {
		this.idHeure = idHeure;
	}
	public String getDate() {
		return Date;
	}
	public void setDate(String date) {
		Date = date;
	}
	
}
