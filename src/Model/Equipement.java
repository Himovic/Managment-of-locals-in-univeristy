package Model;

public class Equipement {
	private int idEquipement;
	private String typeEquipement;
	
	public Equipement(){
		
	}
	public Equipement(String typeEquipement){
		this.typeEquipement = typeEquipement;
	}
	public Equipement(int idEquipement,String typeEquipement){
		this.idEquipement = idEquipement;
		this.typeEquipement = typeEquipement;
	}
	public Equipement(int idEquipement){
		this.idEquipement=idEquipement;
	}
	public int getIdEquipement() {
		return idEquipement;
	}
	public void setIdEquipement(int idEquipement) {
		this.idEquipement = idEquipement;
	}
	public String getTypeEquipement() {
		return typeEquipement;
	}
	public void setTypeEquipement(String typeEquipement) {
		this.typeEquipement = typeEquipement;
	}
	
}
