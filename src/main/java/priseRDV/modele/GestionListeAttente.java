package priseRDV.modele;

import java.util.ArrayList;
import java.util.List;

public class GestionListeAttente {

	private List<Rdv> listeAttente = new ArrayList<Rdv>();

	private void verificationUrgence(Rdv unRdv) {
		if (unRdv.getUrgent()) {
			if (!listeAttente.isEmpty()) {
				for (int i = 0; i < listeAttente.size(); i++) {
					if (!listeAttente.get(i).getUrgent()) {
						listeAttente.add(i, unRdv);
						break;
					}
				}
			} else {
				listeAttente.add(unRdv);
			}
		} else {
			listeAttente.add(unRdv);
		}
	}

	public boolean verificationPlace(Rdv unRdv) {
		boolean retour = true;
		if (listeAttente.size() >= 10) {
			retour = false;
		} else {
			verificationUrgence(unRdv);
		}
		return retour;
	}

	public void supprimer() {
		listeAttente.remove(0);
	}

	public List<Rdv> getListeAttente() {
		return listeAttente;
	}

	public void setListeAttente(List<Rdv> listeAttente) {
		this.listeAttente = listeAttente;
	}

}
