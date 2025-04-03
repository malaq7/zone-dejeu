package jeu;
import cartes.*;
import java.util.List;
import java.util.ArrayList;
import java.util.Collection;

public class ZoneDeJeu {
	
	private List<Limite> pileLimites = new ArrayList<>();
	private List<Bataille> pileBataille = new ArrayList<>();
	private Collection<Borne> pileBorne = new ArrayList<>();
//ensemble
	

	public List<Limite> getLimites() {
		return pileLimites;
	}
	
	public List<Bataille> getBataille() {
		return pileBataille;
	}
	
	public int donnerLimitationVitesse() {
		if (pileLimites.isEmpty() || (donnerSommet(pileLimites) instanceof FinLimite)) {
			return 200;
		}
		return 50;
	}
	
	public int donnerKmParcourus() {
		int total = pileBorne.size();
		for (Borne borne : pileBorne) {
			total += borne.getKm();
		}
		return total;
	}
	public <E> E donnerSommet(List<E> pile) {
		if (!pile.isEmpty()) {
			return pile.get(pile.size() - 1);
		}
		return null;
	}
	
	
	
	public boolean peutAvancer() {
		if (pileBataille.isEmpty() ) {
			return true;
		} else if (!pileBataille.isEmpty()) {
			Bataille sommet = donnerSommet(pileBataille);
			return (sommet.equals(Cartes.FEU_VERT) 
					|| ((sommet instanceof Parade)) 
					|| ((sommet instanceof Attaque) && sommet.equals(Cartes.FEU_ROUGE))
					|| ((sommet instanceof Attaque) && !sommet.equals(Cartes.FEU_ROUGE) ));
		}
		return false;
	}
	private boolean estDepotFeuVertAutorise() {
		if (pileBataille.isEmpty()) {
			return true;
		} else {
			Bataille sommet = donnerSommet(pileBataille);
			return sommet.equals(Cartes.FEU_ROUGE)
					|| (sommet instanceof Parade && !(sommet.equals(Cartes.FEU_VERT))) || (sommet instanceof Attaque );
		}
	}
	
	private boolean estDepotBorneAutorise(Borne b) {
		return peutAvancer()
				&& b.getKm() <= donnerLimitationVitesse()
				&& b.getKm() + donnerKmParcourus() <= 1000;
	}
	private boolean estDepotLimiteAutorise(Limite limite) {
		if (limite instanceof DebutLimite) {
			return pileLimites.isEmpty() || (donnerSommet(pileLimites) instanceof FinLimite);
		} else {
			return donnerSommet(pileLimites) instanceof DebutLimite;
		}
	}
	private boolean estDepotBatailleAutorise(Bataille bataille) {
		if (bataille instanceof Attaque) {
			return peutAvancer();
		}
		if (bataille instanceof Parade) {
			if (bataille.equals(Cartes.FEU_VERT)) {
				return estDepotFeuVertAutorise();
			} else {
				Bataille sommet = donnerSommet(pileBataille);
				return (sommet != null) && (sommet instanceof Attaque) && sommet.getType().equals(bataille.getType());
			}
		}
		return false;
	}
	public void deposer(Carte carte) {
		if(carte instanceof Borne) {
			pileBorne.add((Borne)carte);
		}
		if(carte instanceof Bataille) {
			pileBataille.add((Bataille)carte);
		}
		if(carte instanceof Limite) {
			pileLimites.add((Limite)carte);
		}
	}
	
	public boolean estDepotAutorise(Carte carte) {
		if (carte instanceof Borne ) {
			return estDepotBorneAutorise((Borne)carte);
		} else if (carte instanceof Limite ) {
			return estDepotLimiteAutorise((Limite)carte);
		} else if (carte instanceof Bataille ) {
			return estDepotBatailleAutorise((Bataille)carte);
		} else {
			return true;
		}
	}
	
}