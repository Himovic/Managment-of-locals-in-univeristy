package Control;

import java.io.IOException;
import java.sql.SQLException;
import java.util.LinkedHashMap;
import java.util.Map;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.google.gson.Gson;

import Functions.CreneauFunction;
import Model.Creneau;

/**
 * Servlet implementation class CreneauCtrl
 */
@WebServlet("/CreneauCtrl")
public class CreneauCtrl extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public CreneauCtrl() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		String hiddenAjoutCreneau = request.getParameter("hiddenAjoutCreneau");
		String hiddenDeleteCreneau = request.getParameter("HIDDEN_DELETE_CRENEAU");
		String hiddenShowCreneau = request.getParameter("HIDDEN_SHOW_CRENEAU");
		String hiddenConfirmeCreneau = request.getParameter("HIDDEN_CONFIRME_CHANGE");
		if(hiddenAjoutCreneau != null){
			String result="";
			String HeureDebut = request.getParameter("HeureDebut");
			String HeureFin = request.getParameter("HeureFin");
			Creneau creneau = new Creneau(HeureDebut, HeureFin);
			try {
				result = CreneauFunction.AjouterCreanu(creneau);
			} catch (ClassNotFoundException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			response.setContentType("text/plain");
			response.getWriter().write(result);
		}
		
		if(hiddenDeleteCreneau != null){
			int idCreneau = Integer.parseInt(request.getParameter("idCreneau"));
			String result ="";
			Creneau creneau = new Creneau(idCreneau);
			try {
				result = CreneauFunction.deleteCreneau(creneau);
			} catch (ClassNotFoundException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			response.setContentType("text/plain");
			response.getWriter().write(result);
		}
		
		if(hiddenShowCreneau != null){
			int idCreneau = Integer.parseInt(request.getParameter("idCreneau"));
			Creneau oneCreneau = null;
			Creneau creneau = new Creneau(idCreneau);
			try {
				oneCreneau = CreneauFunction.oneCreneau(creneau);
			} catch (ClassNotFoundException | SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			Map<String,String> jsonData = new LinkedHashMap<String, String>();
			jsonData.put("id",String.valueOf(oneCreneau.getId()));
			jsonData.put("HeureDebut",oneCreneau.getHeureDebut());
			jsonData.put("HeureFin",oneCreneau.getHeureFin());
			String AllDataJson =null;
			if(idCreneau != 0){
				AllDataJson = new Gson().toJson(jsonData);
			}
			response.setContentType("application/json");
			response.setCharacterEncoding("UTF-8");
			response.getWriter().write(AllDataJson);
		}
		
		if(hiddenConfirmeCreneau != null){
			String result = "";
			int idCreneau = Integer.parseInt(request.getParameter("id"));
			String heureDebut = request.getParameter("heuredebut");
			String heureFin = request.getParameter("heurefin");
			Creneau creneau = new Creneau(idCreneau,heureDebut,heureFin);
			try {
				result = CreneauFunction.ModifierCreneau(creneau);
			} catch (ClassNotFoundException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			response.setContentType("text/plain");
			response.getWriter().write(result);
		}
	}
	

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
	}

}
