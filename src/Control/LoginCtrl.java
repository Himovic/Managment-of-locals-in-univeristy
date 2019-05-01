package Control;

import java.io.IOException;
import java.sql.SQLException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import Functions.LocalEquipFunction;
import Functions.LoginFunction;
import Model.Personne;

/**
 * Servlet implementation class LoginCtrl
 */
//@WebServlet("/LoginCtrl")
@WebServlet(name="LoginCtrl",urlPatterns={"/LoginCtrl"})
public class LoginCtrl extends HttpServlet {
	private static final long serialVersionUID = 1L;
       RequestDispatcher dispatcher = null;
    /**
     * @see HttpServlet#HttpServlet()
     */
    public LoginCtrl() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		String Email = request.getParameter("email");
        String Password = request.getParameter("password");
        Personne personne = new Personne(Email, Password);
        Personne result = null;
		try {
			result = LoginFunction.Authentifier(personne);
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
        //request.setAttribute("void",result);
        if(result != null){
            System.out.println("AUTHENTIFICATION REUSSIE");
            HttpSession session = request.getSession();
            session.setAttribute("name",result.getNom()+" "+result.getPrenom());
            session.setAttribute("email",result.getEmail());
            //Thread thread = new Thread(new LocalEquipFunction());
            //thread.start();
            dispatcher = request.getRequestDispatcher("StartScreen/index.jsp");
        }else{
            System.out.println("Email ou Mot de passe sont incorrect!");
            dispatcher = request.getRequestDispatcher("ErrorAuthn.jsp");
        }
        
        dispatcher.forward(request, response);
	}

}
