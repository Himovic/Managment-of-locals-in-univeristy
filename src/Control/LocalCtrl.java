package Control;

import java.io.IOException;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.LinkedHashMap;
import java.util.Map;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.google.gson.Gson;

import Functions.EquipementFunction;
import Functions.LocalEquipFunction;
import Functions.LocalFunction;
import Model.Local;

/**
 * Servlet implementation class LocalCtrl
 */
@WebServlet("/LocalCtrl")
public class LocalCtrl extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public LocalCtrl() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		System.out.println("SERVLET CALLED");
		String HIDDENAJOUT = request.getParameter("HIDDENADD");
		String HIDDENFIRSTMODIF = request.getParameter("hiddenFirstModif");
		String HIDDENDELETE = request.getParameter("HIDDEN_DELETE");
		if(HIDDENAJOUT != null){
			int GENERATED_ID=0;
			String NOM_LOCAL = request.getParameter("NOM_LOCAL");
			String NBR_TABLE = request.getParameter("NBR_TABLE");
			int NBTB = Integer.parseInt(NBR_TABLE);
			String NUMERO = request.getParameter("NUMERO");
			int NUM = Integer.parseInt(NUMERO);
			String ETAGE = request.getParameter("ETAGE");
			int ETG = Integer.parseInt(ETAGE);
			String ALL_NIV = request.getParameter("ALL_NIV");
			String ALL_ID_EQ = request.getParameter("ALL_EQUIP");
			System.out.println(NOM_LOCAL);
			System.out.println(NBR_TABLE);
			System.out.println(NUMERO);
			System.out.println(ETAGE);
			System.out.println(ALL_NIV);
			System.out.println(ALL_ID_EQ);
			Local local = new Local(ALL_NIV,NOM_LOCAL,ETG,NBTB,NUM);
			try {
				GENERATED_ID =  LocalFunction.AjouterLocal(local);
			} catch (ClassNotFoundException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			String[] AllIdEquip = ALL_ID_EQ.split(",");
			for(int i=0 ; i<AllIdEquip.length ; i++){
				int EquipementKey = Integer.parseInt(AllIdEquip[i]);
				try {
					LocalEquipFunction.AddKeys(GENERATED_ID,EquipementKey);
				} catch (ClassNotFoundException | SQLException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			}
		}
		if(HIDDENFIRSTMODIF != null){
			int idLocal =0;
			ArrayList<Integer> AllIdEquipement = new ArrayList<Integer>();
			String localName = request.getParameter("localName");
			Local LocalObjectName = new Local(localName);
			Local getOneLocal = null;
			try {
				getOneLocal = LocalFunction.AfficherUnSeulLocal(LocalObjectName);
			} catch (ClassNotFoundException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			//get id of the local 
			Local localNaming = new Local(localName);
			try {
				idLocal = LocalFunction.GetIDLocal(localNaming);
			} catch (ClassNotFoundException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
				try {
					AllIdEquipement = LocalEquipFunction.AllIdEquipementFromLocal(idLocal);
				} catch (ClassNotFoundException | SQLException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			//Showing name equipement
				ArrayList<String> EquipementName = new ArrayList<String>();
				String name="";
				for(int i=0 ; i<AllIdEquipement.size() ; i++){
					int idEquip = AllIdEquipement.get(i).intValue();
					try {
						name = EquipementFunction.EquipementName(idEquip);
					} catch (ClassNotFoundException e) {
						// TODO Auto-generated catch block
						e.printStackTrace();
					} catch (SQLException e) {
						// TODO Auto-generated catch block
						e.printStackTrace();
					}
					EquipementName.add(name);
				}
				String allEquipement = EquipementName.toString().replaceAll("\\[|\\]", "").replaceAll(", ","\t");
			//convert getting data to hashmap and hashmap for json object 
			Map<String,String> jsonData = new LinkedHashMap<String,String>();
			jsonData.put("priorite",getOneLocal.getNiveau());
			jsonData.put("nom",getOneLocal.getNom());
			jsonData.put("etage",String.valueOf(getOneLocal.getEtage()));
			jsonData.put("nbrtable",String.valueOf(getOneLocal.getNbrtable()));
			jsonData.put("numero",String.valueOf(getOneLocal.getNumero()));
			jsonData.put("equipement",allEquipement);
			String AllDataJson = null;
			if(localName != null){
				AllDataJson = new Gson().toJson(jsonData);
			}
			response.setContentType("application/json");
			response.setCharacterEncoding("UTF-8");
			response.getWriter().write(AllDataJson);
		}
		
		if(HIDDENDELETE != null){
			String responseResult ="";
			String localName = request.getParameter("localName");
			Local getLocalName = new Local(localName);
			try {
				responseResult = LocalFunction.DeleteLocal(getLocalName);
			} catch (ClassNotFoundException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			response.setContentType("application/text");
			response.setCharacterEncoding("UTF-8");
			response.getWriter().write(responseResult);
		}
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		
		
		}
	}


