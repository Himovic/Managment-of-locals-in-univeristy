package Control;

import java.io.IOException;
import java.sql.SQLException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import Functions.EquipementFunction;
import Model.Equipement;

/**
 * Servlet implementation class EquipCtrl
 */
@WebServlet("/EquipCtrl")
public class EquipCtrl extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public EquipCtrl() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		/*String HiddenEquip = request.getParameter("hiddenequip");
		if(HiddenEquip != null){
			System.out.println("Code pour ajouter un équipement");
			int EQUIPEMENT_KEY=0;
			int NbrTable = Integer.parseInt(request.getParameter("nbrtable"));
			String SelectedEquip = request.getParameter("ALL_EQUIP");
			String EtatEquip = request.getParameter("ETAT_EQUIP");
			System.out.println("Nombre table est : "+NbrTable);
			System.out.println("Equipement séléctionnés sont : "+SelectedEquip);
			System.out.println("Etat des équipements sont : "+EtatEquip);
			Equipement equipement = new Equipement(NbrTable,SelectedEquip,EtatEquip);
			try {
				EQUIPEMENT_KEY = EquipementFunction.AjouterEquipement(equipement);
			} catch (ClassNotFoundException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			String a = String.valueOf(EQUIPEMENT_KEY);
			response.setContentType("text/plain");
			response.getWriter().write(a);
		}
		String RESULT ="";
		String hiddendeleteequip = request.getParameter("hiddendeleteequip");
		if(hiddendeleteequip != null){*/
			/*
			 * Code inside delete equipement is done
			 * */
			/*int idEquip = Integer.parseInt(request.getParameter("idEquip"));
			System.out.println("idEquip will deleted is : "+idEquip);
			try {
				RESULT = EquipementFunction.DeleteEquipement(idEquip);
			} catch (ClassNotFoundException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			response.setContentType("text/plain");
			response.getWriter().write(RESULT);*/
		}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		String hiddenajoutequip = request.getParameter("hiddenajoutequip");
		String hiddensupprime = request.getParameter("hiddensupprime");
		if(hiddenajoutequip != null){
			String resultReturn ="";
			String nomEquip = request.getParameter("EquipName");
			Equipement equipement = new Equipement(nomEquip);
			try {
				resultReturn = EquipementFunction.AjouterEquipement(equipement);
			} catch (ClassNotFoundException | SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			response.setContentType("text/plain");
			response.getWriter().write(resultReturn);
		}
		if(hiddensupprime != null){
			String resultReturn = "";
			String nomEquip = request.getParameter("testCode");
			Equipement equipement = new Equipement(nomEquip);
			try {
				resultReturn = EquipementFunction.DeleteEquipement(equipement);
			} catch (ClassNotFoundException | SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			response.setContentType("text/plain");
			response.getWriter().write(resultReturn);
		}
	}

}
