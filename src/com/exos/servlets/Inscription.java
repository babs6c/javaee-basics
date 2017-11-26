package com.exos.servlets;



import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.exos.bdd.Membre;
import com.exos.beans.Utilisateur;

/**
 * Servlet implementation class Inscription
 */

public class Inscription extends HttpServlet {
	private static final long serialVersionUID = 1L;
	
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public Inscription() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
	HttpSession session=request.getSession();
		
		if(session.getAttribute("email")==null)
		{
			  
			this.getServletContext().getRequestDispatcher("/WEB-INF/signup.jsp").forward(request, response);
		}
		else
		{
			response.sendRedirect(request.getContextPath() + "/Accueil");
		}	
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		

		
		Membre membre=new Membre();
		Utilisateur utilisateur=membre.addMembre(request);
		
		if(!membre.getErreurs().isEmpty())
		{
			request.setAttribute("erreurs", membre.getErreurs());
			request.setAttribute("utilisateur", utilisateur);
			
		}
		else
		{
			request.setAttribute("message","Inscription réussie !");
		}
      
        
		this.getServletContext().getRequestDispatcher("/WEB-INF/signup.jsp").forward(request, response);

	}
	
	
	

}
