package com.exos.forms;

import java.io.BufferedInputStream;
import java.io.BufferedOutputStream;
import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.Part;

import com.exos.beans.Utilisateur;

public class InscriptionForm {

	private static final int TAILLE_TAMPON=10240;
	private static final String REPERTOIRE_PERMANENT="/Users/macair/fichiersperm/";
	
	
	
	
	public Utilisateur envoiPhoto (HttpServletRequest request) throws IOException, ServletException
	{
		Utilisateur utilisateur=new Utilisateur();

		// On récupère le champ de la photo
		Part part=request.getPart("photo");
		
		// On vérifie qu'on a bien reçu un fichier
		String nomFichier = getNomFichier(part);

		// Si on a bien un fichier
		if (nomFichier != null && !nomFichier.isEmpty()) 
		{
			String nomChamp = part.getName();
			// Corrige un bug du fonctionnement d'Internet Explorer
			nomFichier = nomFichier.substring(nomFichier.lastIndexOf('/') + 1).substring(nomFichier.lastIndexOf('\\') + 1);

		    // On écrit définitivement le fichier sur le disque
		    ecrireFichier(part, nomFichier, REPERTOIRE_PERMANENT);
		}
		
		return utilisateur;
		
	}
	
	private void ecrireFichier( Part part, String nomFichier, String chemin ) throws IOException {
        BufferedInputStream entree = null;
        BufferedOutputStream sortie = null;
        try {
            entree = new BufferedInputStream(part.getInputStream(), TAILLE_TAMPON);
            sortie = new BufferedOutputStream(new FileOutputStream(new File(chemin + nomFichier)), TAILLE_TAMPON);

            byte[] tampon = new byte[TAILLE_TAMPON];
            int longueur;
            while ((longueur = entree.read(tampon)) > 0) {
                sortie.write(tampon, 0, longueur);
            }
        } finally {
            try {
                sortie.close();
            } catch (IOException ignore) {
            }
            try {
                entree.close();
            } catch (IOException ignore) {
            }
        }
    }
	
	 private static String getNomFichier( Part part ) {
	        for ( String contentDisposition : part.getHeader( "content-disposition" ).split( ";" ) ) {
	            if ( contentDisposition.trim().startsWith( "filename" ) ) {
	                return contentDisposition.substring( contentDisposition.indexOf( '=' ) + 1 ).trim().replace( "\"", "" );
	            }
	        }
	        return null;
	    }  
}
