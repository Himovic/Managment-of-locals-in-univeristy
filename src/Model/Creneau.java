package Model;

public class Creneau {
	private int id;
	private String HeureDebut,HeureFin;
	public Creneau(int id,String HeureDebut,String HeureFin){
		this.id=id;
		this.HeureDebut=HeureDebut;
		this.HeureFin=HeureFin;
	}
	public Creneau(String HeureDebut , String HeureFin){
		this.HeureDebut=HeureDebut;
		this.HeureFin=HeureFin;
	}
	public Creneau(int id){
		this.id=id;
	}
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getHeureDebut() {
		return HeureDebut;
	}
	public void setHeureDebut(String heureDebut) {
		HeureDebut = heureDebut;
	}
	public String getHeureFin() {
		return HeureFin;
	}
	public void setHeureFin(String heureFin) {
		HeureFin = heureFin;
	}
	
}
