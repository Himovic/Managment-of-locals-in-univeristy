package Model;

public class Local {
	private String Nom,Niveau;
	private int Etage,Numero,id,nbrtable;
	
	public Local(){
		
	}
	public Local(String Niveau,String Nom,int Etage,int nbrtable,int Numero){
		this.Niveau=Niveau;
		this.Nom=Nom;
		this.Etage=Etage;
		this.nbrtable=nbrtable;
		this.Numero=Numero;
	}
	public Local(String Niveau,String Nom,int Etage,int nbrtable,int Numero,int id){
		this.Niveau=Niveau;
		this.Nom=Nom;
		this.Etage=Etage;
		this.nbrtable=nbrtable;
		this.Numero=Numero;
		this.id=id;
	}
	public Local(String Nom,int Numero,int nbrtable,int Etage,int id){
		this.Nom=Nom;
		this.Numero=Numero;
		this.nbrtable=nbrtable;
		this.Etage=Etage;
		this.id=id;
	}
	public Local(int nbrtable){
		this.nbrtable=nbrtable;
	}
	public Local(String Nom){
		this.Nom=Nom;
	}
	public int getId() {
		return id;
	}
	public int getNbrtable() {
		return nbrtable;
	}
	public void setNbrtable(int nbrtable) {
		this.nbrtable = nbrtable;
	}
	public void setId(int id) {
		this.id = id;
	}
	public Local(String Niveau,String Nom,int Etage,String Code,int nbrtable){
		this.Niveau = Niveau;
		this.Nom = Nom;
		this.Etage = Etage;
		this.nbrtable=nbrtable;
	}
	public Local(String Nom,String Niveau,int Etage,int Numero){
		this.Nom = Nom;
		this.Niveau=Niveau;
		this.Etage=Etage;
		this.Numero = Numero;
	}
	public String getNom() {
		return Nom;
	}
	public void setNom(String nom) {
		Nom = nom;
	}
	public String getNiveau() {
		return Niveau;
	}
	public void setNiveau(String niveau) {
		Niveau = niveau;
	}
	public int getEtage() {
		return Etage;
	}
	public void setEtage(int etage) {
		Etage = etage;
	}
	public int getNumero() {
		return Numero;
	}
	public void setNumero(int numero) {
		Numero = numero;
	}
	
}
