package com.exos.servlets;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;


import com.exos.beans.Utilisateur;
import com.exos.forms.ConnexionForm;

/**
 * Servlet implementation class Login
 */

public class Login extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public Login() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		HttpSession session=request.getSession();
		
		if(session.getAttribute("utilisateur")==null)
		{
			this.getServletContext().getRequestDispatcher("/WEB-INF/login.jsp").forward(request, response);
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
		
		ConnexionForm form=new ConnexionForm();
		
		Utilisateur utilisateur=form.connexion(request);
		
		HttpSession session=request.getSession();
		
		
		if(!form.getErreurs().isEmpty())
		{
			request.setAttribute("form", form);
			request.setAttribute("utilisateur", utilisateur);
			this.getServletContext().getRequestDispatcher("/WEB-INF/login.jsp").forward(request, response);
		}
		else
		{
			session.setAttribute("utilisateur", utilisateur);
			response.sendRedirect(request.getContextPath() + "/Accueil");
		}
	}

}
