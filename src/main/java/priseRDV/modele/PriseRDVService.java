package priseRDV.modele;

public class PriseRDVService {

	public Rdv rdv(String civilite, String nom, String prenom, boolean urgent) throws PriseRDVInvalideException {
		PriseRDVInvalideException ex = new PriseRDVInvalideException();

		if (nom == null || nom.isEmpty()) {
			ex.addMessage("nom", "Le nom est obligatoire");
		}
		if (prenom == null || prenom.isEmpty()) {
			ex.addMessage("prenom", "Le prénom est obligatoire");
		}
		if (civilite == null || civilite.isEmpty()) {
			ex.addMessage("civilite", "La civilité est obligatoire");
		}
		if (ex.mustBeThrown()) {
			throw ex;
		}
		return new Rdv(civilite, nom, prenom, urgent);
	}
}
