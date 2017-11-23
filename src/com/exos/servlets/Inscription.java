package com.exos.servlets;

import java.io.BufferedInputStream;
import java.io.BufferedOutputStream;
import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import javax.servlet.http.Part;

import com.exos.beans.Utilisateur;
import com.exos.forms.InscriptionForm;

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
		
		if(session.getAttribute("utilisateur")==null)
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
		
        InscriptionForm form=new InscriptionForm();
        Utilisateur utilisateur=form.envoiPhoto(request);
		

        request.setAttribute("utilisateur", utilisateur);
        
		this.getServletContext().getRequestDispatcher("/WEB-INF/signup.jsp").forward(request, response);

	}
	
	
	

}
