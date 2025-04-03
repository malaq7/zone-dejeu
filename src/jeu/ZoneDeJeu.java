package jeu;
import cartes.*;
import java.util.List;
import java.util.ArrayList;

public class ZoneDeJeu {
	
	private List<Limite> pileLimites = new ArrayList<>();
	private List<Bataille> pileBataille = new ArrayList<>();
	private List<Borne> pileBorne = new ArrayList<>();

	

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
		int total = 0;
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
	public void deposer(Carte c) {
		if (c instanceof Borne borne) {
			pileBorne.add(borne);
		} else if (c instanceof Limite limite)  {
			pileLimites.add(limite);
		} else if (c instanceof Bataille bataille) {
			pileBataille.add(bataille);
		}
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
				boolean var= (sommet != null) && (sommet instanceof Attaque) && sommet.getType().equals(bataille.getType());
				return var;
			}
		}
		return false;
	}
	public boolean estDepotAutorise(Carte carte) {
		if (carte instanceof Borne borne) {
			return estDepotBorneAutorise(borne);
		} else if (carte instanceof Limite limite) {
			return estDepotLimiteAutorise(limite);
		} else if (carte instanceof Bataille bataille) {
			return estDepotBatailleAutorise(bataille);
		} else {
			return true;
		}
	}
	
}