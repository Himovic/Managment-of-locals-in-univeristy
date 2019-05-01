package Control;

import java.io.IOException;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.LinkedHashMap;
import java.util.Map;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.google.gson.Gson;

import Functions.CreneauFunction;
import Functions.LocalFunction;
import Functions.LoginFunction;
import Functions.ReservationFunction;
import Model.Creneau;
import Model.Equipement;
import Model.Local;
import Model.Personne;
import Model.Reservation;

/**
 * Servlet implementation class ReservationCtrl
 */
@WebServlet("/ReservationCtrl")
public class ReservationCtrl extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public ReservationCtrl() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		System.out.println("SERVLET CALLED");
		String HiddenReservationLocal = request.getParameter("HiddenReserveLocal");
		String HiddenShowAllLocal = request.getParameter("HiddenShowAllLocal");
		String HiddenConfirmeReserveLocal = request.getParameter("HiddenConfirmeReserveLocal");
		String HIDDEN_LIBERER_RESERVATION = request.getParameter("HIDDEN_LIBERER_RESERVATION");
		if(HiddenReservationLocal != null){
			String reservationReturnConfirme ="";
			String nbrPlace = request.getParameter("nbrPlace");
			int finalNbrPlace = Integer.valueOf(nbrPlace);
			String date = request.getParameter("date");
			String allEquipement = request.getParameter("allEquipement");
			System.out.println("Les équipements choisi sont : "+allEquipement);
			ArrayList<String> equipement = new ArrayList<String>(Arrays.asList(allEquipement.split(",")));
			ArrayList<Integer> finalEquipement = new ArrayList<Integer>();
			String allCreneau = request.getParameter("allCreneau");
			int idCreneau = Integer.valueOf(allCreneau);
			for(String myInt : equipement){
				finalEquipement.add(Integer.valueOf(myInt));
			}
			Local local = new Local(finalNbrPlace);
			Creneau creneau = new Creneau(idCreneau);
			Reservation reservation = new Reservation(creneau,local,finalEquipement,date);
			try {
				reservationReturnConfirme = ReservationFunction.ReservationFunction(reservation);
			} catch (ClassNotFoundException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			System.out.println("RETURN RESULT IN RESERVATION FUNCTION : "+reservationReturnConfirme);
			
			response.getWriter().write(reservationReturnConfirme);
			response.setContentType("application/text");
			response.setCharacterEncoding("UTF-8");
		}
		
		if(HiddenShowAllLocal != null){
			String results = request.getParameter("results");
			ArrayList<Integer> IdInInteger = new ArrayList<Integer>();
			ArrayList<String> stringAllLocalId = new ArrayList<String>(Arrays.asList(results.split(",")));
			ArrayList<Local> showSelectedLocal = new ArrayList<Local>();
			for(String stringValue : stringAllLocalId){
				try{
					IdInInteger.add(Integer.parseInt(stringValue));
				}catch(Exception ex){
					
				}
			}
			System.out.println("id of the locals are : "+IdInInteger.toString());
			for(int i=0 ; i<IdInInteger.size();i++){
				int ID_LOCAL = IdInInteger.get(i);
				Local instanceLocalId = new Local(ID_LOCAL);
				Local local = null;
				try {
					local = LocalFunction.showOneLocal(instanceLocalId);
				} catch (ClassNotFoundException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				} catch (SQLException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
				showSelectedLocal.add(local);
			}
			String allLocalInJson = new Gson().toJson(showSelectedLocal);
			System.out.println("JSON ELEMENT ARE : "+allLocalInJson);
			response.setContentType("application/text");
			response.setCharacterEncoding("UTF-8");
			response.getWriter().write(allLocalInJson);
		}
		
		
		/*
		 * Reservation final
		 * */
		if(HiddenConfirmeReserveLocal != null){
			String returnReservationResult="";
			int idLocal=0;
			int idPersonne = 0;
			String date = request.getParameter("date");
			String email = (String)request.getSession().getAttribute("email");
			Personne personne = new Personne(email);
			int allCreneau = Integer.parseInt(request.getParameter("allCreneau"));
			String localName = request.getParameter("localName");
			Local local = new Local(localName);
			try {
				idLocal = LocalFunction.GetIDLocal(local);
			} catch (ClassNotFoundException | SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			try {
				idPersonne = LoginFunction.getIdPersonFromEmail(personne);
			} catch (ClassNotFoundException | SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			
			System.out.println("FINAL TEST : créneau : "+allCreneau+" date : "+date+" idPers : "+idPersonne+" idLocal :"+idLocal);
			Local finalLocal = new Local(idLocal);
			Creneau creneau = new Creneau(allCreneau);
			Personne finalPersonne = new Personne(idPersonne);
			Reservation finalReservation = new Reservation(finalLocal,creneau,finalPersonne,date);
			try {
				returnReservationResult = ReservationFunction.finalReservation(finalReservation);
			} catch (ClassNotFoundException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			response.getWriter().write(returnReservationResult);
			response.setContentType("application/text");
			response.setCharacterEncoding("UTF-8");
		}
		
		if(HIDDEN_LIBERER_RESERVATION != null){
			String libereReservationResult="";
			int idReservation = Integer.parseInt(request.getParameter("numeroReservation"));
			Reservation reservation = new Reservation(idReservation);
			try {
				libereReservationResult = ReservationFunction.LibererReservation(reservation);
			} catch (ClassNotFoundException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			System.out.println("numéro reservation : "+idReservation);
			response.getWriter().write(libereReservationResult);
			response.setContentType("application/text");
			response.setCharacterEncoding("UTF-8");
		}
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
	}

}
