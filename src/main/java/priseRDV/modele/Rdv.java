package priseRDV.modele;

import java.util.Date;

public class Rdv {

	private String civilite;
	private String nom;
	private String prenom;
	private Date date;
	private boolean urgent;
	
	public Rdv(String civilite, String nom, String prenom, boolean urgent) {
		this.civilite = civilite;
		this.nom = nom;
		this.prenom = prenom;
		this.date = new Date();
		this.urgent = urgent;
	}

	public String getCivilite() {
		return civilite;
	}

	public void setCivilite(String civilite) {
		this.civilite = civilite;
	}

	public String getNom() {
		return nom;
	}

	public void setNom(String nom) {
		this.nom = nom;
	}

	public String getPrenom() {
		return prenom;
	}

	public void setPrenom(String prenom) {
		this.prenom = prenom;
	}

	public Date getDate() {
		return date;
	}

	public void setDate(Date date) {
		this.date = date;
	}
	
	public Boolean getUrgent() {
		return urgent;
	}

	public void setUrgent(Boolean urgent) {
		this.urgent = urgent;
	}

}
