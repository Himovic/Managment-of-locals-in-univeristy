package Model;

public class LocalEquip {
	private int idLocal,idEquipement;
	public LocalEquip(){
		
	}
	public LocalEquip(int idLocal,int idEquipement){
		this.idLocal = idLocal;
		this.idEquipement = idEquipement;
	}
	public int getIdLocal() {
		return idLocal;
	}
	public void setIdLocal(int idLocal) {
		this.idLocal = idLocal;
	}
	public int getIdEquipement() {
		return idEquipement;
	}
	public void setIdEquipement(int idEquipement) {
		this.idEquipement = idEquipement;
	}
	
}
