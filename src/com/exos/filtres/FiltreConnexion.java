package com.exos.filtres;

import java.io.IOException;
import java.util.Arrays;
import java.util.List;

import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.FilterConfig;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;



/**
 * Servlet Filter implementation class FiltreConnexion
 */

public class FiltreConnexion implements Filter {

	private List<String> urlList;
	
    /**
     * Default constructor. 
     */
    public FiltreConnexion() {
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see Filter#destroy()
	 */
	public void destroy() {
		// TODO Auto-generated method stub
	}

	/**
	 * @see Filter#doFilter(ServletRequest, ServletResponse, FilterChain)
	 */
	public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain) throws IOException, ServletException {
		// TODO Auto-generated method stub
		// place your code here
			
		
		HttpServletRequest req = (HttpServletRequest)request;
		HttpServletResponse res = (HttpServletResponse)response;
	    HttpSession session = req.getSession();
	    String url = req.getServletPath();
	    
	    /*Si la page demandée fait partie des URL autorisées , est un fichier
	     Css,img,js,font ou si l'utilisateur qui demande la page est connecté ,aller
	     directement au niveau du servlet correspondant .... Sinon on redirige vers
	     la page de connexion
	     */
	    
		if(urlList.contains(url) || url.startsWith("/css/")
                || url.startsWith("/js/") || url.startsWith("/images/") ||
                url.startsWith("/fonts/") || session.getAttribute("email")!=null)
		{
			// pass the request along the filter chain
			 chain.doFilter(req, res); 
		}
		else
		{
		
			res.sendRedirect(req.getContextPath()+"/Login");
		}
	}

	/**
	 * @see Filter#init(FilterConfig)
	 */
	public void init(FilterConfig fConfig) throws ServletException {
		
		// Initialisation : recuperation des url autorisées
		String urls = fConfig.getInitParameter("avoid-urls");
        urlList = Arrays.asList(urls.split(","));
	}

}
