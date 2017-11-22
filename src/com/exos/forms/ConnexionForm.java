package com.exos.forms;

import java.util.HashMap;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;

import com.exos.beans.Utilisateur;

public class ConnexionForm {

	private Map<String,String> erreurs=new HashMap<String,String>();	


	public Map<String, String> getErreurs() {
		return erreurs;
	}
	
	public Utilisateur connexion(HttpServletRequest request)
	
	{
		String email=(String) request.getParameter("email");
		String pass=(String) request.getParameter("pass");
		
		
		Utilisateur utilisateur=new Utilisateur();
				
		try 
		{
			validationEmail(email);
		}
		catch(Exception e)
		{
			erreurs.put("email", e.getMessage());
		}
		utilisateur.setEmail(email);
		
		try 
		{
			validationMotDePasse(pass);
		}
		catch(Exception e)
		{
			erreurs.put("pass", e.getMessage());
		}
		utilisateur.setPass(pass);
		
		if(erreurs.isEmpty())
		{
			try 
			{
				verifCredentials(email,pass);
			}
			catch(Exception e)
			{
				erreurs.put("credentials", e.getMessage());
			}
		}
		
		
		
		return utilisateur;
		
	}
	
	
	
    private void validationEmail( String email ) throws Exception 
    {
        if ( email != null && !email.matches( "([^.@]+)(\\.[^.@]+)*@([^.@]+\\.)+([^.@]+)" ) ) {
            throw new Exception( "Merci de saisir une adresse mail valide." );
        }
    }

    
    private void validationMotDePasse( String pass ) throws Exception 
    {
        if ( pass != null ) 
        {
            if ( pass.length() < 3 ) {
                throw new Exception( "Le mot de passe doit contenir au moins 3 caractères." );
            }
        } else 
        {
            throw new Exception( "Merci de saisir votre mot de passe." );
        }
    }
	
    private void verifCredentials(String email,String pass) throws Exception
    {
    		if(!pass.equals(email+"123"))
    		{
             throw new Exception( "Vérifiez vos saisies !" );

    		}
    	
    }
	

}
